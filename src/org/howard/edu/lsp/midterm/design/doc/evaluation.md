# Question 2 — Object-Oriented Design Evaluation

The CourseRegistration class has several object-oriented design problems.  These problems can be explained using Arthur Riel's design heuristics.

### 1. Too Many Responsibilities

The CourseRegistration class handles tuition calculations, file storage, confirmation messages, and logging.  This violates **Heuristic 2.8**, which states that a class should capture only one key abstraction, and **Heuristic 2.10**, which recommends moving unrelated behavior into separate classes.

The class also demonstrates the "God class" problem described in **Heuristic 3.2**.  It controls too many parts of the registration process, making changes difficult and increasing the chance that one change will affect another feature.

### 2. Poor Encapsulation

All five fields are public, allowing other classes to modify student and course information directly.  This violates **Heuristic 2.1**, which states that all data should be hidden within its class.

Making these fields private would protect the data and allow the class to control how information is accessed or modified.

### 3. Poor Distribution of Responsibilities

**Heuristic 3.1** recommends distributing responsibilities across the system rather than concentrating them in one class.  CourseRegistration performs almost every operation itself instead of collaborating with other objects.

Separate classes should handle tuition rules, registration storage, and notifications.  This would improve cohesion and reduce coupling.

### 4. Hardcoded Business Rules and Dependencies

The tuition rate of $750 per credit hour and the 10% discount are hardcoded into registerStudent().  The class is also directly dependent on FileWriter for storage and console output for confirmations.

This makes the system difficult to extend.  For example, changing from file storage to database storage would require modifying the registration class.

### 5. Error Handling and Correctness

The class catches exceptions during file writing but continues processing the registration even when saving fails.  This could result in a confirmation for a registration that was not successfully stored.

Additionally, the code only prints a message about sending an email rather than actually sending one.  These issues could cause incorrect or misleading system behavior.

### Overall Evaluation

The CourseRegistration class has low cohesion, high coupling, and poor encapsulation.  Its design violates several of Riel's heuristics, particularly H2.1, H2.8, H2.10, H3.1, and H3.2.  Distributing responsibilities among meaningful classes would make the system easier to maintain, test, and extend.