package com.interview.interviewspring.Controllers;

import com.interview.interviewspring.Entity.Student;
import com.interview.interviewspring.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")

public class MainController {

    private StudentService studentService;


    @Autowired
    public MainController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/all")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @PostMapping("/add_student")
    public Student addStudent(@RequestBody Student student) {
       return studentService.persist(student);
    }

    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable("id") int id) {
       return studentService.findById(id);
    }


//    @DeleteMapping("/delete_student")
//    public void deleteStudent(@RequestParam int id) {
//        studentService.delete(id);
//
//    }

    @GetMapping("/update_student")
    public String updateForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "update_form";
    }

//    @PostMapping("/update_student")
//    public String updateStudent(@RequestParam int id, @RequestParam String name, @RequestParam int age) {
//        Student student = studentService.findById(id);
//        student.setId(id);
//        student.setName(name);
//        student.setAge(age);
//        studentService.update(student);
//
//        return "redirect:/";
//    }



}
