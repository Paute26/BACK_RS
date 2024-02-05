package ec.edu.ups.ppw63.demo63.services;

public class ErrorMessage {

	private int codigo;
	private String message;
	
	public ErrorMessage(int codigo, String message) {
		this.codigo = codigo;
		this.message = message;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
