package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    public static BigDecimal calculateGrossPay(BigDecimal hoursWorked, BigDecimal hourlyRate, String department) {
        BigDecimal grossPay;
        BigDecimal forty = new BigDecimal("40.00");

        if (hoursWorked.compareTo(forty) <= 0) {
            grossPay = hoursWorked.multiply(hourlyRate);
        } else {
            BigDecimal regularPay = forty.multiply(hourlyRate);
            BigDecimal overtimeHours = hoursWorked.subtract(forty);
            BigDecimal overtimePay = overtimeHours.multiply(hourlyRate).multiply(new BigDecimal("1.5"));

            grossPay = regularPay.add(overtimePay);
        }

        if (department.equals("IT")) {
            grossPay = grossPay.multiply(new BigDecimal("1.05"));
        }

        return grossPay.setScale(2, RoundingMode.HALF_UP);
    }

    public static String getPayLevel(BigDecimal grossPay) {
        if (grossPay.compareTo(new BigDecimal("500.00")) < 0) {
            return "Low";
        } else if (grossPay.compareTo(new BigDecimal("1000.00")) < 0) {
            return "Standard";
        } else if (grossPay.compareTo(new BigDecimal("2000.00")) < 0) {
            return "High";
        } else {
            return "Executive";
        }
    }

    public static String getEmploymentStatus(BigDecimal hoursWorked) {
        if (hoursWorked.compareTo(new BigDecimal("30.00")) < 0) {
            return "Part-Time";
        } else {
            return "Full-Time";
        }
    }

    public static void main(String[] args) {
        String inputPath = "data/employees.csv";
        String outputPath = "data/transformed_employees.csv";

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputPath));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));

            reader.readLine();

            writer.write("EmployeeID,Name,Department,HoursWorked,HourlyRate,GrossPay,PayLevel,EmploymentStatus");
            writer.newLine();

            String line;

            while ((line = reader.readLine()) != null) {
                rowsRead++;

                if (line.trim().isEmpty()) {
                    rowsSkipped++;
                    continue;
                }

                String[] fields = line.split(",", -1);

                if (fields.length != 5) {
                    rowsSkipped++;
                    continue;
                }

                for (int i = 0; i < fields.length; i++) {
                    fields[i] = fields[i].trim();
                }

                try {
                    int employeeID = Integer.parseInt(fields[0]);
                    String name = fields[1].toUpperCase();
                    String department = fields[2];
                    BigDecimal hoursWorked = new BigDecimal(fields[3]);
                    BigDecimal hourlyRate = new BigDecimal(fields[4]);

                    if (hoursWorked.compareTo(BigDecimal.ZERO) < 0 || hourlyRate.compareTo(BigDecimal.ZERO) < 0) {
                        rowsSkipped++;
                        continue;
                    }

                    BigDecimal grossPay = calculateGrossPay(hoursWorked, hourlyRate, department);
                    String payLevel = getPayLevel(grossPay);
                    String employmentStatus = getEmploymentStatus(hoursWorked);

                    String hoursOutput = hoursWorked.setScale(2, RoundingMode.HALF_UP).toPlainString();
                    String rateOutput = hourlyRate.setScale(2, RoundingMode.HALF_UP).toPlainString();

                    writer.write(employeeID + "," + name + "," + department + "," +
                            hoursOutput + "," + rateOutput + "," + grossPay.toPlainString() + "," +
                            payLevel + "," + employmentStatus);

                    writer.newLine();
                    rowsTransformed++;

                } catch (NumberFormatException e) {
                    rowsSkipped++;
                }
            }

            reader.close();
            writer.close();

            System.out.println("Rows read: " + rowsRead);
            System.out.println("Rows transformed: " + rowsTransformed);
            System.out.println("Rows skipped: " + rowsSkipped);
            System.out.println("Output file: " + outputPath);

        } catch (IOException e) {
            System.out.println("Error reading or writing file.");
        }
    }
}