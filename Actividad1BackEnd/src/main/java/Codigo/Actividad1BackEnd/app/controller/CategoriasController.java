package Codigo.Actividad1BackEnd.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Codigo.Actividad1BackEnd.app.model.ACCATEGO;
import Codigo.Actividad1BackEnd.app.service.CategoriasService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path="/categorias")
public class CategoriasController {
	private final CategoriasService categoriasService;
	@Autowired
	public CategoriasController(CategoriasService categoriasService) {
		this.categoriasService=categoriasService;
	}
	
	@ApiOperation(
			value = "Consultar Categorias Registradas",
			notes="Trae una Arreglo de objetos JSON de las categorias registradas en la Base de Datos")
	@GetMapping
	public ResponseEntity<List<ACCATEGO>> getCategorias() {
		List<ACCATEGO>listaProductos=categoriasService.getCategorias();
		return new ResponseEntity<>(listaProductos,HttpStatus.OK);
	}
	

	@ApiOperation(
			value = "Registrar Categoria",
			notes="Registra une nueva Categoria en la Base de Datos,unicamente pide el parametro name para su registro")
	@PostMapping
	public ResponseEntity<ACCATEGO> crearCategoria(@RequestParam("nombre") String nombre) {
		return new ResponseEntity<>(categoriasService.insertarCategoria(nombre),HttpStatus.CREATED);
	}
	
	@ApiOperation(
			value = "Actualizar Categoria",
			notes="Actualiza la categoria, en este especifico caso unicamente se cambia el nombre. Requiere el id de la categoria")
	@PutMapping(path="/{id}")
	public ResponseEntity<ACCATEGO> actualizarCategoria(
			@PathVariable("id") Integer id,
			@RequestParam("nombre") String nombre
			){
		return new ResponseEntity<>(categoriasService.putCategoria(id,nombre),HttpStatus.OK);
	}
	
	@ApiOperation(
			value = "Eliminar Categoria",
			notes="Elimina la categoria de la Base de Datos con el id ingresado")
	@DeleteMapping(path="/{id}")
		public ResponseEntity<String> borrarCategoria(
				@PathVariable("id") Integer id){
		categoriasService.deleteCategoria(id);
			return new ResponseEntity<>("{}",HttpStatus.OK);
		}
	
}
