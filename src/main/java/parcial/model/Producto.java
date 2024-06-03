package parcial.model;


public class Producto {
	
	private int id;
	private String descripcion;
	private Float  precio;
	private String categoria;
	private String proveedor;
	private Integer cantidad;
	
	public Producto(int id, String descripcion, Float precio, String categoria, String proveedor,
			Integer cantidad) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
	}
	
	public Producto() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float  precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + ", categoria=" + categoria
				+ ", proveedor=" + proveedor + ", cantidad=" + cantidad + "]";
	}
	
	
}
