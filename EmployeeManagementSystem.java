import java.util.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary);
    }
}

public class EmployeeManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addEmployee(); break;
                case 2: viewEmployees(); break;
                case 3: updateEmployee(); break;
                case 4: deleteEmployee(); break;
                case 5: searchEmployee(); break;
                case 6: System.out.println("Exiting... Thank you!"); break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String department = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, department, salary);
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    static void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        System.out.println("\nList of Employees:");
        for (Employee emp : employees) {
            emp.display();
        }
    }

    static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        for (Employee emp : employees) {
            if (emp.id == id) {
                sc.nextLine();
                System.out.print("Enter new Name: ");
                emp.name = sc.nextLine();
                System.out.print("Enter new Department: ");
                emp.department = sc.nextLine();
                System.out.print("Enter new Salary: ");
                emp.salary = sc.nextDouble();
                System.out.println("Employee updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    static void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (emp.id == id) {
                iterator.remove();
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();
        for (Employee emp : employees) {
            if (emp.id == id) {
                System.out.println("Employee found:");
                emp.display();
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}