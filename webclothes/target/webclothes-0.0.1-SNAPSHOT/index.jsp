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
  		<a href="${pageContext.request.contextPath}/Home">
  	<img src="imagenes/logo.png" class="img-fluid rounded float-left" alt="Responsive image">
  	</a>
  	</div>
  	<div>
  	<a href="${pageContext.request.contextPath}/Admin.do?action=login">
  	<button type="button" class="btn btn-primary  float-right mx-3 float-left">Log in</button> 
  	</a>
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

    <div class="col-sm-12 col-md-6 col-lg-6">
      
      <div class="row">
         <div class="col-sm-12 col-md-12 col-lg-12">
         
         <p class="h1 display-4 pb-3">
         Quienes somos
         </p>
      <p>
        ${empresa.quienesS}
      </p>
       
      </div>

      

    </div>

    <div class="row pt-5">
       <div class="col-sm-12 col-md-12 col-lg-12 text-center">
        <p class="h5">Novedades productos</p>
        <div class="row">
          <div class="col-sm-12 col-md-6 col-lg-3">
          <a class="btn btn-outline-*" href="javascript:detalles('1')">
          <img src="imagenes/camisa1.png" class="img-fluid" alt="Responsive image" /> 
          </a>            
          </div>

          <div class="col-sm-12 col-md-6 col-lg-3 text-center">
        <a class="btn btn-outline-*" href="javascript:detalles('2')">
          <img src="imagenes/camisa2.png" class="img-fluid" alt="Responsive image" /> 
          </a> 
          </div>

          <div class="col-sm-12 col-md-6 col-lg-3 text-center">
         <a class="btn btn-outline-*" href="javascript:detalles('3')">
          <img src="imagenes/camisa3.png" class="img-fluid" alt="Responsive image" /> 
          </a>  
          </div>

          <div class="col-sm-12 col-md-6 col-lg-3 text-center">
        <a class="btn btn-outline-*" href="javascript:detalles('4')">
          <img src="imagenes/camisa4.png" class="img-fluid" alt="Responsive image" /> 
          </a>  
          </div>
        </div>

        <div class="row pt-5">
            
             <div class="col-sm-12 col-md-6 col-lg-3 text-center">
            <a class="btn btn-outline-*" href="javascript:detalles('5')">
          <img src="imagenes/camisa5.png" class="img-fluid" alt="Responsive image" /> 
          </a>  
          </div>

           <div class="col-sm-12 col-md-6 col-lg-3 text-center">
         <a class="btn btn-outline-*" href="javascript:detalles('6')">
          <img src="imagenes/camisa6.png" class="img-fluid" alt="Responsive image" /> 
          </a>    
          </div>

           <div class="col-sm-12 col-md-6 col-lg-3 text-center">
          <a class="btn btn-outline-*" href="javascript:detalles('7')">
          <img src="imagenes/camisa7.png" class="img-fluid" alt="Responsive image" /> 
          </a>  
          </div>

           <div class="col-sm-12 col-md-6 col-lg-3 text-center">
         <a class="btn btn-outline-*" href="javascript:detalles('8')">
          <img src="imagenes/camisa8.png" class="img-fluid" alt="Responsive image" /> 
          </a>  
                
          </div>

          </div>

          <div class="row pt-5">
            <div class="col-sm-12 col-md-12 col-lg-12 text-center pb-5">
              <a href="${pageContext.request.contextPath}/Imagen.do?action=imagenlist">
                <button type="button" class="btn btn-primary"id="btn_verProduc">Ver todos los productos</button> 
              </a>
              
            </div>
          </div>

      </div>
    </div>

  </div>


  <div class="col-sm-12 col-md-6 col-lg-6">
    <div class="row">
      <div class="col-sm-12 col-md-12 col-lg-12 text-center">
        <iframe src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2FMattelsa%2F&tabs=timeline&width=600&height=500&small_header=false&adapt_container_width=true&hide_cover=false&show_facepile=false&appId" width="600" height="500" style="border:none;overflow:hidden" scrolling="no" frameborder="0" allowTransparency="true" allow="encrypted-media"></iframe>
      </div>
    </div>
    <div class="row">
      <div class="col-sm-12 col-md-12 col-lg-12 text-center pt-5">
        <a href="https://www.facebook.com/Mattelsa/" target="_blank" rel="noopener noreferrer">
          <button type="button" class="btn btn-primary ">Siguenos</button>
        </a>        
      </div>
    </div>
    </div>
  </div>

  

  


<jsp:include page="vistaModales/modalContacto.jsp"/>
<jsp:include page="vistaModales/modal.jsp"/>
  
     
  

  <footer>
    <div class="row pt-5">
      <div class="col-sm-12 col-md-12 col-lg-12">
        
      
      <div class="row">
        <div class="col-sm-12 col-md-6 col-lg-6">
          <p class="h5">Informacion de contacto</p>  
        </div>
        <div class="col-sm-12 col-md-6 col-lg-6">
        <a href="${empresa.face}">
          <img src="imagenes/face.png" class="img-fluid rounded float-right mx-3" alt="Responsive image">
        </a>
         <a href="${empresa.twitt}">
          <img src="imagenes/twitter.png" class="img-fluid rounded float-right mx-3" alt="Responsive image">
        </a>
         <a href="${empresa.insta}">
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
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="js/apps.js"></script>
    <script>
		
	function detalles(id){
	$.ajax({
			url:"${pageContext.request.contextPath}/Super.do?action=detalle&id="+id,
			type:"GET",
			dataType:"JSON",
			success: function (data){
				$('#catego_nombre').text(data.categoria);
				$('#producto_precio').text("$ "+data.valor);
				$('#produc_nombre').text(data.producto);
				$('#produc_detalle').text(data.detalle);
				$('#producto_descrip').text(data.descripcion);
				var dir=data.imagen;
				$('#img_modal_info').attr('src',dir);
				$('#modal_info').modal('show');
			}
	}
	);
	}
	</script>
  </body>
</html>