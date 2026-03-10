# Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6

---

# Table of Contents
- [Project Description](#project-description)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Architecture description](#architecture-description)
- [Installation and Usage](#installation-and-usage)
- [Rest Services](#rest-services)
- [Static Files](#static-files)
- [AWS Deployment](#aws-deployment)
- [Conclusion](#conclusion)
- [Author](#author)

---

# Project Description
The project is based on the development of a light-weight Java Web Microframework, which is based on popular frameworks such as Spring Boot.
The framework will enable the development of REST services using annotations and automatically map HTTP requests to methods.

The microframework will automatically scan the controller classes and detect the annotated endpoints, which will be registered dynamically.
It also supports query parameters and static file serving.

The application has a simple web interface that can be used to test the endpoints.

---

# Technologies Used
- Java 
- Maven
- HTTP Sockets
- HTML
- CSS
- JavaScript

---

# Project Structure
The project is organized into three main layers:

```text
src/main/java/arep/
├── controller
    ├── HelloController.java    // Example controller to demonstrate the framework
    ├── GreetingController.java // Another example controller for handling greeting requests
├── framework
    ├── HttpServer.java          // Core HTTP server implementation
    ├── HttpRequest.java         // Class representing an HTTP request
    ├── HttpResponse.java        // Class representing an HTTP response
    ├── WebFramework.java         // Main class for the web framework, responsible for scanning and registering controllers
    ├── WebMethod.java            // Class representing a web method, including HTTP method and path
    ├── MicroSpringBootApplication.java // Main application class to start the server
├── annotations
    ├── GetMapping.java            // Annotation for mapping GET requests
    ├── RequestParam.java             // Annotation for mapping query parameters
    ├── RestController.java             // Annotation for marking a class as a REST controller
```

This structure allows for a clear separation of concerns, with controllers handling the business logic, the framework managing the HTTP server and request/response handling, and annotations providing a way to define endpoints in a declarative manner.

---

# Architecture description
The micro framework is composed of the following main parts:

### HTTP Server
Processes HTTP requests using Java Sockets.

### Controller Scanner

Uses Java Reflection to scan classes annotated with:

- @RestController

- @GetMapping

- @RequestMapping

### Routing System

Dynamically registers routes and maps HTTP routes to Java methods.

Example log message:

```bash
Escaneando controllers...
Registrando endpoint: /
Registrando endpoint: /pi
Registrando endpoint: /hello
Registrando endpoint: /greeting
Listo para recibir ...
```

### Static File Server

Serves static files from the "public" directory.

---

# Installation and Usage
1. Clone the repository:
```bash
git clone https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6.git
```

2. Navigate to the project directory:
```bash
cd Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6
```

3. Build the project using Maven:
```bash
mvn clean install
```

4. Run the application:
```bash
java -cp target/classes edu.eci.MicroSpringBoot.framework.MicroSpringBootApplication
```
Or if you have an IDLE like Visual Studio Code, you can run the `MicroSpringBootApplication` class directly.

5. Open a web browser and navigate to `http://localhost:8080` to access the application.

---

# Rest Services
The application provides the following REST services:

| Endpoint                   | Description                              |
| -------------------------- | ---------------------------------------- |
| `/`                        | Returns a welcome message.               |
| `/pi`                      | Returns the value of π.                   |
| `/hello`                   | Returns a greeting message.              |
| `/greeting?name=YourName`  | Returns a personalized greeting message. |
| `/greeting`                    | Returns a default greeting message.      |
| `/index.html`                    | Here you can find all the endpoints and navegate to them.      |
| `/image.png`                    | Here you can find the image file.      |

Here are the images of the endpoints in action:

- `/`

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/localhost8080.PNG)

- `/pi`

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/pi.PNG)

- `/hello`

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/hello.PNG)

- `/greeting?name=YourName`

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/greetingName.PNG)

- `/greeting`

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/greeting.PNG)

- `/index.html`

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/indexHtml.PNG)

- `/image.png`

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/indexImage.PNG)

---

# Static Files
The application serves static files from the `public` directory. You can access these files by navigating to `http://localhost:8080/filename`, where `filename` is the name of the file you want to access.
For example in this repository you can access to it following the next path: `http://localhost:8080/index.html` to access the main page of the application, where you can find all the endpoints and navigate to them.

- Configuration example
```java
Httpserver.staticFiles("webroot/public");
```

- Static file structure
```text
public/
├── index.html
├── styles.css
├── script.js
```

---

# AWS Deployment
The application can be deployed on AWS using Elastic Beanstalk or EC2 instances. First of all you need to create an instance like this:

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/instancia.PNG)

After creating the instance you will see this:

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/instanciaCreated.PNG)

Now we can see that the instance is running and we can connect to it using SSH. Once connected, we can install Java and run the application.

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/instanciaConectada.PNG)

Before this we have to go to security and put the port 8080 open to the world, so we can access the application from our local machine.

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/security.PNG)

Now we can open git bash and connect to the instance using SSH:

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/conectando.PNG)

Before opening we have to pass the file with sftp so the zip file its going to be save in the instance:

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/passingFile.PNG)

Now we can unzip the file:

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/unzip.PNG)

Now we can install java in the instance:

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/javainstallation.PNG)

After that we can run the application:

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/deployAws.PNG)

And we can see our application running in AWS:

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/awsDeployWebpage.PNG)

Here is the index page of the application running in AWS:

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/indexAws.PNG)

And last but not least here is the image file running in AWS:

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/awsimagenpng.PNG)

---

# Test

We made test for each endpoint with JUnit and you can see using this command:

```bash
mvn test
```

And here is the output of the test:

![image](https://github.com/CamiloFdez/Taller-de-Arquitecturas-de-Servidores-de-Aplicaciones-Lab-6/blob/main/images/tests.PNG)

# Conclusion
This project demonstrates the development of a simple Java Web Microframework that allows for the creation of REST services using annotations. It provides a basic structure for handling HTTP requests, routing, and serving static files, making it easier to develop web applications in Java. Also with AWS deployment capabilities, it can be easily hosted and accessed from anywhere.

---

# Author
- Camilo Fernández
- GitHub: [CamiloFdez](https://github.com/CamiloFdez)