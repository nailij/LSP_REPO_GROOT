package org.howard.edu.lsp.midterm.inheritance;

/**
 * Represents a contractor who receives a
 * 15 percent premium on hourly pay.
 *
 * @author Jillian Drake
 */
public class Contractor extends Employee {

    /**
     * Creates a contractor.
     *
     * @param hoursWorked number of hours worked
     * @param hourlyRate hourly rate of pay
     */
    public Contractor(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    /**
     * Calculates hourly pay with a 15 percent premium.
     *
     * @return total contractor pay
     */
    @Override
    public double calculatePay() {
        return getHoursWorked() * getHourlyRate() * 1.15;
    }
}