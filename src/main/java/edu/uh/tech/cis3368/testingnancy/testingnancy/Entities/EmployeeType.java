package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employee_type", schema = "dbo", catalog = "Complete_DB_V_3")
public class EmployeeType {
    private int employeeTypeId;
    private String employeeType;
    private Set<Employee> employees;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeType", cascade = CascadeType.ALL)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        //  employees.forEach(employee -> employee.setEmployeeType(this));
        this.employees = employees;
    }





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_type_id")
    public int getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(int employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    @Basic
    @Column(name = "employee_type")
    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeType that = (EmployeeType) o;
        return employeeTypeId == that.employeeTypeId &&
                Objects.equals(employeeType, that.employeeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeTypeId, employeeType);
    }


}
