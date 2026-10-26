class Employee {
    protected String employeeId;
    protected String name;
    protected String department;
    protected double basicSalary;

    public Employee(String employeeId, String name, String department, double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.printf("Monthly Salary: $%.2f%n", calculateSalary());
    }
}


class FullTimeEmployee extends Employee {
    private double allowance;

    public FullTimeEmployee(String employeeId, String name, String department,
                            double basicSalary, double allowance) {
        super(employeeId, name, department, basicSalary);
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + allowance;
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Category: Full-Time Employee");
        System.out.printf("Monthly Salary: $%.2f%n", calculateSalary());
    }
}


class PartTimeEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String employeeId, String name, String department,
                            double basicSalary, double hoursWorked, double hourlyRate) {
        super(employeeId, name, department, basicSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Category: Part-Time Employee");
        System.out.printf("Monthly Salary: $%.2f%n", calculateSalary());
    }
}


class Manager extends Employee {
    private double bonus;

    public Manager(String employeeId, String name, String department,
                   double basicSalary, double bonus) {
        super(employeeId, name, department, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Category: Manager");
        System.out.printf("Monthly Salary: $%.2f%n", calculateSalary());
    }
}


public class Assignment1 {
    public static void main(String[] args) {

        Employee[] employees = {
                new FullTimeEmployee(
                        "EMP001", "Ahmed Ali", "IT",
                        550, 100
                ),

                new PartTimeEmployee(
                        "EMP002", "Fatima Hassan", "HR",
                        0, 20, 12
                ),

                new Manager(
                        "EMP003", "Mohamed Omar", "Management",
                        1000, 200
                )
        };

        System.out.println("===== EMPLOYEE SALARY REPORT =====");
        System.out.println();

        for (Employee employee : employees) {
            employee.displayInfo();
            System.out.println();
        }
    }
}