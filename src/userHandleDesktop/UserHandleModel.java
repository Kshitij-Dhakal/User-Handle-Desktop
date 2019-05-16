package userHandleDesktop;

public class UserHandleModel {
    private UserHandleView view;
    private String firstName;
    private String lastName;
    private String userHandle;
    private String password;
    private boolean isValid;

    UserHandleModel(String firstName, String lastName, String userHandle, String password, boolean isValid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userHandle = userHandle;
        this.password = password;
        this.isValid = isValid;
    }

    UserHandleModel(String firstName, String lastName, String userHandle, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userHandle = userHandle;
        this.password = password;
    }

    UserHandleModel(UserHandleView view) {
    }

    public UserHandleModel(String name, String userHandle) {
        String[] s = name.split(" ");
        firstName = s[0];
        lastName = s[1];
        this.userHandle = userHandle;
    }

    static UserBean createBean(UserHandleModel model) {
        UserBean bean = new UserBean();
        bean.setFirst_name(model.getFirstName());
        bean.setLast_name(model.getLastName());
        bean.setUser_handle(model.getUserHandle());
        bean.setPassword(model.getPassword());
        bean.setValid(model.isValid());
        return bean;
    }

    static UserHandleModel createModel(UserBean bean) {
        return new UserHandleModel(bean.getFirst_name(), bean.getLast_name(), bean.getUser_handle(), bean.getPassword(), bean.isValid());
    }

    boolean isValid() {
        return isValid;
    }

    void setValid(boolean valid) {
        isValid = valid;
    }

    String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
        return lastName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserHandle() {
        return userHandle;
    }

    void setUserHandle(String userHandle) {
        this.userHandle = userHandle;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
