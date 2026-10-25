import java.util.*;

// refund requests
public class Additional {
    Queue<Refund> refunds = new LinkedList<>();

    public void addRefund(String ticketId, String reason) {
        refunds.offer(new Refund(ticketId, reason));
    }

    public void showPending() {
        for (Refund refund : refunds) refund.show();
    }

    public Refund decide(boolean approve) {
        Refund r = refunds.poll();   // person who sent first
        if (r != null) {
            if (approve) {
                r.status = "APPROVED";
                Ticket t = AirLine.findTicket(r.ticketId);
                if (t != null) {
                    t.flight.releaseSeat(t.row, t.col);   // free the seat
                    AirLine.tickets.remove(t);             // remove the ticket
                }
            } else {
                r.status = "REJECTED";
            }
        }
        return r;
    }

    static class Refund {
        String ticketId, reason, status = "PENDING";
        Refund(String ticketId, String reason) {
            this.ticketId = ticketId;
            this.reason = reason;
        }
        void show() {
            System.out.println("╔══════════════════════════════════════════════════════════╗");
            System.out.printf("║ %-56s ║%n", "           ✈  REFUND REQUEST");
            System.out.printf("║ %-56s ║%n", "Ticket ID : " + ticketId);
            System.out.printf("║ %-56s ║%n", "Reason    : " + reason);
            System.out.printf("║ %-56s ║%n", "Status    : " + status);
            System.out.println("╚══════════════════════════════════════════════════════════╝");
        }
    }
}