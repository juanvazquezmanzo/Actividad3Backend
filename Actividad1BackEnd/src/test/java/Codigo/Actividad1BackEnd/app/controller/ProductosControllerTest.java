package Codigo.Actividad1BackEnd.app.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import Codigo.Actividad1BackEnd.app.model.ACPRODUC;
import Codigo.Actividad1BackEnd.app.service.ProductosService;

@WebMvcTest(ProductosController.class)
class ProductosControllerTest {
	@MockBean private  ProductosService productosService;
	@Autowired private MockMvc mockMvc;
	private ACPRODUC producto;
	private List<ACPRODUC>listaProductos;
	private final String nombre="TEST";
	private final Integer id=0;
	private final Integer existencia=0;
	private final Double precio=0.0;
	private MultiValueMap<String, String>parametros;
	@BeforeEach
	void setUp() throws Exception {
		listaProductos=new ArrayList<ACPRODUC>();
		producto=new ACPRODUC(-1, 0, "TEST", 0.0);
		listaProductos.add(producto);
		parametros = new LinkedMultiValueMap<>();
		parametros.add("nombre", nombre);
		parametros.add("precio", precio.toString());
		parametros.add("existencias", existencia.toString());

		
	}
	@Test
	void testGetProductos() throws Exception {
		when(productosService.getProductos()).thenReturn(listaProductos);
		mockMvc.perform(get("/producto"))
				.andExpect(status().isOk());
	}
	@Test
	void testCrearProducto() throws Exception {
		when(productosService.insertarProducto(nombre,precio,existencia)).thenReturn(producto);
		mockMvc.perform(post("/producto").params(parametros).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
	}
	@Test
	void testGetProductoById() throws Exception {
		when(productosService.buscarProductoById(id)).thenReturn(producto);
		mockMvc.perform(get("/producto/"+id)).andExpect(status().isOk());
	}
	@Test
	void testActualizarProducto() throws Exception {	
		when(productosService.putProducto(id,nombre,precio,existencia)).thenReturn(producto);
		mockMvc.perform(put("/producto/"+id).params(parametros).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	@Test
	void testPatchProducto() throws Exception {
		when(productosService.patchProducto(id,nombre,precio,existencia)).thenReturn(producto);
		mockMvc.perform(patch("/producto/"+id).params(parametros).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	@Test
	void testBorrarProducto() throws Exception {	
		when(productosService.deleteProducto(id)).thenReturn("{}");
		mockMvc.perform(delete("/producto/"+id))
				.andExpect(status().isOk());
		}

}
