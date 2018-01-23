package modelo;

public class Vehiculo {
	
	int id;
	String marca;
	String modelo;
	float precio;
	
	
	
	
	public Vehiculo() {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.precio = precio;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String mnarca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
