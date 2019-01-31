package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ornament_color", schema = "dbo", catalog = "Complete_DB_V_3")
public class OrnamentColor {
    private int ornamentColorId;
    private String ornamentColor;
    private Set<Ornament> ornaments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ornamentColor", cascade = CascadeType.ALL)
    public java.util.Set<Ornament> getOrnaments() {
        return ornaments;
    }

    public void setOrnaments(Set<Ornament> ornaments) {
        //ornaments.forEach(ornament -> ornament.setOrnamentColor(this));
        this.ornaments = ornaments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ornament_color_id")
    public int getOrnamentColorId() {
        return ornamentColorId;
    }

    public void setOrnamentColorId(int ornamentColorId) {
        this.ornamentColorId = ornamentColorId;
    }

    @Basic
    @Column(name = "ornament_color")
    public String getOrnamentColor() {
        return ornamentColor;
    }

    public void setOrnamentColor(String ornamentColor) {
        this.ornamentColor = ornamentColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrnamentColor that = (OrnamentColor) o;
        return ornamentColorId == that.ornamentColorId &&
                Objects.equals(ornamentColor, that.ornamentColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ornamentColorId, ornamentColor);
    }


}
