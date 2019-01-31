package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "customer_status", schema = "dbo", catalog = "Complete_DB_V_3")
public class CustomerStatus {
    private int customerStatusId;
    private String customerStatus;
    private Set<Customer> customers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerStatus")
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        //customers.forEach(customer -> customer.setCustomerStatus(this));
        this.customers = customers;
    }

    public CustomerStatus() {
    }
    public CustomerStatus returnCustStatus(CustomerStatus customerStatus)
    {return customerStatus;}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_status_id")
    public int getCustomerStatusId() {
        return customerStatusId;
    }

    public void setCustomerStatusId(int customerStatusId) {
        this.customerStatusId = customerStatusId;
    }

    @Basic
    @Column(name = "customer_status")
    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerStatus that = (CustomerStatus) o;
        return customerStatusId == that.customerStatusId &&
                Objects.equals(customerStatus, that.customerStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerStatusId, customerStatus);
    }


}
