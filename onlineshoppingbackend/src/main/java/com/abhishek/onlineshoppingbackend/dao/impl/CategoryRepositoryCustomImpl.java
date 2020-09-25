package com.abhishek.onlineshoppingbackend.dao.impl;

import com.abhishek.onlineshoppingbackend.dao.CategoryRepositoryCustom;
import com.abhishek.onlineshoppingbackend.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

@Repository
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    @Transactional
//    public int updateCategoryStatus(String name, Boolean activationValue) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaUpdate criteriaUpdate = cb.createCriteriaUpdate(Category.class);
//        Root<Category> categoryRoot = criteriaUpdate.from(Category.class);
//        criteriaUpdate.set("active", activationValue).where(cb.equal(categoryRoot.get("name"), name));
//
//
//        int updatedRows = entityManager.createQuery(criteriaUpdate).executeUpdate();
//        return updatedRows;
//    }
}
