package com.innova.spring.advancedspring.customer.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "musteri")
public class Customer {
    // customerId -> customer_id -> customer-id -> CustomerId
    @Id
    @GeneratedValue
    private Long                customerId;
    @Column(name = "cuid", nullable = false, unique = true)
    @NotEmpty
    private String              customerUid;
    private String              name;
    private String              surname;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CustomerCredentials customerCredentials;
    @Embedded
    private CustomerDetails     customerDetails;
    private LocalDateTime       creationDate;
    private LocalDateTime       updateDate;
    @Enumerated(EnumType.STRING)
    private ECustomerStatus     customerStatus = ECustomerStatus.ACTIVE;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Phone>          phones;

//    @Version
//    private Long versionId;

    @PrePersist
    public void persist() {
        creationDate = LocalDateTime.now();
    }

    @PreUpdate
    public void update() {
        updateDate = LocalDateTime.now();
    }

}
