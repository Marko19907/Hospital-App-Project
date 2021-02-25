package mappe.del1.hospital.healthpersonal;

import mappe.del1.hospital.Employee;

/**
 * Class Nurse represents a single nurse at the hospital
 * Nurses are not allowed to give patients a diagnosis
 */
public class Nurse extends Employee
{
    public Nurse(String firstName, String lastName, String socialSecurityNumber)
    {
        super(firstName, lastName, socialSecurityNumber);
    }
}
