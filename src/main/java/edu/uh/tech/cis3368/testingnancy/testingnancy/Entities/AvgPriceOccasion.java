package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class AvgPriceOccasion {
    private int orderLineId;
    private String occasionType;
    private int productTypeId;
    private String productType;
    private Integer productFrequency;
    private Double averagePrice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_line_id")
    public int getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
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
    @Column(name = "product_type_id")
    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Basic
    @Column(name = "product_type")
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Basic
    @Column(name = "Product Frequency")
    public Integer getProductFrequency() {
        return productFrequency;
    }

    public void setProductFrequency(Integer productFrequency) {
        this.productFrequency = productFrequency;
    }

    @Basic
    @Column(name = "AVERAGE PRICE")
    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvgPriceOccasion that = (AvgPriceOccasion) o;
        return orderLineId == that.orderLineId &&
                productTypeId == that.productTypeId &&
                Objects.equals(occasionType, that.occasionType) &&
                Objects.equals(productType, that.productType) &&
                Objects.equals(productFrequency, that.productFrequency) &&
                Objects.equals(averagePrice, that.averagePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderLineId, occasionType, productTypeId, productType, productFrequency, averagePrice);
    }
}
