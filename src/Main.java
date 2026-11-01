public class Main {
    public static void main(String[] args) {
        // Initialize the currency service
        CurrencyService service = new CurrencyService();

        // --- TEMPORARY CONSOLE TEST (Until GUI is pushed) ---
        System.out.println("=== Currency Service Backend Test ===");

        System.out.println("Available Currencies:");
        for (String currency : service.getAvailableCurrencies()) {
            System.out.println(" - " + currency);
        }

        // Test conversion: 100 EUR to USD
        double testAmount = 100.0;
        String from = "EUR - Euro";
        String to = "USD - US Dollar";
        double result = service.convert(testAmount, from, to);

        System.out.printf("%nTest Conversion: %.2f [%s] = %.2f [%s]%n", testAmount, from, result, to);

        // TODO: Uncomment the code below once ConverterGUI is implemented and pushed
        /*
        javax.swing.SwingUtilities.invokeLater(() -> {
            ConverterGUI app = new ConverterGUI();
            app.setVisible(true);
        });
        */
    }
}