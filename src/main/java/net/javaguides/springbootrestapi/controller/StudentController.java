package net.javaguides.springbootrestapi.controller;


import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    /*
    * corresponding ULR: http://localhost:8080/student
    * */
    @GetMapping("")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student("Raj", "Fadatare", 1);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    /*
     * corresponding ULR: http://localhost:8080/student-list
     * */
    @GetMapping("student-list")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Student("firstName" + i, "lastName" + i, i));
        }

        return ResponseEntity.ok(list);
    }

    // Spring BOOT REST API with path variable
    /*
     * corresponding ULR: http://localhost:8080/student/{id}
     * */
    @GetMapping("{id}/{firstname}/{lastname}")
    public ResponseEntity<Student> studentWithPathVariable(@PathVariable int id,
                                           @PathVariable String firstname,
                                           @PathVariable String lastname) {
        Student student = new Student(firstname + id, lastname, id);
        return ResponseEntity.ok(student);
    }


    /*
     * corresponding ULR: http://localhost:8080/students/query?id=5&firstName=Joyce&lastName=Zhou
     * */
    @GetMapping("students/query")
    public ResponseEntity<Student> studentWithPequestParameter(@RequestParam int id,
                                               @RequestParam String firstName,
                                               @RequestParam String lastName) {
        Student student = new Student(firstName + id, lastName + id, id);
        return ResponseEntity.ok(student);
    }


    /*
     * corresponding ULR: http://localhost:8080/saveStudent
     * */
    @PostMapping("saveStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        System.out.println(student.toString());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    /*
     * corresponding ULR: http://localhost:8080/student/3/update
     * */
    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateExistingStudent(@PathVariable int id, @RequestBody Student student) {
        student.setId(id);
        System.out.println(student);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    /*
     * corresponding ULR: http://localhost:8080/student/6/delete
     * */
    @DeleteMapping("{id}/delete")
    public ResponseEntity<String> deleteExistingStudent(@PathVariable int id) {
        System.out.println("deleted" + id);
        return new ResponseEntity<>("student" + id + "deleted", HttpStatus.OK);
    }
}
