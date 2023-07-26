

<%@page import="co.edu.sena.confecciones.logica.Modista"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
  <h1>Listado De Modistas</h1>
            
        <%
            List<Modista> modistas = (List) request.getSession().getAttribute("listaModistas");
            int cont = 1;
            for (Modista m : modistas){
            
        %> 
        
        
        
        <p><b>Usuario Número:<%=cont%></b></p>
        
        <p><%=m%></p>
        
        <%cont=cont+1;%> 
 
        <% } %>     
    </body>
</html>
