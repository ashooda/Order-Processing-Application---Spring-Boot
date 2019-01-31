package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "assignment_line", schema = "dbo", catalog = "Complete_DB_V_3")
public class AssignmentLine {
    private int assignmentLineId;
    private int assignmentId;
    private int employeeId;
    private String assignmentLineDesc;
    Assignment assignment;
    Employee employee;


    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, insertable = false, updatable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {

        this.employee = employee;
    }


    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false, insertable = false, updatable = false)
    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public AssignmentLine() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_line_id")
    public int getAssignmentLineId() {
        return assignmentLineId;
    }

    public void setAssignmentLineId(int assignmentLineId) {
        this.assignmentLineId = assignmentLineId;
    }


    @Basic
    @Column(name = "assignment_id")
    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    @Basic
    @Column(name = "employee_id")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }



    @Basic
    @Column(name = "assignment_line_desc")
    public String getAssignmentLineDesc() {
        return assignmentLineDesc;
    }

    public void setAssignmentLineDesc(String assignmentLineDesc) {
        this.assignmentLineDesc = assignmentLineDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignmentLine that = (AssignmentLine) o;
        return assignmentLineId == that.assignmentLineId &&
                assignmentId == that.assignmentId &&
                employeeId == that.employeeId &&
                Objects.equals(assignmentLineDesc, that.assignmentLineDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentLineId, assignmentId, employeeId, assignmentLineDesc);
    }




}
