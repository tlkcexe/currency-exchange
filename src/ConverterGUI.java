import javax.swing.*;
import java.awt.*;

public class ConverterGUI extends JFrame {

    private final CurrencyService currencyService;
    private JTextField amountField;
    private JComboBox<String> fromCurrencyBox;
    private JComboBox<String> toCurrencyBox;
    private JLabel resultLabel;

    public ConverterGUI() {
        // Initialize the backend service
        currencyService = new CurrencyService();

        // Setup main window properties
        setTitle("Currency Converter");
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on screen
        setLayout(new GridLayout(7, 2, 10, 10));

        initializeComponents();
    }

    private void initializeComponents() {
        String[] currencies = currencyService.getAvailableCurrencies();

        // 1. Amount input
        add(new JLabel("  Amount to convert:"));
        amountField = new JTextField();
        add(amountField);

        // 2. From Currency dropdown
        add(new JLabel("  From Currency:"));
        fromCurrencyBox = new JComboBox<>(currencies);
        add(fromCurrencyBox);

        // 3. To Currency dropdown
        add(new JLabel("  To Currency:"));
        toCurrencyBox = new JComboBox<>(currencies);
        toCurrencyBox.setSelectedIndex(1); // Default to USD
        add(toCurrencyBox);

        // 4. Convert Button
        add(new JLabel("")); // Empty placeholder for grid alignment
        JButton convertButton = new JButton("Convert");
        add(convertButton);

        // 5. Swap Button
        add(new JLabel(""));
        JButton swapButton = new JButton("Swap");
        add(swapButton);

        // 6. Clear Button
        add(new JLabel(""));
        JButton clearButton = new JButton("Clear");
        add(clearButton);

        // 7. Result display
        add(new JLabel("  Result:"));
        resultLabel = new JLabel("0.00");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 15));
        add(resultLabel);

        // Add button click listener
        convertButton.addActionListener(e -> handleConversion());

        // Add swap button listener
        swapButton.addActionListener(e -> {
            int fromIndex = fromCurrencyBox.getSelectedIndex();
            int toIndex = toCurrencyBox.getSelectedIndex();

            fromCurrencyBox.setSelectedIndex(toIndex);
            toCurrencyBox.setSelectedIndex(fromIndex);

            // Convert after swap
            handleConversion();

        });
        // Clear Button listener
        clearButton.addActionListener(e -> {
            amountField.setText("");
            fromCurrencyBox.setSelectedIndex(0);
            toCurrencyBox.setSelectedIndex(1);
            resultLabel.setText("0.00");
        });
    }

    private void handleConversion() {
        try {
            // Replace comma with dot to support both decimal formats
            String input = amountField.getText().trim().replace(",", ".");
            double amount = Double.parseDouble(input);

            String from = (String) fromCurrencyBox.getSelectedItem();
            String to = (String) toCurrencyBox.getSelectedItem();

            // Perform conversion using the backend service
            double result = currencyService.convert(amount, from, to);

            // Extract the 3-letter currency code and display formatted result
            String currencyCode = to.substring(0, 3);
            resultLabel.setText(String.format("%.2f %s", result, currencyCode));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid numeric amount.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException ex) {
            // Catches negative amounts or invalid currencies from CurrencyService
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}