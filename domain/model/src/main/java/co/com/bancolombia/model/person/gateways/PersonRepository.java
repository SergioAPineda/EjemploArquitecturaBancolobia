package co.com.bancolombia.model.person.gateways;

import co.com.bancolombia.model.person.Person;
import reactor.core.publisher.Mono;

public interface PersonRepository {
    Mono<Person> getPerson(String id);
    Mono<Person> createPerson(Double balance);
}
