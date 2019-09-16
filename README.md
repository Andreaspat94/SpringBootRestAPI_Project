# SpringBootRestApi_Project
 
This is an individual project of a back-end server that 
can communicate with and administrator interface via a REST API.
It is developed with Spring Boot and Maven and uses an embedded database(H2).

## How to run it: </br>
What you need: JDK 1.8 or higher  </br>
		Maven 3.3 ord higher

Open Command line prompt and enter the project file where pom.xml is.
then enter the command:"mvn clean install" or "mvn clean package".
(If you want to build with the regular mvn command, you will need Maven v3.5.0 or above)
A jar excecutable file will be created in target file.
Lastly, excecute that jar with this command: "java -cp target/artifactId-version-SNAPSHOT.jar package.Java-Main-File-Name"


## Functionalities: </br>
The application contains one controller with multiple endpoints that use "ResponseEntity" class to manipulate the HTTP response.
ResponseEntity represents the whole HTTP response: status code, headers, and body.
The controller can do the below functionalities: </br>

- Get all products from the database based on product's ID, name, price(ascending and descending) and code: </br>
	The controller receives one of the following path variables: "name", "id", "code", "price" and sends back the appropriate data.
	In case of "price" variable, the user can add the parameter of "?asc=true" or "?asc=false" to take the data in ascending or 		descending order respectively. If the list is empty it returns a 204 No Content Http status. </br>
 
- Get a selected product by entering the product's code: </br>
	The controller is receiving an integer (product_code) through a GET request and forms a response.
	The Response is sent back with an appropriate message in its body if it doesn't find a product with that code(HTTP_Status = 404 not found).
	If the product is found it responds with a HTTP_Status = 200 OK and the product itself. </br>
	
- Create a product: </br>
	A POST request is being sent in the controller with a product that the client wants to create.
	If the product code already exists it respondes with a 409 CONFLICT status and a message.
	Otherwise, the respond contains the header with the location of the new product and a 201 "Created" status. </br>
	
- Update a product  by entering the product's code: </br>
	A PUT request is being sent it the controller.The client sents the product code of the one that wants to update.
 	If it doesn't find it it returns a 404 status not found and an appropriate message.
	Otherwise, it checks if the new product code is already occupied. If yes, it responds with a 404 status not found and an appropriate message, as well.
	If not, it returns a status 200 OK and the updated product. </br>
	
- Delete a product by entering the product's code: </br>
	The controller receives a DELETE request and the product code of the product that wants to delete.
	If the controller does not found the product it responds with a message and a 404 Not Found Status.
	If the product is found it gets erased and the controller sents back just the httpStatus of 204 No content.



