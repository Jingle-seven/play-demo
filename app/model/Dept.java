package model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "table_dept")
public class Dept {

    @Id
    public Long id;
    public String location;
    public String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST)
    public List<User> users = new ArrayList<>();

    public Dept() {
    }

    /**
     * 当有这个字符串构造器的时候,新建user可以设置dept=xxx,而不用dept.name=xxx
     * 但是有两个参数时似乎用不了,而且Long构造器是不起作用的
     */
//    public Dept(String name) {
//        this.name = name;
//    }

    /**
     *  似乎只能用这种方法保存表单级联的对象id,接受String参数并处理
     */
    public Dept(String id) {
        this.id = Long.parseLong(id);
    }

    public Dept(String name, String location) {
        this.name = name;
        this.location = location;

    }

    public Dept addUser(User user) {
        users.add(user);
        return this;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}