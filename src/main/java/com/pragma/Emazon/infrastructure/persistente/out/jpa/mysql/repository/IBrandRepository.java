package com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.repository;


import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<BrandEntity, Long> {
    boolean existsByName(String name);
}
