package ec.edu.ups.ppw63.demo63.business;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.demo63.dao.ClienteDAO;
import ec.edu.ups.ppw63.demo63.dao.FacturaDAO;
import ec.edu.ups.ppw63.demo63.model.Cliente;
import ec.edu.ups.ppw63.demo63.model.DetalleFactura;
import ec.edu.ups.ppw63.demo63.model.Factura;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	private ClienteDAO clienteDAO;
	
	@Inject
	private FacturaDAO facturaDAO;
	
	@PostConstruct
	public void init() {
		System.out.println("Iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setDni("0106458862");
		cliente.setDireccion("Pasacalle y Yaupi");
		cliente.setNombre("Henry Tacuri");
		
		clienteDAO.insert(cliente); 
		
		cliente = new Cliente();
		cliente.setCodigo(2);
		cliente.setDni("7987897");
		cliente.setDireccion("Calle Vieja");
		cliente.setNombre("Santiago Tacuri");
		
		clienteDAO.insert(cliente); 
		
		Factura factura = new Factura();
		factura.setCliente(cliente);
		factura.setNumero("001-001-0000001");
		factura.setFechaEmision(new Date());
		factura.setTotal(1000.52);
		
		
		
		DetalleFactura det = new DetalleFactura();
		det.setNombre("TV");
		det.setCantidad(2);
		det.setPrecio(10.50);
		
		factura.addDetalle(det);
		
		det = new DetalleFactura();
		det.setNombre("Cocina");
		det.setCantidad(1);
		det.setPrecio(150.50);
		
		factura.addDetalle(det);
		
		facturaDAO.insert(factura);
		
		/*List<Cliente> list = clienteDAO.getAll();
		for(Cliente cli: list) {
			System.out.println(cli.getCodigo() + "\t" + cli.getNombre());
		}*/ 
		
		/*List<Factura> list2 = facturaDAO.getAll();
		for(Factura fact: list2) {
			System.out.println(fact.getCodigo() + "\t" + fact.getCliente().getNombre());
		}*/ 
		
		System.out.println("\n------------- Facturas2");
		List<Factura> list2 = facturaDAO.getAll();
		for(Factura fact: list2) {
			System.out.println(fact);
		}
		
	}
	
}







