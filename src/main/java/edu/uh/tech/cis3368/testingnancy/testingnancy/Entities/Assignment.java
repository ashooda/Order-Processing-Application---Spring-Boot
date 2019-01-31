package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Assignment {
    private int assignmentId;
    private int assignmentStatusId;
    private int orderlineId;
    private String assignmentDesc;
    private Date assignmentCompletedDate;
    private Set<AssignmentLine> assignmentLines;
    AssignmentStatus assignmentStatus;
    Orderline orderline;


    @ManyToOne
    @JoinColumn(name = "order_line_id", nullable = false, insertable = false, updatable = false)
    public Orderline getOrderline() {
        return orderline;
    }

    public void setOrderline(Orderline orderline) {
        this.orderline = orderline;
    }


    @ManyToOne
    @JoinColumn(name = "assignment_status_id", nullable = false, insertable = false, updatable = false)
    public AssignmentStatus getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(AssignmentStatus assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }




    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignment", cascade = CascadeType.ALL)
    public Set<AssignmentLine> getAssignmentLines() {
        return assignmentLines;
    }

    public void setAssignmentLines(Set<AssignmentLine> assignmentLines) {
        // assignmentLines.forEach(assignmentLine -> assignmentLine.setAssignment(this));
        this.assignmentLines = assignmentLines;
    }


    public Assignment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    @Basic
    @Column(name = "assignment_status_id")
    public int getAssignmentStatusId() {
        return assignmentStatusId;
    }

    public void setAssignmentStatusId(int assignmentStatusId) {
        this.assignmentStatusId = assignmentStatusId;
    }

    @Basic
    @Column(name = "order_line_id")
    public int getOrderlineId() {
        return orderlineId;
    }

    public void setOrderlineId(int orderlineId) {
        this.orderlineId = orderlineId;
    }


    @Basic
    @Column(name = "assignment_desc")
    public String getAssignmentDesc() {
        return assignmentDesc;
    }

    public void setAssignmentDesc(String assignmentDesc) {
        this.assignmentDesc = assignmentDesc;
    }

    @Basic
    @Column(name = "assignment_completed_date")
    public Date getAssignmentCompletedDate() {
        return assignmentCompletedDate;
    }

    public void setAssignmentCompletedDate(Date assignmentCompletedDate) {
        this.assignmentCompletedDate = assignmentCompletedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return assignmentId == that.assignmentId &&
                assignmentStatusId == that.assignmentStatusId &&
                orderlineId == that.orderlineId &&
                Objects.equals(assignmentDesc, that.assignmentDesc) &&
                Objects.equals(assignmentCompletedDate, that.assignmentCompletedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentId, assignmentStatusId, orderlineId, assignmentDesc, assignmentCompletedDate);
    }






}
