package userHandleDesktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

public class UserHandleView extends JFrame {
    private JPanel loginCard = new Login();
    private JPanel registerCard = new Register();
    private JPanel userHandleCard = new JPanel();
    private static JLabel loginLabel = new JLabel("<html><a href=\"#\">Login</a></html>");
    private static JLabel registerLabel = new JLabel("<html><a href=\"#\">Register</a></html>");

    public JPanel getLoginCard() {
        return loginCard;
    }

    public void setLoginCard(JPanel loginCard) {
        this.loginCard = loginCard;
    }

    public JPanel getRegisterCard() {
        return registerCard;
    }

    public void setRegisterCard(JPanel registerCard) {
        this.registerCard = registerCard;
    }

    public JPanel getUserHandleCard() {
        return userHandleCard;
    }

    public void setUserHandleCard(JPanel userHandleCard) {
        this.userHandleCard = userHandleCard;
    }

    public static JLabel getLoginLabel() {
        return loginLabel;
    }

    public static void setLoginLabel(JLabel loginLabel) {
        UserHandleView.loginLabel = loginLabel;
    }

    public static JLabel getRegisterLabel() {
        return registerLabel;
    }

    public static void setRegisterLabel(JLabel registerLabel) {
        UserHandleView.registerLabel = registerLabel;
    }

    public UserHandleView() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Login");
        add(userHandleCard);
        userHandleCard.setLayout(new CardLayout());
        userHandleCard.add(loginCard, "Login");
        userHandleCard.add(registerCard, "Register");
        ((CardLayout) userHandleCard.getLayout()).show(userHandleCard, "Login");
        setSize(300, 350);
    }

    private class Login extends JPanel {
        JTextField userHandleTextField = new JTextField("@username", 20);
        JTextField passwordTextField = new JTextField("Password", 20);
        JButton loginButton = new JButton("Login");

        public Login() {
            addPlaceHolder(new ArrayList<>() {{
                add(userHandleTextField);
                add(passwordTextField);
            }});
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

    }

    private void initializeGbc(GridBagConstraints gbc) {
        gbc.ipadx = 5;
        gbc.ipady = 5;
        gbc.insets = new Insets(5, 5, 5, 5);
    }

    private class Register extends JPanel {
        JTextField firstNameTextField = new JTextField("First Name", 20);
        JTextField lastNameTextField = new JTextField("Last Name", 20);
        JTextField userHandleTextField = new JTextField("@username", 20);
        JTextField passwordTextField = new JTextField("Password", 20);
        JTextField cpasswordTextField = new JTextField("Confirm Password", 20);
        JButton registerButton = new JButton("Register");


        public Register() {
            addPlaceHolder(new ArrayList<>() {{
                add(firstNameTextField);
                add(lastNameTextField);
                add(userHandleTextField);
                add(passwordTextField);
                add(cpasswordTextField);
            }});
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
    }

    private static class AddPlaceHolder implements FocusListener {
        private JTextField textField;

        public AddPlaceHolder(JTextField textField, String placeHolder) {
            this.textField = textField;
            this.placeHolder = placeHolder;
        }

        private String placeHolder;

        @Override
        public void focusGained(FocusEvent e) {
            if (textField.getText().equals(placeHolder)) {
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

    private static void setTextColor(List<JTextField> textFieldList, Color color) {
        for (JTextField textField :
                textFieldList) {
            textField.setForeground(color);
        }
    }

    private static void addPlaceHolder(List<JTextField> textFieldList) {
        for (JTextField textField :
                textFieldList) {
            textField.addFocusListener(new AddPlaceHolder(textField, textField.getText()));
        }
    }

    public void addMouserEventListener(MouseAdapter mouseAdapter) {
        registerLabel.addMouseListener(mouseAdapter);
        loginLabel.addMouseListener(mouseAdapter);
    }
}
