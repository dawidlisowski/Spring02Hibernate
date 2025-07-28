package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.dto.StudentDto;
import pl.coderslab.mapper.StudentMapper;
import pl.coderslab.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDto> findAllStudents() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDto)
                .toList();
    }
}
