/**
 * Created by patrickcummins on 6/20/16.
 */
public class Boss extends Employee {

    public Boss(double hourlyWage) {

        super(hourlyWage);
        hoursWorked = 0;
    }

    @Override
    public void primaryResponsibility() {
        System.out.println("Boss people around");
        hoursWorked++;

    }

    @Override
    public void secondaryResponsibility() {
        System.out.println("Pretend to know what you're talking about");
        hoursWorked++;
    }
}
