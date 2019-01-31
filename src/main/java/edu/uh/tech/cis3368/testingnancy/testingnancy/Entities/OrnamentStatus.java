package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ornament_status", schema = "dbo", catalog = "Complete_DB_V_3")
public class OrnamentStatus {
    private int ornamentStatusId;
    private String ornamentStatus;
    private Set<Ornament> ornaments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ornamentStatus", cascade = CascadeType.ALL)
    public java.util.Set<Ornament> getOrnaments() {
        return ornaments;
    }

    public void setOrnaments(Set<Ornament> ornaments) {
        //ornaments.forEach(ornament -> ornament.setOrnamentStatus(this));
        this.ornaments = ornaments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ornament_status_id")
    public int getOrnamentStatusId() {
        return ornamentStatusId;
    }

    public void setOrnamentStatusId(int ornamentStatusId) {
        this.ornamentStatusId = ornamentStatusId;
    }

    @Basic
    @Column(name = "ornament_status")
    public String getOrnamentStatus() {
        return ornamentStatus;
    }

    public void setOrnamentStatus(String ornamentStatus) {
        this.ornamentStatus = ornamentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrnamentStatus that = (OrnamentStatus) o;
        return ornamentStatusId == that.ornamentStatusId &&
                Objects.equals(ornamentStatus, that.ornamentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ornamentStatusId, ornamentStatus);
    }


}
