package mappe.del1.hospital.healthpersonal.doctor;

import mappe.del1.hospital.Patient;

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
