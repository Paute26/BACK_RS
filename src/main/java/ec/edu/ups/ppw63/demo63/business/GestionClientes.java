package ec.edu.ups.ppw63.demo63.business;

import java.util.List;

import ec.edu.ups.ppw63.demo63.dao.ClienteDAO;
import ec.edu.ups.ppw63.demo63.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes {
	
	@Inject
	private ClienteDAO daoCliente;
	
	public void guardarClientes(Cliente cliente) {
		Cliente cli = daoCliente.read(cliente.getCodigo());
		if(cli != null) {
			daoCliente.update(cliente);
		} else {
			daoCliente.insert(cliente); 
		}
	}
	
	public void actualizarCliente(Cliente cliente) throws Exception {
		Cliente cli = daoCliente.read(cliente.getCodigo());
		if (cli != null){
			daoCliente.update(cliente);
		}else {
			throw new Exception("Cliente no existe");
		}
	}
	
	
	
	public Cliente getClientePorCedula(String cedula) throws Exception {
		if(cedula.length() != 10) 
			throw new Exception("Cedula Incorrecta");
		return daoCliente.getClientePorCedula(cedula);
	}
	
	public Cliente getClientePorId(int codigo) throws Exception {
		if(codigo < 0) 
			throw new Exception("Id Incorrecto");
		return daoCliente.getClientePorId(codigo);
	}
	
	public void borrarCliente(int codigo) {
		daoCliente.remove(codigo); 
	}
	
	public List<Cliente> getClientes() {
		return daoCliente.getAll();
	}

}
