package userHandleDesktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserHandleController {
    UserHandleView view;
    UserHandleModel model;

    public UserHandleController(UserHandleView view, UserHandleModel model) {
        this.view = view;
        this.model = model;
        this.view.addMouserEventListener(new toggleLoginRegister(this.view));
        this.view.addPlaceHolder(new AddPlaceHolder(this.view));
    }

    public static void main(String[] args) {
        new UserHandleController(new UserHandleView(), new UserHandleModel());

    }

    private static class toggleLoginRegister extends MouseAdapter {
        private UserHandleView view;

        toggleLoginRegister(UserHandleView view) {
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

    private static class AddPlaceHolder implements FocusListener {
        private UserHandleView view;

        AddPlaceHolder(UserHandleView view) {
            this.view = view;
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (e.getSource().equals(view.getLoginCard().getUserHandleTextField())) {
                if (view.getLoginCard().getUserHandleTextField().getText().equals("@username")) {
                    view.getLoginCard().getUserHandleTextField().setText("");
                    view.getLoginCard().getUserHandleTextField().setForeground(Color.BLACK);
                }
            }else if (e.getSource().equals(view.getLoginCard().getPasswordTextField())) {
                if (view.getLoginCard().getPasswordTextField().getText().equals("Password")) {
                    view.getLoginCard().getPasswordTextField().setText("");
                    view.getLoginCard().getPasswordTextField().setForeground(Color.BLACK);
                }
            }else if (e.getSource().equals(view.getRegisterCard().getFirstNameTextField())) {
                if (view.getRegisterCard().getFirstNameTextField().getText().equals("First Name")) {
                    view.getRegisterCard().getFirstNameTextField().setText("");
                    view.getRegisterCard().getFirstNameTextField().setForeground(Color.BLACK);
                }
            }else if (e.getSource().equals(view.getRegisterCard().getLastNameTextField())) {
                if (view.getRegisterCard().getLastNameTextField().getText().equals("Last Name")) {
                    view.getRegisterCard().getLastNameTextField().setText("");
                    view.getRegisterCard().getLastNameTextField().setForeground(Color.BLACK);
                }
            }else if (e.getSource().equals(view.getRegisterCard().getUserHandleTextField())) {
                if (view.getRegisterCard().getUserHandleTextField().getText().equals("@username")) {
                    view.getRegisterCard().getUserHandleTextField().setText("");
                    view.getRegisterCard().getUserHandleTextField().setForeground(Color.BLACK);
                }
            }else if (e.getSource().equals(view.getRegisterCard().getPasswordTextField())) {
                if (view.getRegisterCard().getPasswordTextField().getText().equals("Password")) {
                    view.getRegisterCard().getPasswordTextField().setText("");
                    view.getRegisterCard().getPasswordTextField().setForeground(Color.BLACK);
                }
            }else if (e.getSource().equals(view.getRegisterCard().getCpasswordTextField())) {
                if (view.getRegisterCard().getCpasswordTextField().getText().equals("Confirm Password")) {
                    view.getRegisterCard().getCpasswordTextField().setText("");
                    view.getRegisterCard().getCpasswordTextField().setForeground(Color.BLACK);
                }
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
            if (e.getSource().equals(view.getLoginCard().getUserHandleTextField())) {
                if (view.getLoginCard().getUserHandleTextField().getText().isEmpty()) {
                    view.getLoginCard().getUserHandleTextField().setText("@username");
                    view.getLoginCard().getUserHandleTextField().setForeground(Color.GRAY);
                }
            }else if (e.getSource().equals(view.getLoginCard().getPasswordTextField())) {
                if (view.getLoginCard().getPasswordTextField().getText().isEmpty()) {
                    view.getLoginCard().getPasswordTextField().setText("Password");
                    view.getLoginCard().getPasswordTextField().setForeground(Color.GRAY);
                }
            }else if (e.getSource().equals(view.getRegisterCard().getFirstNameTextField())) {
                if (view.getRegisterCard().getFirstNameTextField().getText().isEmpty()) {
                    view.getRegisterCard().getFirstNameTextField().setText("First Name");
                    view.getRegisterCard().getFirstNameTextField().setForeground(Color.GRAY);
                }
            }else if (e.getSource().equals(view.getRegisterCard().getLastNameTextField())) {
                if (view.getRegisterCard().getLastNameTextField().getText().isEmpty()) {
                    view.getRegisterCard().getLastNameTextField().setText("Last Name");
                    view.getRegisterCard().getLastNameTextField().setForeground(Color.GRAY);
                }
            }else if (e.getSource().equals(view.getRegisterCard().getUserHandleTextField())) {
                if (view.getRegisterCard().getUserHandleTextField().getText().isEmpty()) {
                    view.getRegisterCard().getUserHandleTextField().setText("@username");
                    view.getRegisterCard().getUserHandleTextField().setForeground(Color.GRAY);
                }
            }else if (e.getSource().equals(view.getRegisterCard().getPasswordTextField())) {
                if (view.getRegisterCard().getPasswordTextField().getText().isEmpty()) {
                    view.getRegisterCard().getPasswordTextField().setText("Password");
                    view.getRegisterCard().getPasswordTextField().setForeground(Color.GRAY);
                }
            }else if (e.getSource().equals(view.getRegisterCard().getCpasswordTextField())) {
                if (view.getRegisterCard().getCpasswordTextField().getText().isEmpty()) {
                    view.getRegisterCard().getCpasswordTextField().setText("Confirm Password");
                    view.getRegisterCard().getCpasswordTextField().setForeground(Color.GRAY);
                }
            }

        }
    }

}
