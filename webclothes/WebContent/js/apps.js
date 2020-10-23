$(document).ready(function(){

$('#btn_contacto').click(function(){
$('#modal_contacto').modal();
});

$('#modal_info').modal();

$('#btn_marcas').click(function(){
var columna1= document.getElementById("tabla_col_1");
var columna2= document.getElementById("tabla_col_2");
var columna3= document.getElementById("tabla_col_3");

columna1.textContent="ID";
columna2.textContent="Nombre";
columna3.textContent="Descripcion";

});

$('#btn_categ').click(function(){
var columna1= document.getElementById("tabla_col_1");
var columna2= document.getElementById("tabla_col_2");
var columna3= document.getElementById("tabla_col_3");

columna1.textContent="ID";
columna2.textContent="Descripcion";
columna3.textContent="Estado";

});

$('#btn_produc').click(function(){
var columna1= document.getElementById("tabla_col_1");
var columna2= document.getElementById("tabla_col_2");
var columna3= document.getElementById("tabla_col_3");

columna1.textContent="Referencia";
columna2.textContent="Nombre";
columna3.textContent="Valor";

});

$('#btn_marcas_r').click(function(){
var label1= document.getElementById("label_1_r");
var label2= document.getElementById("label_2_r");

label1.textContent="Nombre";
label2.textContent="Valor";
var padre=document.getElementById("label_3_r");
padre.style.visibility="hidden";
var padre=document.getElementById("label_4_r");
padre.style.visibility="hidden";
var padre=document.getElementById("InputDetalle");
padre.style.visibility="hidden";
var padre=document.getElementById("InputDescri");
padre.style.visibility="hidden";
});

$('#btn_categ_r').click(function(){
var label1= document.getElementById("label_1_r");
var label2= document.getElementById("label_2_r");

label1.textContent="Descripcion";
label2.textContent="Estado";
});

$('#btn_produc_r').click(function(){
var label1= document.getElementById("label_1_r");
var label2= document.getElementById("label_2_r");

label1.textContent="Referencia";
label2.textContent="Nombre";
var padre=document.getElementById("label_3_r");
padre.style.visibility="visible";
var padre=document.getElementById("label_4_r");
padre.style.visibility="visible";
var padre=document.getElementById("InputDetalle");
padre.style.visibility="visible";
var padre=document.getElementById("InputDescri");
padre.style.visibility="visible";
});


});