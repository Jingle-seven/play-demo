package model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Book {
    @Id
    private String id;
    private Integer orderNumber;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String operation;
    private Integer UserId;
    private String userName;

    public String getId() {
        return id;
    }

    public Book setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public Book setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Book setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public String getOperation() {
        return operation;
    }

    public Book setOperation(String operation) {
        this.operation = operation;
        return this;
    }

    public Integer getUserId() {
        return UserId;
    }

    public Book setUserId(Integer userId) {
        UserId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Book setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    @Override
    public String toString() {
        return "Book: {" +
                "id: '" + id + '\'' +
                ", orderNumber: " + orderNumber +
                ", name: '" + name + '\'' +
                ", operation: '" + operation + '\'' +
                ", UserId: " + UserId +
                ", userName: '" + userName + '\'' +
                '}';
    }
}
