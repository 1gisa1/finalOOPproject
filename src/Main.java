import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String selection =
                "Menu: \n" +
                        "1) Add car \n" +
                        "2) Delete car \n" +
                        "3) Get a list of car \n" +
                        "4) Find a most expensive car \n" +
                        "5) Calculate the total cost of all cars \n" +
                        "0) Exit";


        CarLogic carLogic = new CarLogic();



        while (true) {
            System.out.println(selection);
            boolean switcer1 = carLogic.menu(result());
            if (!switcer1) {
                break;
            }


        }


    }


    public static int result() {
        return new Scanner(System.in).nextInt();
    }


}