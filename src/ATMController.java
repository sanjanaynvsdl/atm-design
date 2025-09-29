package src;

import java.util.Scanner;

public class ATMController {
    private CardReader cardReader;
    private CashDispenser cashDispenser;
    private Scanner scanner;
    private ITrasactionType trasactionType;

    public ATMController() {
        this.cardReader = new CardReader();
        this.cashDispenser = new CashDispenser();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("===== Welcome to ATM =====");
      
    }

    public boolean insertCard(Card card) {
        return cardReader.validateCard(card);
    }

    public boolean processTransaction(ITrasactionType transaction, Card card, int amount, int pin) {
        return transaction.processTransaction(card, amount, pin);
    }

    public Card removeCard() {
        return cardReader.removeCard();
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public void shutdown() {
        scanner.close();
        System.out.println("ATM shutting down...");
    }
}
