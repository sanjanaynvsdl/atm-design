### ATM Design Requirements

#### Core Components
1. Card reader
2. PIN entry interface (physical/digital)
3. Cash dispenser with multiple dispensing strategies (e.g., minimize note count)
4. Transaction receipt printer

#### Functional Requirements
5. Future capabilities: PIN change, mini statement generation
6. Support for all card types
7. Transaction fees based on respective bank policies
8. Deposit functionality

#### Process Flow
- Card insertion triggers PIN verification
- Upon correct PIN entry, ATM establishes connection to bank account
- System performs validations and security checks

#### Design Considerations
- Similar design patterns apply to everyday machines (coffee machines, vending machines, snack dispensers)
- Common architectural patterns can be reused across these systems



#### Class Discussion Notes

**Bank Service Integration:**
1. Bank service contains multiple functionalities
2. API calls to bank service may fail, requiring retry mechanisms
3. ATM needs to construct custom responses based on bank service responses
4. Remote proxy pattern: ATM controller communicates through proxy instead of directly with bank service
5. External service integration always uses proxy pattern

**Transaction Processing:**
6. Transaction interface defines `processTransaction()` method
7. Implemented by: Withdrawal, GetStatement, Deposit, CheckBalance classes

**Withdrawal Transaction Steps:**
- PIN validation
- Amount input from user
- Amount validation (multiples of 100, etc.) - local validation
- Cash dispenser availability check - local validation
- User bank balance verification - remote validation
- Daily withdrawal limit check - ATM/bank specific limits

**Error Handling:**
- If any validation fails, alternative flow is triggered
- All validations must pass to complete transaction
- Current implementation violates SRP and other SOLID principles

**Design Pattern Notes:**
- State design pattern was discussed for transaction flow management

