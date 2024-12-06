package pe.edu.vallegrande.vg_ms_course.application.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import pe.edu.vallegrande.vg_ms_course.domain.model.Course;
import pe.edu.vallegrande.vg_ms_course.domain.repository.CourseRepository;
import pe.edu.vallegrande.vg_ms_course.application.service.CourseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Flux<Course> listAll() {
        return courseRepository.findAll();
    }

    @Override
    public Mono<Course> createCourse(Course course) {
        Course newCourse = modelMapper.map(course, Course.class);
        return courseRepository.save(newCourse);
    }

    @Override
    public Mono<Course> updateCourse(String id, Course course) {
        return courseRepository.findById(id)
                .flatMap(existingCourse -> {
                    existingCourse.setNameCourse(course.getNameCourse());
                    existingCourse.setDescription(course.getDescription());
                    return courseRepository.save(existingCourse);
                });
    }

    @Override
    public Mono<Course> findById(String id) {
        return courseRepository.findById(id);
    }

    @Override
    public Mono<Course> findByName(String nameCourse) {
        return courseRepository.findByNameCourse(nameCourse);
    }


}
