package co.com.bancolombia.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Mono;

public interface MongoDBRepository extends ReactiveMongoRepository<PersonData, String>, ReactiveQueryByExampleExecutor<PersonData> {
    //Mono<PersonData> findById(String id);
}
