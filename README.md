# Performance Trace

This repository demonstrates the usage of the `PerformanceMonitorInterceptor` class in a Spring MVC project called `performance_trace`. The project is located in the package `dev.knowledgecafe`. It provides two REST endpoints for creating an employee object and retrieving the full name of an employee.

## Endpoints

1. **Create Employee**
    - URL: POST `/employee`
    - Request Body: JSON object with `firstName`, `lastName`, and `salary` fields
    - Response: Employee ID (integer)

   This endpoint allows you to create an employee object by providing the employee's first name, last name, and salary. The employee object is stored in memory, and the response includes the unique employee ID.

2. **Get Full Name**
    - URL: GET `/fullname`
    - Request Parameter: `id` (integer)
    - Response: Full name of the employee or "Employee not found" string

   This endpoint retrieves the full name of an employee based on the provided employee ID. If the employee is found in memory, the response includes the employee's full name. Otherwise, it returns an "Employee not found" message.

## Classes

1. **AopConfiguration.java**

   This class defines the configuration for interceptors, both the default interceptors and the custom performance interceptor for tracing performance. It sets up the necessary beans and configurations to enable the `PerformanceMonitorInterceptor`.

2. **CustomPerformanceInterceptor.java**

   This class implements a custom performance interceptor by extending the `AbstractMonitoringInterceptor` class. It contains the logic for monitoring and tracking the performance of specific methods. The interceptor is applied to the `createEmployee` method in the `EmployeeService` class.

3. **EmployeeService.java**

   This class contains two methods that are monitored by interceptors:
    - `getFullName()` - This method is monitored by the default interceptors defined in `AopConfiguration.java`. It retrieves the full name of an employee.
    - `createEmployee()` - This method is monitored by the custom performance interceptor defined in `CustomPerformanceInterceptor.java`. It creates an employee object.

## Getting Started

To run the `performance_trace` project and observe the usage of the `PerformanceMonitorInterceptor`, follow these steps:

1. Clone this repository to your local machine.
2. Open the project in your preferred IDE.
3. Build and run the project.
4. Use an API testing tool like Postman to interact with the REST endpoints described above.

Make sure to check the code implementation in each class mentioned above for a detailed understanding of how the `PerformanceMonitorInterceptor` is utilized.

Feel free to explore and modify the project to suit your needs and further experiment with performance monitoring in Spring MVC. Happy coding!