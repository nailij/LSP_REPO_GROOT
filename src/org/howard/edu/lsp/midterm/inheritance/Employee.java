package org.howard.edu.lsp.midterm.inheritance;

/**
 * Represents a general employee with hours worked
 * and an hourly pay rate.
 *
 * @author Jillian Drake
 */
public abstract class Employee {

    private final double hoursWorked;
    private final double hourlyRate;

    /**
     * Creates an employee with hours and a pay rate.
     *
     * @param hoursWorked number of hours worked
     * @param hourlyRate hourly rate of pay
     */
    protected Employee(double hoursWorked, double hourlyRate) {
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    /**
     * Returns the hours worked.
     *
     * @return hours worked
     */
    protected double getHoursWorked() {
        return hoursWorked;
    }

    /**
     * Returns the hourly pay rate.
     *
     * @return hourly rate
     */
    protected double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Calculates pay based on employee type.
     *
     * @return calculated employee pay
     */
    public abstract double calculatePay();
}
