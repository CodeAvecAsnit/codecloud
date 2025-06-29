package com.spring;

public class School{
    private int SchoolId;
    private String SchoolName;
    private String SchoolAddress;

    public School(){}

    public School(int SchoolId, String SchoolName, String SchoolAddress) {
        System.out.println("Constructor School");
        this.SchoolId = SchoolId;
        this.SchoolName = SchoolName;
        this.SchoolAddress = SchoolAddress;
    }

    public int getSchoolId() {
        return SchoolId;
    }

    public void setSchoolId(int schoolId) {
        SchoolId = schoolId;
    }

    public String getSchoolAddress() {
        return SchoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        SchoolAddress = schoolAddress;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    @Override
    public String toString() {
        return "School{" +
                "SchoolId=" + SchoolId +
                ", SchoolName='" + SchoolName + '\'' +
                ", SchoolAddress='" + SchoolAddress + '\'' +
                '}';
    }
}
