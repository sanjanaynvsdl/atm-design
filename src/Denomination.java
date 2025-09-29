package src;

public enum Denomination {
    HUNDRED(100),
    TWO_HUNDRED(200),
    FIVE_HUNDRED(500),
    TWO_THOUSAND(2000);

    private final int value;

    Denomination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}