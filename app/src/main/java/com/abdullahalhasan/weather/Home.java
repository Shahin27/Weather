package com.abdullahalhasan.weather;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Icon;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawer;

    public TextView weatherStatTV;
    public TextView temperatureTV;
    public TextView weatherDescriptionTV;
    public TextView pressureTV;
    public TextView humidityTV;
    public TextView temperatureMinTV;
    public TextView temperatureMaxTV;
    public TextView windSpeedTV;
    public TextView windAngleTV;
    public TextView cityNameTV;
    public TextView countryNameTV;
    public TextView sunsetTV;
    public TextView sunriseTV;
    public ImageView mainImageView;

    public TextView temperatureTV2;
    public TextView temperatureTV3;
    public TextView temperatureTV4;
    public TextView temperatureTV5;
    public TextView temperatureTV6;
    public TextView weatherStatTV2;
    public TextView weatherStatTV3;
    public TextView weatherStatTV4;
    public TextView weatherStatTV5;
    public TextView weatherStatTV6;
    public TextView day2;
    public TextView day3;
    public TextView day4;
    public TextView day5;
    public TextView day6;

    LocationManager manager;

    private String forecastURL;
    private String dhakaURL;
    private String rajshahiURL;
    private String rangpurURL;
    private String sylhetURL;
    private String chittagongURL;
    private String khulnaURL;
    private String barishalURL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        weatherStatTV = (TextView) findViewById(R.id.weatherStatusText);
        temperatureTV = (TextView) findViewById(R.id.temperatureText);
        weatherDescriptionTV = (TextView) findViewById(R.id.descriptionTV);
        pressureTV = (TextView) findViewById(R.id.pressureText);
        humidityTV = (TextView) findViewById(R.id.humidityText);
        temperatureMinTV = (TextView) findViewById(R.id.tempMinText);
        temperatureMaxTV = (TextView) findViewById(R.id.tempMaxText);
        windSpeedTV = (TextView) findViewById(R.id.windSpeedText);
        windAngleTV = (TextView) findViewById(R.id.windAngleText);
        cityNameTV = (TextView) findViewById(R.id.cityNameText);
        countryNameTV = (TextView) findViewById(R.id.countryText);
        sunsetTV = (TextView) findViewById(R.id.sunsetText);
        sunriseTV = (TextView) findViewById(R.id.sunriseText);
        mainImageView = (ImageView) findViewById(R.id.weatherStatusImage);

        temperatureTV2 = (TextView) findViewById(R.id.secondTemp);
        temperatureTV3 = (TextView) findViewById(R.id.thirdTemp);
        temperatureTV4 = (TextView) findViewById(R.id.fourthTemp);
        temperatureTV5 = (TextView) findViewById(R.id.fifthTemp);
        temperatureTV6 = (TextView) findViewById(R.id.sixthTemp);

        weatherStatTV2 = (TextView) findViewById(R.id.secondStatus);
        weatherStatTV3 = (TextView) findViewById(R.id.thirdStatus);
        weatherStatTV4 = (TextView) findViewById(R.id.fourthStatus);
        weatherStatTV5 = (TextView) findViewById(R.id.fifrthStatus);
        weatherStatTV6 = (TextView) findViewById(R.id.sixthStatus);

        day2 = (TextView) findViewById(R.id.secoundDay);
        day3 = (TextView) findViewById(R.id.thirdDay);
        day4 = (TextView) findViewById(R.id.fourthDay);
        day5 = (TextView) findViewById(R.id.fifthDay);
        day6 = (TextView) findViewById(R.id.sixthDay);

        /*manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        String provider = manager.getBestProvider(new Criteria(), false);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = manager.getLastKnownLocation(provider);

        Double lat=location.getLatitude();
        Double lon=location.getAltitude();*/

        forecastURL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20%28select%20woeid%20from%20geo.places%281%29%20where%20text%3D%22nome%2C%20ak%22%29&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        dhakaURL = "http://api.openweathermap.org/data/2.5/weather?lat=23.7104&lon=90.40744&appid=abe177becc14b8ba94a7f11e0bd2e1bb";
        rajshahiURL = "http://api.openweathermap.org/data/2.5/weather?lat=24.3636&lon=88.6241&appid=abe177becc14b8ba94a7f11e0bd2e1bb";
        rangpurURL = "http://api.openweathermap.org/data/2.5/weather?lat=25.7468&lon=89.2508&appid=abe177becc14b8ba94a7f11e0bd2e1bb";
        sylhetURL = "http://api.openweathermap.org/data/2.5/weather?lat=24.9045&lon=91.8611&appid=abe177becc14b8ba94a7f11e0bd2e1bb";
        chittagongURL = "http://api.openweathermap.org/data/2.5/weather?lat=22.3475&lon=91.8123&appid=abe177becc14b8ba94a7f11e0bd2e1bb";
        khulnaURL = "http://api.openweathermap.org/data/2.5/weather?lat=22.8456&lon=89.5403&appid=abe177becc14b8ba94a7f11e0bd2e1bb";
        barishalURL = "http://api.openweathermap.org/data/2.5/weather?lat=22.7029&lon=90.3466&appid=abe177becc14b8ba94a7f11e0bd2e1bb";


        getWeaterStatus(dhakaURL, forecastURL);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.dhakaCity) {
            drawer.closeDrawer(GravityCompat.START);
            getWeaterStatus(dhakaURL, forecastURL);

        } else if (id == R.id.rajshahiCity) {
            drawer.closeDrawer(GravityCompat.START);
            getWeaterStatus(rajshahiURL, forecastURL);

        } else if (id == R.id.rangpurCity) {
            drawer.closeDrawer(GravityCompat.START);
            getWeaterStatus(rangpurURL, forecastURL);

        } else if (id == R.id.sylhetCity) {
            drawer.closeDrawer(GravityCompat.START);
            getWeaterStatus(sylhetURL, forecastURL);

        } else if (id == R.id.chittagongCity) {
            drawer.closeDrawer(GravityCompat.START);
            getWeaterStatus(chittagongURL, forecastURL);

        } else if (id == R.id.khulnaCity) {
            drawer.closeDrawer(GravityCompat.START);
            getWeaterStatus(khulnaURL, forecastURL);

        } else if (id == R.id.barishalCity) {
            drawer.closeDrawer(GravityCompat.START);
            getWeaterStatus(barishalURL, forecastURL);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getWeaterStatus(String firstURL, String forecastURL) {

        final JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, firstURL, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {

                    //Getting Weather Array

                    JSONArray weatherArray = response.getJSONArray("weather");

                    //Getting  Weather Object

                    JSONObject weatherObject = weatherArray.getJSONObject(0);

                    //Getting Weather Status

                    String weatherStatus = weatherObject.getString("main");
                    weatherStatTV.setText(weatherStatus);

                    if (weatherStatus == "Rain") {
                        mainImageView.setImageResource(R.drawable.rain);
                    } else if (weatherStatus == "Cloudy") {
                        mainImageView.setImageResource(R.drawable.cloudy_day);
                    } else if (weatherStatus == "Clear") {
                        mainImageView.setImageResource(R.drawable.cloudy);
                    } else if (weatherStatus == "Sunny") {
                        mainImageView.setImageResource(R.drawable.sun);
                    }


                    //Getting Weather Description

                    String weatherDescription = weatherObject.getString("description");

                    weatherDescriptionTV.setText(weatherDescription);


                    //Getting Main Object

                    JSONObject mainObject = response.getJSONObject("main");

                    //Getting Current Temperature

                    int temp = mainObject.getInt("temp");
                    temp = temp - 273;
                    temperatureTV.setText(String.valueOf(temp) + "ºC");

                    //Getting Air Pressure

                    int pressure = mainObject.getInt("pressure");
                    pressureTV.setText(String.valueOf(pressure) + "mBar");

                    //Getting Humidity

                    int humidity = mainObject.getInt("humidity");
                    humidityTV.setText(String.valueOf(humidity) + "%");

                    //Getting Min Temperature

                    int tempMin = mainObject.getInt("temp_min");
                    tempMin = tempMin - 273;
                    temperatureMinTV.setText(String.valueOf(tempMin) + "ºC");

                    //Getting Max Temperature

                    int tempMax = mainObject.getInt("temp_max");
                    tempMax = tempMax - 273;
                    temperatureMaxTV.setText(String.valueOf(tempMax) + "ºC");

                    //Getting Wind Object

                    JSONObject windObject = response.getJSONObject("wind");

                    //Getting Wind Speed
                    Double windSpeed = windObject.getDouble("speed");
                    int speed = (int) (windSpeed * 2.2369);
                    windSpeedTV.setText(String.valueOf(speed) + "MPH");

                    //Getting Wind Angle
                    int windAngle = windObject.getInt("deg");
                    windAngleTV.setText(String.valueOf(windAngle) + "º");

                    //Getting System Object
                    JSONObject sysObj = response.getJSONObject("sys");

                    //Getting Country Name

                    String countryName = sysObj.getString("country");
                    countryNameTV.setText(countryName);

                    //Getting Sunrise Time

                    long sunriseUnixTime = sysObj.getLong("sunrise");

                    Date sunriseTime = new Date(sunriseUnixTime * 1000L); // *1000 is to convert seconds to milliseconds
                    SimpleDateFormat sdf = new SimpleDateFormat("h:mm a"); // the format of your date/time
                    sdf.setTimeZone(TimeZone.getTimeZone("GMT+6")); // give a timezone reference for formating
                    String formattedSunriseTime = sdf.format(sunriseTime);
                    sunriseTV.setText(formattedSunriseTime);


                    //Getting Sunrise Time

                    long sunsetUnixTime = sysObj.getLong("sunset");

                    Date sunsetTime = new Date(sunsetUnixTime * 1000L); // *1000 is to convert seconds to milliseconds
                    SimpleDateFormat sunsetsdf = new SimpleDateFormat("h:mm a"); // the format of your date/time
                    sunsetsdf.setTimeZone(TimeZone.getTimeZone("GMT+6")); // give a timezone reference for formating
                    String formattedSunsetTime = sunsetsdf.format(sunsetTime);
                    sunsetTV.setText(formattedSunsetTime);


                    //Getting City Name

                    String cityName = response.getString("name");
                    cityNameTV.setText(cityName);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof NoConnectionError) {
                    Toast.makeText(getBaseContext(), "Connection Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

        final JsonObjectRequest forecastRequest = new JsonObjectRequest(Request.Method.GET, forecastURL, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {

                try {

                    //Getting Querry Object
                    JSONObject querryObject = response.getJSONObject("query");
                    //Getting Result Object
                    JSONObject resultObject = querryObject.getJSONObject("results");
                    //Getting Channel Object
                    JSONObject channelObject = resultObject.getJSONObject("channel");
                    //Getting Item Object
                    JSONObject itemObject = channelObject.getJSONObject("item");
                    //Getting Forecast Array
                    JSONArray forcastArray = itemObject.getJSONArray("forecast");
                    //Getting Forecast Object
                    ArrayList<String> dayList = new ArrayList();
                    ArrayList<String> statusList = new ArrayList();
                    ArrayList<String> tempList = new ArrayList();

                    for (int i = 0; i < forcastArray.length(); i++) {
                        JSONObject forecastObject = forcastArray.getJSONObject(i);
                        String day = forecastObject.getString("day");
                        dayList.add(day);
                        String status = forecastObject.getString("text");
                        statusList.add(status);
                        String temp = forecastObject.getString("high");
                        tempList.add(temp);
                    }

                    //Show Days
                    String showDay2 = String.valueOf(dayList.get(2));
                    day2.setText(showDay2 + "Day");
                    String showDay3 = String.valueOf(dayList.get(3));
                    day3.setText(showDay3 + "day");
                    String showDay4 = String.valueOf(dayList.get(4));
                    day4.setText(showDay4 + "day");
                    String showDay5 = String.valueOf(dayList.get(5));
                    day5.setText(showDay5 + "day");
                    String showDay6 = String.valueOf(dayList.get(6));
                    day6.setText(showDay6 + "day");

                    //Show Temps
                    String showTemps2 = String.valueOf(tempList.get(2));
                    temperatureTV2.setText(showTemps2 + " ºC");
                    String showTemps3 = String.valueOf(tempList.get(3));
                    temperatureTV3.setText(showTemps3 + " ºC");
                    String showTemps4 = String.valueOf(tempList.get(4));
                    temperatureTV4.setText(showTemps4 + " ºC");
                    String showTemps5 = String.valueOf(tempList.get(5));
                    temperatureTV5.setText(showTemps5 + " ºC");
                    String showTemps6 = String.valueOf(tempList.get(6));
                    temperatureTV6.setText(showTemps6 + " ºC");

                    //Show Status
                    String showSts2 = String.valueOf(statusList.get(2));
                    weatherStatTV2.setText(showSts2);
                    String showSts3 = String.valueOf(statusList.get(3));
                    weatherStatTV3.setText(showSts3);
                    String showSts4 = String.valueOf(statusList.get(4));
                    weatherStatTV4.setText(showSts4);
                    String showSts5 = String.valueOf(statusList.get(5));
                    weatherStatTV5.setText(showSts5);
                    String showSts6 = String.valueOf(statusList.get(6));
                    weatherStatTV6.setText(showSts6);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof NoConnectionError) {
                    Toast.makeText(getBaseContext(), "Connection Error", Toast.LENGTH_SHORT).show();
                }

            }
        });


        AppController.getInstance().addToRequestQueue(request, forecastRequest);
    }

}
