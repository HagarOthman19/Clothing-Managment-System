package javaapplication20;

import java.awt.BorderLayout;
import javax.swing.*;

class CustomerFrame extends JFrame {
    public CustomerFrame() {
        setTitle("CustomerFrame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a background panel with the image path
        BackgroundPanel backgroundPanel = new BackgroundPanel("C:/Users/ahmed/Downloads/customer.jpg");
        backgroundPanel.setLayout(new BorderLayout());

        // Create buttons
        JButton processSaleButton = new JButton("Process Sale");
        processSaleButton.addActionListener(e -> {
            // Implement sale processing logic
            JOptionPane.showMessageDialog(this, "Sale Processed");
        });

        JButton viewSalesButton = new JButton("View Sales");
        viewSalesButton.addActionListener(e -> {
            // Implement sales viewing logic
            JOptionPane.showMessageDialog(this, "Sales Report");
        });
            JButton viewButton = new JButton("View ");

            JButton viButton = new JButton("Vi");

        // Create a panel for buttons and add them
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(processSaleButton);
        buttonPanel.add(viewSalesButton);
         buttonPanel.add(viewButton);
        buttonPanel.add(viButton);

        // Add the button panel to the background panel at the top
        backgroundPanel.add(buttonPanel, BorderLayout.NORTH);

        // Add the background panel to the frame
        add(backgroundPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CashierFrame frame = new CashierFrame();
            frame.setVisible(true);
        });
    }
}