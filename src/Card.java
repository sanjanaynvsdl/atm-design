package src;

import java.time.LocalDate;

public class Card {
    private String cardNumber;
    private String cardHolderName;
    private LocalDate expiryDate;
    private int cvv;
    private ECardType cardType;
    private String bankName;


    public Card(String cardNo, String name, LocalDate date, int cvv, ECardType cardType, String bankName) {
        this.cardNumber = cardNo;
        this.cardHolderName = name;
        this.expiryDate = date;
        this.cvv = cvv;
        this.cardType = cardType;
        this.bankName = bankName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public ECardType getCardType() {
        return cardType;
    }

    public void setCardType(ECardType cardType) {
        this.cardType = cardType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
