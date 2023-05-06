package turkcellstarbucksworkshop.adapters.mernis;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import turkcellstarbucksworkshop.adapters.CheckPersonService;
import turkcellstarbucksworkshop.common.dtos.MernisCheckRequest;

@Service
@AllArgsConstructor
public class MernisServiceAdapter implements CheckPersonService {

    private WUWKPSPublicSoap mernis;

    @Override
    public boolean CheckIfRealPerson(MernisCheckRequest request) throws Exception {
        return mernis.TCKimlikNoDogrula(Long.parseLong(request.getIdentityNumber()), request.getFirstName().toUpperCase(), request.getLastName().toUpperCase(), request.getDateOfBirth().getYear());
    }

    @Override
    public boolean CheckPerson() {
        return true;
    }
}
