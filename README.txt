
# CodTech Internship Task-2: REST API Client (Java)

## Description
Java application that fetches weather data from OpenWeatherMap API and displays it in a structured format.

## Instructions

1. Replace `"your_api_key"` in the code with your actual OpenWeatherMap API key.
2. Download `json-20230227.jar` from: https://mvnrepository.com/artifact/org.json/json

## Compile and Run

For Windows CMD:
```
javac -cp .;json-20230227.jar WeatherClient.java
java -cp .;json-20230227.jar WeatherClient
```

For Linux/macOS Terminal:
```
javac -cp .:json-20230227.jar WeatherClient.java
java -cp .:json-20230227.jar WeatherClient
```

## Output Example

```
Weather in Pune:
Temperature: 31.0 °C
Humidity: 54%
Description: scattered clouds
```

