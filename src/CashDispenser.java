package src;

import java.util.HashMap;
import java.util.Map;

public class CashDispenser {
    private Map<Denomination, Integer> availableNotes;
    private IDispenseStrategy dispenseStrategy;

    public CashDispenser() {
        this.availableNotes = new HashMap<>();
        initializeCash();
        this.dispenseStrategy = new MinimizeNotesStrategy();
    }

    private void initializeCash() {
        availableNotes.put(Denomination.TWO_THOUSAND, 50);
        availableNotes.put(Denomination.FIVE_HUNDRED, 100);
        availableNotes.put(Denomination.TWO_HUNDRED, 200);
        availableNotes.put(Denomination.HUNDRED, 500);
    }

    public int getAvailableCash() {
        int totalCash = 0;
        for (Map.Entry<Denomination, Integer> entry : availableNotes.entrySet()) {
            totalCash += entry.getKey().getValue() * entry.getValue();
        }
        return totalCash;
    }

    public boolean hasSufficientCash(int amount) {
        return getAvailableCash() >= amount;
    }

    public boolean dispenseCash(int amount) {
        if (!hasSufficientCash(amount)) {
            System.out.println("Insufficient cash in ATM");
            return false;
        }

        Map<Denomination, Integer> notesToDispense = dispenseStrategy.dispenseCash(amount, availableNotes);

        if (notesToDispense == null) {
            System.out.println("Cannot dispense exact amount with available denominations");
            return false;
        }

        for (Map.Entry<Denomination, Integer> entry : notesToDispense.entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();
            availableNotes.put(denom, availableNotes.get(denom) - count);
            System.out.println("Dispensing " + count + " x Rs." + denom.getValue());
        }

        System.out.println("Total amount dispensed: Rs." + amount);
        return true;
    }

    public void setDispenseStrategy(IDispenseStrategy strategy) {
        this.dispenseStrategy = strategy;
    }
}
