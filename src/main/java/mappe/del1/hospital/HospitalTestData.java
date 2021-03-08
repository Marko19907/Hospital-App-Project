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
        emergencyRoom.addEmployee(new Employee("Odd Even", "Primtallet", "565387943791"));
        emergencyRoom.addEmployee(new Employee("Huppasahn", "DelFinito", "472673823536"));
        emergencyRoom.addEmployee(new Nurse("Rigmor", "Mortis", "434180488130"));
        emergencyRoom.addEmployee(new GeneralPractitioner("Inco", "Gnito", "363463819544"));
        emergencyRoom.addEmployee(new Surgeon("Inco", "Gnito", "981577138065"));
        emergencyRoom.addPatient(new Patient("Nina", "Teknologi", "743172339743"));
        emergencyRoom.addPatient(new Patient("Ove", "Ralt", "626774123145"));
        hospital.addDepartment(emergencyRoom);

        Department childrensPolyclinic = new Department("Barne poliklinikk");
        childrensPolyclinic.addEmployee(new Employee("Salti", "Kaffen", "309578490844"));
        childrensPolyclinic.addEmployee(new Employee("Nidel V.", "ElvefÃ¸lger", "191506850981"));
        childrensPolyclinic.addEmployee(new Nurse("Anton", "Nym", "593055201793"));
        childrensPolyclinic.addEmployee(new GeneralPractitioner("Gene", "Sis", "272404269415"));
        childrensPolyclinic.addPatient(new Patient("Nanna", "Na", "545574599496"));
        childrensPolyclinic.addPatient(new Patient("Nora", "Toriet", "786862848988"));
        hospital.addDepartment(childrensPolyclinic);
    }
}