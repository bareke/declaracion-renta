package co.edu.unicauca.distribuidos.core.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.models.Compra;
import co.edu.unicauca.distribuidos.core.services.ClienteDeObjetos;
import sop_corba.ControladorCompraIntOperations;
import sop_corba.ControladorCompraIntPackage.CompraDTO;

@Service
public class CompraRepository {

    private ArrayList<Compra> listaDeCompras;

    public CompraRepository() {
        this.listaDeCompras = new ArrayList<Compra>();
        cargarCompras();
    }

    public List<Compra> findAll() {
        System.out.println("Invocando a listarcompras");
        return this.listaDeCompras;
    }

    public Compra findById(Integer id) {
        System.out.println("Invocando a consultar un compra");
        Compra objCompra = null;

        for (Compra cliente : listaDeCompras) {
            if (cliente.getId() == id) {
                objCompra = cliente;
                break;
            }
        }

        return objCompra;
    }

    public Compra save(Compra cliente) {
        System.out.println("Invocando a almacenar compra");
        Compra objCompra = null;
        if (this.listaDeCompras.add(cliente)) {
            objCompra = cliente;

            // Envia objeto a CORBA
            ClienteDeObjetos clienteObjetos = new ClienteDeObjetos();
            ControladorCompraIntOperations servidorNotificacion = ClienteDeObjetos.obtenerReferenciaRemota();

            CompraDTO objCompraNotificacion = new CompraDTO();
            objCompraNotificacion.id = objCompra.getId();
            objCompraNotificacion.tipo = objCompra.getTipo();
            objCompraNotificacion.valor = objCompra.getValor();
            objCompraNotificacion.lugar = objCompra.getLugar();
            objCompraNotificacion.fecha = objCompra.getFecha().toString();
            objCompraNotificacion.medioPago = objCompra.getMedioPago();
            objCompraNotificacion.nit = objCompra.getNit();

            servidorNotificacion.imprimirCompra(objCompraNotificacion);
        }

        return objCompra;
    }

    public Compra update(Integer id, Compra cliente) {
        System.out.println("Invocando a actualizar un compra");
        Compra objCompra = null;

        for (int i = 0; i < this.listaDeCompras.size(); i++) {
            if (this.listaDeCompras.get(i).getId() == id) {
                this.listaDeCompras.set(i, cliente);
                objCompra = cliente;
                break;
            }
        }

        return objCompra;
    }

    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar un compra");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeCompras.size(); i++) {
            if (this.listaDeCompras.get(i).getId() == id) {
                this.listaDeCompras.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    private void cargarCompras() {
        Compra objCompra1 = new Compra(1, "Cedula", 15000, "CC Campanario", new Date(), "Efectivo", "123");
        this.listaDeCompras.add(objCompra1);
        Compra objCompra2 = new Compra(2, "Extranjeria", 100000, "Exito", new Date(), "Tarjeta Credito", "456");
        this.listaDeCompras.add(objCompra2);
        Compra objCompra3 = new Compra(3, "Cedula", 380000, "Olimpica", new Date(), "Tarjeta Debito", "789");
        this.listaDeCompras.add(objCompra3);
    }

}
