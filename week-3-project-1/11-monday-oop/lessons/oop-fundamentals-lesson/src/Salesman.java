/**
 * Created by patrickcummins on 6/20/16.
 */
public class Salesman extends Employee {
    public Salesman(double hourlyWage) {
        super(hourlyWage);

    }

    @Override
    public void primaryResponsibility() {
        System.out.println("Sell stuff");
        hoursWorked++;

    }

    @Override
    public void secondaryResponsibility() {
        System.out.println("Unreasonably demand things from the developers");
        hoursWorked++;

    }
}
