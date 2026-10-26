package org.howard.edu.lsp.midterm.inheritance;

/**
 * Represents a part-time employee who receives
 * straight hourly pay.
 *
 * @author Jillian Drake
 */
public class PartTimeEmployee extends Employee {

    /**
     * Creates a part-time employee.
     *
     * @param hoursWorked number of hours worked
     * @param hourlyRate hourly rate of pay
     */
    public PartTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    /**
     * Calculates straight hourly pay.
     *
     * @return total part-time pay
     */
    @Override
    public double calculatePay() {
        return getHoursWorked() * getHourlyRate();
    }
}