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
            setFirstName(model.firstName);
            setLastName(model.lastName);
            setUserHandle(model.getUserHandle());
            setPassword(model.getPassword());
            setValid(model.isValid());
        }};
    }

    static UserHandleModel createModel(UserBean bean) {
        return new UserHandleModel() {{
            setFirstName(bean.getFirstName());
            setLastName(bean.getLastName());
            setUserHandle(bean.getUserHandle());
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
        this.firstName = bean.getFirstName();
        this.lastName = bean.getLastName();
        this.userHandle = bean.getUserHandle();
        this.password = bean.getPassword();
        this.isValid = bean.isValid();
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
