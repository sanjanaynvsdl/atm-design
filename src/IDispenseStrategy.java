package src;

import java.util.Map;

public interface IDispenseStrategy {
    public Map<Denomination, Integer> dispenseCash(int amount, Map<Denomination, Integer> availableNotes);
}
