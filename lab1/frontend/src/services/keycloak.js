import Keycloak from 'keycloak-js'
const keycloakConfig = {
    url: 'http://localhost:8180/auth',
    realm: 'Airplane',
    clientId: 'spring-boot-app'
}
const keycloak = new Keycloak(keycloakConfig);
export default keycloak