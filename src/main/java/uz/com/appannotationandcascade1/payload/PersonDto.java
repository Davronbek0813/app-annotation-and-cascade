package uz.com.appannotationandcascade1.payload;

import lombok.Data;

import java.util.List;

@Data
public class PersonDto {
    private String fullName;

    private List<AddressDto> addressDtoList;

}
