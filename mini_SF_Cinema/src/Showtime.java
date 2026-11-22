import java.util.*;

class Showtime {
    static final int ROWS = 5, COLS = 10;

    String movie, time;
    BitSet sold = new BitSet(ROWS * COLS);            // BitSet: bit
    Map<Integer, Integer> locks = new HashMap<>();         // HashMap
    Queue<String> waitlist = new LinkedList<>();           // Queue

    Showtime(String movie, String time) {
        this.movie = movie;
        this.time = time;
    }
    boolean isFree(int seat) {
        return !sold.get(seat) && !locks.containsKey(seat);
    }
    boolean lockSeats(List<Integer> seats, int bookingId) {
        for (int s : seats) {
            if (!isFree(s)) return false;
        }
        for (int s : seats) locks.put(s, bookingId);
        return true;
    }
    void unlockSeats(List<Integer> seats) {
        for (int s : seats) locks.remove(s);
    }
    void sellSeats(List<Integer> seats) {
        for (int s : seats) {
            locks.remove(s);
            sold.set(s);
        }
    }

    // 1) Sliding Window: เลื่อนหน้าต่างขนาด n ไปตามแถว นับที่นั่งที่ไม่ว่างในหน้าต่าง
    List<Integer> findAdjacent(int n) {
        if (n < 1 || n > COLS) return null;
        int bestRow = -1, bestStart = 0;
        double bestDist = 999;

        for (int r = 0; r < ROWS; r++) {
            int busy = 0;
            for (int c = 0; c < COLS; c++) {
                if (!isFree(r * COLS + c)) busy++;                    // ที่นั่งใหม่เข้า
                if (c >= n && !isFree(r * COLS + c - n)) busy--;      // ที่นั่งเก่าออก
                if (c >= n - 1 && busy == 0) {
                    int start = c - n + 1;
                    double dist = Math.abs(start + (n - 1) / 2.0 - (COLS - 1) / 2.0);
                    if (dist < bestDist) {
                        bestDist = dist;
                        bestRow = r;
                        bestStart = start;
                    }
                }
            }
        }
        if (bestRow < 0) return null;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) result.add(bestRow * COLS + bestStart + i);
        return result;
    }

    static String seatNames(List<Integer> seats) {          // [0, 1] = "A1, A2"
        List<String> names = new ArrayList<>();
        for (int s : seats) names.add("" + (char) ('A' + s / COLS) + (s % COLS + 1));
        return String.join(", ", names);
    }

    int freeSeats() {
        return ROWS * COLS - sold.cardinality() - locks.size();
    }

    void printMap() {
        System.out.println("   " + movie + "   ·   รอบ " + time + "\n");
        System.out.println("      ############  SCREEN  ############\n");

        System.out.print("      ");
        for (int c = 0; c < COLS; c++) {
            System.out.printf(" %-2d", c + 1);
        }
        System.out.println();

        for (int r = 0; r < ROWS; r++) {
            char row = (char) ('A' + r);
            System.out.print("   " + row + "  ");
            for (int c = 0; c < COLS; c++) {
                int seat = r * COLS + c;
                System.out.print(sold.get(seat) ? "[X]" : locks.containsKey(seat) ? "[L]" : "[ ]");
            }
            System.out.println("   " + row);
        }
        System.out.println("\n   [ ] ว่าง     [L] ถูกล็อก     [X] ขายแล้ว");
        System.out.println("   ที่นั่งว่าง " + freeSeats() + " / " + ROWS * COLS);
    }
}