package vista;

import java.util.List;
import models.Compra;
import servicios.CompraServices;
import utilidades.UtilidadesConsola;

public class Menu {

    private static CompraServices objCompraServices = new CompraServices();

//    public static void main(String[] args) {
//         System.out.println("consultando un compra con id 1");
//         Compra objCompraConsultado = objCompraServices.consultarCompra(1);
//         imprimirCompra(objCompraConsultado);
//
//         System.out.println("\n listando compras");
//         List<Compra> listaDeCompras = objCompraServices.listarCompras();
//         for (Compra compra : listaDeCompras) {
//             imprimirCompra(compra);
//         }
//         System.out.println("\n registrando un compra");
//         Compra objCompra = new Compra();
//         objCompra.setId(6);
//         objCompra.setTipo("Cedula");
//         objCompra.setValor(250000);
//         objCompra.setLugar("Esmeralda");
//         objCompra.setMedioPago("Tarjeta Credito");
//         objCompra.setNit("001");
//         objCompra.setCreateAt(new Date());
//         Compra objCompraRegistrado = objCompraServices.registrarCompra(objCompra);
//         System.out.println("\n listando compras que contiene el compra registrado");
//         List<Compra> listaDeCompras = objCompraServices.listarCompras();
//         for (Compra compra : listaDeCompras) {
//             imprimirCompra(compra);
//         }
//         System.out.println("\n actualizando un compra con id 1");
//         Compra objCompraActualizado = new Compra();
//         objCompraActualizado.setId(7);
//         objCompraActualizado.setTipo("Cedula");
//         objCompraActualizado.setValor(75000);
//         objCompraActualizado.setLugar("CC Terraplaza");
//         objCompraActualizado.setMedioPago("Efectivo");
//         objCompraActualizado.setNit("002");
//         objCompraActualizado.setCreateAt(new Date());
//         Compra objCompraAtualizado2 = objCompraServices.actualizarCompra(objCompraActualizado, 1);
//         imprimirCompra(objCompraAtualizado2);
//        System.out.println("\n eliminando una compra");
//        Boolean bandera = objCompraServices.eliminarCompra(1);
//
//        System.out.println("\n listando compras que contiene la compra eliminada");
//        List<Compra> listaDeCompras = objCompraServices.listarCompras();
//
//        for (Compra compra : listaDeCompras) {
//            imprimirCompra(compra);
//        }
//
//    }
    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("==Menu==");
            System.out.println("1. Registrar compra");
            System.out.println("2. Listar compras");
            System.out.println("3. Salir");

            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    // Opcion1();
                    break;
                case 2:
                    Opcion2();
                    break;
                case 3:
                    System.out.println("Salir...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 3);
    }

    private static void Opcion1() {
        System.out.println("\n Registrando compra");

        Compra objCompra = new Compra();
        objCompraServices.registrarCompra(objCompra);

        // if (valor) {
        //     System.out.println("Registro realizado satisfactoriamente...");
        // } else {
        //     System.out.println("no se pudo realizar el registro...");
        // }
    }

    private static void Opcion2() {
        System.out.println("\n Listando compras");

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
    }

}
