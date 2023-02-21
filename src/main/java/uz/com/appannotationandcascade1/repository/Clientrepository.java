package uz.com.appannotationandcascade1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.com.appannotationandcascade1.entity.Client;
@RepositoryRestResource(path = "client")
public interface Clientrepository extends JpaRepository<Client,Integer> {
}
