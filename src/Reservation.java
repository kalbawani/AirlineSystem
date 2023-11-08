import java.util.Scanner;

enum AirClass {
    First,
    Economy
}

public class Reservation {
    public static final int FIRST_SEAT_FIRST_CLASS = 1;
    public static final int LAST_SEAT_FIRST_CLASS = 5;
    public static final int FIRST_SEAT_ECO_CLASS = 6;
    public static final int LAST_SEAT_ECO_CLASS = 10;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Passenger[] passengers = new Passenger[LAST_SEAT_ECO_CLASS + 1];

        while (true) {
            printMenu();
            int choice = readUserChoice("\nEnter your choice (1 - 3): ");

            System.out.printf("============================%n");

            switch (choice) {
                case 1:
                    makeReservation(passengers);
                    break;
                case 2:
                    printPassengerList(passengers);
                    break;
                case 3:
                    System.out.println("System is shutting down ...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
    }

    public static void printMenu() {
        System.out.printf("============================%n");
        System.out.println("Menu");
        System.out.println("----");
        System.out.println("1. Make a reservation");
        System.out.println("2. Print passenger list");
        System.out.println("3. Quit");
    }

    public static int readUserChoice(String message) {
        System.out.print(message);
        return scanner.nextInt();
    }

    public static void makeReservation(Passenger[] passengers) {
        int choice = readUserChoice("Please enter 1 for First Class and enter 2 for Economy: ");

        switch (choice) {
            case 1:
                reserveSeat(passengers, FIRST_SEAT_FIRST_CLASS, LAST_SEAT_FIRST_CLASS);
                break;
            case 2:
                reserveSeat(passengers, FIRST_SEAT_ECO_CLASS, LAST_SEAT_ECO_CLASS);
                break;
            default:
                System.out.println("Invalid choice. Try again!");
                break;
        }
    }

    public static void reserveSeat(Passenger[] passengers, int firstSeat, int lastSeat) {
        for (int i = firstSeat; i <= lastSeat; i++) {
            if (passengers[i] == null) {
                String name = readPassengerName();
                AirClass airClass = (i < LAST_SEAT_FIRST_CLASS ? AirClass.First : AirClass.Economy);

                Passenger passenger = new Passenger(name, i, airClass);

                printBoardingPass(passenger);
                return;
            }
        }

        System.out.println("Sorry, all seats in this class are reserved!");
    }

    public static String readPassengerName() {
        System.out.print("Please enter the passenger name: ");
        return scanner.next();
    }

    private static void printBoardingPass(Passenger passenger) {
        printHeader("\nBoarding Pass:");
        printPassenger(passenger);
    }

    public static void printHeader(String title) {
        System.out.println(title);
        System.out.println("---------------------");
        System.out.printf("%-20s %-10s %-10s %n", "Name", "Seat", "Class");
        System.out.printf("%-20s %-10s %-10s %n", "----", "----", "-----");
    }

    public static void printPassenger(Passenger passenger) {
        System.out.printf("%-20s %-10d %-10s %n", passenger.getName(), passenger.getSeatNo(), passenger.getAirClass());
    }

    public static void printPassengerList(Passenger[] passengers) {
        printHeader("Passenger List:");

        for (Passenger passenger : passengers) {
            printPassenger(passenger);
        }
    }
}
