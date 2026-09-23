# Assignment 3 Design Discussion

## Assignment 2 Design

For Assignment #2, my entire ETL pipeline was contained within one `ETLPipeline` class.  The class was responsible for reading the employee CSV file, validating each row, performing all of the employee transformations, writing the transformed data to a new CSV file, and printing the final results to the console.  While the program worked, most of the responsibilities were contained in one place.

## Assignment 3 Design Changes

For Assignment #3, I separated the program into four classes: `Employee`, `EmployeeProcessor`, `EmployeeFileManager`, and `ETLPipeline`.  The goal was to give each class a specific responsibility instead of having one class handle the entire program.

The `Employee` class represents an individual employee.  It stores the employee ID, name, department, hours worked, hourly rate, gross pay, pay level, and employment status.

The `EmployeeProcessor` class handles the transformation logic for each employee.  It calculates gross pay, including overtime and the IT department bonus, determines the employee's pay level, and determines whether the employee is full-time or part-time.

The `EmployeeFileManager` class handles the CSV file operations.  It reads and validates the employee data from the input file, tracks the number of rows read and skipped, and writes the successfully transformed employees to `data/transformed_employees.csv`.

The `ETLPipeline` class is now mainly responsible for coordinating the program.  It creates the file manager and processor, processes the valid employees, writes the output file, and prints the final row counts and output location.

## Division of Responsibilities

The main difference between the two designs is that Assignment #2 placed file handling, employee data, transformation logic, and program execution inside the same class.  Assignment #3 separates these responsibilities based on what each part of the program is responsible for.

This makes the program easier to understand because changes to one part of the program can be made without having to work through one large class.  For example, changes to the payroll calculations can be made in `EmployeeProcessor` without changing the CSV reading and writing logic in `EmployeeFileManager`.

## Why Assignment 3 Is an Improvement

I believe the Assignment #3 design is an improvement because each class has a clearer purpose.  The program still produces the same results as Assignment #2, but the code is more organized and easier to maintain.  It also better represents the employee data as an object instead of passing individual values through the entire program.

Separating the responsibilities also makes it easier to test, debug, or expand the program in the future because the file handling, employee data, processing logic, and overall execution are no longer all dependent on one class.

## AI and External Resources

I used ChatGPT to assist with refactoring my Assignment #2 program into an object-oriented design and with writing this design discussion.

ChatGPT transcript: [https://chatgpt.com/share/6ab44071-8a58-83e8-b4b9-f713d78991f3]

No external Internet resources were used.