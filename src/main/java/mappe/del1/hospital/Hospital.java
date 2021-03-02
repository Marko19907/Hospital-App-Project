package mappe.del1.hospital;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class Hospital represents a hospital
 * It is responsible for storing a list of it's departments
 */
public class Hospital
{
    private final String hospitalName;
    private final HashMap<String, Department> departmentList;

    public Hospital(String hospitalName)
    {
        if (hospitalName == null) {
            throw new IllegalArgumentException("hospitalName can not be null");
        }
        if (hospitalName.isBlank()) {
            throw new IllegalArgumentException("hospitalName can not be blank");
        }
        this.hospitalName = hospitalName;

        this.departmentList = new HashMap<>();
    }

    /**
     * Returns the name of the hospital
     * @return name of the hospital as a String
     */
    public String getHospitalName()
    {
        return this.hospitalName;
    }

    /**
     * Adds a given department to the department list
     * @param department The department to add, can not be null or a duplicate
     */
    public void addDepartment(Department department)
    {
        if (department != null) {
            if (!this.departmentList.containsKey(department.getDepartmentName())) {
                this.departmentList.put(department.getDepartmentName(), department);
            }
        }
    }

    /**
     * Returns a List of the departments
     * @return List of the departments
     */
    public List<Department> getDepartmentList()
    {
        List<Department> toReturn = new ArrayList<>();
        if (!this.departmentList.isEmpty()) {
            toReturn.addAll(this.departmentList.values());
        }
        return toReturn;
    }

    @Override
    public String toString()
    {
        return "Hospital : " + this.getHospitalName() + " with "
                + this.departmentList.size() + " department(s)";
    }
}
