package cz.tul.data;

import java.util.Date;

public class User {

    private int id_user;
    private String username;
    private Date registered;

    public User(int id_user, String username, Date registered) {
        this.id_user = id_user;
        this.username = username;
        this.registered = registered;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }
}
