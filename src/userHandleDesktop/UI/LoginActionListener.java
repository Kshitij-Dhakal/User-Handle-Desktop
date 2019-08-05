package userHandleDesktop.UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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
                UserHandleModel loginModel = userHandleController.view.getLoginModel();
                userHandleController.notifyOnLogin(loginModel.getUserHandle(), loginModel.getPassword());
            } else if (e.getSource().equals(userHandleController.view.getRegisterButton())) {
                UserHandleModel registerModel = userHandleController.view.getRegisterModel();
                if (userHandleController.view.isPasswordsMatch()) {
                    if (userHandleController.model.register()) {
                        userHandleController.notifyOnLogin(registerModel.getUserHandle(), registerModel.getPassword());
                    } else {
                        System.out.println("Registration Failed");
                    }
                } else {
                    userHandleController.showDialogBox("Passwords don't match");
                }
            }
        } catch (SQLException ex) {
            System.err.println("SQL not running");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InvalidKeySpecException ex) {
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }
}
