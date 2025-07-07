package com.codeavecasnit.passportmapper.passportcitizen.Entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "student_table"
)
public class Student {
    @Id
    private Integer rollNo;
    private String studentName;
    private Integer stdClass;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="adrressId")
    private Address address;

    public Student() {
    }

    public Student(Integer rollNo, String studentName, Integer stdClass, Address address) {
        this.rollNo = rollNo;
        this.studentName = studentName;
        this.stdClass = stdClass;
        this.address = address;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStdClass() {
        return stdClass;
    }

    public void setStdClass(Integer stdClass) {
        this.stdClass = stdClass;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
