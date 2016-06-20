import java.util.ArrayList;

/**
 * Created by patrickcummins on 6/20/16.
 */
public class Main {
    public static void main (String[]args){

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Boss(200));
        employees.add(new Developer(100));
        employees.add(new Salesman(50));



        for (int i = 0; i < employees.size(); i++) {
            employees.get(i).primaryResponsibility();
            employees.get(i).secondaryResponsibility();
            employees.get(i).getPaid();

        }
    }
}
