# Question 2 — Object-Oriented Design Evaluation

The CourseRegistration class has several object-oriented design problems.

## 1. Too Many Responsibilities

The class handles student information, calculates tuition, prints confirmations, saves records, sends notification messages, and logs registrations.  These responsibilities should be separated into different classes.

This goes against Arthur Riel's heuristic that classes should have a clear purpose and related responsibilities.  Keeping everything in one class makes the code harder to maintain because changing one feature could affect others.

## 2. Poor Encapsulation

All five fields are public, so other parts of the program can modify them directly.  This could lead to incorrect student information, course information, or tuition calculations.

Riel's heuristics emphasize protecting class data and keeping implementation details hidden.  Making fields private and using appropriate methods would give the classes more control over their data.

## 3. Too Many Dependencies

The registerStudent() method directly handles file writing, tuition calculations, console messages, and notification processing.

This creates unnecessary coupling between different parts of the system.  If the university wants to change how records are stored or confirmations are sent, the class itself must be modified.

## 4. Hardcoded Business Rules

The tuition rate of $750 per credit hour and the 10% discount for students taking at least 12 credit hours are written directly into registerStudent().

Keeping these rules in a separate tuition calculation class would make them easier to update without changing registration processing.

## 5. Poor Error Handling

The class catches all exceptions when saving a registration and prints the error.  However, execution continues even if the registration was not successfully saved.

This could result in a confirmation being sent for a registration that was not properly recorded.  The system should handle failed operations more clearly.

## Overall Evaluation

The current CourseRegistration design has low cohesion and high coupling.  Separating its responsibilities into smaller classes would improve encapsulation, maintainability, testability, and flexibility.
