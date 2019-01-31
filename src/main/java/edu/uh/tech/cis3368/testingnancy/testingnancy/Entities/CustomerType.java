package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer_type", schema = "dbo", catalog = "Complete_DB_V_3")
public class CustomerType {
    private int customerTypeId;
    private String customerType;
    private Set<Customer> customers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerType")
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        // customers.forEach(customer -> customer.setCustomerType(this));
        this.customers = customers;
    }

    public CustomerType() {
    }
    public CustomerType returnCustType(CustomerType customerType){
        return customerType;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    @Basic
    @Column(name = "customer_type")
    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerType that = (CustomerType) o;
        return customerTypeId == that.customerTypeId &&
                Objects.equals(customerType, that.customerType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerTypeId, customerType);
    }


}
