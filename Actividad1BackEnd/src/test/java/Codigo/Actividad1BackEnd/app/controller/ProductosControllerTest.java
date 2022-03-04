package Codigo.Actividad1BackEnd.app.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import Codigo.Actividad1BackEnd.app.model.ACPRODUC;
import Codigo.Actividad1BackEnd.app.service.ProductosService;

@SpringBootTest
class ProductosControllerTest {
	@Mock private  ProductosService productosService;
	@InjectMocks private ProductosController productosController;
	private ACPRODUC producto;
	private List<ACPRODUC>listaProductos;
	private final String nombre="TEST";
	private final Integer id=0;
	private final Integer existencia=0;
	private final Double precio=0.0;
	@BeforeEach
	void setUp() throws Exception {
		listaProductos=new ArrayList<ACPRODUC>();
		producto=new ACPRODUC(-1, 0, "TEST", 0.0);
		listaProductos.add(producto);
	}
	

	@Test
	void testGetProductos() {
		when(productosService.getProductos()).thenReturn(listaProductos);
		assertNotNull(productosService.getProductos());
	}

	@Test
	void testCrearProducto() {
		when(productosService.insertarProducto(nombre,precio,existencia)).thenReturn(producto);
		assertNotNull(productosService.insertarProducto(nombre,precio,existencia));
	}

	@Test
	void testGetCategoriaById() {
		when(productosService.buscarProductoById(id)).thenReturn(producto);
		assertNotNull(productosService.buscarProductoById(id));	}

	@Test
	void testActualizarProducto() {
		when(productosService.putProducto(id,nombre,precio,existencia)).thenReturn(producto);
		assertNotNull(productosService.putProducto(id,nombre,precio,existencia));
	}

	@Test
	void testPatchProducto() {
		when(productosService.patchProducto(id,nombre,precio,existencia)).thenReturn(producto);
		assertNotNull(productosService.patchProducto(id,nombre,precio,existencia));	
		}

	@Test
	void testBorrarProducto() {
		when(productosService.deleteProducto(id)).thenReturn("{}");
		assertNotNull(productosService.deleteProducto(id));
		}

}
