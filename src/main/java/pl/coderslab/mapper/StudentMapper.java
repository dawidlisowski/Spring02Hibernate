package pl.coderslab.mapper;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Student;
import pl.coderslab.dto.StudentDto;

@Component
public class StudentMapper {

    public StudentDto toDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getIndexNumber(),
                student.getAverageGrade()
        );
    }

    public Student toEntity(StudentDto dto) {
        return new Student(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getIndexNumber(),
                dto.getAverageGrade()
        );
    }
}
