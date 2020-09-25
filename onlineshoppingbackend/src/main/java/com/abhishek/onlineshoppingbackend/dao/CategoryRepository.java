package com.abhishek.onlineshoppingbackend.dao;

import com.abhishek.onlineshoppingbackend.model.Category;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryCustom {
    Category findByName(String name);

    List<Category> findByActive(boolean b);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Category c SET c.active= :active WHERE c.name= :name")
    int updateCategoryStatusAndRefreshCache(@Param("name") String name, @Param("active") Boolean active);

    @Transactional
    @Modifying
    @Query("UPDATE Category c SET c.active= :active WHERE c.name= :name")
    int updateCategoryStatus(@Param("name") String name, @Param("active") Boolean active);
}
