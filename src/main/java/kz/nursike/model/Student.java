package kz.nursike.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЕрежеповН on 19.12.2017.
 */
@Entity
@Table(name = "students")
public class Student {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "surname")
    private String lastName;

    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_detail_id")
    private StudentDetail studentDetail;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name = "course_student",
        joinColumns
                = @JoinColumn(name="student_id"),
        inverseJoinColumns
                = @JoinColumn(name="course_id"))
    private List<Course> courses;

    public Student() {
    }

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void add(Course course) {
        if (courses == null) {
            courses = new ArrayList<Course>();
        }
        courses.add(course);
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", studentDetail=" + studentDetail +
                '}';
    }
}
