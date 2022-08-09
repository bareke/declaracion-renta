package servidor.servicios;

import servidor.Repositorios.CompraRepository;
import servidor.controladores.ControladorGestorComprasImpl;

import servidor.utilidades.UtilidadesRegistroS;

/**
 *
 * @authors Cristian Collazos y Alejandro Muñoz
 */
public class ServidorDeObjetos {

    public static void main(String[] args) {

        try {

            String[] vectorDatosLocalizarNS = new String[4];//almacena la información para localizar el ns
            vectorDatosLocalizarNS[0] = "-ORBInitialHost";
            vectorDatosLocalizarNS[1] = "localhost";
            vectorDatosLocalizarNS[2] = "-ORBInitialPort";
            vectorDatosLocalizarNS[3] = "2020";

            CompraRepository objRepository = new CompraRepository();
            ControladorGestorComprasImpl objRemotoGestionCompras = new ControladorGestorComprasImpl(objRepository);

            UtilidadesRegistroS.registrarObjetoRemoto(vectorDatosLocalizarNS, objRemotoGestionCompras, "idObjetoRemoto");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }

    }

}
