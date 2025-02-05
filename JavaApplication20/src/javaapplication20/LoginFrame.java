package javaapplication20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private UserManager userManager;

    public LoginFrame() {
        userManager = new UserManager();
        setTitle("Login");
        setSize(735, 412);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create a background panel with the image path
        BackgroundPanel backgroundPanel = new BackgroundPanel("C:/Users/ahmed/Downloads/test.jpg");
        backgroundPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add username label and field
        gbc.gridx = 0;
        gbc.gridy = 0;
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.BLUE);
        backgroundPanel.add(usernameLabel, gbc);
        
        gbc.gridx = 1;
        usernameField = new JTextField(15);
        usernameField.setOpaque(false);
        usernameField.setForeground(Color.BLUE);
        usernameField.setBackground(new Color(0, 0, 0, 0));
        usernameField.setBorder(BorderFactory.createEmptyBorder());
        backgroundPanel.add(usernameField, gbc);

        // Add password label and field
        gbc.gridx = 0;
        gbc.gridy = 1;
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.BLUE);
        backgroundPanel.add(passwordLabel, gbc);
        
        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        passwordField.setOpaque(false);
        passwordField.setForeground(Color.BLUE);
        passwordField.setBackground(new Color(0, 0, 0, 0));
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        backgroundPanel.add(passwordField, gbc);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton loginButton = new JButton("Login");
        loginButton.setPreferredSize(new Dimension(100, 30));
        loginButton.addActionListener(new LoginAction());
        buttonPanel.add(loginButton);
        
        JButton signupButton = new JButton("Sign Up");
        signupButton.setPreferredSize(new Dimension(100, 30));
        signupButton.addActionListener(new SignupAction());
        buttonPanel.add(signupButton);
        
        // Add button panel to the background panel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.SOUTH;
        backgroundPanel.add(buttonPanel, gbc);
        
        add(backgroundPanel);
    }

    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            User user = userManager.login(username, password);
            
            if (user != null) {
                switch (user.getRole()) {
                    case "admin":
                        new OwnerFrame().setVisible(true);
                        break;
                    case "Cashier":
                        new CashierFrame().setVisible(true);
                        break;
                    case "Customer":
                        new CustomerFrame().setVisible(true);
                        break;
                    case "Supplier":
                        new SupplierFrame().setVisible(true);
                        break;
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(LoginFrame.this, "Invalid credentials");
            }
        }
    }

    private class SignupAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            
            // Role selection
            String[] roles = {"Owner", "Cashier", "Customer", "Supplier"};
            String role = (String) JOptionPane.showInputDialog(
                LoginFrame.this,
                "Select your role:",
                "Role Selection",
                JOptionPane.QUESTION_MESSAGE,
                null,
                roles,
                roles[0]
            );

            if (role != null && userManager.signup(username, password, role)) {
                JOptionPane.showMessageDialog(LoginFrame.this, "Signup successful! You can now log in.");
            } else {
                JOptionPane.showMessageDialog(LoginFrame.this, "Username already exists. Please choose another.");
            }
        }
    }
}