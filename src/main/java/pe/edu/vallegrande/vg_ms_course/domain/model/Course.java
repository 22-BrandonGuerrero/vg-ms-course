package pe.edu.vallegrande.vg_ms_course.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "courses")
public class Course {
    @Id
    private String idCourse;
    private String nameCourse;
    private String description;

}
