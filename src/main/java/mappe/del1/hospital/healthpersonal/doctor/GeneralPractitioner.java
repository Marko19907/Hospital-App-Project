package mappe.del1.hospital.healthpersonal.doctor;

import mappe.del1.hospital.Patient;

/**
 * Class GeneralPractitioner represents a general practitioner in the hospital
 * The class is a subclass of Doctor and a general practitioner is therefore
 * allowed to give patients a diagnosis
 */
public class GeneralPractitioner extends Doctor
{
    public GeneralPractitioner(String firstName, String lastName, String socialSecurityNumber)
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
