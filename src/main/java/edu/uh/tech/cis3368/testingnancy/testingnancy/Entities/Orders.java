package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import edu.uh.tech.cis3368.testingnancy.testingnancy.Repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

@Entity
public class Orders {
    @Autowired
    private OrdersRepository ordersRepository;

    private int orderId;
    private int customerId;
    private int orderPlacementMethodId;
    private int orderStatusId;
    private int occasionId;
    private int orderFulfillmentMethodId;


    private boolean orderRentalRequest;
    private Date orderReceivedDate;
    private Date orderDueDate;
    private double orderDeposit;
    private String orderSpecialRequirements;
    private String orderDeliverStreet;
    private String orderDeliveryCity;
    private String orderDeliveryZipcode;
    private Date orderCompletedDate;
    private String orderDeliverBy;
    private String orderImage;
    private String orderDisclosureForm;
    private double orderTotalPrice;







    Customer customer;
    OrderPlacementMethod orderPlacementMethod;
    OrderStatus orderStatus;
    Occasion occasion;
    OrderFulfillmentMethod orderFulfillmentMethod;
    private Set<Orderline> orderlines;
    private Set<OrnamentLine> ornamentLines;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders", cascade = CascadeType.ALL)
    public Set<OrnamentLine> getOrnamentLines() {
        return ornamentLines;
    }

    public void setOrnamentLines(Set<OrnamentLine> ornamentLines) {
        // ornamentLines.forEach(ornamentLine -> ornamentLine.setOrders(this));
        this.ornamentLines = ornamentLines;
    }



    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orders", cascade = CascadeType.ALL)
    public Set<Orderline> getOrderlines() {
        return orderlines;
    }

    public void setOrderlines(Set<Orderline> orderlines) {
        //orderlines.forEach(orderline -> orderline.setOrders(this));
        this.orderlines = orderlines;
    }



    @ManyToOne
    @JoinColumn(name = "order_fulfillment_method_id", nullable = false, insertable = false, updatable = false)
    public OrderFulfillmentMethod getOrderFulfillmentMethod() {
        return orderFulfillmentMethod;
    }

    public void setOrderFulfillmentMethod(OrderFulfillmentMethod orderFulfillmentMethod) {
        this.orderFulfillmentMethod = orderFulfillmentMethod;
    }


    @ManyToOne
    @JoinColumn(name = "occasion_id", nullable = false, insertable = false, updatable = false)
    public Occasion getOccasion() {
        return occasion;
    }

    public void setOccasion(Occasion occasion) {
        this.occasion = occasion;
    }



