package Dao;

import models.Transaction;

public class WithDrawDao {
    public static void withDrawAmount(Transaction transaction1) {

        DbConnector.save(transaction1);
    }
}
