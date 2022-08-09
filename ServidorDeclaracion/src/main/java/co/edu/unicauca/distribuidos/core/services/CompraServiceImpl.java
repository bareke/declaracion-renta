package co.edu.unicauca.distribuidos.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.repositories.CompraRepository;
import sop_corba.ControladorCompraIntPackage.CompraDTO;

/**
 *
 * @authors Cristian Collazos y Alejandro Muñoz
 */
@Service
public class CompraServiceImpl implements ICompraService {

    @Autowired
    private CompraRepository servicioAccesoBaseDatos;

    @Override
    public List<CompraDTO> findAll() {
        return this.servicioAccesoBaseDatos.findAll();
    }

    @Override
    public CompraDTO findById(Integer id) {
        return this.servicioAccesoBaseDatos.findById(id);
    }

    @Override
    public CompraDTO save(CompraDTO cliente) {
        return this.servicioAccesoBaseDatos.save(cliente);
    }

    @Override
    public CompraDTO update(Integer id, CompraDTO cliente) {
        return this.servicioAccesoBaseDatos.update(id, cliente);
    }

    @Override
    public boolean delete(Integer id) {
        return this.servicioAccesoBaseDatos.delete(id);
    }
}
