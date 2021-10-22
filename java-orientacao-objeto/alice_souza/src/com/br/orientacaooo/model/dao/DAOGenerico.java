package com.br.orientacaooo.model.dao;

import java.sql.SQLException;
import java.util.List;

public interface DAOGenerico<T> {

    void save(T t) throws SQLException;
    List<T> findAll() throws SQLException;
    void delete (int i) throws SQLException;
    void merge(T t) throws SQLException;
    T findById(int id) throws SQLException;

}
