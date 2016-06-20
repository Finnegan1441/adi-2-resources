/**
 * Created by patrickcummins on 6/20/16.
 */
public class Developer extends Employee {
    public Developer(double hourlyWage) {

        super(hourlyWage);
        hoursWorked=0;
    }

    @Override
    public void primaryResponsibility() {
        System.out.println("Code");
        hoursWorked++;

    }

    @Override
    public void secondaryResponsibility() {
        System.out.println("Browse Reddit");
        hoursWorked++;
    }
}
