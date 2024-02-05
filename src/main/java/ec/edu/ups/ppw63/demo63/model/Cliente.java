package ec.edu.ups.ppw63.demo63.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "CLIENTES" )
public class Cliente {
	
	@Id
	@Column(name = "CODIGO", unique = true, nullable= false, precision = 5, scale = 0)
	private int codigo;
	
	@Column(name = "DNI", unique = true, nullable= false, length=15)
	private String dni;
	
	@Column(name = "NOMBRE", unique = false, nullable= false, length=200)
	private String nombre;
	
	@Column(name = "DIRECCION", unique = false, nullable= false, length=200)
	private String direccion;
	
	/*@OneToMany
	@JoinColumn(name = "ID_CLIENTE")
	public List<EncabezadoFactura> encabezadoFacturas;*/
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	/*public List<EncabezadoFactura> getEncabezadoFacturas() {
		return encabezadoFacturas;
	}
	
	public void setEncabezadoFacturas(List<EncabezadoFactura> encabezadoFacturas) {
		this.encabezadoFacturas = encabezadoFacturas;
	}*/
	
}
