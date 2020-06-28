This is a spring boot app using Java 11 and Maven. It requires the lombok plugin to be enabled with your chosen IDE. It also supports Docker.

A springboot app has been created that exposes one endpoint. This endpoint analyses a cve.json file and returns a response with detailes on the severity of the cves published per month for each year.
This endpoint is called using jQuery in the index.html file and then the data is plotted into multple graphs using the Chart.js library.

After cloning the repository from GitHub the project must be built using mvn clean install to generate the cve.plot-0.0.1-SNAPSHOT.jar in the target folder.

Then the app can be run using the docker-compose.yml file if Docker is up and running on your device. Run the "docker-compose up" command in the directory that contains the docker-compose.yml file.
This will build the app image and run it as a container. An alternate way to run the application is to run the Application.java file in your IDE.

After running with either Docker or from Application.java the app will be running on port 8080.

1) Springdoc openapi ui can be accessed using the following link:

   http://localhost:8080/swagger-ui.html

   It documents the get api that retrieves the dates and severity of the cves that have been published.
   
2) The graphs and table can be accessed using the following link:

   http://localhost:8080/index.html
   
   This contains 6 graphs (one for each year) and one table underneath detailing the severity of the cves published for each month.
   
3) Finally the refined data can be retrieved using the following get request url:
   
   http://localhost:8080/analysedCVEData
   
   This is the request url that is used in the index.html file to retrive the data from the spring boot endpoint.
