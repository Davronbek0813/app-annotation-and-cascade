package uz.com.appannotationandcascade1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String city;

    public Address(String street, String city, Person person) {
        this.street = street;
        this.city = city;
        this.person = person;
    }

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person person;
}
