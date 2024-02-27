package Services;

import java.util.ArrayList;
import java.util.List;

import Domain.Employee;
import Domain.PersonComparator;
import Domain.Student;

public class EmployeeService implements iPersonService<Employee> {

    private int count;
    private List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }
// Переопределил метод для выдачи в консоль полно йинофрмации вклюая специальность
    @Override
    public void create(Employee arg) {
        Employee epls = new Employee(arg.getName(), arg.getAge(), arg.getSpecial());
        count++;
        employees.add(epls);
    }

//    @Override
//    public void create(String name, int age) {
//        Employee epls = new Employee(name, age, "basic");
//        count++;
//        employees.add(epls);
//    }

    public void sortByFIO()
    {
        PersonComparator<Employee> persComp = new PersonComparator<Employee>();
        employees.sort(persComp);
    }

    @Override
    public String toString() {
        return "Список рабочих - " +
                employees +
                '.';
    }
}
