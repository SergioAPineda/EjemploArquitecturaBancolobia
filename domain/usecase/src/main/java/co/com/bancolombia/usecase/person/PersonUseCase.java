package co.com.bancolombia.usecase.person;

import co.com.bancolombia.model.person.Person;
import co.com.bancolombia.model.person.gateways.PersonRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PersonUseCase {
    private final PersonRepository serviceGateway;

    public Mono<Person> getPerson(String id){

        return serviceGateway.getPerson(id);
    }

    public Mono<Person> createPerson(Double balance){
        return serviceGateway.createPerson(balance);
    }
}
