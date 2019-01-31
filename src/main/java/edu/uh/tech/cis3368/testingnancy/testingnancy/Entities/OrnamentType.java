package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ornament_type", schema = "dbo", catalog = "Complete_DB_V_3")
public class OrnamentType {
    private int ornamentTypeId;
    private String ornamentType;
    private Set<Ornament> ornaments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ornamentType", cascade = CascadeType.ALL)
    public Set<Ornament> getOrnaments() {
        return ornaments;
    }

    public void setOrnaments(Set<Ornament> ornaments) {
        //  ornaments.forEach(ornament -> ornament.setOrnamentType(this));
        this.ornaments = ornaments;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ornament_type_id")
    public int getOrnamentTypeId() {
        return ornamentTypeId;
    }

    public void setOrnamentTypeId(int ornamentTypeId) {
        this.ornamentTypeId = ornamentTypeId;
    }

    @Basic
    @Column(name = "ornament_type")
    public String getOrnamentType() {
        return ornamentType;
    }

    public void setOrnamentType(String ornamentType) {
        this.ornamentType = ornamentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrnamentType that = (OrnamentType) o;
        return ornamentTypeId == that.ornamentTypeId &&
                Objects.equals(ornamentType, that.ornamentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ornamentTypeId, ornamentType);
    }


}
