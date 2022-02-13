package com.interview.interviewspring.Service;

import com.interview.interviewspring.Entity.Student;
import com.interview.interviewspring.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private StudentRepository studentRepo;

    @Autowired
    public void setStudentRepo(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student persist(Student student) {
        return studentRepo.save(student);
    }

    public void delete(Student student) {
       studentRepo.delete(student);
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    public Optional<Student> findById(int id) {
        return studentRepo.findById(id);
    }

}
