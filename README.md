# evolent health 

Base (codename Evolent HEalth) server.

## Developing

**Clone the following projects:**

1) [evolent-health](https://github.com/TejalThorve95/evolent-health.git) (Main project)

**For each project:**

We recommend the **IntelliJ IDE**

1) Open each project with your **IDE**

2) If it's the first time opening that project, import the **maven dependencies** ( you can do it either via **IDE**  at your <u>project root folder</u>)

3) After that, run `mvn clean install package"` at your <u>project root folder</u>

4) Create an <u>application-dev.properties</u>s file at `./src/main/resources` with your local configurations 

5) Create a run configuration and select the <u>dev profile</u> 
    a) In this configuration, on VM options put `-Dspring.profiles.active=dev`

6) Run each project

Let us know if you don't have access to any resources or in case of issues. Feel free to improve this documents or suggest steps that might help developers to setup their enviroments.

**Folder Structure**

1) Under the `./src/main/java` package you can find the actual code where the package structure is divided based on different modules

2) the `oepnapi` folder contains the API documentation written using OpenApi Spec 3.0

3) Under the  `./src/main/java/resource/db.changelog` package you can find the liquibase script to create the table. Liquibase is an open-source solution for managing revisions of your database schema scripts. You can find more about liquibase on `https://docs.liquibase.com/`

**Running Application**

1) Run the Spring Boot application using the command `mvn spring-boot:run` or use the **IDE** option

2)Make a POST request to `http://localhost:{PORT}/api/v1/users/signup` with request body containing the username and password. 

3) Make a POST request to `http://localhost:{PORT}/login` with the credentials and this will return the `Authorization Token ` in the header of the response.

3) Make any other request to the API using the `Bearer Token` from above step.

4) Swagger documentation can be found on `http://localhost:{PORT}/swagger-ui.html`
