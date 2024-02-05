package ec.edu.ups.ppw63.demo63.services;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.demo63.business.GestionFacturas;
import ec.edu.ups.ppw63.demo63.dao.FacturaDAO;
import ec.edu.ups.ppw63.demo63.model.Factura;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("facturas")
public class FacturaServices {
	
	@Inject
	private GestionFacturas gFacturas;
	
	@Inject
	private FacturaDAO facturaDAO;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Factura factura) {
		try {
			factura.setFechaEmision(new Date());
			gFacturas.guardarFactura(factura);
			ErrorMessage error = new ErrorMessage(1, "Ok");
			return Response.status(Response.Status.CREATED)
					.entity(error).build();
		} catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getFacturas(){
		List<Factura> facturas = gFacturas.getFacturas();
		if(facturas.size()>0)
			return Response.ok(facturas).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran facturas");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
}

/*
	List<Factura> list2 = facturaDAO.getAll();
	for(Factura fact: list2) {
		System.out.println(fact);
	}
*/
