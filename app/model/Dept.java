package model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_dept")
public class Dept {

    @Id
    public Long id;
    public String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST,mappedBy = "dept")
    public List<User> users = new ArrayList<>();

    public Dept(){}
    public Dept(String name) {
        this.name=name;
    }

    public Dept addUser(User user){
        users.add(user);
        return this;
    }
}