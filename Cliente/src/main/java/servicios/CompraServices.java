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

import models.Compra;

public class CompraServices {

    private String endPoint;
    private Client objCompraPeticiones;

    public CompraServices() {
        this.endPoint = "http://localhost:4000/api/compras";
        this.objCompraPeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public Compra consultarCompra(Integer id) {
        Compra objCompra = null;

        WebTarget target = this.objCompraPeticiones.target(this.endPoint + "/" + id);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objCompra = objPeticion.get(Compra.class);

        return objCompra;
    }

    public List<Compra> listarCompras() {
        List<Compra> listaClientes = null;

        WebTarget target = this.objCompraPeticiones.target(this.endPoint);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);

        listaClientes = objPeticion.get(new GenericType<List<Compra>>() {
        });

        return listaClientes;
    }

    public Compra registrarCompra(Compra objCompraRegistar) {
        Compra objCompra = null;

        WebTarget target = this.objCompraPeticiones.target(this.endPoint);

        Entity<Compra> data = Entity.entity(objCompraRegistar, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objCompra = objPeticion.post(data, Compra.class);

        return objCompra;
    }

    public Compra actualizarCompra(Compra objClienteActualizar, Integer id) {
        Compra objCompra = null;

        WebTarget target = this.objCompraPeticiones.target(this.endPoint + "/" + id);

        Entity<Compra> data = Entity.entity(objClienteActualizar, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objCompra = objPeticion.put(data, Compra.class);

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
