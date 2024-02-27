import Controllers.AccountController;
import Domain.*;
import Services.EmployeeService;
import Services.TeacherService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Controllers.AccountController.averageAge;

public class App {
    public static void main(String[] args) {

        Student<String,Integer> pers1 = new Student<>("Иван", 25);
        Student<String,Integer> pers2 = new Student<>("Игорь", 23);
        Student<String,Integer> pers3 = new Student<>("Дима", 22);
        Student<String,Integer> pers4 = new Student<>("Сергей", 23);
        Student<String,Integer> pers5 = new Student<>("Даша", 23);
        Student<String,Integer> pers6 = new Student<>("Лена", 23);
        Student<String,Integer> pers7 = new Student<>("Вова", 21);
        Student<String,Integer> pers8 = new Student<>("Катя", 20);


        List<Student<String,Integer>> listStud = new ArrayList<Student<String,Integer>>();
        List<Student<String,Integer>> listStud2 = new ArrayList<Student<String,Integer>>();
        List<Student<String,Integer>> listStud3 = new ArrayList<Student<String,Integer>>();
        listStud.add(pers1);
        listStud.add(pers2);
        listStud.add(pers3);
        listStud.add(pers4);
        listStud2.add(pers5);
        listStud2.add(pers6);
        listStud3.add(pers7);
        listStud3.add(pers8);

        StudentGroup<String,Integer> group4580 = new StudentGroup<>(listStud, 4580);
        StudentGroup<String,Integer> group4581 = new StudentGroup<>(listStud2, 4581);
        StudentGroup<String,Integer> group4579 = new StudentGroup<>(listStud3, 4579);
        System.out.println(group4580);
        System.out.println(group4581);
        System.out.println(group4579);

        System.out.println("=========================================================");
        // Создал список групп, который содержит в себе список студентов и номер группы
        StudentStream<String,Integer> potok1 = new StudentStream<>(1);
        potok1.add(group4580);
        potok1.add(group4581);
        potok1.add(group4579);
        System.out.println(potok1);

        System.out.println("Список групп в потоке: " + potok1.getGrList().get(0).getIdGroup() +
                ", " + potok1.getGrList().get(1).getIdGroup() +
                ", " + potok1.getGrList().get(2).getIdGroup());

        System.out.println("=========================================================");

        for (Student<String,Integer> std : group4580) {
            System.out.println(std);
        }

        System.out.println("=========================================================");
        //Вывод списка групп. Доавблено два варианта вывода списка групп
        System.out.println("Первый вариант вывода списка групп\n");

        for (StudentGroup<String,Integer> grp : potok1) {
            System.out.println(grp);
        }

        System.out.println("\nВторой вариант вывода списка групп\n");

        for (int i = 0; i < potok1.getGrList().size(); i++) {
            System.out.println("Группа номер: " + potok1.getGrList().get(i).getIdGroup());
            for (int j = 0; j < potok1.getGrList().get(i).getGroup().size(); j++) {
                System.out.println(potok1.getGrList().get(i).getGroup().get(j).getName());
            }
        }
        System.out.println("=========================================================");

        Collections.sort(group4580.getGroup());

        for (Student<String,Integer> std : group4580.getGroup()) {
            System.out.println(std);
        }

        System.out.println("=========================================================");
        // Сортировка групп по количеству студентов и номеру группы
        System.out.println("Сортировка групп по количеству студентов в группе и номеру группы\n");
        Collections.sort(potok1.getGrList());


        for (StudentGroup<String,Integer> grpSort : potok1.getGrList()) {
            System.out.println(grpSort);
        }

        System.out.println("=========================================================");
        Teacher<String,Integer> t1 = new Teacher<>("Галина", 55, "Docent");
        Teacher<String,Integer> t2 = new Teacher<>("Татьяна", 57, "Docent");

        System.out.println(new PersonComparator<String,Integer, Student<String,Integer>>().compare(pers1, pers2));

        // Создал список рабочих
        Employee<String,Integer> e1 = new Employee<>("Сергей", 55, "Разнорабочий");
        Employee<String,Integer> e2 = new Employee<>("Олег", 60, "Сантехник");
        Employee<String,Integer> e3 = new Employee<>("Владимир", 52, "Электрик");
        Employee<String,Integer> e4 = new Employee<>("Валерий", 40, "Слесарь");

        EmployeeService<String,Integer> employList = new EmployeeService<>();

        employList.create(e1);
        employList.create(e2);
        employList.create(e3);
        employList.create(e4);


        // AccountController controller = new AccountController();
        // controller.paySalary(t1, 50000);
        // controller.paySalary(e1, 50000);

        AccountController.paySalary(t1, 50000);

        AccountController.paySalary(e1, 20000);

        System.out.println(AccountController.averageAge(listStud));

        System.out.println("=========================================================");
        Teacher<String,Integer> t3 = new Teacher<>("Алла", 56, "Professor");
        Teacher<String,Integer> t4 = new Teacher<>("Екатерина", 50, "PhD");



        TeacherService<String,Integer> tchList = new TeacherService<>();

        tchList.create(t1);
        tchList.create(t2);
        tchList.create(t3);
        tchList.create(t4);


        //System.out.println("tchList = " + tchList);
        System.out.println(employList);
        System.out.println(tchList);

        System.out.println("\nОтсортированный список учителей");
        tchList.sortByFIOTeach(); //метода сортировки учителей по имени
        System.out.println(tchList);

        System.out.println("\nОтсортированный список рабочх");
        employList.sortByFIO(); //метода сортировки учителей по имени
        System.out.println(employList);

        System.out.println("=========================================================");

        System.out.println("Средний возраст учителей - " + AccountController.averageAge(listStud)
                + ".\nСредний возраст учеников - " + AccountController.averageAge(tchList.getAll())
                + ".\nСредний возраст работников - " + AccountController.averageAge(employList.getAll()));












    }
}