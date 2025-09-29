package src;

public class CheckBalance implements ITrasactionType {

    @Override
    public boolean processTransaction(Card card, int amount, int pin) {
        System.out.println("\n--- Checking Balance ---");

        if (!validatePin(pin)) {
            System.out.println("Invalid PIN");
            return false;
        }

        double balance = fetchBalanceFromBank(card);
        displayBalance(card, balance);
        printReceipt(card, balance);

        return true;
    }

    private boolean validatePin(int pin) {
        return pin > 999 && pin <= 9999;
    }

    private double fetchBalanceFromBank(Card card) {
        System.out.println("Fetching balance from bank for card: " + card.getCardHolderName());
        return 25000.50;
    }

    private void displayBalance(Card card, double balance) {
        System.out.println("\n===== ACCOUNT BALANCE =====");
        System.out.println("Card Holder: " + card.getCardHolderName());
        System.out.println("Available Balance: Rs." + balance);
        System.out.println("============================\n");
    }

    private void printReceipt(Card card, double balance) {
        System.out.println("\n===== BALANCE RECEIPT =====");
        System.out.println("Card Number: XXXX-XXXX-XXXX-" + card.getCardNumber().substring(12));
        System.out.println("Transaction Type: Balance Inquiry");
        System.out.println("Available Balance: Rs." + balance);
        System.out.println("Date: " + java.time.LocalDateTime.now());
        System.out.println("============================\n");
    }
}