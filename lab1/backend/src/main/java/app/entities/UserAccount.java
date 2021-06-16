package app.entities;

public class UserAccount {

    private int id;
    private String login;
    private String password;

    private String role;


    public UserAccount(int id, String userName, String password, String role) {
        this.id = id;
        this.login = userName;
        this.password = password;
        this.role = role;

    }

    public String getUsername() {
        return login;
    }

    public void setUsername(String username) {
        this.login = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRoles(String role) {
        this.role = role;
    }
}