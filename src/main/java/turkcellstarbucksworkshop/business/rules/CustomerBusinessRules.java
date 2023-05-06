package turkcellstarbucksworkshop.business.rules;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import turkcellstarbucksworkshop.adapters.mernis.MernisServiceAdapter;
import turkcellstarbucksworkshop.common.constants.Messages;
import turkcellstarbucksworkshop.common.dtos.MernisCheckRequest;
import turkcellstarbucksworkshop.core.exceptions.BusinessException;
import turkcellstarbucksworkshop.repository.CustomerRepository;

@AllArgsConstructor
@Service
public class CustomerBusinessRules {
    private final CustomerRepository repository;
    private final MernisServiceAdapter adapter;

    public void checkIfCustomerExists(int id)
    {
        if (!repository.existsById(id))
            throw new BusinessException(Messages.CustomerNotExists);
    }

    public boolean checkIfRealPerson(MernisCheckRequest request){
        try
        {
            if (!adapter.CheckIfRealPerson(request))
                throw new BusinessException(Messages.PersonNotExists);
            return true;
        }
        catch (Exception exception)
        {
            throw new BusinessException(exception.getMessage());
        }
    }
}