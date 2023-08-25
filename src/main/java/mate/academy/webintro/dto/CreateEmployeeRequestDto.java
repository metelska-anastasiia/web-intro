package mate.academy.webintro.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateEmployeeRequestDto {
    private String name;
    private String email;
}
