package pl.javastart.bonuscalc.bonus;

import pl.javastart.bonuscalc.employee.Employee;

import java.math.BigDecimal;

public class EmployeeWithBonus {

    private Employee employee;
    private BigDecimal bonus;

    public EmployeeWithBonus(Employee employee, BigDecimal bonus) {
        this.employee = employee;
        this.bonus = bonus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }
}
