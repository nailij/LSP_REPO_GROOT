package org.howard.edu.lsp.assignment3;

import java.util.List;

public class ETLPipeline {

    private static final String INPUT_FILE =
        "data/employees.csv";

    private static final String OUTPUT_FILE =
        "data/transformed_employees.csv";

    public static void main(String[] args) {

        EmployeeFileManager fileManager =
            new EmployeeFileManager();

        EmployeeProcessor processor =
            new EmployeeProcessor();

        List<Employee> employees =
            fileManager.readEmployees(INPUT_FILE);

        for (Employee employee : employees) {
            processor.processEmployee(employee);
        }

        fileManager.writeEmployees(
            OUTPUT_FILE,
            employees
        );

        System.out.println(
            "Rows read: " + fileManager.getRowsRead()
        );

        System.out.println(
            "Rows transformed: " + employees.size()
        );

        System.out.println(
            "Rows skipped: " + fileManager.getRowsSkipped()
        );

        System.out.println(
            "Output file: " + OUTPUT_FILE
        );
    }
}