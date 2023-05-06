package turkcellstarbucksworkshop.business.concretes;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import turkcellstarbucksworkshop.business.abstracts.CustomerService;
import turkcellstarbucksworkshop.business.dtos.*;
import turkcellstarbucksworkshop.business.rules.CustomerBusinessRules;
import turkcellstarbucksworkshop.common.dtos.MernisCheckRequest;
import turkcellstarbucksworkshop.entities.Customer;
import turkcellstarbucksworkshop.repository.CustomerRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {

    private final ModelMapper mapper;
    private final CustomerRepository repository;
    private final CustomerBusinessRules rules;

    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer> customers = repository.findAll();
        List<GetAllCustomersResponse> responses = customers.stream().map(customer -> mapper.map(customer, GetAllCustomersResponse.class)).toList();
        return responses;
    }

    @Override
    public CreateCustomerResponse add(CreateCustomerRequest request) {
        MernisCheckRequest mernisCheck = mapper.map(request, MernisCheckRequest.class);
        rules.checkIfRealPerson(mernisCheck);
        Customer customer = mapper.map(request, Customer.class);
        customer.setId(0);
        repository.save(customer);
        CreateCustomerResponse response = mapper.map(customer, CreateCustomerResponse.class);
        return response;
    }

    @Override
    public UpdateCustomerResponse update(int id, UpdateCustomerRequest request) {
        rules.checkIfCustomerExists(id);
        Customer customer = mapper.map(request, Customer.class);
        customer.setId(id);
        repository.save(customer);
        UpdateCustomerResponse response = mapper.map(customer, UpdateCustomerResponse.class);
        return response;
    }

    @Override
    public GetCustomerResponse getById(int id) {
        rules.checkIfCustomerExists(id);
        Customer customer = repository.findById(id).orElseThrow();
        GetCustomerResponse response = mapper.map(customer, GetCustomerResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfCustomerExists(id);
        repository.deleteById(id);
    }
}