package com.naveen.springboot.demo.manytotmany.dao;


import com.naveen.springboot.demo.manytotmany.entity.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDaoImpl implements AppDao {
    private EntityManager mEntityManager;


    @Autowired
    AppDaoImpl(EntityManager entityManager) {
        this.mEntityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveCourseWithStudent(Course course) {
        mEntityManager.persist(course);
    }
}
