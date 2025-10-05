package com.naveen.springboot.demo.springddonetomany.dao;

import com.naveen.springboot.demo.springddonetomany.entity.Instructor;
import com.naveen.springboot.demo.springddonetomany.entity.InstructorDetail;
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

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        InstructorDetail instructorDetail = mEntityManager.find(InstructorDetail.class, id);
        return instructorDetail;
    }

    @Override
    @Transactional
//    When
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = mEntityManager.find(InstructorDetail.class, id);
        if (instructorDetail != null) {
            mEntityManager.remove(instructorDetail);
        }
    }
}
