package Assigment.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.yaml.snakeyaml.events.Event;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class book {
    @Id
    private Integer id;
    private String name;
    private String description;

}
