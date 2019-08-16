package userHandleDesktop.UI;

import dependencies.Listeners.LoginListener;
import dependencies.lib.UserBean;

public class UserHandleController {
    UserHandleView view;
    UserHandleModel model;
    private LoginListener listener;

    public UserHandleController() {
        this.view = new UserHandleView();
        this.model = new UserHandleModel(view);
        this.view.addMouserEventListener(new ToggleListener(view));
        this.view.addActionListener(new LoginActionListener(this));
    }

    public static void main(String[] args) {
        new UserHandleController();
    }

    public UserHandleView getView() {
        return view;
    }

    public void setListener(LoginListener listener) {
        this.listener = listener;
    }

    public void notifyOnLogin(UserBean bean) {
        listener.onLoginButtonEvent(bean);
    }

    public void notifyOnRegister(UserBean bean) {
        listener.onRegisterButtonEvent(bean);
    }

    public void showDialogBox(String message) {
        view.showDialogBox(message);
    }
}
