# Question 2 — Proposed Design Using CRC Cards

## Class: Student

Responsibilities:
- Store student ID, name, and contact information.
- Provide access to student information.

Collaborators:
- CourseRegistration

## Class: Course

Responsibilities:
- Store course code and credit hours.
- Provide course information.

Collaborators:
- CourseRegistration

## Class: CourseRegistration

Responsibilities:
- Coordinate the registration process.
- Associate a Student with a Course.
- Request tuition calculation.
- Request registration storage and confirmation.

Collaborators:
- Student
- Course
- TuitionCalculator
- RegistrationRepository
- NotificationService

## Class: TuitionCalculator

Responsibilities:
- Calculate tuition using course credit hours and the tuition rate.
- Apply the discount when credit hours are 12 or greater.

Collaborators:
- CourseRegistration
- Course

## Class: RegistrationRepository

Responsibilities:
- Store registration records.
- Handle registration data persistence.

Collaborators:
- CourseRegistration

## Class: NotificationService

Responsibilities:
- Send registration confirmations.
- Handle confirmation messages separately from registration logic.

Collaborators:
- CourseRegistration
- Student
