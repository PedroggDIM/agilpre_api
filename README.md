[![Logo](https://git.institutomilitar.com/PedroggDIM/agil/-/wikis/imagenes/Logo/LogoAgil_M.png)](https://git.institutomilitar.com/PedroggDIM/agil/-/wikis/imagenes/Logo/LogoAgil.png)

# Descripción General

En la Dirección General de la Guardia Civil (DGGC) existen contratos con empresas de limpieza para realizar las tareas de mantenimiento de los estándares de higiene en las distintas instalaciones del Cuerpo. Por desgracia, la labor de limpieza no siempre resulta satisfactoria o se realiza dentro de dichos acuerdos, y existe un cauce establecido para lidiar con estas situaciones.

La unidad afectada por una incidencia de limpieza debe rellenar un modelo y remitirlo por correo electronico a la empresa en cuestión. El Servicio de Abastecimiento (SABAS) interviene cuando no se logra llegar a un acuerdo. Tomando nota de ello para tratarlo en la siguiente reunión dedicada a este tema.

Actualmente se sigue este cauce, y las incidencias son anotadas en un documento excel. Pero se ha demostrado que, de esta manera, muchas de las incidencias quedan desatendidas o insuficientemente resueltas; o no han sido debidamente retratadas en el modelo. Por no hablar de la demora a la hora de tratar dichas incidencias y llegar a una solución cuando la empresa no se ha hecho cargo (la frecuencia con que se produzcan reuniones).

AGIL nace como una idea para la gestión de incidencias, diseñada para simplificar el seguimiento y resolución de problemas de limpieza en la DGGC. Los usuarios podrán registrar incidencias en la aplicación cuando la empresa de limpieza no cumpla con los estándares de higiene, la aplicación notificará a la empresa por correo electrónico para tomar medidas y solucionar estos problemas; y los administradores (SABAS) intervendrán solo si no se proporciona una solución o si se verifica que la solución dada no se ha realizado. Dejando obsoletas las actas ya mencionadas.

AGIL también facilitará la generación de listas de incidencias no resueltas para su revisión y seguimiento. Es decir, el documento excel actual pasaría a no ser necesario, al encargarse la aplicación de reunir los datos de interés.

Con todo ello se espera reunir la gestión de incidencias en un uńico lugar, simplificar el proceso que una unidad debe seguir al hacer frente a una incidencia, agilizar la gestión y aumentar la eficacia de la misma.

## Valor aportado

Gracias a la implantación de AGIL, se dispondrá de un sistema donde cualquier integrante de una unidad territorial podrá crear una incidencia relacionada con el servicio de limpieza en su propia unidad.
AGIL dota a la Guardia Civil de un único espacio donde poder encontrar las diferentes incidencias que hayan sido dadas de alta; así como de una herramienta para la supervisión, el seguimiento y la gestión de las mismas. Tareas que recaerán sobre un administrador perteneciente al Servicio de Abastecimiento.
Además, se consigue agilizar el proceso de gestion individualizada de incidencias, y el proceso de revisión conjunta de incidencias. Gracias a las capacidades inherentes a poseer una base de datos.

Por todo ello AGIL disminuye la cantidad de trabajo y el tiempo requeridos para hacer frente a la tarea; además de asegurar la atención a las incidencias.

## Estado del Proyecto

Actualmente el proyecto se encuentra en **fase de desarrollo**.

## Tecnologías Utilizadas
**Back-End:** API desarrollada en Java empleando el framework [Spring](https://docs.spring.io/spring-framework/reference/index.html).

**Datos:** base de datos relacional alojada en un servidor web de [ElephantSQL](https://www.elephantsql.com).

**Front-End:** web desarrollada con [Vue](https://vuejs.org/guide/introduction.html), framework de JavaScript de código abierto para la construcción de interfaces de usuario y aplicaciones de una sola página.

## Requisitos para la integración
* **Requisitos de hardware**:
    * Espacio de disco: al menos 1 GB de espacio en disco, dependiendo del tamaño de la base de datos y otros archivos.
    * Procesador: al menos 2 GHz.
    * Memoria: al menos 4 GB de RAM.
* **Requisitos de software**:
    * Un navegador web actuaizado compatible con JavaScript.
    * Node.js actualizado.
    * Java DevelopmentKit actualizado.
    * Framework SpringBoot.
    * Vue Command Line Interface actualizado.

## Funcionalidades del proyecto

- Acceso desde internet para los usuarios.
- Compatibilidad con pc, tablet y movil.
- Compatibilidad con al menos chrome y firefox.
- Operaciones de creación, lectura, modificación y borrado de incidencias.
- Generación de una lista de incidencias según su estado.
- Método para avisar al destinatario de la incidencia según el caso.
- Sistema de sesión que impida visitar los diferentes módulos de la aplicación sin disponer de credenciales.
- Diferenciación entre dos tipos de usuarios: básico y administrador.
- Presencia de diferentes tipos de incidencias, con interacciones únicas para cada una:
    + Trabajo de limpieza: carga una lista de incumplimientos.
    + Tratamiento de choque: solicita un trabajo e indica la gravedad.
    + Modificación de dependencias: indica qué cambio se produce y refleja los metros cuadrados cuando es necesario.

## Equipo del Proyecto
- **Scrum Master** y **Product Owner**: Comandante GC D. Ignacio José Morales Molero (Servicio Informática Guardia Civil).
- **Developer**: Teniente GC D. Pedro Gil Gil.
- **Developer**: Teniente GC D. Sergio Perea Gutiérrez.

## Diagrama de clases

![Diagrama](https://git.institutomilitar.com/PedroggDIM/agil/-/wikis/imagenes/DiagramaClases.png)