package Codigo.Actividad1BackEnd.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Codigo.Actividad1BackEnd.app.model.ACPRODUC;
import Codigo.Actividad1BackEnd.app.service.ProductosService;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping(path="/producto")
public class ProductosController {
	private final ProductosService productosService;
	@Autowired
	public ProductosController(ProductosService productosService) {
		this.productosService=productosService;
	}
	
	@ApiOperation(
			value = "Traer Productos",
			notes="Retorna un Arreglo de objetos JSON de los productos registrados en la Base de Datos")
	@GetMapping
	public ResponseEntity<List<ACPRODUC>> getProductos() {
		List<ACPRODUC>listaProductos=productosService.getProductos();
		return new ResponseEntity<>(listaProductos,HttpStatus.OK);
	}
	
	@ApiOperation(
			value = "Registrar Producto",
			notes="Registra un nuevo Producto en la Base de datos")
	@PostMapping
	public ResponseEntity<ACPRODUC> crearProducto(
			@RequestParam("nombre") String nombre,
			@RequestParam("precio") Double precio,
			@RequestParam("existencias") Integer existencias) {
		return new ResponseEntity<>(productosService.insertarProducto(nombre,precio,existencias),HttpStatus.CREATED);
	}
	
	@ApiOperation(
			value = "Actualizar Producto",
			notes="Elimina el Producto de la Base de Datos por su ID")
	@PutMapping(path="/{id}")
	public ResponseEntity<ACPRODUC> actualizarProducto(
			@PathVariable("id") Integer id,
			@RequestParam("nombre") String nombre,
			@RequestParam("precio") Double precio,
			@RequestParam("existencias") Integer existencias
			){
		return new ResponseEntity<>(productosService.putProducto(id,nombre,precio,existencias),HttpStatus.OK);
	}
	
	@ApiOperation(
			value = "Actualizar Producto",
			notes="Actualiza unicamente la informacion ingresada del Producto por su ID en la Base de Datos")
	@PatchMapping(path="/{id}")
	public ResponseEntity<ACPRODUC> patchProducto(
			@PathVariable("id") Integer id,
			@RequestParam(required=false) String nombre,
			@RequestParam(required=false) Double precio,
			@RequestParam(required=false) Integer existencias
			){
		return new ResponseEntity<>(productosService.patchProducto(id,nombre,precio,existencias),HttpStatus.OK);
	}
	
	@ApiOperation(
			value = "Eliminar Producto",
			notes="Elimina el Producto de la Base de Datos con el id ingresado")
	@DeleteMapping(path="/{id}")
		public ResponseEntity<String> borrarProducto(
				@PathVariable("id") Integer id){
			productosService.deleteProducto(id);
			return new ResponseEntity<>("{}",HttpStatus.OK);
		}
		
	
	
}
