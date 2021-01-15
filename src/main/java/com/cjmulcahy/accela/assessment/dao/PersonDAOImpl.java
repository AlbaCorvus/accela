package com.cjmulcahy.accela.assessment.dao;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.type.LongType;
import org.springframework.stereotype.Repository;

import com.cjmulcahy.accela.assessment.domain.Person;

@Repository
public class PersonDAOImpl implements PersonDAO{

    @PersistenceUnit
    private EntityManagerFactory entitymanagerFactory;
    
    @Override
    public void insert(Person person) {
        EntityManager entityManager = entitymanagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(person);
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = entitymanagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.createQuery("DELETE FROM "+Person.class.getSimpleName()+" WHERE id = :id").setParameter("id", id).executeUpdate();
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public void update(Person person) {
        EntityManager entityManager = entitymanagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(person);
        entityManager.flush();
        entityManager.clear();
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public void update(List<Person> persons) {
        EntityManager entityManager = entitymanagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Iterator<Person> people = persons.iterator();
        while(people.hasNext()){
            Person p = people.next();
            entityManager.merge(p);
            entityManager.flush();
            entityManager.clear();
        }
        entityTransaction.commit();
        entityManager.close();
    }

    @Override
    public int count() {
        EntityManager entityManager = entitymanagerFactory.createEntityManager();
        int count = ((BigInteger)entityManager.createNativeQuery("SELECT count(1) FROM "+Person.class.getSimpleName()).getSingleResult()).intValue();
        entityManager.close();
        return count;
    }

    @Override
    public List<Person> listPersons() {
        EntityManager entityManager = entitymanagerFactory.createEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> rootEntry = cq.from(Person.class);
        CriteriaQuery<Person> all = cq.select(rootEntry);
        TypedQuery<Person> allQuery = entityManager.createQuery(all);
        List<Person> people = allQuery.getResultList();
        entityManager.close();
        return people;
    }
    
    @Override
    public Person findPersonById(int id){
        EntityManager entityManager = entitymanagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Person person = entityManager.find(Person.class, id);
        entityTransaction.commit();
        entityManager.close();
        return person;
    }

}
