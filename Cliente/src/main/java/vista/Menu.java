package vista;

import java.util.List;
import models.CompraDTO;
import servicios.CompraServices;
import utilidades.UtilidadesConsola;

/**
 *
 * @authors Cristian Collazos y Alejandro Muñoz
 */
public class Menu {

    private static CompraServices objCompraServices = new CompraServices();

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println();
            System.out.println("==Menu==");
            System.out.println("1. Registrar compra");
            System.out.println("2. Listar compras");
            System.out.println("3. Salir");

            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    Opcion1();
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

        CompraDTO objCompra = new CompraDTO();

        System.out.println("Documento identidad");
        objCompra.setId(UtilidadesConsola.leerEntero());

        System.out.println("Tipo documento identidad");
        objCompra.setTipo(UtilidadesConsola.leerCadena());

        System.out.println("Valor compra");
        objCompra.setValor(UtilidadesConsola.leerEntero());

        System.out.println("Lugar compra");
        objCompra.setLugar(UtilidadesConsola.leerCadena());

        System.out.println("Fecha compra");
        objCompra.setFecha(UtilidadesConsola.leerCadena());

        System.out.println("Medio pago");
        objCompra.setMedioPago(UtilidadesConsola.leerCadena());

        System.out.println("Nit empresa");
        objCompra.setNit(UtilidadesConsola.leerCadena());

        objCompra = objCompraServices.registrarCompra(objCompra);

        if (objCompra != null) {
            System.out.println("Registro realizado satisfactoriamente...");
        } else {
            System.out.println("no se pudo realizar el registro...");
        }
    }

    private static void Opcion2() {
        System.out.println("\n Listando compras");

        List<CompraDTO> listaDeCompras = objCompraServices.listarCompras();

        for (CompraDTO compra : listaDeCompras) {
            imprimirCompra(compra);
        }
    }

    private static void imprimirCompra(CompraDTO objCompra) {
        System.out.println();
        System.out.println(objCompra.getId());
        System.out.println(objCompra.getTipo());
        System.out.println(objCompra.getValor());
        System.out.println(objCompra.getLugar());
        System.out.println(objCompra.getFecha());
        System.out.println(objCompra.getMedioPago());
    }

}
