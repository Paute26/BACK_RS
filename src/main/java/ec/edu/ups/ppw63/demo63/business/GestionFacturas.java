package ec.edu.ups.ppw63.demo63.business;

import java.util.List;

import ec.edu.ups.ppw63.demo63.dao.FacturaDAO;
import ec.edu.ups.ppw63.demo63.model.Factura;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionFacturas {

	@Inject
	private FacturaDAO daoFactura;
	
	public void guardarFactura(Factura factura) {
		Factura fact = daoFactura.read(factura.getCodigo());
		if(fact != null) {
			daoFactura.update(factura);
		} else {
			daoFactura.insert(factura); 
		}
	}
	
	public List<Factura> getFacturas() {
		List<Factura> list2 = daoFactura.getAll();
		for(Factura fact: list2) {
			System.out.println(fact);
		}
		return daoFactura.getAll();
	}
}
