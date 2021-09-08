package co.com.bancolombia.mongo;

import co.com.bancolombia.model.person.Person;
import co.com.bancolombia.model.person.gateways.PersonRepository;
import co.com.bancolombia.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Person, PersonData, String, MongoDBRepository>
 implements PersonRepository
{

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Person.class));
    }

    @Override
    public Mono<Person> getPerson(String id) {
        //System.out.println(this.repository.findById(id).map(this::toEntity));
        return repository.findById(id).map(this::toEntity);
    }

    @Override
    public Mono<Person> createPerson(Double balance) {
        PersonData personData = PersonData.builder().balance(balance).build();
        return repository.save(personData).map(this::toEntity);
    }

}
