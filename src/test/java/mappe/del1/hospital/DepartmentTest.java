package mappe.del1.hospital;

import mappe.del1.hospital.exception.RemoveException;
import mappe.del1.hospital.healthpersonnel.doctor.Surgeon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DepartmentTest
{
    @Test
    @DisplayName("Test removing an already existing person")
    void testRemovingAnExistingPerson()
    {
        Department department = new Department("Test department");
        Surgeon surgeon = new Surgeon("TestName", "TestLastName", "7682378");
        department.addEmployee(surgeon);
        boolean exceptionNotThrown = false;

        try {
            department.remove(surgeon);
            exceptionNotThrown = true;
        }
        catch (RemoveException ignored) {

        }

        assertTrue(exceptionNotThrown);
    }

    @Test
    @DisplayName("Test removing a non existent person from the department")
    void testRemovingANonExistingPerson()
    {
        Department department = new Department("Test department");
        Surgeon surgeon = new Surgeon("TestName", "TestLastName", "7682378");
        boolean exceptionThrown = false;

        try {
            department.remove(surgeon);
        }
        catch (RemoveException ignored) {
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);
    }

    @Test
    @DisplayName("Test removing null from the department")
    void testRemovingNull()
    {
        Department department = new Department("Test department");
        boolean exceptionNotThrown = false;
        boolean nullPointerThrown = false;

        try {
            department.remove(null);
            exceptionNotThrown = true;
        }
        catch (RemoveException ignored) {

        }
        catch (NullPointerException e) {
            nullPointerThrown = true;
        }

        assertTrue(exceptionNotThrown);
        assertFalse(nullPointerThrown);
    }
}