package com.naveen.springboot.demo.springddonetomany.dao;

import com.naveen.springboot.demo.springddonetomany.entity.Course;
import com.naveen.springboot.demo.springddonetomany.entity.Instructor;
import com.naveen.springboot.demo.springddonetomany.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
            List<Course> courses = instructor.getCourses();
            // get the course since it is linked to instructor table
            // Break association of all courses for the instructor
            // We remove specifically because we are not using cascading remove in this table
            // So, spring will not automatically handle remove operation of deleting all data where
            // instructor id is used as foreign key
            for (Course tempCourse : courses) {
                tempCourse.setInstructor(null);
            }

            System.out.println("Instructor present and deleting...");
            mEntityManager.remove(instructor);
        }
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        mEntityManager.merge(instructor);
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

        // Since, cascading All is used, on deleting it
        // Instructor will also be deleted
        if (instructorDetail != null) {
            System.out.println("InstructorDetail present and deleting...");
            System.out.println("Delete associations of instructor from courses");
            Instructor instructor = instructorDetail.getInstructor();
            List<Course> courses = instructor.getCourses();
            for (Course tempCourse : courses) {
                tempCourse.setInstructor(null);
            }

            mEntityManager.remove(instructorDetail);
        }
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = mEntityManager.createQuery("from Course where instructor.id=:data", Course.class);
        query.setParameter("data", id);

        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetchCourses(int id) {
        TypedQuery<Instructor> query = mEntityManager.createQuery(
                "select i from Instructor i "
                        + "JOIN FETCH i.courses "
                        + "JOIN FETCH i.instructorDetail "
                        + "WHERE i.id = :data"
                , Instructor.class);
        query.setParameter("data", id);

        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void updateCourse(Course tempCourse) {
        mEntityManager.merge(tempCourse);

    }

    @Override
    public Course findCourseById(int id) {
        return mEntityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = mEntityManager.find(Course.class, id);
        if (course != null) {
            System.out.println("Course present and deleting...");
            mEntityManager.remove(course);
        }
    }

    @Override
    @Transactional
    public void addCourseToExistingInstructor(int id) {
        Instructor instructor = mEntityManager.find(Instructor.class, id);
        if (instructor != null) {
            Course course1 = new Course("Course - 2");
            Course course2 = new Course("Course - 3");

            instructor.add(course1);
            instructor.add(course2);

            mEntityManager.merge(instructor);
        }
    }
}
