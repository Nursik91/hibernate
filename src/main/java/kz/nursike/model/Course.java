package kz.nursike.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ЕрежеповН on 20.12.2017.
 */
@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;


    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH,
    CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH,
            CascadeType.PERSIST,
            CascadeType.MERGE})
    @JoinTable(name = "course_student",
        joinColumns
                = @JoinColumn(name= "course_id"),
        inverseJoinColumns
                = @JoinColumn(name = "student_id"))
    private List<Student> students;

    public Course() {}

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void add(Student student) {
        if (students == null) {
            students = new ArrayList<Student>();
        }
        students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
