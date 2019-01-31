package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "size_status", schema = "dbo", catalog = "Complete_DB_V_3")
public class SizeStatus {
    private int sizeStatusId;
    private String sizeStatus;
    private Set<Size> sizes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sizeStatus", cascade = CascadeType.ALL)
    public Set<Size> getSizes() {
        return sizes;
    }

    public void setSizes(Set<Size> sizes) {
        this.sizes = sizes;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "size_status_id")
    public int getSizeStatusId() {
        return sizeStatusId;
    }

    public void setSizeStatusId(int sizeStatusId) {
        this.sizeStatusId = sizeStatusId;
    }

    @Basic
    @Column(name = "size_status")
    public String getSizeStatus() {
        return sizeStatus;
    }

    public void setSizeStatus(String sizeStatus) {
        this.sizeStatus = sizeStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SizeStatus that = (SizeStatus) o;
        return sizeStatusId == that.sizeStatusId &&
                Objects.equals(sizeStatus, that.sizeStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sizeStatusId, sizeStatus);
    }


}
