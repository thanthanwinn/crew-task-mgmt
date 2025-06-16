package org.mdt.crewtaskmanagement.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;
import java.util.function.Function;

public class BaseRepositoryImpl<T,ID> extends SimpleJpaRepository<T,ID> implements BaseRepository<T,ID> {
    private final EntityManager entityManager;

    public BaseRepositoryImpl(JpaEntityInformation<T,?> entityInfo, EntityManager entityManager) {
        super(entityInfo, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public <R> List<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<R> cq = queryFunc.apply(cb);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    public <R> Page<R> search(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc,
                              Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc, int page, int size) {

        var countQuery = countFunc.apply(entityManager.getCriteriaBuilder());
        var count = entityManager.createQuery(countQuery).getSingleResult();

        var cq = queryFunc.apply(entityManager.getCriteriaBuilder());
        var query = entityManager.createQuery(cq);
        query.setFirstResult(page * size);
        query.setMaxResults(size);

        var list = query.getResultList();

        var pageInfo = PageRequest.of(page, size);

        return new PageImpl<R>(list, pageInfo, count);
    }

}
