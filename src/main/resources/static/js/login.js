// Call the dataTables jQuery plugin
$(document).ready(function() {

});


const iniciarSesion =async()=>{
 let datos = {};

 datos.email = document.getElementById('txtEmail').value
 datos.password = document.getElementById('txtPassword').value


  const request = await fetch('api/login',{
  method:'POST',
  headers:{
  'Accept':'application/json',
  'Content-type':'application/json'
  },
    body: JSON.stringify(datos)
  });
  const respuesta = await request.text();

  if(respuesta == 'OK'){
  window.location.href = 'usuarios.html'
  }else{
  alert("Las credenciales son incorrectas")
  }




}