# ITS-Assesment
This is the assessment created as a part of interview process with ITS Kuwait 

This project contains 3 webservice:
1. Course
2. Student
3. Allocation

The course webservice contains all CRUD operations where you can do the Following [ add-Course ,
get-Courses , update-Course , delete-Course]

The Student and allocate webservice operates on below points:
Create Restful Web Service for Student Where you can do the Following Activities
a. Register Student to the website providing his details which include

                                - Full name in English and Arabic
                                - Email address
                                - Telephone number
                                - Address

b. Consume Courses Web service to get List of Courses and Create an Restful
Endpoint for This to view the List of Courses  - I have used Rest Template for this
c. Create Restful service to Allocate Student  With Selected Course save it to DB
d. Create Restful service to Get all Students with selected Courses
e. Create Restful service to Update Courses for one Student
f. Create Restful service to delete one Student
g. Implement Swagger , Spring Profiles (Dev-Test-Prod) ,  Exception Handling

You can use swagger UI using - http://localhost:8080/swagger-ui/index.html#/
All endpoints are visible in swagger and their functionality. 
you can check spring profile - by changing value DEV PROD and TEST in application.properties file. for DEV port is 8080 for prod it is 9090 and for test 8180
I have also added two custom exception classes and used in few places -> StudentsNotFoundException and ResourceNotFoundException

For enabling Security uncomment the dependency in pom.xml and in application.properties. Due to time constraint i was not able to perform security operations in depth.


