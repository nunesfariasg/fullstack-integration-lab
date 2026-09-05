import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient66 {
    public static void main(String[] args) {


        // Creates the http client
        HttpClient client = HttpClient.newHttpClient();

        getRequest(client);
        postRequest(client);
    }

    private static void getRequest(HttpClient client) {

        try {

            // Configure the request to the server address
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:6666/api/helloworld"))
                    .GET() // Define the method
                    .build();

            // Sends the request and receives the response from the server
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Displays the results in the console
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response content: " + response.body());


        } catch (Exception exception) {
            System.err.println("Error in GET request" + exception.getMessage());
        }
    }

    private static void postRequest(HttpClient client) {

        try {

            // Data to be sand
            String dataToSand = "name: mateus, age: 19";

            //configure the request to the server address
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:6666/api/sand"))
                    .headers("Content-Type", "text/plain") // Data type to be sand
                    .POST(HttpRequest.BodyPublishers.ofString(dataToSand)) // Passes the request body
                    .build();

            // Sand and wait for the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Displays what the server response
            System.out.println("Status code: " + response.statusCode());
            System.out.println("Server response: " + response.body());

        }catch (Exception exception) {
            System.err.println("Error in POST request" + exception.getMessage());
        }


    }
}