package see.jkhere.Entities;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    private int id;

    @Column(unique = true, nullable = false,name = "Student_name")
    private String name;

    @Column(name="Grade")
    private int level;

    @ManyToOne
    private Tutor tutor;

    public Student() {
    }

    public Student(int id,String name, int level, Tutor tutor) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.tutor = tutor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
}
