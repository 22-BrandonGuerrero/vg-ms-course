package pe.edu.vallegrande.vg_ms_course.application.service;

import pe.edu.vallegrande.vg_ms_course.domain.model.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {
    Flux<Course> listAll();
    Mono<Course> createCourse(Course course);
    Mono<Course> updateCourse(String id, Course course);
    Mono<Course> findById(String id);
    Mono<Course> findByName(String nameCourse);
}
