package pe.edu.vallegrande.vg_ms_course.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.vg_ms_course.domain.model.Course;
import pe.edu.vallegrande.vg_ms_course.application.service.impl.CourseServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/directives/course${api.version}")
public class CourseAdminController {

    private final CourseServiceImpl courseService;

    @Autowired
    public CourseAdminController(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/all")
    public Flux<Course> getListAll(){
        return courseService.listAll();
    }

    @GetMapping("/{id}")
    public Mono<Course> getCourseById(@PathVariable String id) {
        return courseService.findById(id);
    }

    @GetMapping("/search")
    public Mono<Course> getCourseByName(@RequestParam String nameCourse) {
        return courseService.findByName(nameCourse);
    }

    @PostMapping("/create")
    public Mono<Course> createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/update/{id}")
    public Mono<Course> updateCourse(@PathVariable String id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

}
