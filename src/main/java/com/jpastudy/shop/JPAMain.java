package com.jpastudy.shop;

import com.jpastudy.shop.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpashop");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            Book book = new Book();
            book.setName("긴긴밤");
            book.setAuthor("루리");

            entityManager.persist(book);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }
}
