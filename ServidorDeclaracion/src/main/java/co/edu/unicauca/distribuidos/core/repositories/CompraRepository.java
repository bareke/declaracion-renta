package co.edu.unicauca.distribuidos.core.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.services.ClienteDeObjetos;
import java.util.Objects;
import sop_corba.ControladorCompraIntOperations;
import sop_corba.ControladorCompraIntPackage.CompraDTO;

/**
 *
 * @authors Cristian Collazos y Alejandro Muñoz
 */
@Service
public class CompraRepository {

    private ArrayList<CompraDTO> listaDeCompras;

    public CompraRepository() {
        this.listaDeCompras = new ArrayList<CompraDTO>();
        cargarCompras();
    }

    public List<CompraDTO> findAll() {
        System.out.println("Invocando a listar compras");
        return this.listaDeCompras;
    }

    public CompraDTO findById(Integer id) {
        System.out.println("Invocando a consultar una compra");
        CompraDTO objCompra = null;

        for (CompraDTO cliente : listaDeCompras) {
            if (cliente.id == id) {
                objCompra = cliente;
                break;
            }
        }

        return objCompra;
    }

    public CompraDTO save(CompraDTO cliente) {
        System.out.println("Invocando a almacenar compra");
        CompraDTO objCompra = null;
        if (this.listaDeCompras.add(cliente)) {
            objCompra = cliente;

            if (sumarCompras(objCompra.id) > 45000000) {
                System.out.println("Usuario " + objCompra.id + " supero el valor maximo de 45 millones");
                System.out.println();
                System.out.println("Enviando notificacion");

                ClienteDeObjetos clienteObjetos = new ClienteDeObjetos();
                ControladorCompraIntOperations servidorNotificacion = ClienteDeObjetos.obtenerReferenciaRemota();

                servidorNotificacion.imprimirCompra(objCompra);
            }

        }
        return objCompra;
    }

    public CompraDTO update(Integer id, CompraDTO cliente) {
        System.out.println("Invocando a actualizar una compra");
        CompraDTO objCompra = null;

        for (int i = 0; i < this.listaDeCompras.size(); i++) {
            if (this.listaDeCompras.get(i).id == id) {
                this.listaDeCompras.set(i, cliente);
                objCompra = cliente;
                break;
            }
        }

        return objCompra;
    }

    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar una compra");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeCompras.size(); i++) {
            if (this.listaDeCompras.get(i).id == id) {
                this.listaDeCompras.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    private void cargarCompras() {
        CompraDTO objCompra1 = new CompraDTO(1, "Cedula", 5000000, "CC Campanario", new Date().toString(), "Efectivo", "123");
        this.listaDeCompras.add(objCompra1);
        CompraDTO objCompra2 = new CompraDTO(2, "Extranjeria", 1800000, "Exito", new Date().toString(), "Tarjeta Credito", "456");
        this.listaDeCompras.add(objCompra2);
        CompraDTO objCompra3 = new CompraDTO(3, "Cedula", 30000000, "Olimpica", new Date().toString(), "Tarjeta Debito", "789");
        this.listaDeCompras.add(objCompra3);
    }

    private int sumarCompras(Integer id) {
        int valorTotal = 0;

        for (CompraDTO compra : listaDeCompras) {
            if (Objects.equals(compra.id, id)) {
                valorTotal += compra.valor;
            }
        }
        return valorTotal;
    }
}
