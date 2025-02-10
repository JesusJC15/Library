# Laboratorio 3 Testing TDD

## Natalia Espitia Espinel
## Jesús Alberto Jauregui Conde

## Descripción del proyecto
El proyecto consiste en un sistema de gestión de bibliotecas, donde hay clases que representan Libro, Usuario, Prestamo, y Biblioteca. Los usuarios pueden tomar prestados libros de la biblioteca, y la Biblioteca se encarga de gestionar los préstamos, asegurarse de que los libros estén disponibles, y mantener un registro de los libros prestados.

### Crear proyecto con maven
Deben crear un proyecto maven con los siguientes parámetros:
Grupo: edu.eci.cvds 
Artefacto: Library 
Paquete: edu.eci.cvds.tdd 
archetypeArtifactId: maven-archetype-quickstart

![](/assets/images/1.png)

### Agregar dependencia JUnit5
- Buscar en maven central la dependencia de JUnit5 en su versión más reciente.

![](/assets/images/2.png)

- Edite el archivo pom.xml del proyecto para agregar la dependencia.

![](/assets/images/3.png)

- Verifique que la versión de java sea la 21.

![](/assets/images/4.png)

- Compile el proyecto para validar que todo este bien.

![](/assets/images/5.png)
![](/assets/images/6.png)

### Agregar esqueleto del proyecto
- Cree los siguientes paquetes dentro de edu.eci.cvds.tdd

![](/assets/images/7.png)

### Agregar clases
- En el paquete edu.eci.cvds.tdd.library.book cree la siguiente clase:

![](/assets/images/8.png)

- A continuación en el paquete edu.eci.cvds.tdd.library.user cree la siguiente clase:

![](/assets/images/9.png)

- En el paquete edu.eci.cvds.tdd.library.loan se deben crear las clases Loan y el enum LoanStatus:

![](/assets/images/10.png)
![](/assets/images/11.png)

- Por último se debe crear la siguiente clase en el paquete edu.eci.cvds.tdd.library

![](/assets/images/12.png)

## Pruebas unitarias y TDD
- Para poder implementar los métodos addBook, loanABook y returnLoan de la clase Library vamos a aplicar la técnica de TDD, por cada caso de prueba se debe hacer un commit, cada commit debe tener la prueba nueva y la implementación para que la prueba del commit funcione. Las pruebas anteriormente implementadas deben continuar funcionando. Como están trabajando en parejas es necesario trabajar en ramas independientes y utilizar Pull Request para mezclar los cambios.

![](/assets/images/17.png)

## Crear clase de prueba
Es necesario crear la clase de prueba para edu.eci.cvds.tdd.Library, la clase debe seguir los estándares de nombres estudiados en clase.

Para pensar en los casos de pruebas lean detenidamente el javadoc de los métodos para reconocer las clases de equivalencia, basados en las clases de equivalencia se debe crear una prueba la cual debe fallar y posteriormente implementar el código necesario para que funcione, este proceso se debe repetir hasta cumplir con la especificación definida en el javadoc.

TDD para el método "addBook" de la clase "Library"

- Creación de las pruebas en la clase "LibraryTest"

![](/assets/images/18.png)

- Ejecución de las pruebas antes de la implementación del código
![](/assets/images/19.png)

- Implementación del método "addBook" de la clase "Library"
![](/assets/images/20.png)

- Ejecución de las pruebas después de la implementación del código
![](/assets/images/21.png)

TDD para el método "loanABook" de la clase "Library"

- Creación de las pruebas en la clase "LibraryTest"

![](/assets/images/22.png)
![](/assets/images/23.png)

- Ejecución de las pruebas antes de la implementación del código
![](/assets/images/24.jpeg)

- Implementación del método "loanABook" de la clase "Library"
![](/assets/images/25.png)

- Ejecución de las pruebas después de la implementación del código
![](/assets/images/26.jpeg)

TDD para el método "returnLoan" de la clase "Library"

- Creación de las pruebas en la clase "LibraryTest"

![](/assets/images/27.png)
![](/assets/images/28.png)

- Ejecución de las pruebas antes de la implementación del código
![](/assets/images/29.png)

- Implementación del método "returnLoan" de la clase "Library"
![](/assets/images/30.png)

- Ejecución de las pruebas después de la implementación del código
![](/assets/images/31.png)

## Cobertura
- Agregar la dependencia de jacoco, utilizar la última versión disponible en maven central.

![](/assets/images/13.png)
![](/assets/images/14.png)

- Para usar Jacoco es necesario agregar la siguiente sección en el pom.xml

![](/assets/images/15.png)

- Ahora al compilar el proyecto en la carpeta target se debe crear una carpeta con el nombre site la cual tiene un index.html, al abrir dicho archivo se debe ver la cobertura total y de cada una de las clases, el objetivo es tener la cobertura superior al 80%.

Cobertura al principio del laboratorio.
![](/assets/images/16.png)

- Explore los links del reporte en el cual le muestra que partes del código tienen prueba y cuales no.
![](/assets/images/32.png)
![](/assets/images/33.png)
![](/assets/images/34.png)
![](/assets/images/35.png)
![](/assets/images/36.png)
![](/assets/images/37.png)

## Sonarqube
Ahora es necesario hacer el análisis estático del código usando SonarQube, para lo cual necesitamos tener Docker.

- Para lo cual se debe descargar la imagen de docker con el siguiente comando docker pull sonarqube
![](/assets/images/38.png)

- Ahora se debe arrancar el servicio de SonarQube con el siguiente comando: docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:latest
![](/assets/images/39.png)

- Validar funcionamiento docker ps -a
![](/assets/images/40.png)mvn

- Iniciar sesión en sonar localhost:9000 cambiar la clave por defecto usuario y contraseña es admin.
![](/assets/images/41.png)
![](/assets/images/42.png)

- Una vez sonar este corriendo deben generar un token
Entrar a las opciones de la cuenta.
Account -> settings -> generate token.

![](/assets/images/43.png)

- Instale sonarLint en el IDE que este manejando.
![](/assets/images/44.png)

- Añada el plugin de Sonar en el archivo pom del proyecto.
![](/assets/images/45.png)

- Añada las propiedades de SonarQube y Jacoco.
![](/assets/images/46.png)

- Construya el proyecto, genere el reporte de JACOCO y corrija el cubrimiento de las pruebas de unidad para que su proyecto se construya adecuadamente.
![](/assets/images/47.png)
![](/assets/images/48.png)

- Genere la integración con sonar mvn verify sonar:sonar -D sonar.token=TOKEN_GENERADO
![](/assets/images/49.png)