package br.com.fiap.mm.controller;


import java.util.ArrayList;

import br.com.fiap.mm.model.entity.AgendaConsulta;
import br.com.fiap.mm.model.repository.AgendaConsultaRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.ext.Provider;

@Provider
@Path("/mm/consultas")
public class AgendaConsultaResource{
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response findAll() {
		ArrayList<AgendaConsulta> resposta = AgendaConsultaRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid AgendaConsulta ac) {
		AgendaConsulta resposta = AgendaConsultaRepository.save(ac);
		ResponseBuilder response = null;
		
		if (resposta != null) {
			response = Response.created(null);
			
		} else {
			response = Response.status(400);
		}
		
		response.entity(resposta);
		return response.build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@Valid AgendaConsulta ac) {
		AgendaConsulta resposta = AgendaConsultaRepository.update(ac);
		
		ResponseBuilder response = null;
		
		if (resposta != null) {
			response = Response.created(null);
		} else {
			response = Response.status(400);
		}
		response.entity(resposta);
		return response.build();
		
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		if (AgendaConsultaRepository.delete(id)) {
			ResponseBuilder response = Response.noContent();
			return response.build();
		} else {
			ResponseBuilder response = Response.status(400);
			return response.build();
		}
	}
	


	
}
