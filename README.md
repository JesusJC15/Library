# Laboratorio 3 Testing TDD

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