    @ManyToOne
    @JoinColumn(name = "order_status_id", nullable = false, insertable = false, updatable = false)
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }



    @ManyToOne
    @JoinColumn(name = "order_placement_method_id", nullable = false, insertable = false, updatable = false)
    public OrderPlacementMethod getOrderPlacementMethod() {
        return orderPlacementMethod;
    }

    public void setOrderPlacementMethod(OrderPlacementMethod orderPlacementMethod) {
        this.orderPlacementMethod = orderPlacementMethod;
    }



    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, insertable = false, updatable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "order_placement_method_id")
    public int getOrderPlacementMethodId() {
        return orderPlacementMethodId;
    }

    public void setOrderPlacementMethodId(int orderPlacementMethodId) {
        this.orderPlacementMethodId = orderPlacementMethodId;
    }


    @Basic
    @Column(name = "order_status_id")
    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Basic
    @Column(name = "occasion_id")
    public int getOccasionId() {
        return occasionId;
    }

    public void setOccasionId(int occasionId) {
        this.occasionId = occasionId;
    }

    @Basic
    @Column(name = "order_fulfillment_method_id")
    public int getOrderFulfillmentMethodId() {
        return orderFulfillmentMethodId;
    }

    public void setOrderFulfillmentMethodId(int orderFulfillmentMethodId) {
        this.orderFulfillmentMethodId = orderFulfillmentMethodId;
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
    @Column(name = "order_received_date")
    public Date getOrderReceivedDate() {
        return orderReceivedDate;
    }

    public void setOrderReceivedDate(Date orderReceivedDate) {
        this.orderReceivedDate = orderReceivedDate;
    }

    @Basic
    @Column(name = "order_due_date")
    public Date getOrderDueDate() {
        return orderDueDate;
    }

    public void setOrderDueDate(Date orderDueDate) {
        this.orderDueDate = orderDueDate;
    }

    @Basic
    @Column(name = "order_deposit")
    public double getOrderDeposit() {
        return orderDeposit;
    }

    public void setOrderDeposit(double orderDeposit) {
        this.orderDeposit = orderDeposit;
    }

    @Basic
    @Column(name = "order_special_requirements")
    public String getOrderSpecialRequirements() {
        return orderSpecialRequirements;
    }

    public void setOrderSpecialRequirements(String orderSpecialRequirements) {
        this.orderSpecialRequirements = orderSpecialRequirements;
    }

    @Basic
    @Column(name = "order_deliver_street")
    public String getOrderDeliverStreet() {
        return orderDeliverStreet;
    }

    public void setOrderDeliverStreet(String orderDeliverStreet) {
        this.orderDeliverStreet = orderDeliverStreet;
    }

    @Basic
    @Column(name = "order_delivery_city")
    public String getOrderDeliveryCity() {
        return orderDeliveryCity;
    }

    public void setOrderDeliveryCity(String orderDeliveryCity) {
        this.orderDeliveryCity = orderDeliveryCity;
    }

    @Basic
    @Column(name = "order_delivery_zipcode")
    public String getOrderDeliveryZipcode() {
        return orderDeliveryZipcode;
    }

    public void setOrderDeliveryZipcode(String orderDeliveryZipcode) {
        this.orderDeliveryZipcode = orderDeliveryZipcode;
    }

    @Basic
    @Column(name = "order_completed_date")
    public Date getOrderCompletedDate() {
        return orderCompletedDate;
    }

    public void setOrderCompletedDate(Date orderCompletedDate) {
        this.orderCompletedDate = orderCompletedDate;
    }

    @Basic
    @Column(name = "order_deliver_by")
    public String getOrderDeliverBy() {
        return orderDeliverBy;
    }

    public void setOrderDeliverBy(String orderDeliverBy) {
        this.orderDeliverBy = orderDeliverBy;
    }

    @Basic
    @Column(name = "order_image")
    public String getOrderImage() {
        return orderImage;
    }

    public void setOrderImage(String orderImage) {
        this.orderImage = orderImage;
    }

    @Basic
    @Column(name = "order_disclosure_form")
    public String getOrderDisclosureForm() {
        return orderDisclosureForm;
    }

    public void setOrderDisclosureForm(String orderDisclosureForm) {
        this.orderDisclosureForm = orderDisclosureForm;
    }

    @Basic
    @Column(name = "order_total_price")
    public double getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(double orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return orderId == orders.orderId &&
                customerId == orders.customerId &&
                orderPlacementMethodId == orders.orderPlacementMethodId &&
                orderStatusId == orders.orderStatusId &&
                occasionId == orders.occasionId &&
                orderFulfillmentMethodId == orders.orderFulfillmentMethodId &&
                orderRentalRequest == orders.orderRentalRequest &&
                Double.compare(orders.orderDeposit, orderDeposit) == 0 &&
                Double.compare(orders.orderTotalPrice, orderTotalPrice) == 0 &&
                Objects.equals(orderReceivedDate, orders.orderReceivedDate) &&
                Objects.equals(orderDueDate, orders.orderDueDate) &&
                Objects.equals(orderSpecialRequirements, orders.orderSpecialRequirements) &&
                Objects.equals(orderDeliverStreet, orders.orderDeliverStreet) &&
                Objects.equals(orderDeliveryCity, orders.orderDeliveryCity) &&
                Objects.equals(orderDeliveryZipcode, orders.orderDeliveryZipcode) &&
                Objects.equals(orderCompletedDate, orders.orderCompletedDate) &&
                Objects.equals(orderDeliverBy, orders.orderDeliverBy) &&
                Objects.equals(orderImage, orders.orderImage) &&
                Objects.equals(orderDisclosureForm, orders.orderDisclosureForm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, orderPlacementMethodId, orderStatusId, occasionId, orderFulfillmentMethodId, orderRentalRequest, orderReceivedDate, orderDueDate, orderDeposit, orderSpecialRequirements, orderDeliverStreet, orderDeliveryCity, orderDeliveryZipcode, orderCompletedDate, orderDeliverBy, orderImage, orderDisclosureForm, orderTotalPrice);
    }





}
