# reba-challenge

Desafio Tecnico Reba

Con el objetivo de cumplir con los requisitos solicitados en el desafio, se desarrollo una
API Rest utilizando Java 11, Spring Boot y MySQL.

Una vez desarrollada la API se procedio a deployarse en Amazon Web Services (AWS), con el objetivo
de facilitarle el uso a quien la utilice. No solo el codigo Java se deployo sino que tambien la 
base de datos MySQL. 

El link para acceder es el siguiente: http://reba-env.eba-haf7munm.us-east-1.elasticbeanstalk.com/

A su vez, para facilitar las pruebas tambien se incorporo el Swagger al proyecto, para saber que
endpoints existen, que parametros u objetos necesita cada uno, entre otras cosas.
http://reba-env.eba-haf7munm.us-east-1.elasticbeanstalk.com/swagger-ui (link del swagger)

La API esta dividida en 3 controladores, cada uno de los cuales cumple una funcion determinada.

person-controller - /personas

POST /personas: Permite la carga de personas en el sistema. Valida que sea mayor de edad, y que
cargues un DNI (ya que es lo que te identificara como persona unica).

Request Body:
{
  "age": 20,
  "dni": "20223223",
  "email": "juancito@gmail.com",
  "lastname": "Gutierrez",
  "name": "Juan",
  "nationality": "Argentina",
  "telephoneNumber": "4850034"
}

GET /personas/:dni Permite obtener los datos de una persona ingresando su dni via Path.

PUT /personas/:dni Permite actualizar uno o mas datos de una persona que exista en el sistema.
Se debe ingresar el dni de dicha persona via Path, y los datos que se desea modificar via body.

Request Body:
{
  "age": 22,
  "email": "juan.guti@gmail.com"
}

DELETE /personas/:dni Permite eliminar una persona del sistema ingresando su dni via Path.

POST /personas/:dni1/padre/:dni2 Indica si la persona con el :dni1 es padre de la persona con el
:dni2. Devuelve un Bool.

relation-controler - /relaciones

POST /relaciones: permite vincular a dos personas, validando que la relacion puede ser unicamente
HERMANX - PRIMX - TIX - PADRE. 
Request Body: 
{
  "dni1": "1010",
  "dni2": "2010",
  "relation": "PRIMX"
}

GET /relaciones/:dni1/:dni2 Indica la relacion que existe entre las personas que le indicamos.
Para seleccionar que las personas debe pasarse en el path el dni de las dos personas en cuestion.

stats-controller - /stats

GET /stats: permite obtener una estadistica de las nacionalidades de las personas ingresadas al sistema

