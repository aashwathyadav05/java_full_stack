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