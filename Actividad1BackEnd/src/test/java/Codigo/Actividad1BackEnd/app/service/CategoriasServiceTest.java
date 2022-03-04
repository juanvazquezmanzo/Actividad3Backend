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

import Codigo.Actividad1BackEnd.app.model.ACCATEGO;
import Codigo.Actividad1BackEnd.app.repository.CategoriasRepository;

@SpringBootTest
class CategoriasServiceTest {
	
	@Mock
	private  CategoriasRepository categoriasRepository;
	
	@InjectMocks 
	private CategoriasService categoriasService;
	
	private ACCATEGO categoria;
	private List<ACCATEGO>listacategorias;

	@BeforeEach
	void setUp() throws Exception {
		listacategorias=new ArrayList<ACCATEGO>();
		categoria=new ACCATEGO("Test");
		categoria.setCAT_Id(100);
		listacategorias.add(categoria);
	}

	@Test
	void testCategoriasServiceTest() {
		when(categoriasRepository.findAll()).thenReturn(listacategorias);
		assertNotNull(categoriasRepository.findAll());
	}

}
