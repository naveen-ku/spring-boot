package com.naveen.springboot.demo.manytotmany.dao;


import com.naveen.springboot.demo.manytotmany.entity.Course;
import com.naveen.springboot.demo.manytotmany.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    @Override
    public Course findCourseAndStudentByCourseId(int id) {
        TypedQuery<Course> query = mEntityManager.createQuery(
                "select c from Course c " +
                        "JOIN FETCH c.students " +
                        "where c.id = :data", Course.class
        );

        query.setParameter("data", id);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Student findStudentAndCourseByStudentId(int id) {
        TypedQuery<Student> query = mEntityManager.createQuery(
                "select s from Student s " +
                        "JOIN FETCH s.courses " +
                        "where s.id = :data", Student.class
        );

        query.setParameter("data", id);
        Student student = query.getSingleResult();
        return student;
    }
}
