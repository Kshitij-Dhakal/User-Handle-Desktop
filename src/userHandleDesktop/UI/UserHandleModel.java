package userHandleDesktop.UI;

import dependencies.lib.User;
import dependencies.lib.UserBean;
import dependencies.lib.UserDao;
import userHandleDesktop.DbConfig;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class UserHandleModel extends User {
    private UserHandleView view;
    private boolean isValid;

    public UserHandleModel() {
    }

    UserHandleModel(UserHandleView view) {
        this.view = view;
    }

    static UserBean createBean(UserHandleModel model) {
        return new UserBean() {{
            setFirst_name(model.firstName);
            setLast_name(model.lastName);
            setUser_handle(model.getUserHandle());
            setPassword(model.getPassword());
            setValid(model.isValid());
        }};
    }

    static UserHandleModel createModel(UserBean bean) {
        return new UserHandleModel() {{
            setFirstName(bean.getFirst_name());
            setLastName(bean.getLast_name());
            setUserHandle(bean.getUser_handle());
            setPassword(bean.getPassword());
            setValid(bean.isValid());
        }};
    }

    boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

/*
    boolean login() throws SQLException, ClassNotFoundException, InvalidKeySpecException, NoSuchAlgorithmException {
        UserBean bean = UserHandleModel.createBean(view.getLoginModel());
        bean = UserDao.login(bean, DbConfig.DB_USERNAME, DbConfig.DB_PASSWORD);
        saveBean(bean);
        return bean.isValid();
    }
*/

    boolean register() throws SQLException, ClassNotFoundException, InvalidKeySpecException, NoSuchAlgorithmException {
        UserBean bean = UserHandleModel.createBean(view.getRegisterModel());
        bean = UserDao.register(bean, DbConfig.DB_USERNAME, DbConfig.DB_PASSWORD);
        saveBean(bean);
        return bean.isValid();
    }

    private void saveBean(UserBean bean) {
        this.firstName = bean.getFirst_name();
        this.lastName = bean.getLast_name();
        this.userHandle = bean.getUser_handle();
        this.password = bean.getPassword();
        this.isValid = bean.isValid();
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
