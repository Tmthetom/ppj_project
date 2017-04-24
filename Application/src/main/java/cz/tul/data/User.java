package cz.tul.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue
    @Column(name="id_user")
    private int id_user;

    @Column(name="username")
    private String username;

    @Column(name="registered")
    private Date registered;

    public User() {
        ;
    }

    public User(String username) {
        this.username = username;
    }

    public User(int id_user, String username, Date registered) {
        this.id_user = id_user;
        this.username = username;
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "User{" +
                "id = " + id_user + ", " +
                "username = " + username + ", " +
                "registered = " + registered +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        User temp = (User)obj;
        return getUsername().equals(temp.getUsername());
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
