package mappe.del1.hospital;

import mappe.del1.hospital.exception.RemoveException;

import java.util.List;
import java.util.Random;

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
        hospitalClient.removeExistingEmployee();
        hospitalClient.removeNonExistingPatient();
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

        List<Department> departmentList = this.getHospital().getDepartmentList();
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
                            System.out.println();
                        }
                        catch (RemoveException e) {
                            System.out.println("Exception thrown . . .");
                            System.out.println("The existing employee was not removed");
                            e.printStackTrace();
                            System.out.println();
                        }
                    }
                }

                else {
                    System.out.println("There are no more employees in the department "
                            + department.getDepartmentName() + " . . .");
                    System.out.println();
                }
            }
        }
    }

    /**
     * Removes a non existing patient from a random department in the hospital
     */
    public void removeNonExistingPatient()
    {
        System.out.println("Trying to remove a non existing patient from a random department . . .");

        Patient patient = new Patient("TestName", "TestLastName", "123456789");
        List<Department> departmentList = this.getHospital().getDepartmentList();
        if (!departmentList.isEmpty()) {
            int departmentIndex = this.randomGenerator.nextInt(departmentList.size());
            Department department = departmentList.get(departmentIndex);
            if (department != null) {
                try {
                    department.remove(patient);
                    System.out.println("The exception was not thrown . . .");
                    System.out.println("Something went wrong");
                    System.out.println();
                }
                catch (RemoveException e) {
                    System.out.println("Exception thrown successfully!");
                    System.out.println("The non existing patient was not removed from "
                            + department.getDepartmentName());
                    System.out.println();
                }
            }
        }
    }

    /**
     * Returns the current hospital
     * @return The current hospital
     */
    private Hospital getHospital()
    {
        return this.hospital;
    }
}
