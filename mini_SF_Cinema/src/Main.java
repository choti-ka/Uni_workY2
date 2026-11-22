import java.util.*;

public class Main {
    static final boolean CLEAR_SCREEN = true;

    static List<Showtime> showtimes = new ArrayList<>();
    static Map<Integer, Booking> bookings = new LinkedHashMap<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        showtimes.add(new Showtime("Avengers: Endgame", "13:00"));
        showtimes.add(new Showtime("Frozen III", "16:30"));
        showtimes.add(new Showtime("Thai Horror Night", "20:00"));

        while (true) {
            header("หน้าหลัก");
            System.out.println("  กำลังฉาย\n");
            showShowtimes(false);

            int pending = 0;
            for (Booking b : bookings.values()) if (b.state.equals("LOCKED")) pending++;
            if (pending > 0) System.out.println("\n  ! มี " + pending + " การจองที่รอชำระเงิน (เมนู 3)");

            System.out.println("\n  Menu");
            System.out.println("    1   จองตั๋ว");
            System.out.println("    2   ดูผังที่นั่ง");
            System.out.println("    3   ชำระเงิน");
            System.out.println("    4   ยกเลิกการจอง");
            System.out.println("    5   การจองทั้งหมด");
            System.out.println("    0   ออก");
            String choice = ask("\n  เลือกเมนู › ");

            if (choice.equals("0")) {
                System.out.println("\n  ขอบคุณที่ใช้บริการ  แล้วพบกันใหม่\n");
                break;
            } else if (choice.equals("1")) {
                header("จองตั๋ว");
                book();
            } else if (choice.equals("2")) {
                header("ดูผังที่นั่ง");
                Showtime st = pickShowtime();
                if (st != null) {
                    header("ผังที่นั่ง  ›  " + st.movie);
                    st.printMap();
                }
            } else if (choice.equals("3")) {
                header("ชำระเงิน");
                pay(pickBooking());
            } else if (choice.equals("4")) {
                header("ยกเลิกการจอง");
                cancel(pickBooking());
            } else if (choice.equals("5")) {
                header("การจองทั้งหมด");
                listBookings();
            } else {
                continue;
            }
            ask("\n  กด Enter เพื่อกลับหน้าหลัก ");
        }
    }

    static void book() {
        String customer = ask("  ชื่อลูกค้า › ");
        if (customer.isEmpty()) return;

        System.out.println("\n  เลือกรอบฉาย\n");
        Showtime st = pickShowtime();
        if (st == null) return;

        header("จองตั๋ว  ›  " + st.movie);
        System.out.println("  ลูกค้า: " + customer + "\n");
        st.printMap();
        List<Integer> seats = new ArrayList<>();
        System.out.println("\n  เลือกที่นั่ง\n");
        System.out.println("    1   พิมพ์เลือกเอง  (เช่น A5, A6)");
        System.out.println("    2   ให้ระบบหาที่นั่งติดกันให้ ");
        if (ask("\n  เลือก › ").equals("2")) {
            seats = st.findAdjacent(askInt("  ต้องการกี่ที่นั่ง (1-" + Showtime.COLS + ") › "));    // Sliding Window
            if (seats == null) {
                warn("ไม่มีที่นั่งติดกันตามจำนวนที่ต้องการ");
                offerWaitlist(st, customer);
                return;
            }
        } else {
            for (String text : ask("  ที่นั่ง (คั่นด้วยจุลภาค) › ").split(",")) {
                int seat = toSeatIndex(text);
                if (seat < 0) {
                    warn("ที่นั่งไม่ถูกต้อง: " + text.trim());
                    return;
                }
                if (!seats.contains(seat)) seats.add(seat);
            }
        }
        Booking b = new Booking(customer, st, seats);
        bookings.put(b.id, b);

        if (st.lockSeats(seats, b.id)) {
            b.moveTo("LOCKED");
            System.out.println();
            ok("ล็อกที่นั่ง " + Showtime.seatNames(seats) + " ให้แล้ว  ยอดชำระ " + b.price() + " บาท");
            if (ask("\n  ชำระเงินตอนนี้เลยไหม (y/n) › ").equals("y")) pay(b);
            else System.out.println("\n  เก็บการจอง #" + b.id + " ไว้แล้ว ชำระภายหลังได้ที่เมนู 3");
        } else {
            b.moveTo("CANCELLED");
            warn("มีที่นั่งไม่ว่าง การจองนี้ถูกยกเลิก");
            offerWaitlist(st, customer);
        }
    }
    // 3) Queue (FIFO): ที่นั่งเต็ม -> เข้าคิวรอ ใครเข้าก่อนจะได้รับแจ้งก่อน
    static void offerWaitlist(Showtime st, String customer) {
        if (ask("\n  เข้าคิวรอที่นั่งว่างของรอบนี้ไหม (y/n) › ").equals("y")) {
            st.waitlist.offer(customer);
            ok("เข้าคิวรอแล้ว ลำดับที่ " + st.waitlist.size());
        }
    }
    static void pay(Booking b) {
        if (b == null) return;
        if (b.moveTo("PAID")) {
            b.showtime.sellSeats(b.seats);
            System.out.println();
            ok("ชำระเงินสำเร็จ\n");
            printTicket(b);
        } else {
            warn("ชำระเงินไม่ได้ การจองนี้อยู่ในสถานะ " + b.state);
        }
    }
    static void printTicket(Booking b) {
        System.out.println("  ───────────── TICKET ─────────────");
        line("Booking ID", "#" + b.id);
        line("Customer", b.customer);
        line("Movie", b.showtime.movie);
        line("Showtime", b.showtime.time);
        line("Seats", Showtime.seatNames(b.seats));
        line("Total", b.price() + " บาท");
        line("Status", b.state);
        System.out.println("  ───────────────────────────────────");
    }
    static void line(String label, String value) {
        System.out.printf("   %-11s %s%n", label, value);
    }
    static void cancel(Booking b) {
        if (b == null) return;
        if (b.moveTo("CANCELLED")) {
            b.showtime.unlockSeats(b.seats);
            System.out.println();
            ok("ยกเลิกการจอง #" + b.id + " แล้ว คืนที่นั่ง " + Showtime.seatNames(b.seats));

            String next = b.showtime.waitlist.poll();      // คนแรกในคิวรอ (FIFO)
            if (next != null) {
                System.out.println("\n  แจ้งคุณ " + next + " (คิวรอลำดับแรก): มีที่นั่งว่างแล้ว จองได้ที่เมนู 1");
            }
        } else {
            warn("ยกเลิกไม่ได้ การจองนี้อยู่ในสถานะ " + b.state);
        }
    }
    static void header(String title) {
        if (CLEAR_SCREEN) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        System.out.println("\n  ═══════════════════════════════════════");
        System.out.println("   MINI SF CINEMA  ›  " + title);
        System.out.println("  ═══════════════════════════════════════\n");
    }
    static void ok(String message) {
        System.out.println("  ✓ " + message);
    }
    static void warn(String message) {
        System.out.println("\n  ! " + message);
    }
    static void showShowtimes(boolean numbered) {
        for (int i = 0; i < showtimes.size(); i++) {
            Showtime s = showtimes.get(i);
            String no = numbered ? "[" + (i + 1) + "]" : " • ";
            System.out.printf("    %s %-20s %s    ว่าง %-3d คิวรอ %d%n",
                    no, s.movie, s.time, s.freeSeats(), s.waitlist.size());
        }
    }
    static void listBookings() {
        if (bookings.isEmpty()) {
            System.out.println("  ยังไม่มีการจอง");
            return;
        }
        System.out.printf("   %-4s %-10s %-18s %-6s %-16s %-6s %s%n",
                "ID", "Customer", "Movie", "Time", "Seats", "Baht", "Status");
        System.out.println("  ─────────────────────────────────────────────────────────────────────────");
        for (Booking b : bookings.values()) {
            System.out.printf("   #%-3d %-10s %-18s %-6s %-16s %-6d %s%n", b.id, b.customer,
                    b.showtime.movie, b.showtime.time, Showtime.seatNames(b.seats), b.price(), b.state);
        }
    }
    static Showtime pickShowtime() {
        showShowtimes(true);
        int i = askInt("\n  เลือกรอบ › ") - 1;
        if (i < 0 || i >= showtimes.size()) {
            warn("ไม่พบรอบฉายนี้");
            return null;
        }
        return showtimes.get(i);
    }
    static Booking pickBooking() {
        listBookings();
        if (bookings.isEmpty()) return null;
        Booking b = bookings.get(askInt("\n  เลขการจอง (ID) › "));
        if (b == null) warn("ไม่พบการจองนี้");
        return b;
    }
    static int toSeatIndex(String text) {
        text = text.trim().toUpperCase();
        if (text.length() < 2) return -1;
        int row = text.charAt(0) - 'A';
        int col = toInt(text.substring(1)) - 1;
        if (row < 0 || row >= Showtime.ROWS || col < 0 || col >= Showtime.COLS) return -1;
        return row * Showtime.COLS + col;
    }
    static int askInt(String message) {
        return toInt(ask(message));
    }
    static int toInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    static String ask(String message) {
        System.out.print(message);
        return in.nextLine().trim();
    }
}