package com.springdos.JDBC;

public class Student {

    private String id;
    private String Username;

    public Student(){
    }

    public Student(String id, String Username) {
        this.id = id;
        this.Username = Username;
    }
    public String getUsername(){
        return Username;
    }

    public void setUsername(String username){
        this.Username = username;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", Username='" + Username + '\'' +
                '}';
    }
}
