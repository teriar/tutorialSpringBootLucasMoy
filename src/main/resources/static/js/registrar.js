// Call the dataTables jQuery plugin
$(document).ready(function() {

});


const registrarUsuario =async()=>{
 let datos = {};
 datos.nombre = document.getElementById('txtNombre').value
 datos.apellido = document.getElementById('txtApellido').value
 datos.email = document.getElementById('txtEmail').value
 datos.password = document.getElementById('txtPassword').value

 let repetirPassword = document.getElementById('txtRepetirPassword').value

 if(repetirPassword != datos.password){
 alert('contraseña diferente')
 return
 }

  const request = await fetch('api/usuarios',{
  method:'POST',
  headers:{
  'Accept':'application/json',
  'Content-type':'application/json'
  },
    body: JSON.stringify(datos)
  });

alert("la cuenta fue registrada con exito")
window.location.href = 'login.html'



}


