package userHandleDesktop;

public class UserHandleModel {
    String firstName;
    String lastName;
    String userHandle;
    String password;
    boolean isValid;

    public UserHandleModel(String firstName, String lastName, String userHandle, String password, boolean isValid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userHandle = userHandle;
        this.password = password;
        this.isValid = isValid;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public UserHandleModel(String firstName, String lastName, String userHandle, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userHandle = userHandle;
        this.password = password;
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

    public UserHandleModel() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
