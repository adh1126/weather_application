package com.example.myweatherapp.Activities;

import android.app.AlertDialog;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherapp.R;
import com.example.myweatherapp.Sys;
import com.example.myweatherapp.databinding.ActivityMainBinding;
import com.example.myweatherapp.model.WeatherResponse;
import com.example.myweatherapp.network.WeatherAPI;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    String ApiKey = "ab067b50c3a84b535d59d1a4ec3406b3";
    String cityName = "Jalna";
    String url = "https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWeather(cityName);

        binding.searchBtn.setOnClickListener(v1 -> {
            EditText input = new EditText(MainActivity.this);
            input.setHint("Enter city name");
            input.setSingleLine(true);

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Search City")
                    .setView(input)
                    .setPositiveButton("Search", (dialog, which) -> {
                        String newCity = input.getText().toString().trim();
                        if (!newCity.isEmpty()) {
                            cityName = newCity; // Update the city
                            getWeather(cityName); // Pass the updated city
                        } else {
                            Toast.makeText(MainActivity.this, "City name cannot be empty", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                    .show();
        });
    }



    private void getWeather(String cityName) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherAPI myApi = retrofit.create(WeatherAPI.class);

        Call<WeatherResponse> call = myApi.weatherResponse(cityName,ApiKey);
        call.enqueue(new
                             Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (!response.isSuccessful()) {
                    if (response.code() == 404) {
                        Toast.makeText(MainActivity.this, "City not found. Please enter a valid city name.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Error code: " + response.code(), Toast.LENGTH_SHORT).show();
                    }
                    return;
                }

                WeatherResponse myData = response.body();
                if (myData == null || myData.getMain() == null) {
                    Toast.makeText(MainActivity.this, "No weather data found for this city.", Toast.LENGTH_SHORT).show();
                    return;
                }

                WeatherResponse.Main main = myData.getMain();
                float temp = main.getTemp();
                Integer temperature = (int)(temp - 273.15);
                binding.TvTemp.setText(String.valueOf(temperature+"°"));

                binding.TvCity.setText(cityName);

                String weatherCondition = myData.weather.get(0).description;
                binding.TvWeatherCondition.setText(weatherCondition);

                if (weatherCondition.equals("clear sky")){
                    binding.IvWeatherImage.setImageResource(R.drawable.sunny);
                }else if(weatherCondition.equals("few clouds")){
                    binding.IvWeatherImage.setImageResource(R.drawable.cloudy_sunny);
                }else if(weatherCondition.equals("broken clouds")){
                    binding.IvWeatherImage.setImageResource(R.drawable.cloud);
                }else if(weatherCondition.equals("scattered clouds")){
                    binding.IvWeatherImage.setImageResource(R.drawable.cloud);
                }else if(weatherCondition.equals("overcast clouds")){
                    binding.IvWeatherImage.setImageResource(R.drawable.cloudy_1);
                }else if(weatherCondition.equals("moderate rain")){
                    binding.IvWeatherImage.setImageResource(R.drawable.rainy);
                }else if(weatherCondition.equals("light rain")){
                    binding.IvWeatherImage.setImageResource(R.drawable.rainy);
                }else if(weatherCondition.equals("heavy intensity rain")){
                    binding.IvWeatherImage.setImageResource(R.drawable.heavy_rain);
                }else if(weatherCondition.equals("very heavy rain")){
                    binding.IvWeatherImage.setImageResource(R.drawable.heavy_rain);
                }else if(weatherCondition.equals("extreme rain")){
                    binding.IvWeatherImage.setImageResource(R.drawable.heavy_rain);
                }else if(weatherCondition.contains("snow")){
                    binding.IvWeatherImage.setImageResource(R.drawable.snowy);
                }


                float feelslike = main.feels_like;
                binding.feelsLike.setText("Feels like: "+(int)(feelslike-273.15)+"°");

                Double windspeed = myData.getWind().getSpeed();
                binding.TvWindSpeed.setText(windspeed+" km/h");

                int humidity = main.humidity;
                binding.TvHumidity.setText(String.valueOf(humidity+"%"));

                if (myData.getRain() != null) {
                    float rainVolume = myData.getRain().getH1(); // mm in last 1 hour
                    binding.TvRainMM.setText(rainVolume + " mm");
                } else {
                    binding.TvRainMM.setText("No rain reported");
                }

                int sunrise = myData.getSys().getSunrise();
                int sunset = myData.getSys().getSunset();
                int timeZone = myData.getTimezone();

                SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
                format.setTimeZone(TimeZone.getTimeZone(cityName));

                String sunriseTime = format.format(new Date((long) (sunrise + timeZone) * 1000));
                String sunsetTime = format.format(new Date((long) (sunset + timeZone) * 1000));

                binding.TvSunrise.setText(sunriseTime);
                binding.TvSunset.setText(sunsetTime);

                int sea_level = myData.getMain().getSeaLevel();

                binding.TvSealevel.setText(String.valueOf(sea_level + " hPa"));

            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
