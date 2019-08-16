package userHandleDesktop.UI;

import dependencies.lib.UserBean;

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
                userHandleController.notifyOnLogin(new UserBean() {{
                    //FIXME userbean is created when login button is pressed and this is passed around
                    setUserHandle(loginModel.getUserHandle());
                    setPassword(loginModel.getPassword());
                }});
            } else if (e.getSource().equals(userHandleController.view.getRegisterButton())) {
                UserHandleModel registerModel = userHandleController.view.getRegisterModel();
                if (userHandleController.view.isPasswordsMatch()) {
                    //FIXME handle register in server side
                    if (userHandleController.model.register()) {
                        userHandleController.notifyOnLogin(new UserBean() {{
                            //FIXME userbean is created when register button is pressed and this is passed around
                            setUserHandle(registerModel.getUserHandle());
                            setPassword(registerModel.getPassword());
                        }});
                    } else {
                        System.out.println("Registration Failed");
                    }
                } else {
                    userHandleController.showDialogBox("Passwords don't match");
                }
            }
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InvalidKeySpecException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
