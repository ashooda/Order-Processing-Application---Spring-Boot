package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employee_status", schema = "dbo", catalog = "Complete_DB_V_3")
public class EmployeeStatus {
    private int employeeStatusId;
    private String employeeStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employeeStatus", cascade = CascadeType.ALL)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        //  employees.forEach(employee -> employee.setEmployeeStatus(this));
        this.employees = employees;
    }

    private Set<Employee> employees;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_status_id")
    public int getEmployeeStatusId() {
        return employeeStatusId;
    }

    public void setEmployeeStatusId(int employeeStatusId) {
        this.employeeStatusId = employeeStatusId;
    }

    @Basic
    @Column(name = "employee_status")
    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeStatus that = (EmployeeStatus) o;
        return employeeStatusId == that.employeeStatusId &&
                Objects.equals(employeeStatus, that.employeeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeStatusId, employeeStatus);
    }


}
