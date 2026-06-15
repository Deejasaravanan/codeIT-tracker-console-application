import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // Create an instance of Tracker to manage coding questions
        Tracker tracker = new Tracker();
        
        // Create Scanner object for reading user inputs from the console
        Scanner scanner = new Scanner(System.in);
        
        boolean exit = false;

        // Welcome Header
        System.out.println("******************************************************");
        System.out.println("*      Welcome to CodeIt✨ - Coding Question Tracker    *");
        System.out.println("*      Boost your placement prep, one problem at a time! *");
        System.out.println("******************************************************");

        // Main Program Loop
        while (!exit) {
            displayMenu();
            System.out.print("Enter your choice (1-6): ");
            String input = scanner.nextLine().trim();

            int choice = -1;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // Handle non-integer input gracefully
                System.out.println("\n[!] Invalid input. Please enter a number between 1 and 6.");
                continue;
            }

            switch (choice) {
                case 1:
                    // View all coding questions
                    tracker.viewAllQuestions();
                    break;

                case 2:
                    // Mark a coding question as solved
                    System.out.print("Enter the Question ID to mark as solved: ");
                    String idInput = scanner.nextLine().trim();
                    try {
                        int id = Integer.parseInt(idInput);
                        boolean success = tracker.markQuestionSolved(id);
                        if (!success) {
                            System.out.println("\n[X] Error: Question ID " + id + " not found. Please try again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("\n[X] Error: Invalid ID format. Please enter a valid numerical ID.");
                    }
                    break;

                case 3:
                    // View only solved questions
                    tracker.viewSolvedQuestions();
                    break;

                case 4:
                    // View progress stats and completion percentage
                    tracker.viewProgress();
                    break;

                case 5:
                    // Print motivational statistics and exit
                    System.out.println("\n======================================================");
                    System.out.println(" Thank you for using CodeIt!");
                    System.out.println(" Keep practicing, keep coding, and best of luck for placements!");
                    System.out.println("======================================================");
                    exit = true;
                    break;

                case 6:
                    // Explicit Exit option as requested
                    System.out.println("\n======================================================");
                    System.out.println(" Exiting CodeIt tracker. Goodbye!");
                    System.out.println("======================================================");
                    exit = true;
                    break;

                default:
                    System.out.println("\n[!] Invalid choice. Please select an option between 1 and 6.");
                    break;
            }
        }
        
        // Close the scanner resource to avoid memory leaks
        scanner.close();
    }

    /**
     * Helper method to print the user menu.
     */
    private static void displayMenu() {
        System.out.println("=== MENU ===");
        System.out.println("1. View Coding Questions");
        System.out.println("2. Mark Question as Solved");
        System.out.println("3. View Solved Questions");
        System.out.println("4. View Progress");
        System.out.println("5. Exit Program");
        System.out.println("=================");
    }
}
