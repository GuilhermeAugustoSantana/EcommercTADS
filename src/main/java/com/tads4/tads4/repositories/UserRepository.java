package com.tads4.tads4.repositories;

import com.tads4.tads4.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <Product, Long>{


}
