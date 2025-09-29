package src;

import java.util.HashMap;
import java.util.Map;

public class MinimizeNotesStrategy implements IDispenseStrategy {

    @Override
    public Map<Denomination, Integer> dispenseCash(int amount, Map<Denomination, Integer> availableNotes) {
        Map<Denomination, Integer> dispensedNotes = new HashMap<>();

        Denomination[] denominations = {
            Denomination.TWO_THOUSAND,
            Denomination.FIVE_HUNDRED,
            Denomination.TWO_HUNDRED,
            Denomination.HUNDRED
        };

        for (Denomination denom : denominations) {
            if (amount >= denom.getValue()) {
                int notesNeeded = amount / denom.getValue();
                int notesAvailable = availableNotes.getOrDefault(denom, 0);
                int notesToDispense = Math.min(notesNeeded, notesAvailable);

                if (notesToDispense > 0) {
                    dispensedNotes.put(denom, notesToDispense);
                    amount -= notesToDispense * denom.getValue();
                }
            }
        }

        if (amount > 0) {
            System.out.println("Unable to dispense exact amount. Remaining: " + amount);
            return null;
        }

        return dispensedNotes;
    }
}