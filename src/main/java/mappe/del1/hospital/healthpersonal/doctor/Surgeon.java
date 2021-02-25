package mappe.del1.hospital.healthpersonal.doctor;

import mappe.del1.hospital.Patient;

/**
 * Class Surgeon represents a single surgeon in the hospital
 * The class is a subclass of Doctor and a surgeon is therefore
 * allowed to give patients a diagnosis
 */
public class Surgeon extends Doctor
{
    public Surgeon(String firstName, String lastName, String socialSecurityNumber)
    {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public void setDiagnosis(Patient patient, String diagnosis)
    {
        if (patient != null && diagnosis != null) {
            if (!diagnosis.isBlank()) {
                patient.setDiagnosis(diagnosis);
            }
        }
    }
}
