package userHandleDesktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class UserHandleView extends JFrame {

    public UserHandleView() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(new Login());
        setSize(300, 350);
    }

    private class Login extends JPanel {
        JTextField userHandleTextField = new JTextField("@username", 20);
        JTextField passwordTextField = new JTextField("Password", 20);
        JButton loginButton = new JButton("Login");
        JLabel registerLabel = new JLabel("<html><a href=\"#\">Register</a></html>");

        public Login() {
            userHandleTextField.addFocusListener(new addPlaceHolder(userHandleTextField, "@username"));
            passwordTextField.addFocusListener(new addPlaceHolder(passwordTextField, "Password"));
            registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            userHandleTextField.setForeground(Color.GRAY);
            passwordTextField.setForeground(Color.GRAY);
            setLayout(new GridBagLayout());
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.ipadx = 5;
            gbc.ipady = 5;
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.gridwidth = 2;
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(userHandleTextField, gbc);
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(passwordTextField, gbc);
            gbc.gridx = 0;
            gbc.gridy = 2;
            add(loginButton, gbc);
            gbc.gridwidth = 1;
            gbc.gridx = 0;
            gbc.gridy = 3;
            add(new JLabel("Don't have an account?"), gbc);
            gbc.gridx = 1;
            gbc.gridy = 3;
            add(registerLabel, gbc);
        }
    }

    private class Register extends JPanel {
        JTextField firstNameTextField = new JTextField(20);
        JTextField lastNameTextField = new JTextField(20);
        JTextField userHandleTextField = new JTextField(20);
        JTextField passwordTextField = new JTextField(20);

    }

    public static void main(String[] args) {
        new UserHandleView();
    }

    private class addPlaceHolder implements FocusListener {
        private JTextField textField;

        public addPlaceHolder(JTextField textField, String placeHolder) {
            this.textField = textField;
            this.placeHolder = placeHolder;
        }

        private String placeHolder;

        @Override
        public void focusGained(FocusEvent e) {
            if (textField.getText().equalsIgnoreCase(placeHolder)) {
                textField.setForeground(Color.BLACK);
                textField.setText("");
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (textField.getText().isEmpty()) {
                textField.setForeground(Color.GRAY);
                textField.setText(placeHolder);
            }
        }
    }
}
