package userHandleDesktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import static userHandleDesktop.UserHandleView.initializeGbc;
import static userHandleDesktop.UserHandleView.setTextColor;

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
    }

    public JTextField getFirstNameTextField() {
        return firstNameTextField;
    }

    public void setFirstNameTextField(JTextField firstNameTextField) {
        this.firstNameTextField = firstNameTextField;
    }

    public JTextField getLastNameTextField() {
        return lastNameTextField;
    }

    public void setLastNameTextField(JTextField lastNameTextField) {
        this.lastNameTextField = lastNameTextField;
    }

    public JTextField getUserHandleTextField() {
        return userHandleTextField;
    }

    public void setUserHandleTextField(JTextField userHandleTextField) {
        this.userHandleTextField = userHandleTextField;
    }

    public JTextField getPasswordTextField() {
        return passwordTextField;
    }

    public void setPasswordTextField(JPasswordField passwordTextField) {
        this.passwordTextField = passwordTextField;
    }

    public JTextField getCpasswordTextField() {
        return cpasswordTextField;
    }

    public void setCpasswordTextField(JPasswordField cpasswordTextField) {
        this.cpasswordTextField = cpasswordTextField;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

    public void setRegisterButton(JButton registerButton) {
        this.registerButton = registerButton;
    }

    public void addPlaceHolder(FocusListener focusListener) {
        firstNameTextField.addFocusListener(focusListener);
        lastNameTextField.addFocusListener(focusListener);
        userHandleTextField.addFocusListener(focusListener);
        passwordTextField.addFocusListener(focusListener);
        cpasswordTextField.addFocusListener(focusListener);
    }
}