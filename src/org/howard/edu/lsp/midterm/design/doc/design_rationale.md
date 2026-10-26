# Question 2 — Design Rationale

## Supporting Different Storage Options

RegistrationRepository would be an interface with two implementations:

- FileRegistrationRepository — saves registration records to a local file.
- DatabaseRegistrationRepository — saves registration records to a database.

The appropriate implementation would be selected based on the deployment environment.  CourseRegistration would communicate with the RegistrationRepository interface, so changing the storage method would not require changing the registration process.

## Supporting Different Notification Methods

NotificationService would also be an interface with two implementations:

- EmailNotificationService — sends registration confirmations by email.
- TextNotificationService — sends registration confirmations by text message.

CourseRegistration would use NotificationService without needing to know which notification method was selected.  This makes it possible to support additional notification methods without changing the registration logic.

## Updated CRC Cards

### Class: FileRegistrationRepository

**Responsibilities:**
- Save registration records to a local file.
- Handle file-writing operations and related errors.

**Collaborators:** CourseRegistration.

### Class: DatabaseRegistrationRepository

**Responsibilities:**
- Save registration records to a database.
- Handle database operations and related errors.

**Collaborators:** CourseRegistration.

### Class: EmailNotificationService

**Responsibilities:**
- Generate and send registration confirmations by email.

**Collaborators:** CourseRegistration, Student.

### Class: TextNotificationService

**Responsibilities:**
- Generate and send registration confirmations by text message.

**Collaborators:** CourseRegistration, Student.

The original RegistrationRepository and NotificationService interfaces remain in the design.  The new classes provide their specific implementations.

## Responsibility Decision

CourseRegistration should coordinate the registration process, while RegistrationRepository should handle storing registration records.

This decision follows Arthur Riel's Heuristics 2.8 and 3.1 by keeping responsibilities focused and distributing behavior among classes.  RegistrationRepository is responsible for storage because it can manage file or database operations without requiring CourseRegistration to understand those details.

This separation also improves error handling.  If saving fails, the registration process can stop before sending a confirmation.

## Conclusion

The improved design supports changing requirements without concentrating all functionality in CourseRegistration.  Using interfaces for storage and notifications improves flexibility while keeping each class focused on its responsibility.