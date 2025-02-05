/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication20;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnerFrame extends JFrame {
    private JPanel buttonPanel; // Panel to hold the action buttons
    private boolean isMenuVisible = false; // Track visibility of the button panel

    public OwnerFrame() {
        setTitle("admin Frame");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create a background panel with the image path
        BackgroundPanel backgroundPanel = new BackgroundPanel("C:/Users/ahmed/Downloads/test.jpg");
        backgroundPanel.setLayout(new BorderLayout());

        // Add title label
        JLabel titleLabel = new JLabel("Welcome to the admin Frame", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE); // Set text color to white for visibility
        backgroundPanel.add(titleLabel, BorderLayout.NORTH);

        // Create a button to toggle the action menu
        JButton openMenuButton = new JButton("Open Menu");
        openMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleButtonPanel();
            }
        });
        backgroundPanel.add(openMenuButton, BorderLayout.SOUTH);

        // Initialize the button panel
        initializeButtonPanel();

        // Add the background panel to the frame
        backgroundPanel.add(buttonPanel, BorderLayout.CENTER);
        add(backgroundPanel);
    }

    private void initializeButtonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3, 10, 10)); // 2 rows, 3 columns with gaps
        buttonPanel.setOpaque(false); // Make the panel transparent

        // Create six buttons and add them to the panel
        for (int i = 1; i <= 6; i++) {
            JButton actionButton = new JButton("Action " + i);
            actionButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle button action
                    JOptionPane.showMessageDialog(OwnerFrame.this, "Action " + i + " executed!");
                }
            });
            buttonPanel.add(actionButton);
        }

        buttonPanel.setVisible(false); // Initially hide the button panel
    }

    private void toggleButtonPanel() {
        isMenuVisible = !isMenuVisible; // Toggle visibility
        buttonPanel.setVisible(isMenuVisible); // Show or hide the button panel
        buttonPanel.revalidate(); // Refresh the layout
        buttonPanel.repaint(); // Repaint the panel
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OwnerFrame frame = new OwnerFrame();
            frame.setVisible(true);
        });
    }
}
