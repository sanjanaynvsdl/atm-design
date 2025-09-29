package src;

public class Withdrawal implements ITrasactionType {
    private CashDispenser cashDispenser;
    private double dailyLimit = 50000;
    private double minimumAmount = 100;

    public Withdrawal(CashDispenser cashDispenser) {
        this.cashDispenser = cashDispenser;
    }

    @Override
    public boolean processTransaction(Card card, int amount, int pin) {
        System.out.println("\n--- Processing Withdrawal ---");

        if (!validatePin(pin)) {
            System.out.println("Invalid PIN");
            return false;
        }

        if (!validateAmount(amount)) {
            return false;
        }

        if (!checkCashDispenserAvailability(amount)) {
            return false;
        }

        if (!checkBankBalance(card, amount)) {
            return false;
        }

        if (!checkDailyLimit(amount)) {
            return false;
        }

        boolean success = cashDispenser.dispenseCash(amount);
        if (success) {
            System.out.println("Withdrawal successful!");
            printReceipt(card, amount);
        }

        return success;
    }

    private boolean validatePin(int pin) {
        return pin > 999 && pin <= 9999;
    }

    private boolean validateAmount(int amount) {
        if (amount < minimumAmount) {
            System.out.println("Minimum withdrawal amount is Rs." + minimumAmount);
            return false;
        }

        if (amount % 100 != 0) {
            System.out.println("Amount must be in multiples of 100");
            return false;
        }

        return true;
    }

    private boolean checkCashDispenserAvailability(int amount) {
        if (!cashDispenser.hasSufficientCash(amount)) {
            System.out.println("ATM does not have sufficient cash");
            return false;
        }
        return true;
    }

    private boolean checkBankBalance(Card card, int amount) {
        System.out.println("Checking bank balance for card: " + card.getCardHolderName());
        return true;
    }

    private boolean checkDailyLimit(int amount) {
        if (amount > dailyLimit) {
            System.out.println("Amount exceeds daily limit of Rs." + dailyLimit);
            return false;
        }
        return true;
    }

    private void printReceipt(Card card, int amount) {
        System.out.println("\n===== TRANSACTION RECEIPT =====");
        System.out.println("Card Number: XXXX-XXXX-XXXX-" + card.getCardNumber().substring(12));
        System.out.println("Transaction Type: Withdrawal");
        System.out.println("Amount: Rs." + amount);
        System.out.println("Date: " + java.time.LocalDateTime.now());
        System.out.println("================================\n");
    }
}