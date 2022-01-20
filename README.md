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
### Initial setup

Add required dependencies
```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.22</version>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-webflux</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-cache</artifactId>
</dependency>
```
Scan for components in the package from your main class

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

## Products
### Collection 
Initiate a collection request with the following:

```java
@Autowired
Collection collection;

CollectionResponse response;

response = collection.initiate("notes", "75*******", 1000.0, "YOUR_INTERNAL_GENERATED_TRANSACTION_ID");
```

Handle Exception:
```java
try{
    response = collection.initiate("notes", "75*******", 1000, "YOUR_INTERNAL_GENERATED_TRANSACTION_ID");
} catch(AirtelException exception){
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

Perform a refund with the following:

```java
CollectionResponse response;
response = collection.refund("transaction_id");
```

The response has the same data as from initiating a collection except the transaction id which is returned as:

```java
response.getData().getTransaction().getAirtel_money_id();
```

Check status of a transaction:

```java
CollectionResponse response;
response = collection.checkStatus("transaction_id");
```

Get status of the transaction from the response:
```java
response.getData().getTransaction().getStatus();
```

### Disbursement

Initiate a disbursement:

```java
@Autowired
Disbursement disbursement;

disbursement.initiate("notes", "75******", "PIN", 500, "transaction_id");
```

Check status of disbursement

```java
disbursement.checkStatus("transaction_id")
```

### Cash In

Initiate a cash in:

```java
@Autowired
CashIn cashIn;

HashMap<String, String> additional_info = new HashMap<>();
additional_info.put("remark", "Airtime");

cashIn.initiate("75******", 50, additional_info, "notes", "PIN", "transaction_id");
```

Check status of cash in:
```java
cashIn.checkStatus("transaction_id")
```

### Cash Out
Initiate a cash out:

```java
@Autowired
CashOut cashOut;

HashMap<String, String> additional_info = new HashMap<>();
additional_info.put("remark", "Airtime");

cashOut.initiate("75******", 50, additional_info, "notes", "transaction_id");
```

Check status of cash in:
```java
cashOut.checkStatus("transaction_id")
```

### Remittance
Check eligibility of a user to receive money:

**Note:** the amount required by the method won't be deducted, but it's required by the Airtel API to complete the request
```java
@Autowired
Remittance remittance;

remittance.checkEligibility(500, "75*******");
```

### Conclusion
If you wish to use the package, download it and compile it locally into a jar with the following command:
```
mvn install
```
The jar will be created under `/target`, You can then import the created jar into your project.
I will upload it to maven central when it's tested well.