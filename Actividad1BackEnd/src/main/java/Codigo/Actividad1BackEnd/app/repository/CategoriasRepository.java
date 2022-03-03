package Codigo.Actividad1BackEnd.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Codigo.Actividad1BackEnd.app.model.ACCATEGO;

@Repository
public interface CategoriasRepository extends JpaRepository<ACCATEGO, Integer> {

}
