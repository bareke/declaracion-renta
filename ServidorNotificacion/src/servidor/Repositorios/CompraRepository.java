package servidor.Repositorios;

import sop_corba.ControladorCompraIntPackage.CompraDTO;

public class CompraRepository implements CompraRepositoryInt {

    public CompraRepository() {
    }

    @Override
    public boolean imprimirCompra(CompraDTO objCompra) {

        System.out.println("Archivo creado en el servidor");
        System.out.println("id: " + objCompra.id);
        System.out.println("Valor de la compra: " + objCompra.valor);
        System.out.println("Lugar: " + objCompra.lugar);
        System.out.println("Medio de pago: " + objCompra.medioPago);
        System.out.println("Fecha: " + objCompra.fecha);

        return true;
    }

}
