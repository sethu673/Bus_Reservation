package bus_reservation;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BusReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Bus");
            System.out.println("2. View All Buses");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter bus name:");
                    String busName = scanner.nextLine();
                    System.out.println("Enter bus type:");
                    String busType = scanner.nextLine();
                    System.out.println("Enter total seats:");
                    int totalSeats = scanner.nextInt();
                    
                    Bus bus = new Bus();
                    bus.setBusName(busName);
                    bus.setBusType(busType);
                    bus.setTotalSeats(totalSeats);

                    try {
                        Bus.addBus(bus);
                        System.out.println("Bus added successfully!");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        List<Bus> buses = Bus.getAllBuses();
                        for (Bus b : buses) {
                            System.out.println(b.getBusName() + " - " + b.getBusType() + " - " + b.getTotalSeats() + " seats");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}

