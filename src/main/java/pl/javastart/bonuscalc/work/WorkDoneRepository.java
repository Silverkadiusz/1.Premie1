package pl.javastart.bonuscalc.work;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javastart.bonuscalc.employee.Employee;

import java.time.LocalDate;
import java.util.List;

public interface WorkDoneRepository extends JpaRepository<WorkDone, Long> {

    List<WorkDone> findByEmployeeAndDateBetween(Employee employee, LocalDate start, LocalDate end);

}
