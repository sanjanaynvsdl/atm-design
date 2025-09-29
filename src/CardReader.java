package src;

import java.time.LocalDate;

public class CardReader {
    private Card currentCard;

    public boolean validateCard(Card card) {
        System.out.println("--Reading the card--");

        if (card == null) {
            System.out.println("Invalid card: Card is null");
            return false;
        }

        if (card.getCardNumber() == null || card.getCardNumber().length() != 16) {
            System.out.println("Invalid card: Card number must be 16 digits");
            return false;
        }


        // if (card.getExpiryDate() == null || card.getExpiryDate().isBefore(LocalDate.now())) {
        //     System.out.println("Invalid card: Card is expired");
        //     return false;
        // }

        this.currentCard = card;
        System.out.println("Card accepted successfully!");
        System.out.println("Card Holder: " + card.getCardHolderName());
        System.out.println("Card Type: " + card.getCardType());
        System.out.println("Bank: " + card.getBankName());
        return true;
    }

    public Card removeCard() {
        if (currentCard == null) {
            System.out.println("No card to remove");
            return null;
        }

        Card removedCard = currentCard;
        currentCard = null;
        System.out.println("Card removed successfully");
        return removedCard;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public boolean hasCard() {
        return currentCard != null;
    }
}
