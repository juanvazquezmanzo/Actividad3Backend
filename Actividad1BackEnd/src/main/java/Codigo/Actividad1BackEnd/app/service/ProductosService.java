package Codigo.Actividad1BackEnd.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Codigo.Actividad1BackEnd.app.model.ACPRODUC;
import Codigo.Actividad1BackEnd.app.repository.ProductosRepository;

@Service
public class ProductosService {
	private final ProductosRepository productosRepository;
	
	@Autowired
	public ProductosService(ProductosRepository acproducRepo) {
		this.productosRepository=acproducRepo;
	}
	
	public List<ACPRODUC>getProductos(){
		return productosRepository.findAll();
	}
	
	public ACPRODUC insertarProducto(String nombre,Double precio,Integer existencias) {
		ACPRODUC producto = new ACPRODUC(existencias, nombre, precio);
		return productosRepository.save(producto);
	}
	
	
	@Transactional
	public ACPRODUC putProducto(Integer id,String nombre,Double precio,Integer existencias) {
		ACPRODUC producto=productosRepository.findById(id).orElseThrow(()->new IllegalStateException("El Producto no existe"));
		if(nombre.length()>0 && (!producto.getPRO_Nombre().equals(nombre)) && precio>0 && existencias>=0){
			producto.setPRO_Nombre(nombre);
			producto.setPRO_Precio(precio);
			producto.setPRO_Existencias(existencias);
		}
		return producto;
	}
	
	
	@Transactional
	public ACPRODUC patchProducto(Integer id,String nombre,Double precio,Integer existencias) {
		ACPRODUC producto=productosRepository.findById(id).orElseThrow(()->new IllegalStateException("El Producto no existe"));
		if(nombre !=null && nombre.length()>0 && (!producto.getPRO_Nombre().equals(nombre)))
			producto.setPRO_Nombre(nombre);
		
		if(precio !=null && precio>0)
			producto.setPRO_Precio(precio);
		
		if(existencias!=null && existencias>=0)
			producto.setPRO_Existencias(existencias);
		
		return producto;
	}
	
	
	public void deleteProducto(Integer id) {
		if(productosRepository.existsById(id))
			productosRepository.deleteById(id);
	}
}
