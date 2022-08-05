

package co.edu.unicauca.distribuidos.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.models.Compra;
import co.edu.unicauca.distribuidos.core.repositories.CompraRepository;


@Service
public class CompraServiceImpl implements ICompraService {

	@Autowired
	private CompraRepository servicioAccesoBaseDatos;

	@Override
	public List<Compra> findAll() {		
		return this.servicioAccesoBaseDatos.findAll();
	}

	@Override
	public Compra findById(Integer id) {		
		return this.servicioAccesoBaseDatos.findById(id);
	}

	@Override
	public Compra save(Compra cliente) {		
		return this.servicioAccesoBaseDatos.save(cliente);
	}

	@Override
	public Compra update(Integer id, Compra cliente) {		
		return this.servicioAccesoBaseDatos.update(id, cliente);
	}

	@Override
	public boolean delete(Integer id) {
		return this.servicioAccesoBaseDatos.delete(id);		
	}
}
