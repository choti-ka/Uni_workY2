import java.util.*;

// main menu
public class AirLine {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Destination> flights = new ArrayList<>();
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static Stack<Destination> undoStack = new Stack<>();
    static Additional extra = new Additional();
    static int nextTicketNo = 1001;

    public static void main(String[] args) {
        flights.add(new Destination("TG101", "Bangkok", "Phuket", "2026-11-01", "08:00", "A1", 1850));
        flights.add(new Destination("TG201", "Bangkok", "Chiangmai", "2026-11-01", "13:30", "B3", 2400));
        flights.add(new Destination("TG344", "Bangkok", "Chiangmai", "2026-11-01", "07:30", "B5", 2100));
        flights.add(new Destination("TG431", "Bangkok", "Krabi", "2026-02-28", "20:30", "A2", 2410));
        flights.add(new Destination("TG714", "Bangkok", "Koh Samui", "2026-07-06", "12:00", "A1", 2345));
        Ticket.coupons.add(new Ticket.Coupon("SALE10", 10));
        Ticket.coupons.add(new Ticket.Coupon("AIRLINE2026", 20));
        mainMenu();
    }

    static void mainMenu() {
        while (true) {
            System.out.println("\n╔══════════════════════════╗");
            System.out.println("║      AIRLINE SYSTEM      ║");
            System.out.println("╚══════════════════════════╝");
            System.out.println(" 1. Staff Login");
            System.out.println(" 2. Customer");
            System.out.println(" 0. Exit");
            System.out.print("\nChoice: ");
            int c = Integer.parseInt(input.nextLine());
            if (c == 1) {
                System.out.print("username: ");
                String user = input.nextLine();
                System.out.print("password: ");
                String pass = input.nextLine();
                if (user.equals("admin") && pass.equals("admin")) staffMenu();
                else System.out.println("⚠ Login unsuccessful");
            } else if (c == 2) customerMenu();
            else if (c == 0) return;
        }
    }

    // for staff
    static void staffMenu() {
        while (true) {
            System.out.println("\n╔══════════════════════════╗");
            System.out.println("║        STAFF MENU        ║");
            System.out.println("╚══════════════════════════╝");
            System.out.println(" 1. Add Flight");
            System.out.println(" 2. Remove Flight");
            System.out.println(" 3. Undo Remove");
            System.out.println(" 4. Flight Status");
            System.out.println(" 5. Refund Report");
            System.out.println(" 0. Back");
            System.out.print("\nChoice: ");
            int c = Integer.parseInt(input.nextLine());
            if (c == 1) addFlight();
            else if (c == 2) deleteFlight();
            else if (c == 3) undoDelete();
            else if (c == 4) setStatus();
            else if (c == 5) handleRefunds();
            else if (c == 0) return;
        }
    }

    static void addFlight() {
        System.out.print("FlightId: ");
        String id = input.nextLine();
        System.out.print("From: ");
        String from = input.nextLine();
        System.out.print("To: ");
        String to = input.nextLine();
        System.out.print("Date (yyyy-MM-dd): ");
        String date = input.nextLine();
        System.out.print("Time: ");
        String time = input.nextLine();
        System.out.print("Gate: ");
        String gate = input.nextLine();
        System.out.print("Price: ");
        int price = Integer.parseInt(input.nextLine());
        flights.add(new Destination(id, from, to, date, time, gate, price));
        System.out.println("✓ Flight added");
    }

    static void deleteFlight() {
        Destination.showAll(flights);
        System.out.print("Target FlightId: ");
        String id = input.nextLine();
        Iterator<Destination> it = flights.iterator();
        while (it.hasNext()) {
            Destination f = it.next();
            if (f.flightId.equalsIgnoreCase(id)) {
                undoStack.push(f);
                it.remove();
                System.out.println("✓ Flight removed");
                return;
            }
        }
        System.out.println("⚠ Flight not found");
    }

    static void undoDelete() {
        if (undoStack.isEmpty()) {
            System.out.println("⚠ Nothing to undo");
        } else {
            Destination f = undoStack.pop();
            flights.add(f);
            System.out.println("✓ Flight " + f.flightId + " restored");
        }
    }

    static void setStatus() {
        Destination.showAll(flights);
        System.out.print("FlightId: ");
        Destination f = findFlight(input.nextLine());
        if (f == null) { System.out.println("⚠ Flight not found"); return; }
        System.out.print("1.ON_TIME\n2.DELAYED\n3.CANCELLED\nInput: ");
        int s = Integer.parseInt(input.nextLine());
        if (s == 1) {
            f.status = "ON_TIME";
        } else if (s == 2) {
            f.status = "DELAYED";
        } else if (s == 3) {
            f.status = "CANCELLED";
        } else {
            System.out.println("⚠ Invalid choice");
            return;
        }
        System.out.println("✓ Status updated");
    }

