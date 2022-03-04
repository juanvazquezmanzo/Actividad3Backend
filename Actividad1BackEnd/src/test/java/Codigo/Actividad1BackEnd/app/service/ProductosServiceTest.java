package Codigo.Actividad1BackEnd.app.service;

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
import Codigo.Actividad1BackEnd.app.repository.ProductosRepository;


@SpringBootTest
class ProductosServiceTest {
	
	@Mock
	private  ProductosRepository productosRepository;
	
	@InjectMocks 
	private ProductosService productosService;
	
	private ACPRODUC producto;
	private List<ACPRODUC>listaProductos;

	@BeforeEach
	void setUp() throws Exception {
		listaProductos=new ArrayList<ACPRODUC>();
		producto=new ACPRODUC(1000, 0, "TEST", 0.0);
		listaProductos.add(producto);
	}


	@Test
	void testGetProductos() {
		when(productosRepository.findAll()).thenReturn(listaProductos);
		assertNotNull(productosRepository.findAll());
	}

	@Test
	void testInsertarProducto() {
		when(productosRepository.save(producto)).thenReturn(producto);
		assertNotNull(productosRepository.save(producto));
	}

}
