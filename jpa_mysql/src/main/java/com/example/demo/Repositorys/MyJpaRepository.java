package com.example.demo.Repositorys;

import com.example.demo.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MyJpaRepository implements UserRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        String jpql = "from com.example.demo.models.User";
        Query query = em.createQuery(jpql);
        List<User> list = query.getResultList();
        return list;
    }

    public List<User> findAlldesc() {
        String jpql = "from User order by id desc";
        Query query = em.createQuery(jpql);
        List<User> list = query.getResultList();
        return list;
    }

    public List<User> findemail(String email) {
        String jpql = " from User where email like ?1";
        Query query = em.createQuery(jpql);
        query.setParameter(1, email);
        return query.getResultList();
    }

    public Long findAllCount() {
        String jpql = "select count(id) from User order by id desc";
        Query query = em.createQuery(jpql);
        Long i = (Long) query.getSingleResult();
        return i;
    }

    public List<User> findAllPage() {
        String jpql = " from User";
        Query query = em.createQuery(jpql);
        query.setFirstResult(0);
        //从1-2 不包括0
        query.setMaxResults(2);
        return query.getResultList();

    }

    @Override
    public void save(User n) {

        if (n.getId() == null) {
            em.persist(n);
        } else {
            em.merge(n);
        }
    }
}
