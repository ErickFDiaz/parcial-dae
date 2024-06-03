package parcial.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import parcial.conexion.Conexion;
import parcial.model.Producto;

public class ProductoService {

	public int crearProducto(Producto producto) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psmt = null;

		try {
			cn = Conexion.getConnection();
			String query = "INSERT INTO producto (descripcion, precio, categoria, proveedor, cantidad) VALUES(?, ?, ?, ?, ?)";
			psmt = cn.prepareStatement(query);
			psmt.setString(1, producto.getDescripcion());
			psmt.setFloat(2, producto.getPrecio());
			psmt.setString(3, producto.getCategoria());
			psmt.setString(4, producto.getProveedor());
			psmt.setInt(5, producto.getCantidad());
			value = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (psmt != null)
					psmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return value;
	}

	public List<Producto> listarProducto() {
		List<Producto> productos = new ArrayList<>();
		Connection cn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			cn = Conexion.getConnection();
			String query = "SELECT * FROM producto order by id asc";
			psmt = cn.prepareStatement(query);
			rs = psmt.executeQuery();

			while (rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setDescripcion(rs.getString("descripcion"));

				producto.setPrecio(rs.getFloat("precio"));

				producto.setCategoria(rs.getString("categoria"));
				producto.setProveedor(rs.getString("proveedor"));
				producto.setCantidad(rs.getInt("cantidad"));
				productos.add(producto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (psmt != null)
					psmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return productos;
	}

	public Producto obtenerProducto(Integer id) {
		Producto producto = null;
		Connection cn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			cn = Conexion.getConnection();
			String query = "SELECT * FROM producto p WHERE p.id = ?";
			psmt = cn.prepareStatement(query);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();

			while (rs.next()) {
				producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setDescripcion(rs.getString("descripcion"));

				producto.setPrecio(rs.getFloat("precio"));

				producto.setCategoria(rs.getString("categoria"));
				producto.setProveedor(rs.getString("proveedor"));
				producto.setCantidad(rs.getInt("cantidad"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (psmt != null)
					psmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return producto;
	}

	public Integer editarProducto(Producto producto) {
		Integer value = 0;
		Connection cn = null;
		PreparedStatement psmt = null;

		try {
			cn = Conexion.getConnection();

			String query = "UPDATE producto SET descripcion=?, precio=?, categoria=?, proveedor=?, cantidad=? WHERE id=?";
			psmt = cn.prepareStatement(query);
			psmt.setString(1, producto.getDescripcion());
			psmt.setFloat(2, producto.getPrecio());
			psmt.setString(3, producto.getCategoria());
			psmt.setString(4, producto.getProveedor());
			psmt.setInt(5, producto.getCantidad());
			psmt.setInt(6, producto.getId());
			value = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (psmt != null)
					psmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return value;
	}

	public int eliminarProducto(Integer id) {
		int value = 0;
		Connection cn = null;
		PreparedStatement psmt = null;
		try {
			cn = Conexion.getConnection();

			String query = "DELETE FROM producto WHERE id=?";
			psmt = cn.prepareStatement(query);
			psmt.setInt(1, id);
			value = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (cn != null)
					cn.close();
				if (psmt != null)
					psmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return value;
	}
}
