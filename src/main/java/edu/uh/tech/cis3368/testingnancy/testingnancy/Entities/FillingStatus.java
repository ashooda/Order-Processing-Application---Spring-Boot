package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "filling_status", schema = "dbo", catalog = "Complete_DB_V_3")
public class FillingStatus {
    private int fillingStatusId;
    private String fillingStatus;
    private Set<Filling> fillings;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fillingStatus", cascade = CascadeType.ALL)
    public Set<Filling> getFillings() {
        return fillings;
    }

    public void setFillings(Set<Filling> fillings) {
        //fillings.forEach(filling -> filling.setFillingStatus(this));
        this.fillings = fillings;
    }







    @Id
    @Column(name = "filling_status_id")
    public int getFillingStatusId() {
        return fillingStatusId;
    }

    public void setFillingStatusId(int fillingStatusId) {
        this.fillingStatusId = fillingStatusId;
    }

    @Basic
    @Column(name = "filling_status")
    public String getFillingStatus() {
        return fillingStatus;
    }

    public void setFillingStatus(String fillingStatus) {
        this.fillingStatus = fillingStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FillingStatus that = (FillingStatus) o;
        return fillingStatusId == that.fillingStatusId &&
                Objects.equals(fillingStatus, that.fillingStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fillingStatusId, fillingStatus);
    }


}
