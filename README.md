#lanscape-challenge

A very simple Spring Boot REST API, performs CRUD operations on a SQLite database, documented with Swagger2.

* Swagger UI URL: http://localhost:8080/api/swagger-ui/

* Swagger JSON URL: http://localhost:8080/api/v2/api-docs

LINK POSTMAN PARA IMPORTAR
https://api.postman.com/collections/13263658-7eeb39ef-6b11-4b0a-a7d3-5be28f44fcbb?access_key=PMAT-01HCPE3JSQAKYHKDHD55A1MHNW

PARA PODER CORRER EL PROGRAMA DEBE TENER INSTALADO LAS DEPENDENCIAS NECESARIAS ( MAVEN, JAVA)

El API CREA UNA BASE DE DATOS EN SQLITE, CREA 3 TABLAS ( USER, ACCESS , PERMISSION)

*CREAR USUARIO*  

EL API PERMITE CREAR UN USUARIO, SI EN CASO EL EMAIL YA EXISTE DEVOLVERA EL MISMO ID

~~~
curl --location 'http://localhost:8080/api/user' \
--header 'Content-Type: application/json' \
--data-raw '{
    "fullName" : "Johao Rosas",
    "email" : "johaonet@gmail.com",
    "password" : "123"
}'
~~~

RESPONSE  
~~~
{
    "id": "58956d90-30bc-467a-934e-2c5bc2b79cba",
    "fullName": "Johao Rosas",
    "email": "johaonet@gmail.com",
    "password": "123"
}
~~~

*CREAR PERMISO POR USUARIO*  
EL API PERMITE CREAR PERMISOS POR USUARIO, TENER EN CUENTA QUE SOLO DEJARA CREAR SI EL ID DEL USUARIO EXISTE

~~~
curl --location 'http://localhost:8080/api/permission' \
--header 'Content-Type: application/json' \
--data '{
  "permission": "AUDITORIA",
  "userId": "<USER_ID>"
}'
~~~

RESPONSE  
~~~
{
    "id": 3,
    "userId": "58956d90-30bc-467a-934e-2c5bc2b79cba",
    "permission": "AUDITORIA"
}
~~~

*LOGIN*  
EL LOGIN SOLO DEVOLVERA CORRECTAMENTE SI EL EMAIL Y EL PASSWORD COINCIDEN CON LO GUARDADO EN LA BASE DE DATOS, CADA VEZ QUE EL USUARIO HACE LOGIN Y ES CORRECTO SE GUARDA EN LA TABLA ACCESO.
~~~
curl --location 'http://localhost:8080/api/user/login' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email" : "johaonet@gmail.com",
    "password" : "123"
}'
~~~


*BASE DE DATOS*  
EL NOMBRE DE LA BASE DE DATOS QUE SE GENERA ES *LandScapeChallenge.sqlite*

PARA PODER VISUALIZAR LOS DATOS PODEMOS USAR ESTA WEB https://sqliteviewer.app/ E IMPORTAR LA BASE DATOS 
