package com.packt.quarkus.chapter5;

import javax.persistence.SequenceGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Cacheable
@Entity
@NamedQuery(name = "Customers.findAll",
<<<<<<< HEAD
        query = "SELECT c FROM Customer c ORDER BY c.id",
=======
        query = "SELECT c FROM Customer c ORDER BY c.name",
>>>>>>> fc099194d947fb486088b902a424566c9b9fa3a7
        hints = @QueryHint(name = "org.hibernate.cacheable", value = "true") )
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customerSequence",
            sequenceName = "customerId_seq",
            allocationSize = 1,
            initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSequence")
    private Long id;
    @Column(length = 40)
    private String name;
    @Column(length = 40)
    private String surname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

<<<<<<< HEAD
    @java.lang.Override
    public java.lang.String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", orders=" + orders +
                '}';
    }

=======
>>>>>>> fc099194d947fb486088b902a424566c9b9fa3a7
    @OneToMany(mappedBy = "customer")
    public List<Orders> orders;
}