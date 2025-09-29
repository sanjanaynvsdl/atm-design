package src;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("less design atm!");

        Card card1 = new Card("1234567890123456", "Sanjana", LocalDate.of(2026, 12, 31), 123, ECardType.DEBIT,
                "SBI Bank");
        Card card2 = new Card("9876543210987654", "Jane Smith", LocalDate.of(2025, 6, 30), 456, ECardType.CREDIT,
                "HDFC Bank");

        ATMController atm = new ATMController();
        Scanner scanner = new Scanner(System.in);

        atm.start();

        System.out.println("\n===== Select Card =====");
        System.out.println("1. Sanjana - SBI Debit Card");
        System.out.println("2. test - HDFC Credit Card");
        System.out.print("Select card (1 or 2): ");
        int cardChoice = scanner.nextInt();

        Card selectedCard = (cardChoice == 1) ? card1 : card2;

        if (atm.insertCard(selectedCard)) {
            boolean continueSession = true;

            while (continueSession) {
                displayMenu();
                int choice = scanner.nextInt();

                System.out.print("Enter PIN: ");
                int pin = scanner.nextInt();

                ITrasactionType transaction = null;
                int amount = 0;

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to withdraw: ");
                        amount = scanner.nextInt();
                        transaction = new Withdrawal(atm.getCashDispenser());
                        atm.processTransaction(transaction, selectedCard, amount, pin);
                        break;

                    case 2:
                        transaction = new CheckBalance();
                        atm.processTransaction(transaction, selectedCard, 0, pin);
                        break;

                    case 3:
                        System.out.println("Deposit functionality not implemented yet");
                        break;

                    case 4:
                        continueSession = false;
                        Card removedCard = atm.removeCard();
                        if (removedCard != null) {
                            System.out.println("Thank you for using our ATM!");
                        }
                        break;

                    default:
                        System.out.println("Invalid option!");
                }

                if (continueSession && choice != 4) {
                    System.out.print("\nDo you want another transaction? (yes=1/no=0): ");
                    int another = scanner.nextInt();
                    continueSession = (another == 1);
                }
            }
        } else {
            System.out.println("Card validation failed! Please try with another card.");
        }

        atm.shutdown();
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Withdraw Cash");
        System.out.println("2. Check Balance");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}
