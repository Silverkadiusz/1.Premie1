package pl.javastart.bonuscalc.bonus;

import pl.javastart.bonuscalc.employee.Employee;

import java.math.BigDecimal;

public class EmployeeWithBonus {

    private Employee employee;
    private BigDecimal bonus;
    private BigDecimal totalSalary;

    public EmployeeWithBonus(Employee employee, BigDecimal bonus, BigDecimal totalSalary) {
        this.employee = employee;
        this.bonus = bonus;
        this.totalSalary = totalSalary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public BigDecimal getTotalSalary() {
        return totalSalary;
    }
}

