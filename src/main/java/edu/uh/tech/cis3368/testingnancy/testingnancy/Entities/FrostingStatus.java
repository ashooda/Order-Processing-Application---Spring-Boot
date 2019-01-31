package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "frosting_status", schema = "dbo", catalog = "Complete_DB_V_3")
public class FrostingStatus {
    private int frostingStatusId;
    private String frostingStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "frostingStatus", cascade = CascadeType.ALL)
    public Set<Frosting> getFrostings() {
        return frostings;
    }

    public void setFrostings(Set<Frosting> frostings) {
        this.frostings = frostings;
    }

    private Set<Frosting> frostings;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "frosting_status_id")
    public int getFrostingStatusId() {
        return frostingStatusId;
    }

    public void setFrostingStatusId(int frostingStatusId) {
        this.frostingStatusId = frostingStatusId;
    }

    @Basic
    @Column(name = "frosting_status")
    public String getFrostingStatus() {
        return frostingStatus;
    }

    public void setFrostingStatus(String frostingStatus) {
        this.frostingStatus = frostingStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrostingStatus that = (FrostingStatus) o;
        return frostingStatusId == that.frostingStatusId &&
                Objects.equals(frostingStatus, that.frostingStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frostingStatusId, frostingStatus);
    }


}
