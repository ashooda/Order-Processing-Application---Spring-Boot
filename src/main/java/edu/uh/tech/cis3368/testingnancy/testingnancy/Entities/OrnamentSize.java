package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ornament_size", schema = "dbo", catalog = "Complete_DB_V_3")
public class OrnamentSize {
    private int ornamentSizeId;
    private String ornamentSize;
    private Set<Ornament> ornaments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ornamentSize", cascade = CascadeType.ALL)
    public java.util.Set<Ornament> getOrnaments() {
        return ornaments;
    }

    public void setOrnaments(Set<Ornament> ornaments) {
        // ornaments.forEach(ornament -> ornament.setOrnamentSize(this));
        this.ornaments = ornaments;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ornament_size_id")
    public int getOrnamentSizeId() {
        return ornamentSizeId;
    }

    public void setOrnamentSizeId(int ornamentSizeId) {
        this.ornamentSizeId = ornamentSizeId;
    }

    @Basic
    @Column(name = "ornament_size")
    public String getOrnamentSize() {
        return ornamentSize;
    }

    public void setOrnamentSize(String ornamentSize) {
        this.ornamentSize = ornamentSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrnamentSize that = (OrnamentSize) o;
        return ornamentSizeId == that.ornamentSizeId &&
                Objects.equals(ornamentSize, that.ornamentSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ornamentSizeId, ornamentSize);
    }


}
