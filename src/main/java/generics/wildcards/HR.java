package generics.wildcards;

import java.util.List;
import java.util.function.Predicate;

import static java.lang.System.out;

public class HR {

	public static void printEmpNames(List<Employee> employees) {
		employees.stream()
				.map(Employee::getName)
				.forEach(out::println);
	}

	public static void printEmpAndSubclassNames(List<? extends Employee> employees) {
		employees.stream()
				.map(Employee::getName)
				.forEach(out::println);
//		employees.add(new Employee("Fred"));	// does not compile
//		employees.add(new Salaried("Barney", 12000));	// does not compile
	}

	public static void printAllFiltered(
			List<? extends Employee> employees, Predicate<? super Employee> predicate) {
		employees.stream().
				filter((Predicate<Employee>) predicate::test).
				forEach(e -> System.out.println(e.getName()));
	}
}
