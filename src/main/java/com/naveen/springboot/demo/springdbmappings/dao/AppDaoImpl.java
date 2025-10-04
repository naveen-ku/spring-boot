package com.naveen.springboot.demo.springdbmappings.dao;

import com.naveen.springboot.demo.springdbmappings.entity.Instructor;
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
    public void saveInstructor(Instructor instructor) {
        mEntityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return mEntityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = mEntityManager.find(Instructor.class, id);
        if (instructor != null) {
            mEntityManager.remove(instructor);
        }
    }
}
