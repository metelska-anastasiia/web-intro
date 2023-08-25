package mate.academy.webintro.mapper;

import mate.academy.webintro.config.MapperConfig;
import mate.academy.webintro.dto.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.EmployeeDto;
import mate.academy.webintro.model.Employee;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);

    Employee toModel(CreateEmployeeRequestDto requestDto);
}
