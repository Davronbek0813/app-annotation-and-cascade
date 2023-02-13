package uz.com.appannotationandcascade1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uz.com.appannotationandcascade1.entity.Address;
import uz.com.appannotationandcascade1.entity.Person;
import uz.com.appannotationandcascade1.payload.AddressDto;
import uz.com.appannotationandcascade1.payload.PersonDto;
import uz.com.appannotationandcascade1.repository.AddressRepository;
import uz.com.appannotationandcascade1.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AddressRepository addressRepository;

    @PostMapping
    public HttpEntity<?> addPerson(@RequestBody PersonDto personDto) {
//        Personni saqlaymiz
        Person person = new Person();
        person.setFullName(personDto.getFullName());

//        Address yasab olamiz
        List<Address> addressList = new ArrayList<>();
        for (AddressDto addressDto : personDto.getAddressDtoList()) {
            Address address = new Address(addressDto.getStreet(),
                    addressDto.getCity(),
                    person
            );
            addressList.add(address);
        }
        person.setAddresses(addressList);
        personRepository.save(person);
        return ResponseEntity.ok("Saqlandi");
    }

    @PutMapping("/{id}")
    public HttpEntity<?> updatePerson(@PathVariable Integer id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        Person person = optionalPerson.get();
        person.setFullName("Ism o'zgardi");

//        Address yasab olamiz
        for (Address address : person.getAddresses()) {
            address.setStreet("Ko'cha nomi o'zgardi");
        }
        personRepository.save(person);
        return ResponseEntity.ok("O'zgartirildi");
    }


    @DeleteMapping("/{id}")
    public HttpEntity<?> deletePerson(@PathVariable Integer id) {
        try {
            personRepository.deleteById(id);
            return ResponseEntity.ok("O'chirildi");
        }catch (Exception e){
            return ResponseEntity.ok("O'chirilmadi");
        }
    }

}
