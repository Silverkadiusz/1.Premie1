package pl.javastart.bonuscalc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.bonuscalc.bonus.BonusCalculator;
import pl.javastart.bonuscalc.bonus.EmployeeWithBonus;
import pl.javastart.bonuscalc.employee.Employee;
import pl.javastart.bonuscalc.employee.EmployeeRepository;
import pl.javastart.bonuscalc.work.WorkDone;
import pl.javastart.bonuscalc.work.WorkDoneRepository;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {

    private final EmployeeRepository employeeRepository;
    private final WorkDoneRepository workDoneRepository;
    private final BonusCalculator bonusCalculator;

    public MainController(EmployeeRepository employeeRepository,
                          WorkDoneRepository workDoneRepository,
                          BonusCalculator bonusCalculator) {
        this.employeeRepository = employeeRepository;
        this.workDoneRepository = workDoneRepository;
        this.bonusCalculator = bonusCalculator;
    }

    @GetMapping("/")
    public String homepage(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeWithBonus> employeeWithBonuses = bonusCalculator.calculateBonusForEmployees(employees);

        model.addAttribute("employeeWithBonuses", employeeWithBonuses);
        WorkDone workDone = new WorkDone();
        workDone.setDate(LocalDate.now());
        model.addAttribute("workDone", workDone);
        model.addAttribute("employees", employeeRepository.findAll());

        return "index";
    }

    @PostMapping("/")
    public String addWorkDone(WorkDone workDone) {
        workDoneRepository.save(workDone);
        return "redirect:/";
    }

}
