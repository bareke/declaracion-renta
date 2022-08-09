package co.edu.unicauca.distribuidos.core.services;

import co.edu.unicauca.distribuidos.core.utilidades.UtilidadesRegistroC;
import sop_corba.ControladorCompraIntOperations;

/**
 *
 * @authors Cristian Collazos y Alejandro Muñoz
 */
public class ClienteDeObjetos {

    private static ControladorCompraIntOperations objRemoto;

    public ClienteDeObjetos() {

        String[] vectorDatosLocalizarNS = new String[4];

        vectorDatosLocalizarNS[0] = "-ORBInitialHost";
        vectorDatosLocalizarNS[1] = "localhost";

        vectorDatosLocalizarNS[2] = "-ORBInitialPort";
        vectorDatosLocalizarNS[3] = "2020";

        objRemoto = UtilidadesRegistroC.obtenerObjRemoto(vectorDatosLocalizarNS, "idObjetoRemoto");
    }

    public static ControladorCompraIntOperations obtenerReferenciaRemota() {
        return objRemoto;
    }

}
