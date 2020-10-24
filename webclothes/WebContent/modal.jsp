<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
     <link rel="stylesheet" href="css/style.css">
  </head>
  	<body>
  	       
  <div class="modal fade" id="modal_info" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
       
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       <div class="col-sm-12 col-md-3 col-lg-9">
    <img src="imagenes/camisa1.png" class="img-fluid rounded float-left" alt="Responsive image">
     
	<form name="form" action=SuperServlet method="get">
	
    <p class="float-none"><c:out value='${categoria.descripcion}'/></p>
     </form>
    <form name="form" action="SuperServlet" method="get">
       <p class="h5 float-none"><c:out value='${producto.nombre}'/></p>
      <p class="float-none">
       <c:out value='${producto.valor}'/><br>
       <c:out value='${producto.descripcion}'/>
    </p>
    </form>
   
    
    <a href="detalleProduc.jsp">
    <button type="button" class="btn btn-primary float-right">Mas</button>
    </a>
    
    <p class="float-left pt-5">
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sed enim et ligula posuere viverra. Mauris massa lectus, mollis vitae enim at, faucibus malesuada justo. Praesent vel semper nulla, et maximus magna. Morbi vel ultrices odio. Aenean nec rhoncus enim. Nam elementum et nulla id luctus. Mauris non neque volutpat, ullamcorper risus a, varius tortor.
    </p>
  </div>
      </div>
      
    </div>
  </div>
</div>

    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="js/apps.js"></script>
  </body>
</html>