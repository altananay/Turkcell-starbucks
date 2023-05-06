package turkcellstarbucksworkshop.api.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import turkcellstarbucksworkshop.business.abstracts.CustomerService;
import turkcellstarbucksworkshop.business.dtos.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    private final CustomerService service;

    @GetMapping
    public List<GetAllCustomersResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCustomerResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCustomerResponse add(@Valid @RequestBody CreateCustomerRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCustomerResponse update(@PathVariable int id, @RequestBody UpdateCustomerRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(int id) {
        service.delete(id);
    }

}
