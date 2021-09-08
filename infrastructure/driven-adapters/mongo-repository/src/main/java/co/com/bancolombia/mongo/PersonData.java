package co.com.bancolombia.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("person")
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class PersonData {
    @Id
    private String id;
    private Double balance;
}
