# Inditex Prices API
## Descripción
API creada con Spring Boot para devolver el precio correspondiente a un producto y rama para una fecha dada.

## Ejecución de los tests

`gradle test`

Necesita java 17 y gradle 7.5.1 o superior.

## Ejecución de la aplicación

`gradle bootRun`

Necesita java 17 y gradle 7.5.1 o superior.

## Resources

La aplicación expone sólo un endpoint:
- GET - /price/{date}/{productId}/{brandId}

El formato de fecha debe ser yyyy-MM-dd hh:mm:ss. Por ejemplo, una fecha válida sería "2020-06-14 18:00:00".

## Usando la solución

Puedes ejecutar este comando curl:

`curl -request GET 'http://localhost:8080/price/2020-06-14 18:00:00/35455/1' --header 'Content-Type: application/json'`

Response:

```json
{
    "productId": 35455,
    "brandId": 1,
    "priceList": 2,
    "startDate": "2020-06-14 15:00:00",
    "endDate": "2020-06-14 18:30:00",
    "price": 25.45
}
```
