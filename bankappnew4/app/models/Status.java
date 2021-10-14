package models;

import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="status")
public class Status {

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

   public enum CurrentStatusEnum {

       Active(1), Inactive(2);

       private Integer id;


       public Integer getId() {
           return this.id;
       }

       CurrentStatusEnum(Integer id) {
           this.id = id;
       }

   }

       public static Status getInstanceOf(int id){
           Status status=new Status();
           status.setId(id);
           return  status;

       }

    public static final Finder<Integer, Status> find = new Finder<>(Status.class);



}
