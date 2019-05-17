package userHandleDesktop.UI;

import dependencies.UI.AddPlaceHolder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static userHandleDesktop.UI.UserHandleView.initializeGbc;
import static userHandleDesktop.UI.UserHandleView.setTextColor;

public class Register extends JPanel {
    JTextField firstNameTextField = new JTextField("First Name", 20);
    JTextField lastNameTextField = new JTextField("Last Name", 20);
    JTextField userHandleTextField = new JTextField("@username", 20);
    JPasswordField passwordTextField = new JPasswordField("Password", 20);
    JPasswordField cpasswordTextField = new JPasswordField("Password", 20);
    JButton registerButton = new JButton("Register");

    public Register() {
        setBackground(Color.WHITE);
        setTextColor(new ArrayList<>() {{
            add(firstNameTextField);
            add(lastNameTextField);
            add(userHandleTextField);
            add(passwordTextField);
            add(cpasswordTextField);
        }}, Color.GRAY);
        UserHandleView.loginLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        initializeGbc(gbc);
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(firstNameTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lastNameTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(userHandleTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(passwordTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(cpasswordTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(registerButton, gbc);
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Already have an account?"), gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        add(UserHandleView.loginLabel, gbc);

        addPlaceHolder();
    }

    private void addPlaceHolder() {
        firstNameTextField.addFocusListener(new AddPlaceHolder("First Name", firstNameTextField));
        lastNameTextField.addFocusListener(new AddPlaceHolder("Last Name", lastNameTextField));
        userHandleTextField.addFocusListener(new AddPlaceHolder("@username", userHandleTextField));
        passwordTextField.addFocusListener(new AddPlaceHolder("Password", passwordTextField));
        cpasswordTextField.addFocusListener(new AddPlaceHolder("Password", cpasswordTextField));
    }

    public String getFirstNameText() {
        return firstNameTextField.getText().trim();
    }

    public String getLastNameText() {
        return lastNameTextField.getText().trim();
    }

    public String getUserHandleText() {
        return userHandleTextField.getText().trim();
    }

    public String getPasswordText() {
        return ((JTextField) passwordTextField).getText().trim();
    }

    public String getCpasswordText() {
        return ((JTextField) cpasswordTextField).getText().trim();
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

}