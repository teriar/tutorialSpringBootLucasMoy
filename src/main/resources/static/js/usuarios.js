// Call the dataTables jQuery plugin
$(document).ready(function() {

cargarUsuarios()
  $('#usuarios').DataTable();

  actualizarEmailDelUsuario();
});
  const actualizarEmailDelUsuario= ()=>{
   document.getElementById('txt-email-usuario').outerHTML = localStorage.email;
  }

const cargarUsuarios =async()=>{

  const request = await fetch('api/usuarios',{
  method:'GET',
  headers:getHeaders(),

  });
  const usuarios = await request.json();

let listadoHtml = ''
   for(let usuario of usuarios){
   let botonEliminar = '<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>'

   let telefeno = usuario.telefono ==null ?'-':usuario.telefono;
   console.log(usuario)
   let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+''+usuario.apellido+'</td><td>'+usuario.email+'</td><td>'+telefeno+'</td><td>'+botonEliminar+'</td></tr>'
    listadoHtml +=usuarioHtml
   }
  console.log(usuarios);


// para insertar en la tabla #usuarios
document.querySelector('#usuarios tbody').outerHTML = listadoHtml
  }


function getHeaders(){
return {
         'Accept':'application/json',
         'Content-type':'application/json',
         'Authorization': localStorage.token
         }
}

async function eliminarUsuario(id){

if(!confirm('¿desea eliminar este usuario')){
return;
}


 const request = await fetch('api/usuarios/'+id,{
  method:'DELETE',
  headers:getHeaders(),

  });
  location.reload();
}

