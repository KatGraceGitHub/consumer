package jee3060.design.model;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Member {
    private int memberId;
    private String firstName;
    private String lastName;
    private String email;
}
