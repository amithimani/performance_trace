package dev.knowledgecafe.performance_trace;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class EmployeeController {
    private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService;

    @Autowired
    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }



    @GetMapping("/fullname")
    public String getFullName(@RequestParam("id") Integer employeeId) throws Exception{
        logger.debug("Started Processing for "+ employeeId);
       return employeeService.getFullName(employeeId);
    }

    @PostMapping("/employee")
    public Integer CreateEmployee(@RequestBody Employee employee) throws Exception{
        logger.debug("Started Processing for"+ employee);
        return employeeService.createEmployee(employee);
    }
}
