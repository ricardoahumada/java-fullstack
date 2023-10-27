<%@page import="com.banana.models.Maquillaje"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<% 
		Maquillaje[] listaRecibida = (Maquillaje[])request.getAttribute("listaMaquillajesAMostrar"); 
	%>
	
	<section>
		<h1>Lista de maquillajes de Pepe</h1>
		<ul>
			<% if(listaRecibida!=null) for(Maquillaje maq:listaRecibida) {%>
				<li>
					<span><%=maq.getCodigo() %></span> -
					<span><%=maq.getMarca() %></span> -
					<span><%=maq.getTipo() %></span> -
					<span><%=maq.getPrecio() %>EUR</span>
				</li>
			<%} %>
		</ul>
	</section>

	<jsp:include page="footer.jsp"></jsp:include>	
</body>
</html>