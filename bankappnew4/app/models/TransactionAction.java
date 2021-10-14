package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="transaction_action")
public class TransactionAction {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum TransactionActionEnum {

        Deposite(1), WITHDRAW(2);
        private int id;

        public int getId() {
            return this.id;
        }

        TransactionActionEnum(int id) {
            this.id = id;
        }
    }
        public static TransactionAction getInstanceOf(int id) {
            TransactionAction transactionAction = new TransactionAction();
            transactionAction.setId(id);
            return transactionAction;

        }



}
