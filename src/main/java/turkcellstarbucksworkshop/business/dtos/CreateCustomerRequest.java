package turkcellstarbucksworkshop.business.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import turkcellstarbucksworkshop.common.constants.Messages;
import turkcellstarbucksworkshop.common.constants.Regex;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCustomerRequest {
    @Size(min = 3, message = Messages.FirstNameMinCharacter)
    private String firstName;
    @Size(min = 3, message = Messages.LastNameMinCharacter)
    private String lastName;
    @NotNull
    private LocalDateTime dateOfBirth;
    @Pattern(regexp = Regex.identityNumber, message = Messages.RegexError)
    @Size(min = 11, message = Messages.IdentityNumberMinCharacter)
    @Size(max = 11, message = Messages.IdentityNumberMaxCharacter)
    private String identityNumber;
}