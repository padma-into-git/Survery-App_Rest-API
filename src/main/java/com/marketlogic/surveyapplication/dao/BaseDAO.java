package com.marketlogic.surveyapplication.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.marketlogic.surveyapplication.conf.AppConfig;

public class BaseDAO {
	AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(AppConfig.class);
    EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
	
    public void persistEntity(Object obj) {
	      EntityManager em = emf.createEntityManager();
	      em.getTransaction().begin();
	      em.persist(obj);
	      em.getTransaction().commit();
	      em.close();
	  }
	
	 public void mergeEntity(Object obj) {
	      EntityManager em = emf.createEntityManager();
	      em.getTransaction().begin();
	      em.merge(obj);
	      em.getTransaction().commit();
	      em.close();
	  } 
	
	  public void nativeQuery(String s) {
	      EntityManager em = emf.createEntityManager();
	      Query query = em.createNativeQuery(s);
	      List list = query.getResultList();
	      for (Object o : list) {
	          if (o instanceof Object[]) {
	              System.out.println(Arrays.toString((Object[]) o));
	          } else {
	              System.out.println(o);
	          }
	      }
	      em.close();
	  }

	  public <T> List<T> findAll(Class<T> T) {
		  EntityManager em = emf.createEntityManager();
		  CriteriaBuilder cb = em.getCriteriaBuilder();
		  CriteriaQuery<T> cq = cb.createQuery(T);
	      Root<T> rootEntry = cq.from(T);
	      CriteriaQuery<T> all = cq.select(rootEntry);
	      TypedQuery<?> allQuery = em.createQuery(all);
	      return (List<T>) allQuery.getResultList();
	}
	  public <T> T findById(Class<T> T, Integer id) {
		  EntityManager em = emf.createEntityManager();
		  return em.find(T, id);
		 
	}

	  public <T> CriteriaQuery getCriteria(Class<T> T) {
		  EntityManager em = emf.createEntityManager();
		  CriteriaBuilder builder = em.getCriteriaBuilder();
		  CriteriaQuery<T> criteria = builder.createQuery(T);
	      Root<T> rootEntry = criteria.from(T);
	      CriteriaQuery<T> criteriaQuery = criteria.select(rootEntry);
	    //  TypedQuery<?> allQuery = em.createQuery(all);
	      return criteriaQuery;
	}
}
