package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileManager {

    private int rowsRead = 0;
    private int rowsSkipped = 0;

    public List<Employee> readEmployees(String inputFile) {

        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader =
                new BufferedReader(new FileReader(inputFile))) {

            // Skip header
            reader.readLine();

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

                try {

                    int employeeId =
                        Integer.parseInt(fields[0].trim());

                    String name =
                        fields[1].trim().toUpperCase();

                    String department =
                        fields[2].trim();

                    BigDecimal hoursWorked =
                        new BigDecimal(fields[3].trim());

                    BigDecimal hourlyRate =
                        new BigDecimal(fields[4].trim());

                    if (hoursWorked.compareTo(BigDecimal.ZERO) < 0 ||
                        hourlyRate.compareTo(BigDecimal.ZERO) < 0) {

                        rowsSkipped++;
                        continue;
                    }

                    Employee employee =
                        new Employee(
                            employeeId,
                            name,
                            department,
                            hoursWorked,
                            hourlyRate
                        );

                    employees.add(employee);

                } catch (NumberFormatException e) {

                    rowsSkipped++;
                }
            }

        } catch (IOException e) {

            System.out.println("Error reading or writing file.");
        }

        return employees;
    }

    public void writeEmployees(
            String outputFile,
            List<Employee> employees) {

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(outputFile))) {

            writer.write(
                "EmployeeID,Name,Department,HoursWorked,"
                + "HourlyRate,GrossPay,PayLevel,EmploymentStatus"
            );

            writer.newLine();

            for (Employee employee : employees) {

                writer.write(
                    employee.getEmployeeId()
                    + ","
                    + employee.getName()
                    + ","
                    + employee.getDepartment()
                    + ","
                    + employee.getHoursWorked()
                        .setScale(2, RoundingMode.HALF_UP)
                        .toPlainString()
                    + ","
                    + employee.getHourlyRate()
                        .setScale(2, RoundingMode.HALF_UP)
                        .toPlainString()
                    + ","
                    + employee.getGrossPay().toPlainString()
                    + ","
                    + employee.getPayLevel()
                    + ","
                    + employee.getEmploymentStatus()
                );

                writer.newLine();
            }

        } catch (IOException e) {

            System.out.println("Error reading or writing file.");
        }
    }

    public int getRowsRead() {
        return rowsRead;
    }

    public int getRowsSkipped() {
        return rowsSkipped;
    }
}