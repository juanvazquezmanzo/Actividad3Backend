package Codigo.Actividad1BackEnd.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Codigo.Actividad1BackEnd.app.model.ACCATEGO;
import Codigo.Actividad1BackEnd.app.repository.CategoriasRepository;

@Service
public class CategoriasService {
	private final CategoriasRepository categoriasRepository;
	
	@Autowired
	public CategoriasService(CategoriasRepository categoriasRepository) {
		this.categoriasRepository=categoriasRepository;
	}
	
	public List<ACCATEGO>getCategorias(){
		return categoriasRepository.findAll();
	}
	
	public ACCATEGO insertarCategoria(String nombre) {
		ACCATEGO categoria=new ACCATEGO(nombre);
		return categoriasRepository.save(categoria);
	}
	//putCategoria
	@Transactional
	public ACCATEGO putCategoria(Integer id,String nombre) {
		ACCATEGO categoria=categoriasRepository.findById(id).orElseThrow(()->new IllegalStateException("LA CATEGORIA NO EXISTE"));
		if(nombre.length()>0 && (!categoria.getCAT_Nombre().equals(nombre)))
			categoria.setCAT_Nombre(nombre);
		return categoria;
	}
	
	public ACCATEGO buscarCategoriaById(Integer id) {
			return categoriasRepository.findById(id).orElse(null);
	}
	
	public void deleteCategoria(Integer id) {
		if(categoriasRepository.existsById(id))
			categoriasRepository.deleteById(id);
	}
	

}
