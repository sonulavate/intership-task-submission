
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherClient {

    // Replace with your actual OpenWeatherMap API key
    static final String API_KEY = "your_api_key";
    static final String CITY = "Pune";

    public static void main(String[] args) {
        try {
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + CITY + "&appid=" + API_KEY + "&units=metric";

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if(responseCode == 200){
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer responseContent = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    responseContent.append(inputLine);
                }
                in.close();

                // Parse JSON
                JSONObject json = new JSONObject(responseContent.toString());
                JSONObject main = json.getJSONObject("main");
                double temp = main.getDouble("temp");
                int humidity = main.getInt("humidity");

                JSONObject weather = json.getJSONArray("weather").getJSONObject(0);
                String description = weather.getString("description");

                System.out.println("Weather in " + CITY + ":");
                System.out.println("Temperature: " + temp + " °C");
                System.out.println("Humidity: " + humidity + "%");
                System.out.println("Description: " + description);

            } else {
                System.out.println("Error: Unable to fetch data. Response Code = " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
