# Question 2 — Design Rationale

The proposed design can support the new requirements by allowing multiple implementations of RegistrationRepository and NotificationService.

## Registration Storage

RegistrationRepository would become an interface with two implementations:

- FileRegistrationRepository — saves registration records to a local file.
- DatabaseRegistrationRepository — saves registration records to a database.

CourseRegistration would communicate with the RegistrationRepository interface rather than directly accessing a file or database.  The appropriate implementation could be selected based on the deployment environment.

## Confirmation Notifications

NotificationService would also become an interface with two implementations:

- EmailNotificationService — sends confirmations through email.
- TextNotificationService — sends confirmations through text messages.

CourseRegistration would request a confirmation through NotificationService without needing to know which method is being used.

## Responsibility Decision

An important design decision is that CourseRegistration should coordinate the registration process, while RegistrationRepository should own record storage.

This follows the principle of assigning responsibilities to the classes best suited to handle them.  It keeps CourseRegistration focused on registration coordination and allows the storage method to change independently.

## CRC Card Updates

The original RegistrationRepository and NotificationService CRC cards would be updated to describe them as interfaces.  Their concrete implementations would each be responsible for their specific storage or notification method.

No changes would be necessary to Student, Course, or TuitionCalculator.
