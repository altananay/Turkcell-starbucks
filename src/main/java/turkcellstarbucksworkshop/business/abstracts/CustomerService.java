package turkcellstarbucksworkshop.business.abstracts;

import turkcellstarbucksworkshop.business.dtos.*;

import java.util.List;

public interface CustomerService {
    List<GetAllCustomersResponse> getAll();
    CreateCustomerResponse add(CreateCustomerRequest request);
    UpdateCustomerResponse update(int id, UpdateCustomerRequest request);
    GetCustomerResponse getById(int id);
    void delete(int id);
}