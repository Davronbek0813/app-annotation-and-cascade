package uz.com.appannotationandcascade1.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddressDto {
    @NotNull
    @Size(min = 3,max = 50)
    private String street;
    @NotNull
    @Size(min = 3,max = 50)
    private String city;


}
