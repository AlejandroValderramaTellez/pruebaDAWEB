window.onload = function() {iniciar();}

function inicia(){
	alert('Elige el usuario a actualizar');
	document.getElementById("botonActualiza").disabled = "enabled";
	document.getElementById("botonBusca").onclick = activaActualiza;
}

function iniciaActualiza(){
	document.getElementById("botonActualiza").disabled = "enabled";
}