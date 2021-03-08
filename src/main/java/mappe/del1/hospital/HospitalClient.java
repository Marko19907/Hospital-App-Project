package mappe.del1.hospital;

import mappe.del1.hospital.exception.RemoveException;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Class HospitalClient represents a simple client that is used to the test the program
 */
public class HospitalClient
{
    private final Hospital hospital;
    private final Random randomGenerator;

    public HospitalClient()
    {
        this.hospital = new Hospital("Test hospital");
        this.fillHospitalWithTestData();
        this.randomGenerator = new Random();
    }

    /**
     * The main method
     */
    public static void main(String[] args)
    {
        HospitalClient hospitalClient = new HospitalClient();
        hospitalClient.start();
    }

    /**
     * Main loop, loops until the user quits
     */
    public void start()
    {
        boolean running = true;
        while (running) {
            this.showMenu();

            switch (this.getNumberInput()) {
                case 1:
                    this.removeExistingEmployee();
                    break;

                case 2:
                    this.removeNonExistingPatient();
                    break;

                case 9:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid menu choice!");
                    break;
            }
        }
    }

    /**
     * Fills the hospital with test data from HospitalTestData
     */
    public void fillHospitalWithTestData()
    {
        HospitalTestData.fillRegisterWithTestData(this.getHospital());
    }

    /**
     * Removes an existing random employee from a randomly selected department in the hospital
     */
    public void removeExistingEmployee()
    {
        System.out.println("Trying to remove a random existing employee from a randomly selected department . . .");

        List<Department> departmentList = this.hospital.getDepartmentList();
        if (!departmentList.isEmpty()) {
            int departmentIndex = this.randomGenerator.nextInt(departmentList.size());
            Department department = departmentList.get(departmentIndex);

            if (department != null) {
                List<Employee> employees = department.getEmployees();

                if (!employees.isEmpty()) {
                    int employeeIndex = this.randomGenerator.nextInt(employees.size());
                    Employee employee = employees.get(employeeIndex);

                    if (employee != null) {
                        try {
                            department.remove(employee);
                            System.out.println(employee.getClass().getSimpleName() + " "
                                    + employee.getFullName()
                                    + " was successfully removed from the department "
                                    + department.getDepartmentName());
                        }
                        catch (RemoveException e) {
                            System.out.println("Exception thrown . . .");
                            System.out.println("The existing employee was not removed");
                            e.printStackTrace();
                        }
                    }
                }

                else {
                    System.out.println("There are no more employees in the department "
                            + department.getDepartmentName() + " . . .");
                }
            }
        }
    }

    /**
     * Removes a non existing patient from the first department in the hospital
     */
    public void removeNonExistingPatient()
    {
        System.out.println("Trying to remove a non existing patient from the first department . . .");

        Patient patient = new Patient("TestName", "TestLastName", "123456789");
        List<Department> departmentList = this.hospital.getDepartmentList();
        if (!departmentList.isEmpty()) {
            Department department = departmentList.get(0);
            if (department != null) {
                try {
                    department.remove(patient);
                    System.out.println("The exception was not thrown . . .");
                    System.out.println("Something went wrong");
                }
                catch (RemoveException e) {
                    System.out.println("Exception thrown successfully!");
                    System.out.println("The non existing patient was not removed");
                }
            }
        }
    }

    /**
     * Prints the menu to the console
     */
    private void showMenu()
    {
        System.out.println();
        System.out.println("1. Remove an existing employee from the first department");
        System.out.println("2. Remove a non existing patient from the first department");
        System.out.println();
        System.out.println("9. Quit");
        System.out.println();
    }

    /**
     * Returns the current hospital
     * @return The current hospital
     */
    private Hospital getHospital()
    {
        return this.hospital;
    }

    /**
     * Returns the number input from the console
     * @return The input from the console as an int
     */
    private int getNumberInput()
    {
        boolean running = true;
        int toReturn = 0;

        while (running) {
            System.out.print("> ");         // print prompt
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                toReturn = scanner.nextInt();
                running = false;
            }
            else {
                System.out.println("You must enter a number");
            }
        }
        return toReturn;
    }
}
