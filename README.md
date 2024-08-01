#Adopta Un Amigo

Adopta Un Amigo es una aplicación web para la adopción de mascotas. Permite a los clientes de otras entidades ver mascotas disponibles, agregar nuevas mascotas, gestionar propietarios y contactar con la organización.


#Características

- Listar todas las mascotas disponibles para adopción.
- Buscar mascotas por ID o nombre.
- Crear, editar y eliminar registros de mascotas.
- Listar y gestionar propietarios de mascotas.
- Sección de contacto para consultas.

#Tecnologías

- **Frontend**: HTML, CSS (Bootstrap), JavaScript (jQuery)
- **Backend**: Spring Boot
- **Base de Datos**: (H2)
- **Despliegue**: (Local)

#Instalación

### Requisitos Previos

- Java 11 o superior
- Maven
- SpringBoot

### Clonar el Repositorio

``` 
git clone https://github.com/EleVG26/adopta-un-amigo
```

#Uso
### Navegación
-**Home**: Página principal con un mensaje de bienvenida y enlaces a las diferentes secciones.

-**Peluditos**: Lista de mascotas disponibles para adopción.

-**Propietarios**: Gestión de propietarios de mascotas adoptadas.

-**Contacto**: Información de contacto para consultas.


## Rutas

-**Inicio**: `/`

-**Peluditos**: `/mascotas` 

-**Propietarios**: `/propietarios`

-**Contacto**: `/contacto` 



## API Endpoints

###Mascotas

`GET /api/mascotas`: Obtener todas las mascotas.

`POST /api/mascotas`: Crear una nueva mascota.

`GET /api/mascotas/{id}`: Obtener una mascota por ID.

`DELETE /api/mascotas/{id}`: Eliminar una mascota por ID.

`GET /api/mascotas/nombre/{nombre}`: Obtener una mascota por nombre.

`GET /api/mascotas/page`: Obtener mascotas paginadas.

`GET /api/mascotas/youngest`: Obtener las 20 mascotas más jóvenes.


###Propietarios

`GET /api/propietarios`: Obtener todos los propietarios.

`POST /api/propietarios`: Crear un nuevo propietario.

`GET /api/propietarios/{id}`: Obtener un propietario por ID.

`DELETE /api/propietarios/{id}`: Eliminar un propietario por ID.


##Swagger

Swagger es una herramienta para la documentación y prueba de APIs. Proporciona una interfaz de usuario donde puedes ver todos los endpoints disponibles, sus detalles y realizar peticiones directamente desde el navegador.

Para acceder a la documentación generada por Swagger, visita la siguiente URL una vez que la aplicación esté en ejecución:

Swagger UI: ```http://localhost:8080/swagger-ui.html```


##Arquitectura del proyecto

```txt
adopta-un-amigo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/elenakeepcoding/
│   │   │       ├── config/
│   │   │       │   └── SwaggerConfig.java
│   │   │       ├── model/
│   │   │       │   ├── Mascota.java
│   │   │       │   └── Propietario.java
│   │   │       ├── repository/
│   │   │       │   ├── MascotaRepository.java
│   │   │       │   └── PropietarioRepository.java
│   │   │       ├── service/
│   │   │       │   ├── MascotaService.java
│   │   │       │   └── PropietarioService.java
│   │   │       └── web/
│   │   │           └── api/
│   │   │               ├── DesignMascotaControllerApi.java
│   │   │               ├── HomeController.java
│   │   │               └── PropietarioControllerApi.java
│   ├── resources/
│   │   ├── sql/
│   │   │   ├── data.sql
│   │   │   └── schema.sql
│   │   ├── static/
│   │   │   └── images/
│   │   ├── templates/
│   │   │   ├── contacto.html
│   │   │   ├── index.html
│   │   │   ├── mascotas.html
│   │   │   └── propietarios.html
│   │   └── application.properties
│   └── test/
│       ├── java/
│       │   └── com/elenakeepcoding/
│       └── resources/
├── target/
├── adopta-un-amigo.postman_collection.json
├── HELP.md
├── mvnw
├── mvnw.cmd
└── pom.xml
```

##Contacto
**Elena Vargas Grisales**: `ele92gris@gmail.com`
