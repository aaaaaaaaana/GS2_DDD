package br.com.fiap.mm.controller;


import java.util.ArrayList;

import br.com.fiap.mm.model.entity.Instituicao;
import br.com.fiap.mm.model.repository.InstituicaoRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.ext.Provider;

@Provider
@Path("/mm/instituicao")
public class InstituicaoResource{
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public Response findAll() {
		ArrayList<Instituicao> resposta = InstituicaoRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Instituicao inst) {
		Instituicao resposta = InstituicaoRepository.save(inst);
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
