package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Ornament {
    private int ornamentId;







    private int ornamentSizeId;
    private int ornamentStatusId;
    private int ornamentTypeId;
    private int ornamentColorId;

    OrnamentSize ornamentSize;
    OrnamentStatus ornamentStatus;
    OrnamentType ornamentType;
    OrnamentColor ornamentColor;
    private Set<OrnamentLine> ornamentLines;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ornament", cascade =  CascadeType.ALL)
    public Set<OrnamentLine> getOrnamentLines() {
        return ornamentLines;
    }

    public void setOrnamentLines(Set<OrnamentLine> ornamentLines) {
        // ornamentLines.forEach(ornamentLine -> ornamentLine.setOrnament(this));
        this.ornamentLines = ornamentLines;
    }



    @ManyToOne
    @JoinColumn(name = "ornament_color_id", insertable = false, updatable = false)
    public OrnamentColor getOrnamentColor() {
        return ornamentColor;
    }

    public void setOrnamentColor(OrnamentColor ornamentColor) {
        this.ornamentColor = ornamentColor;
    }



    @ManyToOne
    @JoinColumn(name = "ornament_type_id", nullable = false, insertable = false, updatable = false)
    public OrnamentType getOrnamentType() {
        return ornamentType;
    }

    public void setOrnamentType(OrnamentType ornamentType) {
        this.ornamentType = ornamentType;
    }



    @ManyToOne
    @JoinColumn(name = "ornament_status_id", nullable = false, insertable = false, updatable = false)
    public OrnamentStatus getOrnamentStatus() {
        return ornamentStatus;
    }

    public void setOrnamentStatus(OrnamentStatus ornamentStatus) {
        this.ornamentStatus = ornamentStatus;
    }



    @ManyToOne
    @JoinColumn(name = "ornament_size_id", insertable = false, updatable = false)
    public OrnamentSize getOrnamentSize() {
        return ornamentSize;
    }

    public void setOrnamentSize(OrnamentSize ornamentSize) {
        this.ornamentSize = ornamentSize;
    }



    @Id
    @Column(name = "ornament_id")
    public int getOrnamentId() {
        return ornamentId;
    }

    public void setOrnamentId(int ornamentId) {
        this.ornamentId = ornamentId;
    }

    @Basic
    @Column(name = "ornament_size_id")
    public int getOrnamentSizeId() {
        return ornamentSizeId;
    }

    public void setOrnamentSizeId(int ornamentSizeId) {
        this.ornamentSizeId = ornamentSizeId;
    }



    @Basic
    @Column(name = "ornament_status_id")
    public int getOrnamentStatusId() {
        return ornamentStatusId;
    }

    public void setOrnamentStatusId(int ornamentStatusId) {
        this.ornamentStatusId = ornamentStatusId;
    }


    @Basic
    @Column(name = "ornament_type_id")
    public int getOrnamentTypeId() {
        return ornamentTypeId;
    }

    public void setOrnamentTypeId(int ornamentTypeId) {
        this.ornamentTypeId = ornamentTypeId;
    }


    @Basic
    @Column(name = "ornament_color_id")
    public int getOrnamentColorId() {
        return ornamentColorId;
    }

    public void setOrnamentColorId(int ornamentColorId) {
        this.ornamentColorId = ornamentColorId;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ornament ornament = (Ornament) o;
        return ornamentId == ornament.ornamentId &&
                ornamentSizeId == ornament.ornamentSizeId &&
                ornamentStatusId == ornament.ornamentStatusId &&
                ornamentTypeId == ornament.ornamentTypeId &&
                ornamentColorId == ornament.ornamentColorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ornamentId, ornamentSizeId, ornamentStatusId, ornamentTypeId, ornamentColorId);
    }





}
