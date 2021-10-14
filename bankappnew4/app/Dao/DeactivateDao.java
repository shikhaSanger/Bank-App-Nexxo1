package Dao;

import models.User;

public class DeactivateDao {
    public static void deactivateDao(User user){

        DbConnector.update(user);
    }
}
