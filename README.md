# Airtel Money Integration for Java

## Introduction
This is a java library for spring applications to ease integration of the Airtel Money API into Java applications. 
The complexities of the whole API are simplified into easily usable methods.

**Note:** The library is still in developemnt so I can't guarantee stability.

### Technologies used

- Spring WebFlux for API integration
- [JUnit](https://junit.org/junit5/) for testing
- [Lombok](https://projectlombok.org/) to avoid writing boilerplate code
- [Redis](https://redis.io/) for cache

## Usage
First of all, scan for components in the package from your main class

```java
@SpringBootApplication(scanBasePackages = {"com.enocklubowa.airtelmoneyjava", ...your other packages})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
```

Specify these in your application.properties file

```properties
airtel_client_id=
airtel_client_secret=
airtel_country=UG   #If different from Uganda, then change it to your country
airtel_currency=UGX     #If different from UGX, then change it
airtel_base_url=https://openapiuat.airtel.africa
airtel_grant_type=client_credentials    #Leave with default
airtel_token_expires_in=160     #Leave with default
```
`airtel_base_url` is `https://openapiuat.airtel.africa` in sandbox and `https://openapi.airtel.africa` in production 

### Collection 
Initiate a collection request to the user's phone number with the following:

```java
@Autowired
Collection collection;

CollectionResponse response;

response = collection.initiate("Testing transaction", "75*******", 1000.0, "YOUR_INTERNAL_GENERATED_TRANSACTION_ID");
```

Handle Exception:
```java
try{
    response = collection.initiate("Testing transaction", "75*******", 1000, "YOUR_INTERNAL_GENERATED_TRANSACTION_ID");
} catch(CollectionException exception){
    //Print or log the error
    System.out.println(exception.getMessage());
}
```

The `response` has:
```java
// transaction details
Transaction transaction = response.getData().getTransaction(); 
// transaction status details
CollectionStatus status = response.getStatus();

// store the transaction details as well as the status details        
transaction.getId();
transaction.getStatus();
        
status.getResponse_code();
status.getCode();
status.isSuccess();
status.getMessage();
```

### Refund
Perform a refund with the following:

```java
CollectionResponse response;
response = refund.make("transaction_id");
```

Handle Exception:
```java
try{
    response = refund.make("transaction_id");
}catch(CollectionException exception){
    System.out.println(exception.getMessage())
}
```

The response has the same data as from initiating a collection exception the transaction id which is returned as:

```java
response.getData().getTransaction().getAirtel_money_id();
```

### Transaction inquiry

Make a transaction inquiry with the following:

```java
CollectionResponse response;
response = transactionInquiry.make("transaction_id");
```

Handle Exception:
```java
try{
    response = transactionInquiry.make("transaction_id");
}catch (CollectionException exception){
    System.out.println(exception.getMessage());
}
```

Get status of the transaction from the response:
```java
response.getData().getTransaction().getStatus();
```

More Products in the API will be added soon.
For now, if you wish to use it, download it and compile it locally into a jar that you can import.
Otherwise, a package is coming soon after setting up and passing tests.
