package userHandleDesktop.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
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

    public static JLabel getRegisterLabel() {
        return registerLabel;
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

    public UserHandleModel getLoginModel() {
        return new UserHandleModel() {{
            setUserHandle(loginCard.getUserHandleText());
            setPassword(loginCard.getPasswordText());
        }};
    }

    public UserHandleModel getRegisterModel() {
        return new UserHandleModel() {{
            setFirstName(registerCard.getFirstNameText());
            setLastName(registerCard.getLastNameText());
            setUserHandle(registerCard.getUserHandleText());
            setPassword(registerCard.getPasswordText());
        }};
    }

    public JPanel getUserHandleCard() {
        return userHandleCard;
    }

    public JButton getLoginButton() {
        return loginCard.loginButton;
    }

    public JButton getRegisterButton() {
        return registerCard.registerButton;
    }

    public void addMouserEventListener(MouseAdapter mouseAdapter) {
        registerLabel.addMouseListener(mouseAdapter);
        loginLabel.addMouseListener(mouseAdapter);
    }

    public void addActionListener(ActionListener actionListener) {
        this.loginCard.getLoginButton().addActionListener(actionListener);
        this.registerCard.getRegisterButton().addActionListener(actionListener);
    }
}


