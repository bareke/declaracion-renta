

package co.edu.unicauca.distribuidos.core.services;

import java.util.List;

import co.edu.unicauca.distribuidos.core.models.Compra;

public interface ICompraService {

	public List<Compra> findAll();		
	public Compra findById(Integer id);	
	public Compra save(Compra cliente);	
	public Compra update(Integer id, Compra cliente);	
	public boolean delete(Integer id);	
}
