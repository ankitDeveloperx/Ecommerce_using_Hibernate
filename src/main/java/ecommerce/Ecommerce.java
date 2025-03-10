package ecommerce;

import java.util.Scanner;

public class Ecommerce {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==============Ecommerce===============");
        boolean b = true;

        while (b) {
            System.out.println("1. Login\n2. Registration\n3. Delete User\n4. Exit");
            System.out.print("Enter your Choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); 
                continue;
            }

            int ch = scanner.nextInt();
            scanner.nextLine(); 

            switch (ch) {
                case 1:
                    new UserLogin().start();
                    break;
                case 2:
                    new SaveUser().start();
                    break;
                case 3:
                    new DeleteUser().start();
                    break;
                case 4:  // Fixed Exit Case
                    b = false;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid Choice! Try Again");
            }
        }

        scanner.close();
    }
}
