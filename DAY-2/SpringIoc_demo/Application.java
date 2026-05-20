package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 1. Initialize context from your xml
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println("Spring IoC Container is officially up and running!");

        // 2. Fetch the bean using its ID from bean.xml
        Employee_Pojo emp = (Employee_Pojo) context.getBean("employee1");

        // 3. Print the loaded object data
        System.out.println("Fetched Data: " + emp);
    }
}

package org.example;

public class Employee_Pojo
{
    private int emp_id;
    private String empName;
    private String email;

    public Employee_Pojo() { }

    public Employee_Pojo(int emp_id, String empName, String email) {
        this.emp_id = emp_id;
        this.empName = empName;
        this.email = email;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee [emp_id=" + emp_id +
                ", empName=" + empName + '\'' +
                ", email='" + email + '\'' +
                ']';
    }
}

package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}
