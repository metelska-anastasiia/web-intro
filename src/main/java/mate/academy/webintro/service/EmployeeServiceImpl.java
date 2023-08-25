package mate.academy.webintro.service;

import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import mate.academy.webintro.dto.CreateEmployeeRequestDto;
import mate.academy.webintro.dto.EmployeeDto;
import mate.academy.webintro.exception.EntityNotFoundException;
import mate.academy.webintro.mapper.EmployeeMapper;
import mate.academy.webintro.model.Employee;
import mate.academy.webintro.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    @Override
    public EmployeeDto save(CreateEmployeeRequestDto requestDto) {
        Employee employee = employeeMapper.toModel(requestDto);
        employee.setSocialSecurityNumber("abc" + new Random().nextInt(1000));
        return employeeMapper.toDto(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDto findById(Long id) {
        return employeeMapper.toDto(employeeRepository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Can't find employee by id " + id)));

    }

    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toDto)
                .toList();
    }

    @Override
    public List<EmployeeDto> findAllByName(String name) {
        return employeeRepository.findAllByNameContainingIgnoreCase(name)
                .stream()
                .map(employeeMapper::toDto)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
