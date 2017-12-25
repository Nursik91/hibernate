package kz.nursike.controllers;

import kz.nursike.model.Student;
import kz.nursike.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЕрежеповН on 20.12.2017.
 */
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/")
    public String getList(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "all-students";
    }

    @RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
    public String showFormForAdd(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-form";
    }

    @GetMapping(value = "/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {
        Student student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "student-form";
    }

    @PostMapping(value = "/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/";
    }
}
