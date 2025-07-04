package see.jkhere.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tutor{
    @Id
    @Column(name="tutor_id")
    private int id;

    private String TutorName;
    private String Course;

    @OneToMany
    private List<Student> students;
    public Tutor() {}
    public Tutor(int id,String TutorName, String Course, List<Student> students) {
        this.id = id;
        this.TutorName = TutorName;
        this.Course = Course;
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTutorName() {
        return TutorName;
    }

    public void setTutorName(String tutorName) {
        TutorName = tutorName;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }
}
