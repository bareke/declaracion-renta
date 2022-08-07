
package co.edu.unicauca.distribuidos.core.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.distribuidos.core.models.Compra;
import co.edu.unicauca.distribuidos.core.services.ICompraService;

@RestController
@RequestMapping("/api")
public class ClienteRestController {

	@Autowired
	private ICompraService compraService;

	@GetMapping("/compras")
	public List<Compra> index() {
		return compraService.findAll();
	}

	@GetMapping("/compras/{id}")
	public Compra show(@PathVariable Integer id) {
		Compra objCliente = null;
		objCliente = compraService.findById(id);
		return objCliente;
	}

	@GetMapping("compras2/{name}/{age}")
	public String getMessage(@PathVariable("name") String name, @PathVariable("age") String edad) {
		String msg = String.format("%s es %s años viejo", name, edad);
		System.out.println(msg);
		return msg;
	}

	@GetMapping("consultarCompras")
	public String getMessageParametros(@RequestParam String nombres,
			@RequestParam String apellidos,
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fecha) {
		String msg = String.format("buscando un cliente por nombre: %s, apellidos: %s fecha %s", nombres, apellidos,
				fecha);
		System.out.println(msg);
		return msg;
	}

	@PostMapping("/compras")
	public Compra create(@RequestBody Compra cliente) {
		Compra objCliente = null;
		objCliente = compraService.save(cliente);
		return objCliente;
	}

	@PutMapping("/compras/{id}")
	public Compra update(@RequestBody Compra cliente, @PathVariable Integer id) {
		Compra objCliente = null;
		Compra clienteActual = compraService.findById(id);
		if (clienteActual != null) {
			objCliente = compraService.update(id, cliente);
		}
		return objCliente;
	}

	@DeleteMapping("/compras/{id}")
	public Boolean delete(@PathVariable Integer id) {
		Boolean bandera = false;
		Compra clienteActual = compraService.findById(id);
		if (clienteActual != null) {
			bandera = compraService.delete(id);
		}
		return bandera;

	}

	@GetMapping("/compras/listarCabeceras")
	public void listarCabeceras(@RequestHeader Map<String, String> headers) {
		System.out.println("cabeceras");
		headers.forEach((key, value) -> {
			System.out.println(String.format("Cabecera '%s' = %s", key, value));
		});
	}

}