    static void handleRefunds() {
        if (extra.refunds.isEmpty()) { System.out.println("⚠ No refund requests"); return; }
        extra.showPending();
        System.out.print("1.Approve\n2.Decline\nChoice: ");
        int choice = Integer.parseInt(input.nextLine());
        Additional.Refund r = extra.decide(choice == 1);
        System.out.println("✓ Result: " + r.status);
    }

    // for customer
    static void customerMenu() {
        while (true) {
            System.out.println("\n╔══════════════════════════╗");
            System.out.println("║      CUSTOMER MENU       ║");
            System.out.println("╚══════════════════════════╝");
            System.out.println(" 1. Book Ticket");
            System.out.println(" 2. Search Ticket");
            System.out.println(" 3. Display Flight");
            System.out.println(" 4. Request Refund");
            System.out.println(" 0. Back");
            System.out.print("\nChoice: ");
            int c = Integer.parseInt(input.nextLine());
            if (c == 1) bookTicket();
            else if (c == 2) searchTicket();
            else if (c == 3) { Destination.showAll(flights); }
            else if (c == 4) requestRefund();
            else if (c == 0) return;
        }
    }

    static void bookTicket() {
        System.out.print("From: ");
        String from = input.nextLine();
        System.out.print("To: ");
        String to = input.nextLine();
        System.out.print("Date (yyyy-MM-dd): ");
        String date = input.nextLine();

        ArrayList<Destination> found = new ArrayList<>();
        for (Destination f : flights) {
            if (f.from.equalsIgnoreCase(from) && f.to.equalsIgnoreCase(to)
                    && f.date.equals(date) && !f.status.equals("CANCELLED")) found.add(f);
        }
        if (found.isEmpty()) { System.out.println("⚠ Flight not found"); return; }
        Destination.showAll(found);

        System.out.print("Choose flightId: ");
        Destination flight = findFlight(input.nextLine());
        if (flight == null || !found.contains(flight)) { System.out.println("⚠ Invalid choice"); return; }

        System.out.print("Number of passengers: ");
        int count = Integer.parseInt(input.nextLine());

        Ticket.Coupon coupon = null;
        System.out.print("Coupon (leave empty to skip): ");
        String code = input.nextLine();
        if (!code.isEmpty()) {
            coupon = Ticket.findCoupon(code);
            if (coupon == null) System.out.println("⚠ Coupon not found");
            else System.out.println("✓ Coupon applied: " + coupon.percent + "% off");
        }

        for (int i = 0; i < count; i++) {
            System.out.print("Passenger " + (i + 1) + " name: ");
            String name = input.nextLine();

            int row, col;
            while (true) {
                flight.showSeats();
                System.out.print("Seat (ex. 2A): ");
                String seat = input.nextLine().toUpperCase();

                if (seat.length() < 2) {
                    System.out.println("⚠ Invalid seat");
                    continue;
                }

                row = Integer.parseInt(seat.substring(0, seat.length() - 1)) - 1;
                col = seat.charAt(seat.length() - 1) - 'A';

                if (row < 0 || row >= flight.seats.length || col < 0 || col >= flight.seats[0].length) {
                    System.out.println("⚠ Invalid seat");
                } else if (!flight.bookSeat(row, col)) {
                    System.out.println("⚠ Seat already taken");
                } else {
                    break;
                }
            }
            String seatNo = (row + 1) + "" + (char) ('A' + col);

            Ticket t = new Ticket("T" + nextTicketNo++, name, flight, seatNo);
            t.row = row;
            t.col = col;
            t.finalPrice = t.calcPrice(flight.price, coupon);
            t.coupon = coupon;
            tickets.add(t);
            System.out.println("✓ Booking successful");
            t.show();
        }
    }

    static void searchTicket() {
        System.out.print("Ticket Number: ");
        Ticket t = findTicket(input.nextLine());
        if (t == null) {
            System.out.println("⚠ Ticket not found");
        } else {
            t.show();
        }
    }

    static void requestRefund() {
        System.out.print("Ticket Number: ");
        String id = input.nextLine();
        if (findTicket(id) == null) { System.out.println("⚠ Ticket not found"); return; }
        System.out.print("Reason: ");
        String reason = input.nextLine();
        extra.addRefund(id, reason);
        System.out.println("✓ Refund request sent");
    }

    // other
    static Destination findFlight(String id) {
        for (Destination f : flights) if (f.flightId.equalsIgnoreCase(id)) return f;
        return null;
    }

    static Ticket findTicket(String id) {
        for (Ticket t : tickets) if (t.ticketId.equalsIgnoreCase(id)) return t;
        return null;
    }
}