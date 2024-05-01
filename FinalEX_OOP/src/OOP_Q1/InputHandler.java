package OOP_Q1;

import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int getIntInput() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            scanner.next(); // Read and discard non-int input
            System.out.print("Please enter an integer: ");
        }
        int result = scanner.nextInt();
        scanner.nextLine();  // Consume the remaining newline
        return result;
    }
    public int getbalanceInput() {
        System.out.print("Enter your balance: ");
        while (!scanner.hasNextInt()) {
            scanner.next(); // Read and discard non-int input
            System.out.print("Please enter an integer: ");
        }
        int result = scanner.nextInt();
        scanner.nextLine();  // Consume the remaining newline
        return result;
    }

    public String getyesnoInput() {
        System.out.print("Enter your response: ");
         String input = scanner.nextLine().trim().toLowerCase(); // Normalize the input to lower case

    // Check if the input is either "yes" or "no"
    while (!input.equals("yes") && !input.equals("no")) {
        System.out.print("Invalid input. Please enter 'yes' or 'no': ");
        input = scanner.nextLine().trim().toLowerCase();
    }

    return input;
    }
    public String getNameInput() {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }
    public String getStringInput() {
        System.out.print("Enter your respone: ");
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }

    public void Clientcreate(){
        System.out.println("\nEnter your name, and then your balance - for example 'Lary', Enter, '500' ");

    }

    public void displayOptions() {
        System.out.println("\nEnter '1' for price, '2' for airline, '3' for duration, '4' for departure time:");
    }

    public int [] displayPricePrompt() {
        int[] minmax = new int[2];
        System.out.println("Enter minimum price:");
        minmax[0] = getIntInput();
        System.out.println("Enter maximum price:");
        minmax[1] = getIntInput();
        return minmax;

    }

    public void displayFilterOptions() {
        System.out.println("Enter 1 for all airlines, 2 for a specific airline, 3 to filter by duration:");
    }

    public void displayErrorMessage() {
        System.out.println("Invalid option, try again.");
    }
}
