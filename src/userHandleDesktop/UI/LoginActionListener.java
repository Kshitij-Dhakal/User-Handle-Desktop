package userHandleDesktop.UI;

import dependencies.lib.UserBean;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoginActionListener implements ActionListener {

    private UserHandleController userHandleController;

    public LoginActionListener(UserHandleController userHandleController) {
        this.userHandleController = userHandleController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equalsIgnoreCase("login")) {
            UserHandleModel loginModel = userHandleController.view.getLoginModel();
            userHandleController.notifyOnLogin(new UserBean() {{
                setUserHandle(loginModel.getUserHandle());
                setPassword(loginModel.getPassword());
            }});
        } else if (e.getActionCommand().equalsIgnoreCase("register")) {
            UserHandleModel registerModel = userHandleController.view.getRegisterModel();
            if (userHandleController.view.isPasswordsMatch()) {
                userHandleController.notifyOnRegister(new UserBean() {{
                    setFirstName(registerModel.getFirstName());
                    setLastName(registerModel.getLastName());
                    setUserHandle(registerModel.getUserHandle());
                    setPassword(registerModel.getPassword());
                }});

            } else {
                userHandleController.showDialogBox("Passwords don't match");
            }
        }
    }
}
