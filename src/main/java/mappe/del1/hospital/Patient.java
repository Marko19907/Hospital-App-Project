package mappe.del1.hospital;

/**
 * Class Patient represents a single patient in the hospital
 * It is responsible for storing the patient's diagnosis and personal details
 */
public class Patient extends Person implements Diagnosable
{
    private String diagnosis;

    public Patient(String firstName, String lastName, String socialSecurityNumber)
    {
        super(firstName, lastName, socialSecurityNumber);
        this.diagnosis = "";
    }

    /**
     * Returns the person's diagnosis
     * @return The person's diagnosis as a String
     */
    public String getDiagnosis()
    {
        return this.diagnosis;
    }

    @Override
    public void setDiagnosis(String diagnosis)
    {
        if (diagnosis != null) {
            if (!diagnosis.isBlank()) {
                this.diagnosis = diagnosis;
            }
        }
    }
}
