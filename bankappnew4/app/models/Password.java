package models;

import io.ebean.Finder;

import javax.persistence.*;
import java.util.Date;

@Entity(name="password")
public class Password {

    @Id
    @Column (name="id")
    private int id;

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User userId;

    @Column (name="password")
    private String password;

    @Column(name = "created_on")
    private Date  createdOn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
    public static final Finder<Integer, Password> find = new Finder<>(Password.class);
}
