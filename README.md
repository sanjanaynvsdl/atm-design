# ATM Design 


A simple ATM system implementation with card validation, cash dispensing, and transaction processing.

## Class Diagram

![ATM Class Diagram](classdiagramATM.png)

```mermaid
classDiagram
    class Main {
        +main(String[] args)
        +displayMenu()
    }

    class ATMController {
        -CardReader cardReader
        -CashDispenser cashDispenser
        -Scanner scanner
        +start()
        +insertCard(Card) boolean
        +processTransaction(ITrasactionType, Card, int, int) boolean
        +removeCard() Card
        +getCashDispenser() CashDispenser
    }

    class Card {
        -String cardNumber
        -String cardHolderName
        -LocalDate expiryDate
        -int cvv
        -ECardType cardType
        -String bankName
        +getters/setters
    }

    class CardReader {
        -Card currentCard
        +validateCard(Card) boolean
        +removeCard() Card
        +getCurrentCard() Card
        +hasCard() boolean
    }

    class CashDispenser {
        -Map~Denomination, Integer~ availableNotes
        -IDispenseStrategy dispenseStrategy
        +getAvailableCash() int
        +dispenseCash(int) boolean
        +hasSufficientCash(int) boolean
    }

    class ITrasactionType {
        <<interface>>
        +processTransaction(Card, int, int) boolean
    }

    class Withdrawal {
        -CashDispenser cashDispenser
        -double dailyLimit
        +processTransaction(Card, int, int) boolean
    }

    class CheckBalance {
        +processTransaction(Card, int, int) boolean
    }

    class IDispenseStrategy {
        <<interface>>
        +dispenseCash(int, Map) Map
    }

    class MinimizeNotesStrategy {
        +dispenseCash(int, Map) Map
    }

    class Denomination {
        <<enumeration>>
        HUNDRED
        TWO_HUNDRED
        FIVE_HUNDRED
        TWO_THOUSAND
        +getValue() int
    }

    class ECardType {
        <<enumeration>>
        DEBIT
        CREDIT
    }

    Main --> ATMController
    Main --> Card
    ATMController --> CardReader
    ATMController --> CashDispenser
    ATMController --> ITrasactionType
    Card --> ECardType
    CardReader --> Card
    CashDispenser --> IDispenseStrategy
    CashDispenser --> Denomination
    ITrasactionType <|-- Withdrawal
    ITrasactionType <|-- CheckBalance
    IDispenseStrategy <|-- MinimizeNotesStrategy
    Withdrawal --> CashDispenser
```

## Key Design Patterns Used

1. **Strategy Pattern**: `IDispenseStrategy` with `MinimizeNotesStrategy`
2. **Template Method**: `ITrasactionType` interface with concrete implementations
3. **Single Responsibility**: Each class has one clear purpose

## Transaction Flow

1. **Card Insertion**: CardReader validates card details
2. **Menu Selection**: User chooses transaction type
3. **PIN Validation**: Each transaction validates PIN
4. **Processing**: Transaction-specific logic executes
5. **Cash Dispensing**: Uses strategy pattern for note distribution
6. **Receipt Generation**: Transaction confirmation

## Components

- **Main**: Entry point, user interaction, menu display
- **ATMController**: Central coordinator, delegates to components
- **CardReader**: Card validation and management
- **CashDispenser**: Cash management with configurable dispensing strategy
- **Transaction Types**: Withdrawal, CheckBalance (extensible for more)
- **Strategy**: MinimizeNotesStrategy for optimal cash dispensing
