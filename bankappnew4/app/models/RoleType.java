package models;

import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity(name="role_type")
public class RoleType {

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

    public enum RoleTypeEnum {

        ADMIN(1), Customer(2);
        public int id;

        public int getId() {
            return id;
        }

        RoleTypeEnum(int id) {
            this.id = id;
        }
    }
        public static RoleType getInstanceOf(int id){
            RoleType roleType=new RoleType();
            roleType.setId(id);
            return roleType;
        }


    public static final Finder<Integer, RoleType> find = new Finder<>(RoleType.class);
}
