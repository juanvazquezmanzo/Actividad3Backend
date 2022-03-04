package Codigo.Actividad1BackEnd.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Codigo.Actividad1BackEnd.app.model.ACPRODUC;

@Repository
public interface ProductosRepository extends JpaRepository<ACPRODUC, Integer> {

	
	@Query(
			value="SELECT producto FROM ACPRODUC producto WHERE producto.PRO_Nombre like '%:#{nombre}:%'")
	public List<ACPRODUC> productosPorNombre(@Param("nombre") String nombre);
}
