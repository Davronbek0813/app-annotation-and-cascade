package uz.com.appannotationandcascade1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;


    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private List<Address> addresses ;

    private LocalDate birthDate;

    @Transient
    private Integer age;

    @Transient
    private Integer countFullNameLetters;

    public Integer getAge() {
        if(birthDate==null) return age;
        return Period.between(birthDate,LocalDate.now()).getYears();
    }

    public Integer getCountFullNameLetters() {
        return fullName!=null?fullName.length():0;
    }


}
