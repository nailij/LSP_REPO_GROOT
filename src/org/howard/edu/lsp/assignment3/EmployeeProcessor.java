package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EmployeeProcessor {

    private static final BigDecimal FORTY_HOURS = new BigDecimal("40");
    private static final BigDecimal THIRTY_HOURS = new BigDecimal("30");
    private static final BigDecimal OVERTIME_RATE = new BigDecimal("1.5");
    private static final BigDecimal IT_BONUS = new BigDecimal("1.05");

    public void processEmployee(Employee employee) {

        BigDecimal grossPay = calculateGrossPay(employee);

        employee.setGrossPay(grossPay);
        employee.setPayLevel(determinePayLevel(grossPay));
        employee.setEmploymentStatus(
            determineEmploymentStatus(employee.getHoursWorked())
        );
    }

    private BigDecimal calculateGrossPay(Employee employee) {

        BigDecimal hoursWorked = employee.getHoursWorked();
        BigDecimal hourlyRate = employee.getHourlyRate();
        BigDecimal grossPay;

        if (hoursWorked.compareTo(FORTY_HOURS) <= 0) {

            grossPay = hoursWorked.multiply(hourlyRate);

        } else {

            BigDecimal regularPay =
                FORTY_HOURS.multiply(hourlyRate);

            BigDecimal overtimeHours =
                hoursWorked.subtract(FORTY_HOURS);

            BigDecimal overtimePay =
                overtimeHours
                    .multiply(hourlyRate)
                    .multiply(OVERTIME_RATE);

            grossPay = regularPay.add(overtimePay);
        }

        if (employee.getDepartment().equals("IT")) {
            grossPay = grossPay.multiply(IT_BONUS);
        }

        return grossPay.setScale(2, RoundingMode.HALF_UP);
    }

    private String determinePayLevel(BigDecimal grossPay) {

        if (grossPay.compareTo(new BigDecimal("500")) < 0) {
            return "Low";
        }

        if (grossPay.compareTo(new BigDecimal("1000")) < 0) {
            return "Standard";
        }

        if (grossPay.compareTo(new BigDecimal("2000")) < 0) {
            return "High";
        }

        return "Executive";
    }

    private String determineEmploymentStatus(BigDecimal hoursWorked) {

        if (hoursWorked.compareTo(THIRTY_HOURS) < 0) {
            return "Part-Time";
        }

        return "Full-Time";
    }
}