import java.util.*; import java.io.*;

public class Quiz_Game {
    public static void main(String[] args) {
        int choice;
        Scanner cin = new Scanner(System.in);

        // Java handles file appending using 'true' in the FileWriter constructor
        try (PrintWriter logFile = new PrintWriter(new FileWriter("logs/activity.log", true))) {

            System.out.println("==== Welcome to CyberQuest ====");
            System.out.println("\n1. Login");
            System.out.println("2. Password Security Challenge");
            System.out.println("3. Phishing Detection Challenge");
            System.out.println("4. Encryption Basics Challenge");
            System.out.println("5. View Scores");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            choice = cin.nextInt();

            if (choice == 1) {
                System.out.println("\nOpening Login System...");
                logFile.println("User opened Login System");
            } else if (choice == 2) {
                System.out.println("\nOpening Password Security Challenge...");
                logFile.println("User opened Password Security Challenge");
            } else if (choice == 3) {
                System.out.println("\nOpening Phishing Detection Challenge...");
                logFile.println("User opened Phishing Detection Challenge");
            } else if (choice == 4) {
                System.out.println("\nOpening Encryption Basics Challenge...");
                logFile.println("User opened Encryption Basics Challenge");
            } else if (choice == 5) {
                System.out.println("\nOpening Score Tracker...");
                logFile.println("User opened Score Tracker");
            } else if (choice == 6) {
                System.out.println("\nExiting CyberQuest...");
                logFile.println("User exited CyberQuest");
            } else {
                System.out.println("\nInvalid choice.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the log file.");
        }
    }
}