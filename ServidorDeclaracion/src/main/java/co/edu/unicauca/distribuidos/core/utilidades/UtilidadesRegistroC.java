package co.edu.unicauca.distribuidos.core.utilidades;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import sop_corba.ControladorCompraInt;
import sop_corba.ControladorCompraIntHelper;

/**
 *
 * @authors Cristian Collazos y Alejandro Muñoz
 */
public class UtilidadesRegistroC {

    public static ControladorCompraInt obtenerObjRemoto(String[] vectorDatosNS, String idObjetoRemoto) {

        ControladorCompraInt ref = null;
        try {
            ORB orb = ORB.init(vectorDatosNS, null);

            // se obtiene un link al name service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // *** Resuelve la referencia del objeto en el N_S ***
            ref = ControladorCompraIntHelper.narrow(ncRef.resolve_str(idObjetoRemoto));
        } catch (Exception e) {
            System.out.println("Error al localizar el objeto remoto");
        }

        return ref;
    }

}
