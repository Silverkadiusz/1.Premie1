package pl.javastart.bonuscalc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.bonuscalc.bonus.BonusCalculator;
import pl.javastart.bonuscalc.bonus.EmployeeWithBonus;
import pl.javastart.bonuscalc.employee.Employee;
import pl.javastart.bonuscalc.employee.EmployeeRepository;

import java.util.List;

@Controller
public class MainController {

    private EmployeeRepository employeeRepository;
    private BonusCalculator bonusCalculator;

    public MainController(EmployeeRepository employeeRepository,
                          BonusCalculator bonusCalculator) {
        this.employeeRepository = employeeRepository;
        this.bonusCalculator = bonusCalculator;
    }

    @GetMapping("/")
    public String homepage(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeWithBonus> employeeWithBonuses = bonusCalculator.calculateBonusForEmployees(employees);

        model.addAttribute("employeeWithBonuses", "employeeWithBonuses");

        return "index";
    }
}
