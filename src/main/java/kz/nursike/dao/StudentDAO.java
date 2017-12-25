package kz.nursike.dao;

import kz.nursike.model.Student;

import java.util.List;

/**
 * Created by ЕрежеповН on 21.12.2017.
 */
public interface StudentDAO {
    public List<Student> getStudents();

    public void save(Student student);

    public Student findStudentById(int id);

    public void deleteStudent(int id);
}
