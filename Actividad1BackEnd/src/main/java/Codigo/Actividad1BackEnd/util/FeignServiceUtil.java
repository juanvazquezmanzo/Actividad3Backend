package Codigo.Actividad1BackEnd.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import Codigo.Actividad1BackEnd.app.model.ACPRODUC;

@FeignClient(value="feignVentas",url="http://localhost:8080")
public interface FeignServiceUtil {
	
	@GetMapping(path="/producto")
	List<ACPRODUC> getProductos();

}
