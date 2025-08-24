package swingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * Name: Agbai Obasi Uwa
 * Registration number: 20231411752
 * Department: Computer Science
 * Group No: 1
 * S/N: 7
 */

public class Swingapp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Run on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create JFrame
                JFrame frame = new JFrame("Date & Time App");
                frame.setSize(400, 200);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new FlowLayout());

                // Components
                JTextField inputField = new JTextField(15);
                JButton button = new JButton("Click Me");
                JLabel resultLabel = new JLabel("Result will appear here...");

                // Add components to frame
                frame.add(new JLabel("Enter something:"));
                frame.add(inputField);
                frame.add(button);
                frame.add(resultLabel);

                // Button click logic
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get current date & time
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        String dateTime = now.format(formatter);

                        // Handle user input safely
                        try {
                            String userInput = inputField.getText();
                            int number = Integer.parseInt(userInput); // attempt conversion
                            resultLabel.setText("DateTime: " + dateTime + " | Parsed Integer: " + number);
                        } catch (NumberFormatException ex) {
                            resultLabel.setText("DateTime: " + dateTime + " | Invalid integer input!");
                        }
                    }
                });

                // Show frame
                frame.setVisible(true);
            }
        });
    }
}
