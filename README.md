🌦️ Weather Forecast Application

A simple yet powerful Android application built using Java and Android Studio, designed to provide real-time weather information for any city entered by the user.
The app integrates the OpenWeatherMap API to fetch live weather details such as temperature, humidity, wind speed, sea level, and weather conditions (like rain, clear sky, or cloudiness).

This project demonstrates API integration, JSON parsing, and modern Android development practices such as ViewBinding and Geocoder.

📱 Features

Current Weather Display
Shows temperature, humidity, wind speed, pressure, cloud percentage, and city name.

City Search
Enter a city name and instantly fetch weather details.

Dynamic Updates
Real-time updates whenever a new city is searched.

Weather Icons
Displays weather icons dynamically based on the API response.

Error Handling
Invalid city names or network issues are handled gracefully with Toast messages.

Responsive UI
Clean and user-friendly layout built with ConstraintLayout, CardView, TextView, and ImageView.

🛠️ Technologies Used
Programming Language

Java – Core logic for Android development

Android Components

MainActivity – Handles UI and data fetching

ViewBinding – Type-safe access to layout components

Geocoder – Converts city names to latitude & longitude

External Libraries / Tools

Retrofit2 – For making API requests

Gson – For JSON parsing

OpenWeatherMap API – Provides real-time weather data

UI & Design

ConstraintLayout – Responsive design

CardView, TextView, ImageView – For displaying weather data and icons

⚙️ How It Works

User enters a city name in the search bar.

The app uses Retrofit to call the OpenWeatherMap API.

API response (JSON) is parsed with Gson into a custom WeatherResponse model.

Weather details are displayed in real-time on the main screen.

Weather icon is dynamically fetched using the icon code from API.

📸 Screens (Example Output)

Main Screen: Search bar + weather details

Weather Display: Temperature, humidity, wind, sea level, icons

(Add screenshots here if available)

🚀 Installation & Setup

Clone the repository:

git clone https://github.com/your-username/WeatherApp.git


Open in Android Studio.

Add your OpenWeatherMap API key in the code.

Build and run the project on an Android device or emulator.

📚 References

OpenWeatherMap API Documentation

Android Developers – Official Documentation

Retrofit Documentation

Gson – JSON Parser for Java

Android Studio – Official IDE

Stack Overflow
 – Debugging help

YouTube Tutorials – For basic structure and Retrofit integration

✅ Conclusion

The Weather Forecast Application effectively demonstrates Android development concepts such as API integration, JSON parsing, Retrofit usage, ViewBinding, and Geocoder.
It provides a practical and informative solution for real-time weather monitoring, making it an excellent college-level project.
