package Codigo.Actividad1BackEnd.app.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import Codigo.Actividad1BackEnd.app.model.ACPRODUC;
import Codigo.Actividad1BackEnd.util.FeignServiceUtil;

@SpringBootTest
class VentasControllerTest {

	@Mock private FeignServiceUtil feignServiceUtil;
	@InjectMocks private VentasController ventasController;
	private ACPRODUC producto;
	private List<ACPRODUC>listaProductos;
	private final String nombre="TEST";
	private final Integer id=0;
	private final Integer existencia=0;
	private final Double precio=0.0;
	@BeforeEach
	void setUp() throws Exception {
		listaProductos=new ArrayList<ACPRODUC>();
		producto=new ACPRODUC(id, existencia, nombre, precio);
		listaProductos.add(producto);
	}
	

	@Test
	void testGetProductos() {
		when(feignServiceUtil.getProductos()).thenReturn(listaProductos);
		assertNotNull(feignServiceUtil.getProductos());
	}

}
