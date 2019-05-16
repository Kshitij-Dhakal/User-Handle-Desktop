package userHandleDesktop;

import dependencies.Listeners.LoginListener;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserHandleController {
    UserHandleView view;
    UserHandleModel model;
    private String userHandle;
    private LoginListener listener;

    public UserHandleController() {
        this.view = new UserHandleView();
        this.model = new UserHandleModel(view);
        this.view.addMouserEventListener(new ToggleLoginRegister(this.view));
        this.view.addPlaceHolder(new AddPlaceHolder(this.view));
        this.view.addActionListener(new AddActionListener(this.view, this.model));
    }

    public UserHandleView getView() {
        return view;
    }

    public void setListener(LoginListener listener) {
        this.listener = listener;
    }

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    public void notifyOnLogin() {
        listener.onDatabaseLogin();
    }

    public UserHandleModel getModel() {
        return model;
    }

    private class ToggleLoginRegister extends MouseAdapter {
        private UserHandleView view;

        ToggleLoginRegister(UserHandleView view) {
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

    private class AddPlaceHolder implements FocusListener {
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
            } else if (e.getSource().equals(view.getLoginCard().getPasswordTextField())) {
                if (view.getLoginCard().getPasswordTextField().getText().equals("Password")) {
                    view.getLoginCard().getPasswordTextField().setText("");
                    view.getLoginCard().getPasswordTextField().setForeground(Color.BLACK);
                }
            } else if (e.getSource().equals(view.getRegisterCard().getFirstNameTextField())) {
                if (view.getRegisterCard().getFirstNameTextField().getText().equals("First Name")) {
                    view.getRegisterCard().getFirstNameTextField().setText("");
                    view.getRegisterCard().getFirstNameTextField().setForeground(Color.BLACK);
                }
            } else if (e.getSource().equals(view.getRegisterCard().getLastNameTextField())) {
                if (view.getRegisterCard().getLastNameTextField().getText().equals("Last Name")) {
                    view.getRegisterCard().getLastNameTextField().setText("");
                    view.getRegisterCard().getLastNameTextField().setForeground(Color.BLACK);
                }
            } else if (e.getSource().equals(view.getRegisterCard().getUserHandleTextField())) {
                if (view.getRegisterCard().getUserHandleTextField().getText().equals("@username")) {
                    view.getRegisterCard().getUserHandleTextField().setText("");
                    view.getRegisterCard().getUserHandleTextField().setForeground(Color.BLACK);
                }
            } else if (e.getSource().equals(view.getRegisterCard().getPasswordTextField())) {
                if (view.getRegisterCard().getPasswordTextField().getText().equals("Password")) {
                    view.getRegisterCard().getPasswordTextField().setText("");
                    view.getRegisterCard().getPasswordTextField().setForeground(Color.BLACK);
                }
            } else if (e.getSource().equals(view.getRegisterCard().getCpasswordTextField())) {
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
            } else if (e.getSource().equals(view.getLoginCard().getPasswordTextField())) {
                if (view.getLoginCard().getPasswordTextField().getText().isEmpty()) {
                    view.getLoginCard().getPasswordTextField().setText("Password");
                    view.getLoginCard().getPasswordTextField().setForeground(Color.GRAY);
                }
            } else if (e.getSource().equals(view.getRegisterCard().getFirstNameTextField())) {
                if (view.getRegisterCard().getFirstNameTextField().getText().isEmpty()) {
                    view.getRegisterCard().getFirstNameTextField().setText("First Name");
                    view.getRegisterCard().getFirstNameTextField().setForeground(Color.GRAY);
                }
            } else if (e.getSource().equals(view.getRegisterCard().getLastNameTextField())) {
                if (view.getRegisterCard().getLastNameTextField().getText().isEmpty()) {
                    view.getRegisterCard().getLastNameTextField().setText("Last Name");
                    view.getRegisterCard().getLastNameTextField().setForeground(Color.GRAY);
                }
            } else if (e.getSource().equals(view.getRegisterCard().getUserHandleTextField())) {
                if (view.getRegisterCard().getUserHandleTextField().getText().isEmpty()) {
                    view.getRegisterCard().getUserHandleTextField().setText("@username");
                    view.getRegisterCard().getUserHandleTextField().setForeground(Color.GRAY);
                }
            } else if (e.getSource().equals(view.getRegisterCard().getPasswordTextField())) {
                if (view.getRegisterCard().getPasswordTextField().getText().isEmpty()) {
                    view.getRegisterCard().getPasswordTextField().setText("Password");
                    view.getRegisterCard().getPasswordTextField().setForeground(Color.GRAY);
                }
            } else if (e.getSource().equals(view.getRegisterCard().getCpasswordTextField())) {
                if (view.getRegisterCard().getCpasswordTextField().getText().isEmpty()) {
                    view.getRegisterCard().getCpasswordTextField().setText("Confirm Password");
                    view.getRegisterCard().getCpasswordTextField().setForeground(Color.GRAY);
                }
            }

        }
    }

    private class AddActionListener implements ActionListener {
        private UserHandleView view;
        private UserHandleModel model;

        public AddActionListener(UserHandleView view, UserHandleModel model) {
            this.view = view;
            this.model = model;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(view.getLoginCard().getLoginButton())) {
                model.setUserHandle(view.getLoginCard().getUserHandleTextField().getText().trim());
                model.setPassword(view.getLoginCard().getPasswordTextField().getText().trim());
                if (model.getUserHandle().equalsIgnoreCase("@username")) {
                    System.out.println("Login Failed");
                    return;
                }
                try {
                    model = UserHandleModel.createModel(UserDao.login(UserHandleModel.createBean(model)));
                } catch (SQLException e1) {
                    e1.printStackTrace();
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                if (model.isValid()) {
                    setUserHandle(model.getUserHandle());
                    System.out.println("UserHandle : Login Successful");
                    notifyOnLogin();
                } else {
                    System.out.println("UserHandle : Login Failed");
                }
            } else if (e.getSource().equals(view.getRegisterCard().getRegisterButton())) {
                model.setFirstName(view.getRegisterCard().getFirstNameTextField().getText().trim());
                model.setLastName(view.getRegisterCard().getLastNameTextField().getText().trim());
                model.setUserHandle(view.getRegisterCard().getUserHandleTextField().getText().trim());
                model.setPassword(view.getRegisterCard().getPasswordTextField().getText().trim());
                if (model.getUserHandle().equalsIgnoreCase("@username")) {
                    System.out.println("UserHandle : Registration Failed");
                    return;
                }
                try {
                    model = UserHandleModel.createModel(UserDao.register(UserHandleModel.createBean(model)));
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                if (model.isValid()) {
                    setUserHandle(model.getUserHandle());
                    System.out.println("UserHandle : Registration Successful!");
                    notifyOnLogin();

                } else {
                    System.out.println("UserHandle : Registration Failed!");
                }
            }
        }
    }
}
