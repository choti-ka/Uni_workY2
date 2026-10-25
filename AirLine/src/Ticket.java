import java.util.*;

// ticket + coupon
public class Ticket {
    Coupon coupon;
    int row, col;;
    String ticketId, passengerName, seatNo;
    Destination flight;
    double finalPrice;
    String status = "BOOKED";
    static ArrayList<Coupon> coupons = new ArrayList<>();

    public Ticket(String ticketId, String passengerName, Destination flight, String seatNo) {
        this.ticketId = ticketId;
        this.passengerName = passengerName;
        this.flight = flight;
        this.seatNo = seatNo;
    }

    public void show() {
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.printf("║ %-56s ║%n", "            AIRLINE BOOKING CONFIRMATION");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
            System.out.println();

            System.out.println("PASSENGER INFORMATION");
            System.out.println("┌──────────────────────────────────────────────────────────┐");
            System.out.printf("│ %-56s │%n", "Name:        " + passengerName);
            System.out.printf("│ %-56s │%n", "Booking ID:  " + ticketId);
            System.out.printf("│ %-56s │%n", "Date Issued: " + java.time.LocalDate.now());
            System.out.println("└──────────────────────────────────────────────────────────┘");
            System.out.println();

            System.out.println("FLIGHT DETAILS");
            System.out.println("┌──────────────────────────────────────────────────────────┐");
            System.out.printf("│ %-56s │%n", "Flight:  " + flight.flightId + "  █  " + flight.from + " → " + flight.to);
            System.out.printf("│ %-56s │%n", "Date:    " + flight.date);
            System.out.printf("│ %-56s │%n", "Time:    " + flight.time);
            System.out.printf("│ %-56s │%n", "Gate:    " + flight.gate);
            System.out.printf("│ %-56s │%n", "Seat:    " + seatNo);
            System.out.printf("│ %-56s │%n", "Status:  " + flight.status);
            System.out.println("└──────────────────────────────────────────────────────────┘");
            System.out.println();

            System.out.println("TICKET PRICE");
            System.out.println("┌──────────────────────────────────────────────────────────┐");
            System.out.printf("│ %-56s │%n", String.format("Base Fare:   %,.0f THB", flight.price));
            if (coupon != null) {
                double discount = flight.price - finalPrice;
                System.out.printf("│ %-56s │%n", String.format("Coupon:      %s (-%.0f%%)", coupon.code, coupon.percent));
                System.out.printf("│ %-56s │%n", String.format("Discount:    -%,.0f THB", discount));
            }
            System.out.printf("│ %-56s │%n", String.format("Total:       %,.0f THB", finalPrice));
            System.out.printf("│ %-56s │%n", "Ticket:      " + status);
            System.out.println("└──────────────────────────────────────────────────────────┘");

            System.out.println("IMPORTANT NOTES");
            System.out.println("┌──────────────────────────────────────────────────────────┐");
            System.out.printf("│ %-56s │%n", "✈ Arrive at the airport 2 hours early.");
            System.out.printf("│ %-56s │%n", "✈ E-ticket only. No paper ticket required.");
            System.out.println("└──────────────────────────────────────────────────────────┘");
            System.out.println();

            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.printf("║ %-56s ║%n", "  THANK YOU FOR FLYING WITH US!");
            System.out.printf("║ %-56s ║%n", "  Safe travels and see you soon!");
            System.out.println("╚══════════════════════════════════════════════════════════╝");
    }

    public double calcPrice(double base, Coupon coupon) {
        if (coupon != null) return base * (1 - coupon.percent / 100.0);
        return base;
    }

    public static Coupon findCoupon(String code) {
        for (Coupon c : coupons) {
            if (c.code.equalsIgnoreCase(code)) return c;
        }
        return null;
    }

    static class Coupon {
        String code;
        double percent;
        Coupon(String code, double percent) {
            this.code = code;
            this.percent = percent;
        }
    }
}