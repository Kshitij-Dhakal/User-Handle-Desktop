package userHandleDesktop.UI;

import dependencies.Listeners.LoginListener;

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

    public void notifyOnLogin() {
        listener.onDatabaseLogin();
    }

    public UserHandleModel getModel() {
        return model;
    }

    public void showDialogBox(String message) {
        view.showDialogBox(message);
    }
}
