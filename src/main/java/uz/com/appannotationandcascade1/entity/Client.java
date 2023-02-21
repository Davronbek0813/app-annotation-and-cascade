package uz.com.appannotationandcascade1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

    private String phoneNumber;

    @OneToOne(mappedBy = "client",cascade = CascadeType.PERSIST)
    private BankAccount bankAccount;

    public void setBankAccount(BankAccount bankAccount) {
        bankAccount.setClient(this);
        this.bankAccount = bankAccount;
    }
}
