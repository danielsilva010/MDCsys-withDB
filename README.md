# Faculty Course Management System

The Faculty Course Management System is a Java-based application designed to facilitate the organization and viewing of faculty course schedules within an educational institution. Leveraging JavaFX for the user interface, it allows for efficient management of course schedules, faculty assignments, and course rosters.

## Key Features

- **Faculty Schedule View**: Enables faculty members to view their teaching schedules.
- **Course Information Management**: Allows insertion and retrieval of course details such as CRN, course name, term, and associated faculty.
- **Faculty Data Entry**: Provides a user interface for faculty to input their ID and retrieve their course schedule.
- **Error Handling**: Implements error alerts for database connectivity and data retrieval issues.

## Technologies

- **Java**: Primary programming language used for backend logic.
- **JavaFX**: Used for creating the graphical user interface.
- **MySQL/JDBC**: Potential database connectivity for storing and retrieving schedule data.

## Prerequisites

To run the system, ensure you have the following installed:
`-`: Oracle Java Development Kit (JDK)
`-`: JavaFX SDK
`-`: MySQL - Proper JDBC drivers for database connectivity

## Usage

Faculty members can enter their ID in the provided text field to view their scheduled courses. The system also supports adding new course schedules to the database.

## Components

- **Frontend:** The user interface is implemented using JavaFX.

- **Java:** The main logic of the system is implemented in Java. The database connectivity is handled using MySQL.

- **Database:** The database is implemented using MySQL.

- **JDBC:** The database is connected using JDBC.

## Structure

- **src:** The source code for the system is stored here.

`- Controllers:` The controller classes are stored here.

`- Models:` The model classes are stored here.

`- Views:` The view classes are stored here.

`- Utils:` The utility classes are stored here.

`- Main:` The main class is stored here.

`- DAO:` The data access object is stored here.

## Disclaimer

The system is provided "as is" without warranty of any kind, either express or implied, including but not limited to the implied warranties of merchantability and fitness for a particular purpose.
