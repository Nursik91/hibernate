package kz.nursike.dao;

import kz.nursike.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ЕрежеповН on 21.12.2017.
 */
@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getStudents() {
        Session session = sessionFactory.getCurrentSession();

        Query<Student> query = session.createQuery("from Student order by id",
                Student.class);

        List<Student> students = query.getResultList();

        return students;
    }

    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(student);
    }

    @Override
    public Student findStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        return student;
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Student where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
