package Codigo.Actividad1BackEnd.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Codigo.Actividad1BackEnd.app.model.ACPRODUC;
import Codigo.Actividad1BackEnd.util.FeignServiceUtil;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ventas")
public class VentasController {
	
	@Autowired
	private FeignServiceUtil feignServiceUtil;
	
	@ApiOperation(
			value = "Consultar Productos",
			notes="Trae un Arreglo de Productos"
				+ "haciendo uso de la libreria @FeignClient.")
	
	@GetMapping(path="/producto")
	public ResponseEntity<List<ACPRODUC>> getProductos(){
		return new ResponseEntity<>(feignServiceUtil.getProductos(),HttpStatus.OK);
	}
}
