package userHandleDesktop;

public class UserHandleModel {
    private UserHandleView view;
    private String firstName;
    private String lastName;
    private String userHandle;
    private String password;
    private boolean isValid;

    public UserHandleModel(String firstName, String lastName, String userHandle, String password, boolean isValid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userHandle = userHandle;
        this.password = password;
        this.isValid = isValid;
    }

    public UserHandleModel(String firstName, String lastName, String userHandle, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userHandle = userHandle;
        this.password = password;
    }

    public UserHandleModel(UserHandleView view) {
    }

    public static UserBean createBean(UserHandleModel model) {
        UserBean bean = new UserBean();
        bean.setFirst_name(model.getFirstName());
        bean.setLast_name(model.getLastName());
        bean.setUser_handle(model.getUserHandle());
        bean.setPassword(model.getPassword());
        bean.setValid(model.isValid());
        return bean;
    }

    public static UserHandleModel createModel(UserBean bean) {
        return new UserHandleModel(bean.getFirst_name(), bean.getLast_name(), bean.getUser_handle(), bean.getPassword(), bean.isValid());
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserHandle() {
        return userHandle;
    }

    public void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
