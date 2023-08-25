package mate.academy.webintro.service;

import java.util.List;
import mate.academy.webintro.dto.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto save(CreateEmployeeRequestDto requestDto);

    EmployeeDto findById(Long id);

    List<EmployeeDto> findAll();

    List<EmployeeDto> findAllByName(String name);

    void deleteById(Long id);
}
