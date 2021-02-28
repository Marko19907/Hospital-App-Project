package mappe.del1.hospital;

import mappe.del1.hospital.exception.RemoveException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Class Department represents a single department in the hospital
 * It is responsible for storing a list of the employees and patients in the department
 */
public class Department {
    private String departmentName;

    private final HashMap<String, Person> personnel;

    public Department(String departmentName) {
        if (departmentName == null) {
            throw new IllegalArgumentException("departmentName can not be null");
        }
        if (departmentName.isBlank()) {
            throw new IllegalArgumentException("departmentName can not be blank");
        }
        this.departmentName = departmentName;

        this.personnel = new HashMap<>();
    }

    /**
     * Sets the department name
     * @param newDepartmentName The new name to set, can not be null or blank
     */
    public void setDepartmentName(String newDepartmentName) {
        if (newDepartmentName != null) {
            if (!newDepartmentName.isBlank()) {
                this.departmentName = newDepartmentName;
            }
        }
    }

    /**
     * Returns the departmentName
     * @return Returns the departmentName as a String
     */
    public String getDepartmentName() {
        return this.departmentName;
    }

    /**
     * Adds a given employee to the department
     * @param employee The employee to add, can not be null
     *                 and can not have the same social security
     *                 number as an already existing employee
     */
    public void addEmployee(Employee employee) {
        if (employee != null) {
            if (!this.personnel.containsKey(employee.getSocialSecurityNumber())) {
                this.personnel.put(employee.getSocialSecurityNumber(), employee);
            }
        }
    }

    /**
     * Removes a given person from the department
     * @param person The person to remove, can not be null
     * @throws RemoveException If the person is not already present in the department
     */
    public void remove(Person person) throws RemoveException
    {
        if (person != null) {
            if (!this.personnel.containsKey(person.getSocialSecurityNumber())) {
                throw new RemoveException("The given person to remove was not found in the register");
            }

            this.personnel.remove(person.getSocialSecurityNumber());
        }
    }

    /**
     * Returns a List of employees in the department
     * @return A List of employees in the department
     */
    public List<Employee> getEmployees() {
        List<Employee> toReturn = new ArrayList<>();

        if (!this.personnel.isEmpty()) {
            for (Person person : this.personnel.values()) {
                if (person instanceof Employee) {
                    toReturn.add((Employee) person);
                }
            }
        }

        return toReturn;
    }

    /**
     * Adds a given patient to the department
     * @param patient The patient to add, can not be null
     *                and can not have the same social security
     *                number as an already existing patient
     */
    public void addPatient(Patient patient) {
        if (patient != null) {
            if (!this.personnel.containsKey(patient.getSocialSecurityNumber())) {
                this.personnel.put(patient.getSocialSecurityNumber(), patient);
            }
        }
    }

    /**
     * Returns a List of patients in the department
     * @return A List of patients in the department
     */
    public List<Patient> getPatients() {
        List<Patient> toReturn = new ArrayList<>();

        if (!this.personnel.isEmpty()) {
            for (Person person : this.personnel.values()) {
                if (person instanceof Patient) {
                    toReturn.add((Patient) person);
                }
            }
        }

        return toReturn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Department that = (Department) o;
        return ((this.departmentName.equals(that.departmentName)) && (this.personnel.equals(that.personnel)));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.departmentName, this.personnel);
    }

    @Override
    public String toString() {
        return "Department name: " + this.departmentName + "\n" +
                "Personnel: " + this.personnel + "\n";
    }
}