package edu.uh.tech.cis3368.testingnancy.testingnancy.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "state_province", schema = "dbo", catalog = "Complete_DB_V_3")
public class StateProvince {
    private int stateProvinceId;
    private String stateName;
    private Set<Customer> customers;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stateProvince")
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        // customers.forEach(customer -> customer.setStateProvince(this));
        this.customers = customers;
    }

    public StateProvince() {
    }

    public StateProvince returnStateProv(StateProvince stateProvince){
        return stateProvince;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_province_id")
    public int getStateProvinceId() {
        return stateProvinceId;
    }

    public void setStateProvinceId(int stateProvinceId) {
        this.stateProvinceId = stateProvinceId;
    }

    @Basic
    @Column(name = "state_name")
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateProvince that = (StateProvince) o;
        return stateProvinceId == that.stateProvinceId &&
                Objects.equals(stateName, that.stateName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stateProvinceId, stateName);
    }


}
