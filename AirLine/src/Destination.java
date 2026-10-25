import java.util.*;

// flight + seat map
public class Destination {
    String flightId, from, to, date, time, gate;
    String status = "ON_TIME";   // ON_TIME / DELAYED / CANCELLED
    double price;
    boolean[][] seats = new boolean[8][7];   // false = free, true = taken

    public Destination(String flightId, String from, String to,
                       String date, String time, String gate, double price) {
        this.flightId = flightId;
        this.from = from;
        this.to = to;
        this.date = date;
        this.time = time;
        this.gate = gate;
        this.price = price;
    }

    public void showSeats() {
        System.out.println("\n        A   B     C   D   E     F   G");
        for (int r = 0; r < seats.length; r++) {
            System.out.print("   " + (r + 1) + "   ");
            for (int c = 0; c < seats[r].length; c++) {
                System.out.print(seats[r][c] ? "[X] " : "[ ] ");
                if (c == 1) System.out.print("  ");
                if (c == 4) System.out.print("  ");// aisle
            }
            System.out.println();
        }
        System.out.println("\n   [ ] Available    [X] Taken\n");
    }

    public boolean bookSeat(int row, int col) {
        if (seats[row][col]) return false;
        seats[row][col] = true;
        return true;
    }

    public void releaseSeat(int row, int col) {
        seats[row][col] = false;
    }

    public void showInfo() {
        String mark = status.equals("ON_TIME") ? "✓" : status.equals("DELAYED") ? "⚠" : "✗";
        System.out.printf("%-8s %-12s %-12s %-12s %-7s %-6s %,9.0f  %s %s%n",
                flightId, from, to, date, time, gate, price, mark, status);
    }

    public static void showAll(ArrayList<Destination> list) {
        System.out.printf("%-8s %-12s %-12s %-12s %-7s %-6s %9s  %s%n",
                "Flight", "From", "To", "Date", "Time", "Gate", "Price", "Status");
        System.out.println("-------------------------------------------------------------------------------------");
        for (Destination d : list) d.showInfo();
        System.out.println("-------------------------------------------------------------------------------------");
    }
}