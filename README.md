# Proyecto ecommerce 

**Estructura Actual:**

- **config-server:** servidor de configuración central (archivos en src/main/resources/config/).
- **discovery-server:** servidor de descubrimiento (Eureka/servicio de registro).
- **microservices/:** contiene los microservicios customer-microservice y product-microservice (cada uno con su propio Dockerfile y configuración).
- **docker-compose.yml:** orquesta los servicios para levantar el sistema completo.

**Requisitos:**

- Java JDK 21 instalado.
- Maven 3.6+ (o usar los wrappers mvnw / mvnw.cmd).
- Docker y Docker Compose.

**Compilar desde la raíz del proyecto ejecutar:**

```bash
mvn clean install
```
**o con wrapper (Linux/macOS):**
```bash
./mvnw clean install
``` 
 
**en Windows:**
```bash
mvnw.cmd clean install
```
**Ejecutar con Docker Compose Para levantar todos los servicios en contenedores:**
```bash
docker-compose up --build
```
**Para detener:**
```bash
docker-compose down
```







