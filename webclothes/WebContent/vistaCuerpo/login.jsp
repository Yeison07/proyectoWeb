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
    <title>Didier Sachs</title>
  </head>
  	<body>
  	<header>
  		<div>
  	<img src="imagenes/logo.png" class="img-fluid rounded float-left" alt="Responsive image">
	</div>
  	
  <div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
        <img src="imagenes/1.png" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="imagenes/2.png" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="imagenes/3.png" class="d-block w-100" alt="...">
    </div>
  </div>
</div>

    <div>
      
    </div>

  </header>  

	<div class="row pt-5">
		<div class="col-sm-0 col-md-0 col-lg-4"></div>
		<div class="col-sm-12 col-md-12 col-lg-4 pl-5">
  
  
	<form name="form" action="${pageContext.request.contextPath}/Admin.do" method="get">
	<input type="hidden" name="action" value="login"/>
	
     <div class="form-group row">
    <label for="InputReferencia" class="col-sm-2 col-form-label">Usuario</label>
    <div class="col-sm-5">
    <input type="text" class="form-control" value="Ingrese usuario"  name="user" id="InputUser">  
    </div>
    
  </div>
  <div class="form-group row">
    <label for="InputReferencia" class="col-sm-2 col-form-label">Contrase�a</label>
    <div class="col-sm-5">
    <input type="text" class="form-control" value="Ingrese contrase�a"  name="contra" id="InputContra">  
    </div>
    
  </div>
  
  <button type="submit" class="btn btn-success">Guardar</button>
   
</form>
	</div>
	<div class="col-sm-0 col-md-0 col-lg-4"></div>
 </div>


  <footer>
    <div class="row pt-5">
      <div class="col-sm-12 col-md-12 col-lg-12">
        
      
      <div class="row">
        <div class="col-sm-12 col-md-6 col-lg-6">
          <p class="h5">Informacion de contacto</p>  
        </div>
        <div class="col-sm-12 col-md-6 col-lg-6">
        <a href="https://www.facebook.com">
          <img src="imagenes/face.png" class="img-fluid rounded float-right mx-3" alt="Responsive image">
        </a>
         <a href="https://twitter.com/?lang=es">
          <img src="imagenes/twitter.png" class="img-fluid rounded float-right mx-3" alt="Responsive image">
        </a>
         <a href="https://www.instagram.com/?hl=es-la">
          <img src="imagenes/insta.png" class="img-fluid rounded float-right mx-3" alt="Responsive image">
        </a>
        </div>
      </div>

      <div class="row">
        
        <div class="col-sm-12 col-md-6 col-lg-6">
        <p><strong>Email: </strong>Yeisonalexanderss@ufps.edu.co 
          <br>
          <strong>Telefonos de contacto: </strong>+52 320 242 53 75
        </p>
        
        </div>
        <div class="col-sm-12 col-md-6 col-lg-6 pt-2">
         <button type="button" class="btn btn-primary float-right mx-5"id="btn_contacto">Contactanos</button> 
        </div>

      </div>

      <div class="row">
        <div class="col-sm-12 col-md-12 col-lg-12 text-center">
        <p>
          Todos los derechos reservados Didier Sanchs.
          Diseñado y programado por Yeison Soto
        </p>
    
        </div>
      
    </div>
    </div>
  </div>
  </footer>



    
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="js/apps.js"></script>
  </body>
</html>