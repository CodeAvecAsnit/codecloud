package com.org.orm.Dao;

import com.org.orm.entities.Shipper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ShipperDao {

    @PersistenceContext
    private EntityManager entityManager;


    public void Print(Shipper shipper) {
        System.out.println();
        System.out.println(shipper.toString());
    }

    @Transactional
    public void Save(Shipper shipper) {
        entityManager.persist(shipper);
    }

    @Transactional
    public void Update(Shipper shipper) {
        entityManager.merge(shipper);
    }

    @Transactional
    public Shipper Find(int ID){
        return entityManager.find(Shipper.class, ID);
    }

    @Transactional
    public void Delete(Shipper shipper) {
        entityManager.remove(shipper);
    }

    @Transactional
    public void deleteById(int id) {
        try {
            Shipper shipper = entityManager.find(Shipper.class, id);
            if (shipper != null) {
                entityManager.remove(shipper);
            }
        } catch (Exception e) {
            System.out.println( e.getMessage());

        }
    }


  }