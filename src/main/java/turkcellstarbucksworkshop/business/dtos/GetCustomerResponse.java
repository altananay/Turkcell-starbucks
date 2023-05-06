package turkcellstarbucksworkshop.business.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerResponse {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDateTime dateOfBirth;
    private String identityNumber;
}