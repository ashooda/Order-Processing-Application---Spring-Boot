package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Customer {
    private int customerId;
    private int countryId;
    private int customerStatusId;
    private int customerTypeId;
    private int stateProvinceId;
    private String customerPhoneNumber;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerCity;
    private String customerStreetAddress;
    private String customerZipcode;
    Country country;
    CustomerStatus customerStatus;
    CustomerType customerType;
    StateProvince stateProvince;
    private Set<Orders> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    public Set<Orders> getOrders() {
        return orders;
    }



    public void setOrders (Set < Orders > orders) {
        //orders.forEach(orders1 -> orders1.setCustomer(this));
        this.orders = orders;
    }



    @ManyToOne
    @JoinColumn(name = "state_province_id", nullable = false, insertable = false, updatable = false)
    public StateProvince getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(StateProvince stateProvince) {
        this.stateProvince = stateProvince;
    }






    @ManyToOne
    @JoinColumn(name = "customer_type_id", nullable = false, insertable = false, updatable = false)
    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }




    @ManyToOne
    @JoinColumn(name = "customer_status_id", nullable = false, insertable = false, updatable = false)
    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }



    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }


    public Customer(int customerId, int countryId, int customerStatusId, int customerTypeId, int stateProvinceId, String customerPhoneNumber, String customerFirstName, String customerLastName, String customerEmail, String customerCity, String customerStreetAddress, String customerZipcode) {
        this.customerId = customerId;
        this.countryId = countryId;
        this.customerStatusId = customerStatusId;
        this.customerTypeId = customerTypeId;
        this.stateProvinceId = stateProvinceId;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerEmail = customerEmail;
        this.customerCity = customerCity;
        this.customerStreetAddress = customerStreetAddress;
        this.customerZipcode = customerZipcode;
    }

    public Customer() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "country_id")
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "customer_status_id")
    public int getCustomerStatusId() {
        return customerStatusId;
    }

    public void setCustomerStatusId(int customerStatusId) {
        this.customerStatusId = customerStatusId;
    }


    @Basic
    @Column(name = "customer_type_id")
    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    @Basic
    @Column(name = "state_province_id")
    public int getStateProvinceId() {
        return stateProvinceId;
    }

    public void setStateProvinceId(int stateProvinceId) {
        this.stateProvinceId = stateProvinceId;
    }


    @Basic
    @Column(name = "customer_phone_number")
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    @Basic
    @Column(name = "customer_first_name")
    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    @Basic
    @Column(name = "customer_last_name")
    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    @Basic
    @Column(name = "customer_email")
    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Basic
    @Column(name = "customer_city")
    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    @Basic
    @Column(name = "customer_street_address")
    public String getCustomerStreetAddress() {
        return customerStreetAddress;
    }

    public void setCustomerStreetAddress(String customerStreetAddress) {
        this.customerStreetAddress = customerStreetAddress;
    }

    @Basic
    @Column(name = "customer_zipcode")
    public String getCustomerZipcode() {
        return customerZipcode;
    }

    public void setCustomerZipcode(String customerZipcode) {
        this.customerZipcode = customerZipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId &&
                countryId == customer.countryId &&
                customerStatusId == customer.customerStatusId &&
                customerTypeId == customer.customerTypeId &&
                stateProvinceId == customer.stateProvinceId &&
                Objects.equals(customerPhoneNumber, customer.customerPhoneNumber) &&
                Objects.equals(customerFirstName, customer.customerFirstName) &&
                Objects.equals(customerLastName, customer.customerLastName) &&
                Objects.equals(customerEmail, customer.customerEmail) &&
                Objects.equals(customerCity, customer.customerCity) &&
                Objects.equals(customerStreetAddress, customer.customerStreetAddress) &&
                Objects.equals(customerZipcode, customer.customerZipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, countryId, customerStatusId, customerTypeId, stateProvinceId, customerPhoneNumber, customerFirstName, customerLastName, customerEmail, customerCity, customerStreetAddress, customerZipcode);
    }




}
