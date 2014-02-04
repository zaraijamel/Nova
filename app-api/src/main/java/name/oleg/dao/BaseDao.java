package name.oleg.dao;

import name.oleg.entity.Entity;

import java.util.List;


public interface BaseDao<T extends Entity> {

    public List<T> loadAll();

    public T load(long id);

    public void update(T entity);

    public void save(T entity);

    public void delete(T entity);
}
