package com.example.skincare_backend.repository;

import com.example.skincare_backend.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepo extends JpaRepository<product, Integer> {
}
