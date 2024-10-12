# Patient Application (back end)

## Descritpion
This project provides several API's restful to add a new patient and patient's childs with coherent blood type, get existing patients' data on a page format and have aggregate information on the number of male and female patients in the database.    

## Applications needed 
- Dbeaver or another postgreSQL system of database management
- IntelliJ IDEA or another java IDE (Integrated Development Environment) 

## Before running the project
On the dev branch take the link URL of the project. Then on your PC open a terminal and clone the project with the command *git clone **link** *

## Adaptations needed

This application require a database.
On a postgreSQL system of database management create :
- a new schema with the name "projet_prog301"
  The tables are generated automatically when the application is launched.

On your java IDE open the project.
Now you need to connect the application to the database where you have created the schema prior :
- create a new application.properties as a Properties type of file at project_prog301/src/main/resources and copy/past in it the filled instructions in [ ] in the file application.properties.example available at project_prog301/src/main/resources

## Run the application

Go the application's file at this path : /home/pataris/Projects/exam_prog301/src/main/java/fr/bordeaux/isped/sitis/ExamProg301Application.java.
Run it by clicking on the arrow at the top right of your screen. 
To see the output click here once your application is launched : http://localhost:8080/swagger-ui/index.html

## APIs Restful

### 1. Register a Patient
- **Path**: `/api/patient`
- **Method**: `POST`
- **Input Parameters**: A DTO containing patient characteristics (excluding ID), annotated with `@RequestBody`.
- **Output**: The created patient.

### 2. Retrieve Patient Data
- **Path**: `/api/patient/{id}`
- **Method**: `GET`
- **Input Parameters**: Patient ID, annotated with `@PathVariable`.
- **Output**: The requested patient.

### 3. Retrieve All Patients (Paginated)
- **Path**: `/api/patient/all`
- **Method**: `GET`
- **Input Parameters**: A `Pageable` object (not annotated).
- **Output**: A paginated list of patients.

### 4. Count Patients by Gender
- **Path**: `/api/patient/count`
- **Method**: `GET`
- **Input Parameters**: None.
- **Output**: Count of patients by gender.

### 5. Create a New Patient from Two Parents
- **Path**: `/api/patient/create`
- **Method**: `POST`
- **Input Parameters**: A DTO containing the IDs of two parents and other patient characteristics (excluding ABO blood type logic).
- **Output**: The created patient.

