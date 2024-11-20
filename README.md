
## Prérequis
- Java 17 ou supérieur
- Maven 3.9.9 ou supérieur
- PostgreSQL
- [Un compte Algolia](https://www.algolia.com/)

## Installation
1. Clonez le dépôt :
    ```sh
   git clone https://github.com/MiltonEu/algolia_backend.git
    cd algolia_microservice
    ```
2. Installez les dépendances Maven :
    ```sh
    ./mvnw clean install
    ```

## Configuration
Assurez-vous de configurer les propriétés suivantes dans `application.properties` :

```properties
# Configuration de la base de données
spring.datasource.url=jdbc:postgresql://localhost:5432/db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=create
#spring.sql.init.mode=always

# Configuration JWT
security.jwt.secret-key=your_secret_key
security.jwt.expiration-time=3600000
security.refresh.expiration-time=7200000

# Configuration Algolia
algolia.application-id=your_algolia_app_id
algolia.api-key=your_algolia_api_key
algolia.users.index=users_index
algolia.pokemons.index=pokemons_index
