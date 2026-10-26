# Question 2 — Proposed Object-Oriented Design

The redesigned course registration system separates student information, course information, tuition rules, registration processing, storage, and notifications.  Each class has a clear responsibility and collaborates with other classes when needed.

### Class: Student

**Responsibilities:**
- Store student ID, name, and contact information.
- Provide student information when needed.

**Collaborators:** None.

### Class: Course

**Responsibilities:**
- Store course code and credit hours.
- Provide course information when needed.

**Collaborators:** None.

### Class: CourseRegistration

**Responsibilities:**
- Associate a student with a course.
- Coordinate the registration process.
- Request tuition calculation.
- Request storage of registration records.
- Request confirmation after successful storage.

**Collaborators:** Student, Course, TuitionPolicy, RegistrationRepository, NotificationService.

### Class: TuitionPolicy

**Responsibilities:**
- Maintain tuition rates and discount rules.
- Calculate tuition based on credit hours.
- Apply the 10% discount when credit hours are 12 or greater.

**Collaborators:** Course.

### Class: RegistrationRepository

**Responsibilities:**
- Provide an interface for saving registration records.
- Separate registration processing from storage implementation.

**Collaborators:** CourseRegistration.

### Class: NotificationService

**Responsibilities:**
- Provide an interface for sending registration confirmations.
- Separate registration processing from notification implementation.

**Collaborators:** CourseRegistration, Student.

## Design Summary

This design follows Arthur Riel's heuristics by distributing responsibilities between classes instead of concentrating them in one class.  CourseRegistration coordinates the process but delegates specialized responsibilities to other classes.  This improves encapsulation, reduces coupling, and makes the system easier to modify.