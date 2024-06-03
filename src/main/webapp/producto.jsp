<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="parcial.model.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>

<script
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
<style type="text/css">
.my-error-class {
	color: #ff0000;
}

.my-valid-class {
	color: #00cc00;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-3">
				<br> <br>
				<h3>Registrar Productos</h3>
				<form action="ProductoServlet?type=registrar"
					name="productoRegistration" method="post">
					<div class="form-group">
						<label>Id</label> <input class="form-control" type="text"
							value="${producto.id}" name="txtId" readonly="readonly">
					</div>
					<br>
					<div class="form-group">
						<label>Descripción</label> <input class="form-control" type="text"
							value="${producto.descripcion}" name="txtDescripcion">
					</div>
					<br>
					<div class="form-group">
						<label>Precio</label> <input class="form-control" type="number"
							value="${producto.precio}" name="txtPrecio" min="1" step="any">
					</div>
					<br>
					<div class="form-group">
						<label>Categoría</label> <input class="form-control" type="text"
							value="${producto.categoria}" name="txtCategoria">
					</div>
					<br>
					<div class="form-group">
						<label>Proveedor</label> <input class="form-control" type="text"
							value="${producto.proveedor}" name="txtProveedor">
					</div>
					<br>
					<div class="form-group">
						<label>Cantidad</label> <input class="form-control" type="number"
							value="${producto.cantidad}" name="txtCantidad">
					</div>
					<br> <input type="submit" class="btn btn-primary"
						value="Enviar Datos">
				</form>
			</div>
			<div class="col-9" style="padding-top: 4em">
				<table class="table table-success table-striped">
					<thead>
						<tr>
							<th>id</th>
							<th>Descripción</th>
							<th>Precio</th>
							<th>Categoría</th>
							<th>Proveedor</th>
							<th>Cantidad</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<Producto> listProductos = (List<Producto>) request.getAttribute("listProductos");
						if (listProductos != null) {
							for (Producto p : listProductos) {
						%>
						<tr>
							<td><%=p.getId()%></td>
							<td><%=p.getDescripcion()%></td>
							<td><%=p.getPrecio()%></td>
							<td><%=p.getCategoria()%></td>
							<td><%=p.getProveedor()%></td>
							<td><%=p.getCantidad()%></td>
							<td><a href="ProductoServlet?type=obtener&txtId=<%=p.getId()%>"
								class="btn btn-primary">Editar</a> <a
								href="ProductoServlet?type=eliminar&txtId=<%=p.getId()%>"
								class="btn btn-primary">Eliminar</a></td>
						</tr>
						<%
						}
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>