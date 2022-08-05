package vista;

import java.util.Date;
import java.util.List;
import models.Compra;
import servicios.CompraServices;

public class Menu {

    public static void main(String[] args) {

        CompraServices objCompraServices = new CompraServices();

        // System.out.println("consultando un compra con id 1");
        // Compra objCompraConsultado = objCompraServices.consultarCompra(1);
        // imprimirCompra(objCompraConsultado);

        // System.out.println("\n listando compras");
        // List<Compra> listaDeCompras = objCompraServices.listarCompras();

        // for (Compra compra : listaDeCompras) {
        //     imprimirCompra(compra);
        // }

        // System.out.println("\n registrando un compra");
        // Compra objCompra = new Compra();
        // objCompra.setId(6);
        // objCompra.setTipo("Cedula");
        // objCompra.setValor(250000);
        // objCompra.setLugar("Esmeralda");
        // objCompra.setMedioPago("Tarjeta Credito");
        // objCompra.setNit("001");
        // objCompra.setCreateAt(new Date());
        // Compra objCompraRegistrado = objCompraServices.registrarCompra(objCompra);

        // System.out.println("\n listando compras que contiene el compra registrado");
        // List<Compra> listaDeCompras = objCompraServices.listarCompras();

        // for (Compra compra : listaDeCompras) {
        //     imprimirCompra(compra);
        // }

        // System.out.println("\n actualizando un compra con id 1");
        // Compra objCompraActualizado = new Compra();
        // objCompraActualizado.setId(7);
        // objCompraActualizado.setTipo("Cedula");
        // objCompraActualizado.setValor(75000);
        // objCompraActualizado.setLugar("CC Terraplaza");
        // objCompraActualizado.setMedioPago("Efectivo");
        // objCompraActualizado.setNit("002");
        // objCompraActualizado.setCreateAt(new Date());

        // Compra objCompraAtualizado2 = objCompraServices.actualizarCompra(objCompraActualizado, 1);
        // imprimirCompra(objCompraAtualizado2);

        System.out.println("\n eliminando un compra");
        Boolean bandera = objCompraServices.eliminarCompra(1);

        System.out.println("\n listando compras que contiene el compra eliminado");
        List<Compra> listaDeCompras = objCompraServices.listarCompras();

        for (Compra compra : listaDeCompras) {
            imprimirCompra(compra);
        }

    }

    private static void imprimirCompra(Compra objCompra) {
        System.out.println(objCompra.getId());
        System.out.println(objCompra.getTipo());
        System.out.println(objCompra.getValor());
        System.out.println(objCompra.getLugar());
        System.out.println(objCompra.getFecha());
        System.out.println(objCompra.getMedioPago());
        System.out.println(objCompra.getCreateAt());
    }

}
