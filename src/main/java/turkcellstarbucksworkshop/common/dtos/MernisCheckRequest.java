package turkcellstarbucksworkshop.common.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import turkcellstarbucksworkshop.common.constants.Regex;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MernisCheckRequest {
    @Size(min = 3)
    private String firstName;
    @Size(min = 3)
    private String lastName;
    @NotBlank
    private LocalDateTime dateOfBirth;
    @Pattern(regexp = Regex.identityNumber)
    @Size(min = 11, message = "TC kimlik numarası 11 karakterden az olamaz.")
    @Size(max = 11, message = "Tc kimlik numarası 11 karakterden fazla olamaz")
    private String identityNumber;
}