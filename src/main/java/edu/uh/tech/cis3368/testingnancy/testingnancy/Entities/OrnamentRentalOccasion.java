package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrnamentRentalOccasion {
    private int ornamentLineId;
    private String occasionType;
    private String ornamentType;
    private boolean orderRentalRequest;
    private Integer frequency;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ornament_line_id")
    public int getOrnamentLineId() {
        return ornamentLineId;
    }

    public void setOrnamentLineId(int ornamentLineId) {
        this.ornamentLineId = ornamentLineId;
    }

    @Basic
    @Column(name = "occasion_type")
    public String getOccasionType() {
        return occasionType;
    }

    public void setOccasionType(String occasionType) {
        this.occasionType = occasionType;
    }

    @Basic
    @Column(name = "ornament_type")
    public String getOrnamentType() {
        return ornamentType;
    }

    public void setOrnamentType(String ornamentType) {
        this.ornamentType = ornamentType;
    }

    @Basic
    @Column(name = "order_rental_request")
    public boolean isOrderRentalRequest() {
        return orderRentalRequest;
    }

    public void setOrderRentalRequest(boolean orderRentalRequest) {
        this.orderRentalRequest = orderRentalRequest;
    }

    @Basic
    @Column(name = "Frequency")
    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrnamentRentalOccasion that = (OrnamentRentalOccasion) o;
        return ornamentLineId == that.ornamentLineId &&
                orderRentalRequest == that.orderRentalRequest &&
                Objects.equals(occasionType, that.occasionType) &&
                Objects.equals(ornamentType, that.ornamentType) &&
                Objects.equals(frequency, that.frequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ornamentLineId, occasionType, ornamentType, orderRentalRequest, frequency);
    }
}
