# Currency Converter

A simple desktop currency converter written in Java using Swing. The application converts amounts between five major currencies using fixed exchange rates, with a clean separation between backend logic and the user interface.

## Supported Currencies

* EUR - Euro (Base currency)
* USD - US Dollar
* GBP - British Pound
* JPY - Japanese Yen
* CHF - Swiss Franc

## Project Structure

The source code is located inside the `src` directory and consists of three classes:

* `Main.java`: The entry point that launches the application.
* `CurrencyService.java`: Handles the exchange rates, input validation, and conversion calculations.
* `ConverterGUI.java`: Builds the Swing user interface and connects user actions to the service class.

## Requirements

* Java JDK 8 or higher

## How to Run

1. Clone the repository:
   ```bash
   git clone [https://github.com/tlkcexe/currency-converter.git](https://github.com/tlkcexe/currency-converter.git)
2. Open the project folder in IntelliJ IDEA (or any Java IDE).

3. Run the ```Main.java``` file.