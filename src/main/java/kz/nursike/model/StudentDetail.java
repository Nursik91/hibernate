package kz.nursike.model;

import javax.persistence.*;

/**
 * Created by ЕрежеповН on 19.12.2017.
 */
@Entity
@Table(name = "student_detail")
public class StudentDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String hobby;

    @OneToOne(mappedBy = "studentDetail",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    private Student student;

    public StudentDetail() {}

    public StudentDetail(String hobby) {
        this.hobby = hobby;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "StudentDetail{" +
                "id=" + id +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
