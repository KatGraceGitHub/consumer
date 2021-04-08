package jee3060.design.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hobbyid")
    private int hobbyId;
    @Column(name = "hobbyname")
    private String hobbyName;
    @Column(name = "hobbydesc")
    private String hobbyDescription;
    @Column(name = "hobbyoptional")
    private String hobbyCategory;

    public int getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(int hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public String getHobbyCategory() {
        return hobbyCategory;
    }

    public void setHobbyCategory(String hobbyCategory) {
        this.hobbyCategory = hobbyCategory;
    }

    public String getHobbyDescription() {
        return hobbyDescription;
    }

    public void setHobbyDescription(String hobbyDescription) {
        this.hobbyDescription = hobbyDescription;
    }
}