## Projeto de Sistema para uma Assitência Tecnica em Informática

Neste Projeto eu estou utilizando [Spring Initializr]([URL](https://start.spring.io/) na **versão 3.3.4**, com **java 17** e **Maven**, optei por utilizar o **postgresql** como BD, e as dependências que estarei listando logo abaixo.

Primeiramente eu montei um UML para representar o que eu buscava como sistema, após isso eu montei a relação que cada classe representaria no sistema. 

![representacao grafica de relacionamento entre as classes bem como seus atributos e metodos](./esquematico.png)

## Spring Initializr:
**Spring Web:** Constrói aplicativos web, incluindo aqueles que seguem o estilo RESTful, usando o Spring MVC.
Utiliza o Apache Tomcat como o contêiner embutido padrão.

**Spring Security:** É um framework altamente personalizável para autenticação e controle de acesso em aplicativos Spring.
Permite configurar regras de segurança, autenticação de usuários e autorização de recursos.

**Spring Data JPA:** Facilita a persistência de dados em bancos de dados SQL usando a API de Persistência Java (JPA).
Integra-se com o Hibernate para mapeamento objeto-relacional.
PostgreSQL Driver:
É um driver JDBC e R2DBC que permite que programas Java se conectem a um banco de dados PostgreSQL usando código Java padrão, independente do banco de dados.

**Spring Boot DevTools:** Fornece reinicializações rápidas de aplicativos, LiveReload e configurações para melhorar a experiência de desenvolvimento.
Útil durante o desenvolvimento para evitar a necessidade de reiniciar manualmente o aplicativo após alterações no código.
Lombok:
É uma biblioteca de anotações Java que ajuda a reduzir o código boilerplate.
Gera automaticamente getters, setters, construtores e outros métodos com base nas anotações aplicadas às classes.


## Dependências

As dependências Spring Boot Starter Validation, Apache Commons FileUpload e ``Spring Boot Starter Test`` não estão aparecendo para adicionar na interface do **Spring Initializr**. Por isso, eu as incluí manualmente no arquivo ``pom.xml``.

#### Spring Boot Starter Validation:
Essa dependência fornece suporte para validação de dados (por exemplo, usando anotações como ``@Valid`` e ``@NotNull)``.

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

#### Apache Commons FileUpload
Essa biblioteca é necessária para lidar com upload de arquivos.

```
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.4</version>
</dependency>
```

#### Spring Boot Starter Test
Essa dependência inclui bibliotecas de teste como JUnit, Mockito, e assertj, entre outras, para facilitar o desenvolvimento de testes unitários e de integração.

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <scope>test</scope>
</dependency>
```

