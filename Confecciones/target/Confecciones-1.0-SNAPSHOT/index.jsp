
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confecciones_sr</title>
        <link rel="stylesheet" href="css/estilo.css"/>
    </head>
    <body>
        
        <div class="cuerpo">

            <header>
                <img src="img/portada.png" alt="no carga">               
            </header>

            <nav>

            </nav>

            <section>


                <article>
                    <fieldset>
                        <legend> <h1>Registrar Modista </h1></legend>
                        <form action="SvModista" method="POST">
                            
                                                       
                            <input type="number" placeholder="Id:" id="txtId" name="id" ><br>
                            
                            
                            <input type="text" placeholder="Nombre:" id="txtNombre" name="nombre"><br>
                            
                            
                            <input type="text" placeholder="Apellido:" id="txtApellido" name="apellido" ><br>
                            
                            
                            <input type="number" placeholder="Telefono:" id="txtTelefono" name="telefono" ><br><br>


                            <input class="button" type="submit" value="Registrar">
                        </form>
                    </fieldset>
                
              
                    <fieldset>
                        <legend> <h1 class="m">Listar Modistas</h1></legend>
                        <div class="contenedor-sobre-nota"> 
                            <p> <em> Para listar modistas presione el boton</em></p>
                        </div>    

                            <form action="SvModista" method="GET">
                                <input class="button-2" type="submit" value="Consultar">
                            </form>                     
                    </fieldset>           
                </article>
           </section>           
        </div>
</body>
</html>

