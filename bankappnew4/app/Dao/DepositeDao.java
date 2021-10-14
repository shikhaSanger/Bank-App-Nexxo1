package Dao;

import models.Transaction;
import models.User;

public class DepositeDao {

    public static void saveAmount(Transaction transaction) {

        DbConnector.save(transaction);
    }
}
