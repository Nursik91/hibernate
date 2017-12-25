package kz.nursike.service;

import kz.nursike.model.Student;

import java.util.List;

/**
 * Created by ЕрежеповН on 21.12.2017.
 */
public interface StudentService {
    public List<Student> getStudents();
    public void save(Student student);
    public Student findStudentById(int id);
}
