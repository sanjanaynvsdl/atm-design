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



- class disucussion
1. IN the bank service, there might be many functionalities, 
2. someitimes, the api calls from the bank service, might fail, in whicih we have to make multiple requ;s again
3. Accoridng to the back service, response we mgith want to costruct our own reposnse 
4. So, we will have a remote proxy, instead of our ATMcontroller directly talking to the back service we will have a remote proxy, 
5. when ever we are usign external service, we will make use of proxy
6. the Transation interface has processTransaction wchi will be implemented by withdrawl class, getStatemenet class, deposit, checkbalance, 
7. but this withdrawl has multiple steps 

- validate pin
- insert amount (user)
- validate amount( multiple of 100 or etc) (local validation)
- checks cash dispenser for avaliable cash (local validation)
- checks the users bank balance (remote validation)
- checks how much did the user withdrawn on this specif date for base limit validation / ATM specific limit, 


- if any of this fails, we have different flow, 
- if all of this is true, we complete transaction.
- makeTransaction, SRP being violated, and the most of the solid principles are being violated

- discussed state-desgin pattern.

