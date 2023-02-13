package uz.com.appannotationandcascade1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.com.appannotationandcascade1.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
