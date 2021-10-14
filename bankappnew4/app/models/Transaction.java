package models;

import io.ebean.Finder;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name="amount")
    private int amount;

    @Column(name="created_on")
    private Date createdOn;

    @Column (name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "action_type",referencedColumnName = "id")
    private TransactionAction transactionAction;

    @ManyToOne
    @JoinColumn(name = "transactiontypeid",referencedColumnName = "id")
    private TransactionType transactionType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionAction getTransactionAction() {
        return transactionAction;
    }

    public void setTransactionAction(TransactionAction transactionAction) {
        this.transactionAction = transactionAction;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public static final Finder<Integer, Transaction> find = new Finder<>(Transaction.class);
}
