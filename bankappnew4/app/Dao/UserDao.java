package Dao;

import models.Password;
import models.User;

public class UserDao {

    public void saveUser(User user) {

        DbConnector.save(user);
    }

    public void saveUserPassword(Password password) {

        DbConnector.save(password);
    }
}
