package br.com.fiap.mm.controller;


import java.util.ArrayList;

import br.com.fiap.mm.model.entity.Paciente;

import br.com.fiap.mm.model.repository.PacienteRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.ext.Provider;

@Provider
@Path("/mm/paciente")
public class PacienteResource{
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response findAll() {
		ArrayList<Paciente> resposta = PacienteRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Paciente pac) {
		Paciente resposta = PacienteRepository.save(pac);
		

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
	public Response update(@Valid Paciente pac) {
		Paciente resposta = PacienteRepository.update(pac);
		
		ResponseBuilder response = null;
		
		if (resposta != null) {
			response = Response.created(null);
		} else {
			response = Response.status(400);
		}
		response.entity(resposta);
		return response.build();
		
	}

	
}
