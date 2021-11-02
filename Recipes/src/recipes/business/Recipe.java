package recipes.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    @NotBlank(message = "name can not be blank")
    String name;

    @NotBlank(message = "description can not be blank")
    String description;

    @NotNull(message = "ingredients should not be null")
    @Size(min = 1, message = "minimal size should be 1")
    @ElementCollection
    List<String> ingredients;

    @NotNull(message = "directions should not be null")
    @Size(min = 1, message = "minimal size should be 1")
    @ElementCollection
    List<String> directions;


}


