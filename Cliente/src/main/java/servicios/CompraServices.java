package servicios;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

import models.CompraDTO;

/**
 *
 * @authors Cristian Collazos y Alejandro Muñoz
 */
public class CompraServices {

    private String endPoint;
    private Client objCompraPeticiones;

    public CompraServices() {
        this.endPoint = "http://localhost:4000/api/compras";
        this.objCompraPeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public CompraDTO consultarCompra(Integer id) {
        CompraDTO objCompra = null;

        WebTarget target = this.objCompraPeticiones.target(this.endPoint + "/" + id);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objCompra = objPeticion.get(CompraDTO.class);

        return objCompra;
    }

    public List<CompraDTO> listarCompras() {
        List<CompraDTO> listaClientes = null;

        WebTarget target = this.objCompraPeticiones.target(this.endPoint);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);

        listaClientes = objPeticion.get(new GenericType<List<CompraDTO>>() {
        });

        return listaClientes;
    }

    public CompraDTO registrarCompra(CompraDTO objCompraRegistar) {
        CompraDTO objCompra = null;

        WebTarget target = this.objCompraPeticiones.target(this.endPoint);

        Entity<CompraDTO> data = Entity.entity(objCompraRegistar, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objCompra = objPeticion.post(data, CompraDTO.class);

        return objCompra;
    }

    public CompraDTO actualizarCompra(CompraDTO objClienteActualizar, Integer id) {
        CompraDTO objCompra = null;

        WebTarget target = this.objCompraPeticiones.target(this.endPoint + "/" + id);

        Entity<CompraDTO> data = Entity.entity(objClienteActualizar, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objCompra = objPeticion.put(data, CompraDTO.class);

        return objCompra;
    }

    public Boolean eliminarCompra(Integer id) {
        Boolean bandera = false;

        WebTarget target = this.objCompraPeticiones.target(this.endPoint + "/" + id);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        bandera = objPeticion.delete(Boolean.class);

        return bandera;
    }
}
