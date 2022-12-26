package com.kemalyuksel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_user_address" , allocationSize = 1)
    @GeneratedValue(generator = "seq_user_address",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500,name = "address")
    private String address;

    @Enumerated
    private AddressType addressType;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_address_id")
    private User user;
    enum AddressType{
        HOME,
        WORK,
        OTHER
    }

}
