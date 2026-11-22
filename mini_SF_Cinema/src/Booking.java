import java.util.List;

class Booking {
    static int nextId = 1;

    int id = nextId++;
    String customer;
    Showtime showtime;
    List<Integer> seats;
    String state = "CREATED";   // CREATED -> LOCKED -> PAID  (หรือ CANCELLED)

    Booking(String customer, Showtime showtime, List<Integer> seats) {
        this.customer = customer;
        this.showtime = showtime;
        this.seats = seats;
    }

    // 3) State Machine เปลี่ยนสถานะได้เฉพาะเส้นทางที่ถูกต้องคืน true/false
    boolean moveTo(String next) {
        boolean ok = (state.equals("CREATED") && (next.equals("LOCKED") || next.equals("CANCELLED")))
                || (state.equals("LOCKED") && (next.equals("PAID") || next.equals("CANCELLED")));
        if (ok) state = next;
        return ok;
    }

    int price() {
        return seats.size() * 220;
    }
}