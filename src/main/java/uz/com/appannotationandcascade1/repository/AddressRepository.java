package uz.com.appannotationandcascade1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.appannotationandcascade1.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
