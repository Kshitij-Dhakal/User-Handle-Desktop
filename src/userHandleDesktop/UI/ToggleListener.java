package userHandleDesktop.UI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ToggleListener extends MouseAdapter {
    private UserHandleView view;

    ToggleListener(UserHandleView view) {
        this.view = view;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(UserHandleView.getRegisterLabel())) {
            view.setTitle("Register");
            ((CardLayout) view.getUserHandleCard().getLayout()).show(view.getUserHandleCard(), "Register");
        } else if (e.getSource().equals(UserHandleView.getLoginLabel())) {
            view.setTitle("Login");
            ((CardLayout) view.getUserHandleCard().getLayout()).show(view.getUserHandleCard(), "Login");
        }
    }
}
