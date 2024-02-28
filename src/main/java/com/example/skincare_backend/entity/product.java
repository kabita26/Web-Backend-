package com.example.skincare_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Skincare")

public class product {
    @Id
    @SequenceGenerator(name="product_seq_gen",sequenceName = "product_item_productId_seq",allocationSize = 1)
    @GeneratedValue(generator="fruit_item_seq_gen", strategy = GenerationType.SEQUENCE)

    private Integer id;

    @Column(name = "Name", nullable = false)
    private String itemName;

    @Column(name = "image")
    private String image;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "description", nullable = false, length = 1000)
    private String description;
}
