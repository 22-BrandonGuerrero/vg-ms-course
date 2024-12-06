package pe.edu.vallegrande.vg_ms_course.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.edu.vallegrande.vg_ms_course.domain.model.Course;
import reactor.core.publisher.Mono;

public interface CourseRepository extends ReactiveMongoRepository<Course, String> {

    Mono<Course> findByNameCourse(String nameCourse);


}
