package parcial.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import parcial.model.Producto;
import parcial.service.ProductoService;


@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductoService productoService = new ProductoService();

	public ProductoServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type = request.getParameter("type");

		switch (type) {
		case "registrar":
			String id = request.getParameter("txtId");
			if (id != null && !id.isEmpty()) {
				editarProducto(request, response);
			} else {
				crearProducto(request, response);
			}
			break;
		case "listar":
			listarProducto(request, response);
			break;
		case "obtener":
			obtenerProducto(request, response);
			break;
		case "eliminar":
			eliminarProducto(request, response);
			break;
		default:
			break;
		}
	}

	private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("txtId"));

		Integer value = productoService.eliminarProducto(id);

		if (value == 1) {
			listarProducto(request, response);
		} else {
			request.setAttribute("mensaje", "Error al obtener producto");
			request.getRequestDispatcher("error.jsp");
		}

	}

	private void obtenerProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("txtId"));
		Producto c = productoService.obtenerProducto(id);

		if (c != null) {
			request.setAttribute("producto", c);
			listarProducto(request, response);
		} else {	
			request.setAttribute("mensaje", "Error al obtener producto");
			request.getRequestDispatcher("error.jsp");
		}

	}

	private void listarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Producto> productos = productoService.listarProducto();
		request.setAttribute("listProductos", productos);
		request.getRequestDispatcher("producto.jsp").forward(request, response);
	}

	private void crearProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String descripcion = request.getParameter("txtDescripcion");
		Float precio = Float.parseFloat(request.getParameter("txtPrecio"));
		String categoria = request.getParameter("txtCategoria");
		String proveedor = request.getParameter("txtProveedor");
		Integer cantidad = Integer.parseInt(request.getParameter("txtCantidad"));

		Producto producto = new Producto();
		producto.setDescripcion(descripcion);
		producto.setPrecio(precio);
		producto.setCategoria(categoria);
		producto.setProveedor(proveedor);
		producto.setCantidad(cantidad);

		Integer value = productoService.crearProducto(producto);

		if (value == 1) {
			listarProducto(request, response);
		} else {
			request.setAttribute("mensaje", "Error al registrar un Producto");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

	private void editarProducto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer id = Integer.parseInt(request.getParameter("txtId"));
		String descripcion = request.getParameter("txtDescripcion");
		Float precio = Float.parseFloat(request.getParameter("txtPrecio"));
		String categoria = request.getParameter("txtCategoria");
		String proveedor = request.getParameter("txtProveedor");
		Integer cantidad = Integer.parseInt(request.getParameter("txtCantidad"));

		Producto producto = new Producto();
		producto.setId(id);
		producto.setDescripcion(descripcion);
		producto.setPrecio(precio);
		producto.setCategoria(categoria);
		producto.setProveedor(proveedor);
		producto.setCantidad(cantidad);

		Integer value = productoService.editarProducto(producto);

		if (value == 1) {
			listarProducto(request, response);
		} else {
			request.setAttribute("mensaje", "Error al registrar una producto");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
