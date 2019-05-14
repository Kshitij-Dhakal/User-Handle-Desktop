package userHandleDesktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.util.List;

public class UserHandleView extends JFrame {
    static JLabel loginLabel = new JLabel("<html><a href=\"#\">Login</a></html>");
    static JLabel registerLabel = new JLabel("<html><a href=\"#\">Register</a></html>");
    private Login loginCard = new Login();
    private Register registerCard = new Register();
    private JPanel userHandleCard = new JPanel();

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

    static void initializeGbc(GridBagConstraints gbc) {
        gbc.ipadx = 5;
        gbc.ipady = 5;
        gbc.insets = new Insets(5, 5, 5, 5);
    }

    static void setTextColor(List<JTextField> textFieldList, Color color) {
        for (JTextField textField :
                textFieldList) {
            textField.setForeground(color);
        }
    }

    public Login getLoginCard() {
        return loginCard;
    }

    public void setLoginCard(Login loginCard) {
        this.loginCard = loginCard;
    }

    public Register getRegisterCard() {
        return registerCard;
    }

    public void setRegisterCard(Register registerCard) {
        this.registerCard = registerCard;
    }

    public JPanel getUserHandleCard() {
        return userHandleCard;
    }

    public void setUserHandleCard(JPanel userHandleCard) {
        this.userHandleCard = userHandleCard;
    }

/*
    private static void addPlaceHolder(List<JTextField> textFieldList) {
        for (JTextField textField :
                textFieldList) {
            textField.addFocusListener(new AddPlaceHolder(textField, textField.getText()));
        }
    }
*/

    public void addMouserEventListener(MouseAdapter mouseAdapter) {
        registerLabel.addMouseListener(mouseAdapter);
        loginLabel.addMouseListener(mouseAdapter);
    }

    public void addPlaceHolder(FocusListener focusListener) {
        this.loginCard.addPlaceHolder(focusListener);
        this.registerCard.addPlaceHolder(focusListener);
    }

    public void addActionListener(ActionListener actionListener) {
        this.loginCard.getLoginButton().addActionListener(actionListener);
        this.registerCard.getRegisterButton().addActionListener(actionListener);
    }
}


