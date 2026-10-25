import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Room {
    int roomNumber;
    String roomType;
    double pricePerNight;
    boolean isAvailable;
    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }
    @Override
    public String toString() {
        return "Room #" + roomNumber + " [" + roomType + "] - $" + pricePerNight + "/night - Status: " + (isAvailable ? "AVAILABLE" : "BOOKED");
    }
}
class Reservation {
    String customerName;
    Room room;
    int days;
    double totalPrice;
    boolean isPaid;

    public Reservation(String customerName, Room room, int days) {
        this.customerName = customerName;
        this.room = room;
        this.days = days;
        this.totalPrice = room.pricePerNight * days;
        this.isPaid = false;
    }
    @Override
    public String toString() {
        return "Guest: " + customerName + " | Room #" + room.roomNumber + " (" + room.roomType + ")" +
                " | Stay: " + days + " night(s) | Total: $" + totalPrice + " | Status: " + (isPaid ? "PAID" : "UNPAID");
    }
}
public class ReceptionHotelBookingSystem {
    public static void main(String[] args) {
        Stack<Reservation> bookingStack = new Stack<>();
        // ประเภทห้อง
        List<Room> roomList = new ArrayList<>();
        roomList.add(new Room(101, "Standard Single", 100.0));
        roomList.add(new Room(102, "Standard Single", 100.0));
        roomList.add(new Room(103, "Standard Double", 150.0));
        roomList.add(new Room(201, "Executive Deluxe", 250.0));
        roomList.add(new Room(301, "Presidential Suite", 500.0));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n================ RECEPTION DESK SYSTEM ================");
            System.out.println("1. Book Room for Customer");
            System.out.println("2. Cancel Last Customer Booking");
            System.out.println("3. Process Customer Payment");
            System.out.println("4. View Active Booking Log");
            System.out.println("5. Exit System");
            System.out.println("=======================================================");
            System.out.print("Select staff action (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n--- NEW CUSTOMER BOOKING ---");
                    System.out.print("Enter Customer Full Name: ");
                    String customerName = scanner.nextLine();
                    // แสดงห้องว่าง
                    System.out.println("\nCurrently Available Rooms:");
                    for (Room r : roomList) {
                        if (r.isAvailable) {
                            System.out.println(" Room #" + r.roomNumber + " (" + r.roomType + ") - $" + r.pricePerNight + "/night");
                        }
                    }
                    System.out.print("Enter Room Number to Assign: ");
                    int selectedRoomNum = scanner.nextInt();
                    // หาห้องว่าง
                    Room selectedRoom = null;
                    for (Room r : roomList) {
                        if (r.roomNumber == selectedRoomNum && r.isAvailable) {
                            selectedRoom = r;
                            break;
                        }
                    }
                    if (selectedRoom == null) {
                        System.out.println(" [!] Error: Room is invalid or booked!");
                        break;
                    }
                    System.out.print("Enter Number of Nights: ");
                    int days = scanner.nextInt();
                    // user stay room -> unavailable
                    selectedRoom.isAvailable = false;
                    Reservation newBooking = new Reservation(customerName, selectedRoom, days);
                    bookingStack.push(newBooking);
                    System.out.println("\nBooking success for [" + customerName + "] in Room #" + selectedRoom.roomNumber + "!");
                    break;
                case 2:
                    System.out.println("\n--- CANCEL RECENT BOOKING ---");
                    if (bookingStack.isEmpty()) {
                        System.out.println(" [!] No active bookings available to cancel.");
                    } else {
                        Reservation cancelled = bookingStack.pop();
                        // คเปลี่ยนเป้นห้องว่าง จองได้
                        cancelled.room.isAvailable = true;
                        System.out.println("Cancellation success for guest [" + cancelled.customerName +
                                "] (Room #" + cancelled.room.roomNumber + ") has been CANCELLED and room is now available again.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- PROCESS CUSTOMER PAYMENT ---");
                    if (bookingStack.isEmpty()) {
                        System.out.println(" [!] No active bookings in system.");
                    } else {
                        System.out.print("Enter Customer Name to Process Payment: ");
                        String targetName = scanner.nextLine().trim();
                        Reservation foundReservation = null;
                        // หาชื่อลูกค้า
                        for (Reservation res : bookingStack) {
                            if (res.customerName.equalsIgnoreCase(targetName)) {
                                foundReservation = res;
                                break;
                            }
                        }
                        if (foundReservation == null) {
                            System.out.println(" [!] No reservation found for customer: " + targetName);
                        } else if (foundReservation.isPaid) {
                            System.out.println(" [!] Reservation for guest [" + foundReservation.customerName + "] is ALREADY paid.");
                        } else {
                            foundReservation.isPaid = true;
                            System.out.println("\n================ PAYMENT RECEIPT ================");
                            System.out.println("Guest Name:     " + foundReservation.customerName);
                            System.out.println("Room Details:   Room #" + foundReservation.room.roomNumber + " (" + foundReservation.room.roomType + ")");
                            System.out.println("Length of Stay: " + foundReservation.days + " night(s)");
                            System.out.println("Total Amount:   $" + foundReservation.totalPrice);
                            System.out.println("Payment Status: PAID");
                            System.out.println("=================================================");
                            System.out.println("Successful payment!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("\n--- FRONT DESK BOOKING LOG ---");
                    if (bookingStack.isEmpty()) {
                        System.out.println("No active reservations logged.");
                    } else {
                        System.out.println("Most Recent Booking: " + bookingStack.peek());
                        System.out.println("\nAll Active Bookings (Latest to Oldest):");
                        for (int i = bookingStack.size() - 1; i >= 0; i--) {
                            System.out.println(" [" + (bookingStack.size() - i) + "] " + bookingStack.get(i));
                        }
                    }
                    break;
                case 5:
                    System.out.println("Logging out of Reception System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Select a menu option only from 1 to 6.");
            }
        }
    }
}