package br.edu.ifsc.aluno.victor.model.dao;

import java.util.List;
import java.util.Optional;

public interface InterfaceDAO<T> {

    void create(T object);
    Optional<T> findById(Integer id);
    List<T> findAll();
    void update(T object);
    void delete(Integer id);
}
