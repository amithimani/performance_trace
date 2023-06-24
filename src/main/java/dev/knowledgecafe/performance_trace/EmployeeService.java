package dev.knowledgecafe.performance_trace;

import ch.qos.logback.core.model.conditional.ElseModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EmployeeService {

    private Map<Integer, Employee> employeeMap = new HashMap<>();
    private AtomicInteger lastEmpId = new AtomicInteger(0);

    public String getFullName(Integer employeeId) throws InterruptedException{
        //Adding 300ms sleep to see impact on execution
        Thread.sleep(300);
        Employee employee = employeeMap.get(employeeId);
        if(employee != null) {
            return employee.getFirstName() + " " + employee.getLastName();
        }
        return "Employee Not found" ;
    }


    public int createEmployee(Employee employee) throws InterruptedException{
        //Adding 500ms delay
        Thread.sleep(50);
        employeeMap.put(lastEmpId.addAndGet(1), employee);
        return lastEmpId.get();
    }
}
