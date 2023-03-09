package com.springboot.di.app;

import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.springboot.di.app.models.domain.ItemFactura;
import com.springboot.di.app.models.domain.Producto;
import com.springboot.di.app.models.service.InterfaceService;
import com.springboot.di.app.models.service.InterfaceServices;
import com.springboot.di.app.models.service.MiServicio;
import com.springboot.di.app.models.service.MiServicioComplejo;
import com.springboot.di.app.models.service.Servicios;

@Configuration
//Para poder crear los componentes esta clase tiene que estar dentro del paquete base de Spring, es decir en el MAIN
public class AppConfig {
	
	//Estos métodos crean componentes y retornan la instancia del objeto
	//@Bean permite registrar un método o una clase en Spring para poderla inyectar a un controlador
	@Bean("miServicioSimple")
	public InterfaceService registrarMiServicio() {
		return new MiServicio();
	}
	
	//Como punto importante aquí también se puede colcoar la Anotación @Primary para definir el componente por defecto
	@Bean("miServicioComplejo")
	public InterfaceService resgistrarServicioComplejo() {
		return new MiServicioComplejo();
	}
	
	//Este es el ejemplo de otra Interface de java
	@Bean("misServicios")
	public InterfaceServices registrarServicios() {
		return new Servicios();
	}
	
	//Importante, si se encuentran dos Beans que retornen el mismo tipo es necesario añadir la Anotación @Qualifier o @Primary
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems() {
		Producto producto = new Producto("Camara Sony", 100);
		Producto producto2 = new Producto("Camara Canon", 100);

		ItemFactura itemFactura = new ItemFactura(producto, 2);
		ItemFactura itemFactura2 = new ItemFactura(producto2, 4);
		return Arrays.asList(itemFactura, itemFactura2);
	}
	
	@Bean("itemsFacturaOficina")
	public List<ItemFactura> registrarItemsOficina() {
		Producto producto = new Producto("Monitor Samsung", 10000);
		Producto producto2 = new Producto("Monitor LG", 9000);
		Producto producto3 = new Producto("Notebook", 1000);

		ItemFactura itemFactura = new ItemFactura(producto, 5);
		ItemFactura itemFactura2 = new ItemFactura(producto2, 7);
		ItemFactura itemFactura3 = new ItemFactura(producto3, 11);
		return Arrays.asList(itemFactura, itemFactura2, itemFactura3);
	}
}
