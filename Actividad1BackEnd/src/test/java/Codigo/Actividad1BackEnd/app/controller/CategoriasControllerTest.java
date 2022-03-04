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

import Codigo.Actividad1BackEnd.app.model.ACCATEGO;
import Codigo.Actividad1BackEnd.app.service.CategoriasService;

@SpringBootTest
class CategoriasControllerTest {
	@Mock private  CategoriasService categoriasService;
	@InjectMocks private CategoriasController categoriasController;
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
	void testGetCategorias() {
		when(categoriasService.getCategorias()).thenReturn(listacategorias);
		assertNotNull(categoriasService.getCategorias());
	}
	@Test
	void testGetCategoriaById() {
		when(categoriasService.buscarCategoriaById(id)).thenReturn(categoria);
		assertNotNull(categoriasService.getCategorias());
	}
	@Test
	void testCrearCategoria() {
		when(categoriasService.insertarCategoria(nombre)).thenReturn(categoria);
		assertNotNull(categoriasService.getCategorias());
	}
	@Test
	void testActualizarCategoria() {
		when(categoriasService.putCategoria(id,nombre)).thenReturn(categoria);
		assertNotNull(categoriasService.putCategoria(id,nombre));
	}
	@Test
	void testBorrarCategoria() {
		when(categoriasService.deleteCategoria(id)).thenReturn("{}");
		assertNotNull(categoriasService.deleteCategoria(id));
	}

}
