package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService{
	
	//RestTemplate template;
	ProductosDao productosDao;

	public ProductosServiceImpl(@Autowired ProductosDao productosDao) {
		super();
		this.productosDao = productosDao;
	}

	@Override
	public List<Producto> listaProductos() {
		return productosDao.findAll();
	}

	@Override
	public Producto actualizarStock(int codigoProducto, int unidades) {
		Producto producto = productosDao.findById(codigoProducto).orElse(null);
		if(producto != null) {
			producto.setStock(producto.getStock() - unidades);
			productosDao.save(producto);
			return producto;
		}else {
			return null;
		}
	}

	@Override
	public double precioProducto(int codigoProducto) {
		Producto producto = productosDao.findById(codigoProducto).orElse(null);
		if(producto != null){
			return producto.getPrecioUnitario();
		}else {
			return 0;
		}
	}

}
