package src;

public class Withdraw  implements ITrasactionType{
    @Override
    public boolean processTransaction(Card card, int amount, int pin) {
        return true;
    }
    
}
