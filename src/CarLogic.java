import java.util.Scanner;

public class CarLogic implements CarOperations {
    private static int currentId = 1;

    Car[] arrayCar = new Car[0];


    @Override
    public boolean menu(int num) {

        CarLogic carLogic = new CarLogic();

        switch (num) {

            case 1:
                addCar();
                break;
            case 2:
                removeCar();
                break;
            case 3:
                carList();
                break;
            case 4:
                findExpensiveCar();
                break;
            case 5:
                findTotalCoastCar();
                break;
            case 0:
                System.out.println("BEST WISHES!!!");
                return false;

            default:
                System.out.println("Invalid value specified !!!");
                break;

        }


        return true;
    }


    @Override
    public void addCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the brand of car");
        String make = scanner.nextLine();

        System.out.println("Enter the model of car");
        String model = scanner.nextLine();

        System.out.println("Enter the year of car");
        int year;
        while (true) {
            try {
                year = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid year.");
            }
        }

        System.out.println("Enter the price of car");
        double price;
        while (true) {
            try {
                price = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid price.");
            }
        }

        Car car = new Car(currentId++, make, model, year, price);
        Car[] newArray = new Car[arrayCar.length + 1];
        System.arraycopy(arrayCar, 0, newArray, 0, arrayCar.length);
        newArray[newArray.length - 1] = car;
        arrayCar = newArray;

        System.out.println("Car with ID " + car.getId() + " has been added.");
    }


    @Override
    public void removeCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the car to be removed:");

        int id = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;

        for (int i = 0; i < arrayCar.length; i++) {
            Car car = arrayCar[i];
            if (car != null && car.getId() == id) {
                arrayCar[i] = null;
                found = true;

                for (int j = i; j < arrayCar.length - 1; j++) {
                    arrayCar[j] = arrayCar[j + 1];
                }
                arrayCar[arrayCar.length - 1] = null;
                break;
            }
        }

        if (found) {
            System.out.println("Car with ID " + id + " has been removed.");
        } else {
            System.out.println("Car with ID " + id + " was not found.");
        }
    }


    @Override
    public void carList() {
        for (Car value : arrayCar) {
            if (value != null) {
                System.out.printf("Car id: %d\n", value.getId());
                System.out.printf("Brand: %s\n", value.getMake());
                System.out.printf("Model: %s\n", value.getModel());
                System.out.printf("Year: %d\n", value.getYear());
                System.out.printf("Price: %.2f\n", value.getPrice());
                System.out.println();
            }
        }

    }

    @Override
    public void findExpensiveCar() {

        double maxCoastCar = 0;
        String maxCoastCar2 = "";
        for (Car car : arrayCar) {
            if (car.getPrice() > maxCoastCar) {

                maxCoastCar2 = "id " + car.getId() + ", make " + car.getMake() + " ,model " + car.getModel() + " ,year " + car.getYear() + " ,price "+ car.getPrice() ;
            }
        }
        System.out.println("the most expensive car: " + maxCoastCar2);
    }

    @Override
    public void findTotalCoastCar() {

    double totalCoast = 0;
        for (Car car : arrayCar) {
            totalCoast += car.getPrice();
        }

        System.out.println("total coast car: " + totalCoast);
    }





    private String entered() {
        return new Scanner(System.in).next();
    }
}



/*    private final Scanner scanner = new Scanner(System.in);
    private final List<Car> carList = new ArrayList<>();

    public void addCar() {
        Car car = new Car();

        System.out.println("Enter the brand of car");
        car.setMake(scanner.nextLine());

        System.out.println("Enter the model of car");
        car.setModel(scanner.nextLine());

        System.out.println("Enter the year of car");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid year.");
            scanner.nextLine();
        }
        car.setYear(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Enter the price of car");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid price.");
            scanner.nextLine();
        }
        car.setPrice(scanner.nextDouble());
        scanner.nextLine();

        carList.add(car);

        viewCars();
    }

    public void viewCars() {
        Car[] carArray = carList.toArray(new Car[0]);
        if (carArray.length == 0) {
            System.out.println("No cars to display.");
            return;
        }

        System.out.println("List of cars:");

        for (int i = 0; i < carArray.length; i++) {
            Car car = carArray[i];
            System.out.printf("Car #%d:\n", i + 1);
            System.out.printf("Brand: %s\n", car.getMake());
            System.out.printf("Model: %s\n", car.getModel());
            System.out.printf("Year: %d\n", car.getYear());
            System.out.printf("Price: %.2f\n", car.getPrice());
            System.out.println();
        }
    }*/