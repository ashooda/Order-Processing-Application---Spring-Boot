package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Orderline {
    private int orderLineId;
    private int orderId;
    private int productTypeId;
    private int orderlineStatusId;
    private int orderLineQuantity;
    private int numberOfLayers;
    private String productAllergensDesc;
    private Set<Assignment> assignments;
    Orders orders;
    OrderLineStatus orderLineStatus;
    ProductType productType;
    private Set<ProductLayer> productLayers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderline", cascade = CascadeType.ALL)
    public Set<ProductLayer> getProductLayers() {
        return productLayers;
    }

    public void setProductLayers(Set<ProductLayer> productLayers) {
        //  productLayers.forEach(productLayer -> productLayer.setOrderline(this));
        this.productLayers = productLayers;
    }



    @ManyToOne
    @JoinColumn(name = "product_type_id", nullable = false, insertable = false, updatable = false)
    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }



    @ManyToOne
    @JoinColumn(name = "order_line_status_id", nullable = false, insertable = false, updatable = false)
    public OrderLineStatus getOrderLineStatus() {
        return orderLineStatus;
    }

    public void setOrderLineStatus(OrderLineStatus orderLineStatus) {
        this.orderLineStatus = orderLineStatus;
    }



    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderline", cascade = CascadeType.ALL)
    public Set<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<Assignment> assignments) {
        //assignments.forEach(assignment -> assignment.setOrderline(this));
        this.assignments = assignments;
    }



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
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
    @Column(name = "order_line_status_id")
    public int getOrderlineStatusId() {
        return orderlineStatusId;
    }

    public void setOrderlineStatusId(int orderlineStatusId) {
        this.orderlineStatusId = orderlineStatusId;
    }


    @Basic
    @Column(name = "order_line_quantity")
    public int getOrderLineQuantity() {
        return orderLineQuantity;
    }

    public void setOrderLineQuantity(int orderLineQuantity) {
        this.orderLineQuantity = orderLineQuantity;
    }

    @Basic
    @Column(name = "number_of_layers")
    public int getNumberOfLayers() {
        return numberOfLayers;
    }

    public void setNumberOfLayers(int numberOfLayers) {
        this.numberOfLayers = numberOfLayers;
    }

    @Basic
    @Column(name = "product_allergens_desc")
    public String getProductAllergensDesc() {
        return productAllergensDesc;
    }

    public void setProductAllergensDesc(String productAllergensDesc) {
        this.productAllergensDesc = productAllergensDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orderline orderline = (Orderline) o;
        return orderLineId == orderline.orderLineId &&
                orderId == orderline.orderId &&
                productTypeId == orderline.productTypeId &&
                orderlineStatusId == orderline.orderlineStatusId &&
                orderLineQuantity == orderline.orderLineQuantity &&
                numberOfLayers == orderline.numberOfLayers &&
                Objects.equals(productAllergensDesc, orderline.productAllergensDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderLineId, orderId, productTypeId, orderlineStatusId, orderLineQuantity, numberOfLayers, productAllergensDesc);
    }






}
