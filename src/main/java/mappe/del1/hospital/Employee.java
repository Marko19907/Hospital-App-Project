package mappe.del1.hospital;

/**
 * Class Employee a single employee in the hospital
 */
public class Employee extends Person
{
    public Employee(String firstName, String lastName, String socialSecurityNumber)
    {
        super(firstName, lastName, socialSecurityNumber);
    }

    @Override
    public String toString()
    {
        return "Employee: " + super.getFullName() + ", with ID: " + super.getSocialSecurityNumber();
    }
}
