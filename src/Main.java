import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Launch the GUI application on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            ConverterGUI app = new ConverterGUI();
            app.setVisible(true);
        });
    }
}