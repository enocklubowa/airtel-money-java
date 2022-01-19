# Airtel Money Integration for Java

## Introduction
This is a java library to ease integration of the Airtel Money API into Java applications. 
The complexities of the whole API are simplified into easily usable methods.

**Note:** The library is still in developemnt so I can't guarantee stability.

### Technologies used sofar

- Spring WebFlux for API integration
- JUnit for testing
- [Lombok](https://projectlombok.org/) to avoid writing boilerplate code

### Usage

Initiate a collection request to the user's phone number with the following:

```java
@Autowired
Collection collection;

CollectionResponse response;

response = collection.initiate("Testing transaction", "75*******", 1000, "YOUR_INTERNAL_GENERATED_TRANSACTION_ID");
```

Handle Exceptions:
```java
try{
    response = collection.initiate("Testing transaction", "75*******", 1000, "YOUR_INTERNAL_GENERATED_TRANSACTION_ID");
} catch(CollationException exception){
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

Currently, you can be able to make a collection request.
Still setting up things like transaction inquiry, refunds, disbursement, a batch of refactoring plus tests of course.

Since the library is still in early stages, I will update the readme as we go, and I will finally release it as a dependency when it's stable enough.

For now, if you wish to use it, download it and compile it locally into a jar that you can import.