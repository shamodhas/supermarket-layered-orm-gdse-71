package lk.ijse.gdse.supermarket.dao;

import lk.ijse.gdse.supermarket.entity.SuperEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * --------------------------------------------
 * Author: Shamodha Sahan
 * GitHub: https://github.com/shamodhas
 * Website: https://shamodha.live
 * --------------------------------------------
 * Created: 2/26/2025 3:00 PM
 * Project: Supermarket-72
 * --------------------------------------------
 **/

public interface CrudDAO<T extends SuperEntity, ID> extends SuperDAO {
    public boolean save(T t);

    public boolean update(T t);

    public boolean deleteByPK(ID pk) throws Exception;

    public List<T> getAll();

    public Optional<T> findByPK(ID pk);

    public Optional<String> getLastPK();
}
