package pl.coderslab.model;

import org.mindrot.jbcrypt.BCrypt;



public class User {
    private int id;
    private Group group;
    private String username;
    private String email;
    private String password;
    private String admin;

    public User() {
    }

    public User(Group group, String userName, String email, String password, String admin) {
        this.group = group;
        this.username = userName;
        this.email = email;
        this.hashPassword(password);
        this.admin = admin;
    }

    public void hashPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
