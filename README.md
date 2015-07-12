# microservice-demo
The sample application consists of microservices backed by spring and netflix components to build a simple catalog service. 

The catalog service communicates wth :
1. Product-service : Simulates generating product. 
2. Price-service : Simulates price calculation for a given product.
3. Comment-service : Simulates comments generation for a given product.

Apart from these there are eureka-service which acts as service registry and zuul-service which acts as proxy.

#Launching 
In order to launch all microservices, execute 

```sh run-all.sh```

Once all services are up and running, you can visit http://localhost:8761/ to monitor all services registered with eureka.

#Sample request

Note, I am using [jq](http://stedolan.github.io/jq/) library for json parsing. If you prefer some different library then you need to re-adjust all commands pasted below.

#Determing ports, ip address, hostname and service name
Execute 
```
curl -s -H "Accept: application/json" http://localhost:8761/eureka/apps | jq '.applications.application[] | {port:.instance.port["$"], ipAddress:.instance.ipAddr,hostName: .instance.hostName, serviceName:.name}'
```

**Replace the port under which zuul-service is running on your computer** and  execute

```
curl -s localhost:44953/catalog-service/catalog/100 | jq .
```

You will see sample response 
```json
{
  "product": {
    "price": {
      "amount": 1000.2
    },
    "comments": [
      {
        "content": "I like this product very much!!!",
        "author": "John",
        "productId": 100,
        "id": 1
      },
      {
        "content": "A must buy, worth the price",
        "author": "Bob",
        "productId": 100,
        "id": 2
      }
    ],
    "description": "super cool product",
    "name": "Product-A",
    "id": 100
  },
  "id": 100
}
```
Now If you will take the comment-service down, and execute 
```
curl -s localhost:44953/catalog-service/catalog/100 | jq .
```
You will notice that only comments will be missing from the response and still your application will be working . E.g.

```json
{
  "product": {
    "price": {
      "amount": 1000.2
    },
    "comments": [],
    "description": "super cool product",
    "name": "Product-A",
    "id": 100
  },
  "id": 100
}
```


