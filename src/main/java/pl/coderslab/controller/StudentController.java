package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.dto.StudentDto;
import pl.coderslab.entity.Student;
import pl.coderslab.repository.StudentRepository;
import pl.coderslab.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/test")
    public Student test() {
        Student student = new Student();
        student.setFirstName("test");
        student.setLastName("test");
        student.setAverageGrade(5.0);
        student.setIndexNumber("456");

        return studentRepository.save(student);
    }
}
