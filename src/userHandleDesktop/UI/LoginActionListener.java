package userHandleDesktop.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class LoginActionListener implements ActionListener {

    private UserHandleController userHandleController;

    public LoginActionListener(UserHandleController userHandleController) {
        this.userHandleController = userHandleController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource().equals(userHandleController.view.getLoginButton())) {
                if (userHandleController.model.login()) {
                    userHandleController.notifyOnLogin();
                } else {
                    System.out.println("Login Failed");
                }
            } else if (e.getSource().equals(userHandleController.view.getRegisterButton())) {
                if (userHandleController.model.register()) {
                    userHandleController.notifyOnLogin();
                } else {
                    System.out.println("Registration Failed");
                }
            }
        } catch (SQLException ex) {
            System.err.println("SQL not running");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
