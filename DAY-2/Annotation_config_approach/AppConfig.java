package org.example;

import org.springframework.context.annotation.Bean;

public class AppConfig
{
@Bean("Student1")
public Student_Pojo getUser1(){
return new Student_Pojo(101,"Mukesh","mukeshgulati@gmail.com");
}

@Bean("Student2")
public Student_Pojo getUser2(){
    return new Student_Pojo(102,"Vidit","viditgujarathi@gmail.com");
}

    @Bean("Student3")
    public Student_Pojo getUser3(){
        return new Student_Pojo(103,"Saket","sakettemburne@gmail.com");
    }
}

package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.printf("Done using Annotation config,Spring IOC setup");

        Student_Pojo emp = (Student_Pojo) context.getBean("Student1");

        // 3. Print the loaded object data
        System.out.println("Fetched Data: " + emp);
    }
}
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
