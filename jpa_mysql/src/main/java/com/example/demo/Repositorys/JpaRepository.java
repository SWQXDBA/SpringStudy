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
public class JpaRepository implements UserRepository {
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

    public Long findAllCount() {
        String jpql = "select count(id) from User order by id desc";
        Query query = em.createQuery(jpql);
        Long i = (Long) query.getSingleResult();
        return i;
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
