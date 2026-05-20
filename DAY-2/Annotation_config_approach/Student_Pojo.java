package org.example;

public class Student_Pojo
{
 private int std_id;
 private String std_name;
 private String std_email;

 public Student_Pojo(){}

    public Student_Pojo(int std_id, String std_name, String std_email) {
        this.std_id = std_id;
        this.std_name = std_name;
        this.std_email = std_email;
    }

    public int getStd_id() {
        return std_id;
    }

    public String getStd_name() {
        return std_name;
    }

    public String getStd_email() {
        return std_email;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public void setStd_name(String std_name) {
        this.std_name = std_name;
    }

    public void setStd_email(String std_email) {
        this.std_email = std_email;
    }

    @Override
    public String toString() {
        return "Student_Pojo{" +
                "std_id=" + std_id +
                ", std_name='" + std_name + '\'' +
                ", std_email='" + std_email + '\'' +
                '}';
    }
}
