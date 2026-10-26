package org.howard.edu.lsp.midterm.inheritance;

/**
 * Represents a full-time employee who receives
 * overtime pay after 40 hours.
 *
 * @author Jillian Drake
 */
public class FullTimeEmployee extends Employee {

    /**
     * Creates a full-time employee.
     *
     * @param hoursWorked number of hours worked
     * @param hourlyRate hourly rate of pay
     */
    public FullTimeEmployee(double hoursWorked, double hourlyRate) {
        super(hoursWorked, hourlyRate);
    }

    /**
     * Calculates regular and overtime pay.
     *
     * @return total pay including overtime
     */
    @Override
    public double calculatePay() {
        double regularHours = Math.min(getHoursWorked(), 40);
        double overtimeHours = Math.max(getHoursWorked() - 40, 0);

        double regularPay = regularHours * getHourlyRate();
        double overtimePay = overtimeHours * getHourlyRate() * 1.5;

        return regularPay + overtimePay;
    }
}