package co.edu.unicauca.distribuidos.core.services;

import java.util.List;
import sop_corba.ControladorCompraIntPackage.CompraDTO;

/**
 *
 * @authors Cristian Collazos y Alejandro Muñoz
 */
public interface ICompraService {

    public List<CompraDTO> findAll();

    public CompraDTO findById(Integer id);

    public CompraDTO save(CompraDTO cliente);

    public CompraDTO update(Integer id, CompraDTO cliente);

    public boolean delete(Integer id);
}
