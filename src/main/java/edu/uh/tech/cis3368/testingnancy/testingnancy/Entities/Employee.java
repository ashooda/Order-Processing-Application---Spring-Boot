package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Employee {
    private int employeeId;
    private int empolyeeStatusId;
    private int employeeTypeId;
    private String employeePhoneNumber;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeEmail;
    private Date employeeHireDate;
    private Date employeeTerminationDate;
    private Set<AssignmentLine> assignmentLines;
    EmployeeType employeeType;
    EmployeeStatus employeeStatus;

    @ManyToOne
    @JoinColumn(name = "employee_status_id", nullable = false, insertable = false, updatable = false)
    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }



    @ManyToOne
    @JoinColumn(name = "employee_type_id", nullable = false, insertable = false, updatable = false)
    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }




    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee", cascade = CascadeType.ALL)
    public Set<AssignmentLine> getAssignmentLines() {
        return assignmentLines;
    }

    public void setAssignmentLines(Set<AssignmentLine> assignmentLines) {
        //assignmentLines.forEach(assignmentLine -> assignmentLine.setEmployee(this));
        this.assignmentLines = assignmentLines;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @Column(name = "employee_status_id")
    public int getEmpolyeeStatusId() {
        return empolyeeStatusId;
    }

    public void setEmpolyeeStatusId(int empolyeeStatusId) {
        this.empolyeeStatusId = empolyeeStatusId;
    }

    @Basic
    @Column(name = "employee_type_id")
    public int getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(int employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }


    @Basic
    @Column(name = "employee_phone_number")
    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    @Basic
    @Column(name = "employee_first_name")
    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    @Basic
    @Column(name = "employee_last_name")
    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    @Basic
    @Column(name = "employee_email")
    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    @Basic
    @Column(name = "employee_hire_date")
    public Date getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(Date employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    @Basic
    @Column(name = "employee_termination_date")
    public Date getEmployeeTerminationDate() {
        return employeeTerminationDate;
    }

    public void setEmployeeTerminationDate(Date employeeTerminationDate) {
        this.employeeTerminationDate = employeeTerminationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                empolyeeStatusId == employee.empolyeeStatusId &&
                employeeTypeId == employee.employeeTypeId &&
                Objects.equals(employeePhoneNumber, employee.employeePhoneNumber) &&
                Objects.equals(employeeFirstName, employee.employeeFirstName) &&
                Objects.equals(employeeLastName, employee.employeeLastName) &&
                Objects.equals(employeeEmail, employee.employeeEmail) &&
                Objects.equals(employeeHireDate, employee.employeeHireDate) &&
                Objects.equals(employeeTerminationDate, employee.employeeTerminationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, empolyeeStatusId, employeeTypeId,  employeePhoneNumber, employeeFirstName, employeeLastName, employeeEmail, employeeHireDate, employeeTerminationDate);
    }




}
