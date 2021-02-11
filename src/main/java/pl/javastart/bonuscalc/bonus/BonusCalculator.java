package pl.javastart.bonuscalc.bonus;

import org.springframework.stereotype.Service;
import pl.javastart.bonuscalc.employee.Employee;
import pl.javastart.bonuscalc.work.WorkDone;
import pl.javastart.bonuscalc.work.WorkDoneRepository;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BonusCalculator {

    public WorkDoneRepository workDoneRepository;

    public BonusCalculator(WorkDoneRepository workDoneRepository) {
        this.workDoneRepository = workDoneRepository;
    }

    public List<EmployeeWithBonus> calculateBonusForEmployees(List<Employee> employees) {
        return employees
                .stream()
                .map(e -> new EmployeeWithBonus(e, calculateBonusForEmployee(e)))
                .collect(Collectors.toList());
    }


    private BigDecimal calculateBonusForEmployee(Employee employee) {
        YearMonth currentMonth = YearMonth.now();
        List<WorkDone> workDone = workDoneRepository.findByEmployeeAndDateBetween(employee, currentMonth.atDay(1), currentMonth.atEndOfMonth());

        int extraWorkInMinutes = workDone.stream()
                .filter(WorkDone::isAdditional)
                .mapToInt(WorkDone::getTimeInMinutes)
                .sum();

        int extraPayment = extraWorkInMinutes / 60 * 30;
        extraPayment = Math.max(extraPayment, 500);
        return BigDecimal.valueOf(extraPayment);
    }
}
