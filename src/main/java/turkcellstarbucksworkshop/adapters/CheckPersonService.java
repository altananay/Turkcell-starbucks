package turkcellstarbucksworkshop.adapters;

import turkcellstarbucksworkshop.common.dtos.MernisCheckRequest;

public interface CheckPersonService {
    boolean CheckIfRealPerson(MernisCheckRequest request) throws Exception;
    boolean CheckPerson();
}