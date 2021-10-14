package models;

import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="transaction_type")
public class TransactionType {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum TransactionTypeEnum {

        CREDIT(1), DEBIT(2);
        private Integer id;

        public Integer getId() {
            return this.id;
        }

        TransactionTypeEnum(Integer id) {
            this.id = id;
        }
    }
        public static TransactionType getInstanceOf(int id){
           TransactionType transactionType=new TransactionType();
            transactionType.setId(id);
            return  transactionType;

        }



    public static final Finder<Integer, TransactionType> find = new Finder<>(TransactionType.class);
}
