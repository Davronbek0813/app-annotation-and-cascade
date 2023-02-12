package uz.com.appannotationandcascade1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue
    private Integer id;

    private String fullName;

    @OneToMany(mappedBy = "person",cascade = CascadeType.PERSIST)
    private List<Address> addresses ;
}
