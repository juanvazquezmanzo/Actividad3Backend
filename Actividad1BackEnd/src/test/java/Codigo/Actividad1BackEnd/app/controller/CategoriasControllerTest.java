package Codigo.Actividad1BackEnd.app.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import Codigo.Actividad1BackEnd.app.model.ACCATEGO;
import Codigo.Actividad1BackEnd.app.service.CategoriasService;
import Codigo.Actividad1BackEnd.app.service.ProductosService;

@WebMvcTest(CategoriasController.class)
class CategoriasControllerTest {
	@MockBean private  CategoriasService categoriasService;
	@Autowired private MockMvc mockMvc;
	private ACCATEGO categoria;
	private List<ACCATEGO>listacategorias;
	private final String nombre="TEST";
	private final Integer id=0;
	@BeforeEach
	void setUp() throws Exception {
		listacategorias=new ArrayList<ACCATEGO>();
		categoria=new ACCATEGO("Test");
		categoria.setCAT_Id(100);
		listacategorias.add(categoria);
	}
	@Test
	void testGetCategorias() throws Exception {
		when(categoriasService.getCategorias()).thenReturn(listacategorias);
		mockMvc.perform(get("/categoria"))
				.andExpect(status().isOk());
	}
	@Test
	void testGetCategoriaById() throws Exception {
		when(categoriasService.buscarCategoriaById(id)).thenReturn(categoria);
		mockMvc.perform(get("/categoria/"+id))
				.andExpect(status().isOk());
	}
	@Test
	void testCrearCategoria() throws Exception {
		when(categoriasService.insertarCategoria(nombre)).thenReturn(categoria);
		mockMvc.perform(post("/categoria").param("nombre",nombre).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());

	}
	@Test
	void testActualizarCategoria() throws Exception {
		when(categoriasService.putCategoria(id,nombre)).thenReturn(categoria);
		mockMvc.perform(put("/categoria/"+id).param("nombre",nombre).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	@Test
	void testBorrarCategoria() throws Exception {
		when(categoriasService.deleteCategoria(id)).thenReturn("{}");
		mockMvc.perform(get("/categoria/"+id))
				.andExpect(status().isOk());
	}

}
