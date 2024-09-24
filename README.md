# Tool Rental Application

## Overview

This is a simple tool rental application designed as a point-of-sale system for a tool rental store. The application calculates rental charges based on the tool type, rental duration, applicable discounts, and special days (weekends and holidays). It can handle multiple rental agreements in one session and calculate the total cost for all rentals.

## Features

- **Tool Selection**: Choose from a variety of tools such as Chainsaws, Ladders, and Jackhammers, each with specific rental charges.
- **Multiple Rentals**: Handle multiple rental agreements in one session and print all agreements along with a total charge.
- **Rental Agreement**: Generates detailed rental agreements that include rental days, chargeable days, discount amounts, and final charges.
- **Holiday Handling**: Automatically adjusts for Independence Day and Labor Day, applying holiday rates as specified.
- **Weekend Handling**: Some tools charge for weekends, while others do not, and the application handles this accordingly.

## Tools Available

| Tool Code | Tool Type  | Brand   | Daily Charge | Weekday Charge | Weekend Charge | Holiday Charge |
|-----------|------------|---------|--------------|----------------|----------------|----------------|
| CHNS      | Chainsaw   | Stihl   | $1.49        | Yes            | No             | Yes            |
| LADW      | Ladder     | Werner  | $1.99        | Yes            | Yes            | No             |
| JAKD      | Jackhammer | DeWalt  | $2.99        | Yes            | No             | No             |
| JAKR      | Jackhammer | Ridgid  | $2.99        | Yes            | No             | No             |

## Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/sadie8686/js0924.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd js0924
    ```

3. **Compile the code:**

    ```bash
    javac -d bin src/*.java
    ```

4. **Run the application:**

    ```bash
    java -cp bin ToolRentalApplication
    ```


## Usage

The application can be run from the command line. It demonstrates multiple rentals in one session. By default, it includes a sample scenario where three tools (Ladder, Chainsaw, Jackhammer) are rented with different rental days and discounts. You can modify the `ToolRentalApplication` class to test different scenarios.

### Example Output

```plaintext
Tool code: LADW
Tool type: Ladder
Tool brand: Werner
Rental days: 5
Check out date: 09/01/24
Due date: 09/06/24
Daily rental charge: $1.99
Charge days: 4
Pre-discount charge: $7.96
Discount percent: 10%
Discount amount: $0.80
Final charge: $7.16

Tool code: CHNS
Tool type: Chainsaw
Tool brand: Stihl
Rental days: 3
Check out date: 07/02/24
Due date: 07/05/24
Daily rental charge: $1.49
Charge days: 2
Pre-discount charge: $2.98
Discount percent: 20%
Discount amount: $0.60
Final charge: $2.38

Tool code: JAKD
Tool type: Jackhammer
Tool brand: DeWalt
Rental days: 7
Check out date: 09/05/24
Due date: 09/12/24
Daily rental charge: $2.99
Charge days: 5
Pre-discount charge: $14.95
Discount percent: 15%
Discount amount: $2.24
Final charge: $12.71

Total cost for all rentals: $22.25
