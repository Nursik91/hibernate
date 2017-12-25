package kz.nursike.service;

import kz.nursike.dao.StudentDAO;
import kz.nursike.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ЕрежеповН on 21.12.2017.
 */
@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentDAO studentDAO;

    @Transactional
    public List<Student> getStudents() {
        return studentDAO.getStudents();
    }

    @Transactional
    public void save(Student student) {
        studentDAO.save(student);
    }

    @Transactional
    @Override
    public Student findStudentById(int id) {
        return studentDAO.findStudentById(id);
    }
}
