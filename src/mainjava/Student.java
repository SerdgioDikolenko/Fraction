
package mainjava;


public class Student {
    
    String name;
    String secondname;
    String lastname;
    int age;
    int salary;

    Student() {
        name = "";
        secondname = "";
        lastname = "";
        age = 0;
        salary = -1;
    }

    Student(String nmA, String nmB, String nmC, int ageP, int salaryP) {
        name = nmA;
        secondname = nmB;
        lastname = nmC;
        age = ageP;
        salary = salaryP;
    }

    String ToFormatString() {
        return "Student " + name + " " + secondname + " " + lastname + " " + age + " " + salary;
    }

    void SetSalary(int newsalary) // int []marka
    {
        salary = newsalary;
    }
}
