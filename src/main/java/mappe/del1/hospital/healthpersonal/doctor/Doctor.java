package mappe.del1.hospital.healthpersonal.doctor;

import mappe.del1.hospital.Employee;
import mappe.del1.hospital.Patient;

public abstract class Doctor extends Employee
{
    public Doctor(String firstName, String lastName, String socialSecurityNumber)
    {
        super(firstName, lastName, socialSecurityNumber);
    }

    /**
     * Sets the diagnosis of a patient
     * @param patient The patient to set the diagnosis to, can't be null
     * @param diagnosis The diagnosis to set, can't be null or blank
     */
    public abstract void setDiagnosis(Patient patient, String diagnosis);
}
