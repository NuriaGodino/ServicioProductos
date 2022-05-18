package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Producto;
import service.ProductosService;

@RestController
@CrossOrigin("*")
public class ProductoController {
	@Autowired
	ProductosService service;
	
	@GetMapping(value = "Productos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> totalProductos(){
		return service.listaProductos();
	}
	
	@PutMapping(value = "Producto/{codigoProducto}/{unidades}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Producto actualizarStock(@PathVariable("codigoProducto") Integer codigoProducto, @PathVariable("unidades") Integer unidades) {
		return service.actualizarStock(codigoProducto, unidades);
	}
	
	@GetMapping(value = "Producto/{codigoProducto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public double precio(@PathVariable("codigoProducto") Integer codigoProducto) {
		return service.precioProducto(codigoProducto);
	}
}
