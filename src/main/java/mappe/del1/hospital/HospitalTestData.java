package mappe.del1.hospital;

import mappe.del1.hospital.healthpersonnel.Nurse;
import mappe.del1.hospital.healthpersonnel.doctor.GeneralPractitioner;
import mappe.del1.hospital.healthpersonnel.doctor.Surgeon;

public class HospitalTestData {

    /**
     * Fills the hospital provided as a parameter with
     * departments and some employees and patients.
     *
     * @param hospital the hospital to be populated with testdata
     */
    public static void fillRegisterWithTestData(final Hospital hospital) {

        // Add some departments
        Department emergencyRoom = new Department("Akutten");
        emergencyRoom.addEmployee(new Employee("Odd Even", "Primtallet", null));
        emergencyRoom.addEmployee(new Employee("Huppasahn", "DelFinito", null));
        emergencyRoom.addEmployee(new Nurse("Rigmor", "Mortis", null));
        emergencyRoom.addEmployee(new GeneralPractitioner("Inco", "Gnito", null));
        emergencyRoom.addEmployee(new Surgeon("Inco", "Gnito", null));
        emergencyRoom.addPatient(new Patient("Nina", "Teknologi", null));
        emergencyRoom.addPatient(new Patient("Ove", "Ralt", null));
        hospital.addDepartment(emergencyRoom);

        Department childrensPolyclinic = new Department("Barne poliklinikk");
        childrensPolyclinic.addEmployee(new Employee("Salti", "Kaffen", null));
        childrensPolyclinic.addEmployee(new Employee("Nidel V.", "ElvefÃ¸lger", null));
        childrensPolyclinic.addEmployee(new Nurse("Anton", "Nym", null));
        childrensPolyclinic.addEmployee(new GeneralPractitioner("Gene", "Sis", null));
        childrensPolyclinic.addPatient(new Patient("Nanna", "Na", null));
        childrensPolyclinic.addPatient(new Patient("Nora", "Toriet", null));
        hospital.addDepartment(childrensPolyclinic);
    }
}