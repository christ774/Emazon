package com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.repository;


import com.pragma.Emazon.infrastructure.persistente.out.jpa.mysql.entity.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByName(String name);


}
