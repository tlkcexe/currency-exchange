import java.util.LinkedHashMap;
import java.util.Map;

public class CurrencyService {

    // Stores exchange rates relative to EUR (Base currency = 1.0)
    private final Map<String, Double> exchangeRates;

    public CurrencyService() {
        // Using LinkedHashMap to maintain the insertion order of currencies
        exchangeRates = new LinkedHashMap<>();
        exchangeRates.put("EUR - Euro", 1.0);
        exchangeRates.put("USD - US Dollar", 1.08);
        exchangeRates.put("GBP - British Pound", 0.85);
        exchangeRates.put("JPY - Japanese Yen", 162.50);
        exchangeRates.put("CHF - Swiss Franc", 0.96);
    }

    // Returns the list of available currencies (to be used by the GUI dropdowns)
    public String[] getAvailableCurrencies() {
        return exchangeRates.keySet().toArray(new String[0]);
    }

    // Converts the amount from one currency to another
    public double convert(double amount, String fromCurrency, String toCurrency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }

        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency selection.");
        }

        double rateFrom = exchangeRates.get(fromCurrency);
        double rateTo = exchangeRates.get(toCurrency);

        // Convert to base currency (EUR) first, then to target currency
        return (amount / rateFrom) * rateTo;
    }
}