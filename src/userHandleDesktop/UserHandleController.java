package userHandleDesktop;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserHandleController {
    UserHandleView view;
    UserHandleModel model;

    public UserHandleController(UserHandleView view, UserHandleModel model) {
        this.view = view;
        this.model = model;
        this.view.addMouserEventListener(new toggleLoginRegister(this.view));
    }

    public static void main(String[] args) {
        new UserHandleController(new UserHandleView(), new UserHandleModel());

    }

    static class toggleLoginRegister extends MouseAdapter {
        private UserHandleView view;

        toggleLoginRegister(UserHandleView view) {
            this.view = view;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource().equals(UserHandleView.getRegisterLabel())) {
                ((CardLayout)view.getUserHandleCard().getLayout()).show(view.getUserHandleCard(),"Register");
            } else if (e.getSource().equals(UserHandleView.getLoginLabel())) {
                ((CardLayout)view.getUserHandleCard().getLayout()).show(view.getUserHandleCard(),"Login");
            }
        }
    }
}
