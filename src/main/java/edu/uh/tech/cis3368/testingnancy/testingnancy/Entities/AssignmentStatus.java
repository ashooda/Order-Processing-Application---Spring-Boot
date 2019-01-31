package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "assignment_status", schema = "dbo", catalog = "Complete_DB_V_3")
public class AssignmentStatus {
    private int assignmentStatusId;
    private String assignmentStatus;
    private Set<Assignment> assignments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "assignmentStatus", cascade = CascadeType.ALL)
    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        // assignments.forEach(assignment -> assignment.setAssignmentStatus(this));
        this.assignments = assignments;
    }

    public AssignmentStatus() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_status_id")
    public int getAssignmentStatusId() {
        return assignmentStatusId;
    }

    public void setAssignmentStatusId(int assignmentStatusId) {
        this.assignmentStatusId = assignmentStatusId;
    }

    @Basic
    @Column(name = "assignment_status")
    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignmentStatus that = (AssignmentStatus) o;
        return assignmentStatusId == that.assignmentStatusId &&
                Objects.equals(assignmentStatus, that.assignmentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assignmentStatusId, assignmentStatus);
    }


}
