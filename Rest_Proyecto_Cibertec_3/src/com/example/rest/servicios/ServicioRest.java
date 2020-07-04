package com.example.rest.servicios;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.dao.PaisModel;
import com.example.rest.entidades.Pais;


@Path("/servicios")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);
	private PaisModel daoPais = new PaisModel();


	@GET
	@Path("/login")
	public Response login(Usuario obj) {
		log.info("login rest ");
		return Response.ok(daoUser.login(obj)).build();
	}

	@GET
	@Path("/usuario")
	public Response listarUsuarioTodos() {
		log.info("listar usuario rest ");
		return Response.ok(daoUser.listarTodos()).build();
	}

	// Crud de Pais
	@GET
	@Path("/pais")
	public Response listarPaisTodos() {
		log.info("listars pais rest ");
		return Response.ok(daoPais.listarPaisTodos()).build();
	}

	@POST
	@Path("/pais")
	public Response registraPais(Pais obj) {
		log.info("Registra pais " + obj.getIdPais());
		if (daoPais.insertaPais(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Path("/pais")
	public Response atualizaPais(Pais obj) {
		log.info("Actualiza pais " + obj.getIdPais());
		if (daoPais.actualizaPais(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/pais/{idPais}")
	public Response eliminaPais(@PathParam("idPais") int id) {
		log.info("Elimina usuario " + id);
		if (daoPais.eliminaPais(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	
}