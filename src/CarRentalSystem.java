import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static User currentUser = null;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            while (running) {
                if (currentUser == null) {
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");
                    int choice = getIntInput(scanner);

                    switch (choice) {
                        case 1:
                            register(scanner);
                            break;
                        case 2:
                            login(scanner);
                            break;
                        case 3:
                            running = false;
                            System.out.println("Exiting the system.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } else {
                    System.out.println("Welcome to the TRAVELTIME CAR RENTAL SOFTWARE, Please choose what to work on");
                    System.out.println("1. Add a Car");
                    System.out.println("2. Add a Motorcycle");
                    System.out.println("3. Add a Truck");
                    System.out.println("4. Display All Vehicles");
                    System.out.println("5. Logout");
                    System.out.print("Enter your choice: ");
                    int choice = getIntInput(scanner);

                    switch (choice) {
                        case 1:
                            vehicles.add(createCar(scanner));
                            break;
                        case 2:
                            vehicles.add(createMotorcycle(scanner));
                            break;
                        case 3:
                            vehicles.add(createTruck(scanner));
                            break;
                        case 4:
                            displayAllVehicles();
                            break;
                        case 5:
                            currentUser = null;
                            System.out.println("Logged out successfully.");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        }
    }

    private static void register(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        users.add(new User(username, password));
        System.out.println("Registration successful. You can now log in.");
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful. Welcome, " + username + "!");
                return;
            }
        }

        System.out.println("Invalid username or password. Please try again.");
    }

    private static Car createCar(Scanner scanner) {
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter year: ");
        int year = getIntInput(scanner);
        System.out.println("Enter number of doors: ");
        int doors = getIntInput(scanner);
        System.out.println("Enter fuel type (petrol, diesel, electric): ");
        String fuelType = scanner.nextLine();

        Car car = new Car(make, model, year);
        car.setNumberOfDoors(doors);
        car.setFuelType(fuelType);

        return car;
    }

    private static Motorcycle createMotorcycle(Scanner scanner) {
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter year: ");
        int year = getIntInput(scanner);
        System.out.println("Enter number of wheels: ");
        int wheels = getIntInput(scanner);
        System.out.println("Enter motorcycle type (sport, cruiser, off-road): ");
        String type = scanner.nextLine();

        Motorcycle motorcycle = new Motorcycle(make, model, year);
        motorcycle.setNumberOfWheels(wheels);
        motorcycle.setMotorcycleType(type);

        return motorcycle;
    }

    private static Truck createTruck(Scanner scanner) {
        System.out.println("Enter make: ");
        String make = scanner.nextLine();
        System.out.println("Enter model: ");
        String model = scanner.nextLine();
        System.out.println("Enter year: ");
        int year = getIntInput(scanner);
        System.out.println("Enter cargo capacity (in tons): ");
        double capacity = getDoubleInput(scanner);
        System.out.println("Enter transmission type (manual, automatic): ");
        String transmissionType = scanner.nextLine();

        Truck truck = new Truck(make, model, year);
        truck.setCargoCapacity(capacity);
        truck.setTransmissionType(transmissionType);

        return truck;
    }

    private static void displayAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles available.");
        } else {
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter an integer: ");
            }
        }
    }

    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}