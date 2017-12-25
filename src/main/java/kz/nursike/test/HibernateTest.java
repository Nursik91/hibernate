package kz.nursike.test;

import kz.nursike.model.Course;
import kz.nursike.model.Student;
import kz.nursike.model.StudentDetail;
import kz.nursike.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by ЕрежеповН on 19.12.2017.
 */
public class HibernateTest {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(StudentDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Teacher.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();


//        Student student = new Student("Bill", "Gates", 26);
//        StudentDetail studentDetail = new StudentDetail("Movies2");
//        student.setStudentDetail(studentDetail);

        try {
            session.beginTransaction();

            Course course = new Course("Hello World");

            session.save(course);

            Student student1 = new Student("student1", "student1", 10);
            Student student2 = new Student("student2", "student2", 20);

            course.add(student1);
            course.add(student2);

            session.save(student1);
            session.save(student2);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }





    }
}
