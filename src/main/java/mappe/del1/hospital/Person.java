package mappe.del1.hospital;

/**
 * Class Person represents a single person in the hospital.
 * It is responsible for storing the name, last name and
 * the social security number of a single person.
 */
public abstract class Person
{
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    public Person(String firstName, String lastName, String socialSecurityNumber)
    {
        if (firstName == null || lastName == null || socialSecurityNumber == null) {
            throw new IllegalArgumentException("firstName, lastName or socialSecurityNumber can not be null");
        }
        if (firstName.isBlank() || lastName.isBlank() || socialSecurityNumber.isBlank()) {
            throw new IllegalArgumentException("firstName, lastName or socialSecurityNumber can not be blank");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    /**
     * Returns the social security number of the person
     * @return Returns the social security number of the person as a String
     */
    public String getSocialSecurityNumber()
    {
        return this.socialSecurityNumber;
    }

    /**
     * Sets the person's social security number
     * @param newSocialSecurityNumber The new social security number, can't be null or blank
     */
    public void setSocialSecurityNumber(String newSocialSecurityNumber)
    {
        if (newSocialSecurityNumber != null) {
            if (!newSocialSecurityNumber.isBlank()) {
                this.socialSecurityNumber = newSocialSecurityNumber;
            }
        }
    }

    /**
     * Sets the person's first name
     * @param newFirstName The new first name, can't be null or blank
     */
    public void setFirstName(String newFirstName)
    {
        if (newFirstName != null) {
            if (!newFirstName.isBlank()) {
                this.firstName = newFirstName;
            }
        }
    }

    /**
     * Sets the person's last name
     * @param newLastName The new last name, can't be null or blank
     */
    public void setLastName(String newLastName)
    {
        if (newLastName != null) {
            if (!newLastName.isBlank()) {
                this.lastName = newLastName;
            }
        }
    }

    /**
     * Returns the first name of the person
     * @return The first name of the person as a String
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * Returns the last name of the person
     * @return The last name of the person as a String
     */
    public String getLastName()
    {
        return this.lastName;
    }

    /**
     * Returns the full name of the person
     * @return The full name of the person as a single String
     */
    public String getFullName()
    {
        return this.firstName + " " + this.lastName;
    }
}
