package com.innova.spring.advancedspring.customer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Phone {
    @Id
    @GeneratedValue
    private Long     phoneId;
    @ManyToOne
    private Customer customer;
    private String   phoneName;
    private String   phoneNumber;

    public Phone() {
    }

    public Long getPhoneId() {
        return this.phoneId;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public String getPhoneName() {
        return this.phoneName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Phone)) {
            return false;
        }
        final Phone other = (Phone) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        final Object this$phoneId  = this.getPhoneId();
        final Object other$phoneId = other.getPhoneId();
        if (this$phoneId == null ? other$phoneId != null : !this$phoneId.equals(other$phoneId)) {
            return false;
        }
        final Object this$customer  = this.getCustomer();
        final Object other$customer = other.getCustomer();
        if (this$customer == null ? other$customer != null : !this$customer.equals(other$customer)) {
            return false;
        }
        final Object this$phoneName  = this.getPhoneName();
        final Object other$phoneName = other.getPhoneName();
        if (this$phoneName == null ? other$phoneName != null : !this$phoneName.equals(other$phoneName)) {
            return false;
        }
        final Object this$phoneNumber  = this.getPhoneNumber();
        final Object other$phoneNumber = other.getPhoneNumber();
        if (this$phoneNumber == null ? other$phoneNumber != null : !this$phoneNumber.equals(other$phoneNumber)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Phone;
    }

    public int hashCode() {
        final int    PRIME    = 59;
        int          result   = 1;
        final Object $phoneId = this.getPhoneId();
        result = result * PRIME + ($phoneId == null ? 43 : $phoneId.hashCode());
        final Object $phoneName = this.getPhoneName();
        result = result * PRIME + ($phoneName == null ? 43 : $phoneName.hashCode());
        final Object $phoneNumber = this.getPhoneNumber();
        result = result * PRIME + ($phoneNumber == null ? 43 : $phoneNumber.hashCode());
        return result;
    }

    public String toString() {
        return "Phone(phoneId="
               + this.getPhoneId()
               + ", customer="
               + this.getCustomer()
               + ", phoneName="
               + this.getPhoneName()
               + ", phoneNumber="
               + this.getPhoneNumber()
               + ")";
    }
}
