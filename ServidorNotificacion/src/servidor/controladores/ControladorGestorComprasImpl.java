package servidor.controladores;

import java.rmi.RemoteException;
import sop_corba.ControladorCompraIntPOA;
import sop_corba.ControladorCompraIntPackage.CompraDTO;
import servidor.Repositorios.CompraRepositoryInt;

/**
 *
 * @authors Cristian Collazos y Alejandro Muñoz
 */
public class ControladorGestorComprasImpl extends ControladorCompraIntPOA {

    private final CompraRepositoryInt objCancionesRepository;

    public ControladorGestorComprasImpl(CompraRepositoryInt objCancionesRepository) throws RemoteException {
        this.objCancionesRepository = objCancionesRepository;
    }

    @Override
    public boolean imprimirCompra(CompraDTO objCompra) {
        boolean bandera = false;
        if (this.objCancionesRepository.imprimirCompra(objCompra)) {
            bandera = true;
        }
        return bandera;
    }

}
