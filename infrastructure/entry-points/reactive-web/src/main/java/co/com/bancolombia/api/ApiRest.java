package co.com.bancolombia.api;
import co.com.bancolombia.model.person.Person;
import co.com.bancolombia.usecase.person.PersonUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH})
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final PersonUseCase useCase;


    @GetMapping(path = "/person/{id}")
    public Mono<Person> getPerson(@PathVariable String id) {
      return useCase.getPerson(id);
    }

    @PostMapping(path = "/")
    public Mono<Person> savePerson(@RequestBody Person person) {
        System.out.println("datos del balance ");
        Double balance = person.getBalance();
        return useCase.createPerson(balance);

    }
}
