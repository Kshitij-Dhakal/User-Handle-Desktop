package userHandleDesktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import static userHandleDesktop.UserHandleView.initializeGbc;
import static userHandleDesktop.UserHandleView.setTextColor;

class Login extends JPanel {
    JTextField userHandleTextField = new JTextField("@username", 20);
    JPasswordField passwordTextField = new JPasswordField("Password", 20);
    JButton loginButton = new JButton("Login");

    public Login() {
        setBackground(Color.WHITE);
        setTextColor(new ArrayList<>() {{
            add(userHandleTextField);
            add(passwordTextField);
        }}, Color.GRAY);
        UserHandleView.registerLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        initializeGbc(gbc);
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
        add(UserHandleView.registerLabel, gbc);
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

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public void addPlaceHolder(FocusListener focusListener) {
        userHandleTextField.addFocusListener(focusListener);
        passwordTextField.addFocusListener(focusListener);
    }

}
