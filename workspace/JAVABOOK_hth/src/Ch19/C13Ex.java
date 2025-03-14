package Ch19;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class C13Ex {

	public static void main(String[] args) throws IOException, InterruptedException {

		// https://api.openweathermap.org/data/2.5/weather?q=Daegu&units=metric&lang=kr&appid=e3ef06f5e824287e524c96c57275ee57
		String url = "https://api.openweathermap.org/data/2.5/weather";
		String q = "Daegu";	// 지역
		String units = "metric";	// 미터법
		String lang = "kr";	// 국가
		String appid = "e3ef06f5e824287e524c96c57275ee57";

		url += "?q=" + q + "&units=" + units + "&lang=" + lang + "&appid=" + appid;
		System.out.println(url);

		// hr 객체 생성
		HttpRequest hr = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

		// hr 요청/ 응답확인
		HttpClient hc = HttpClient.newHttpClient();

		HttpResponse<String> response = hc.send(hr, HttpResponse.BodyHandlers.ofString());

		// 가공 처리
		ObjectMapper om = new ObjectMapper();

		// Class type
		Root ro = om.readValue(response.body(), Root.class);
		
		// 출력되는 값들
		System.out.printf("도시: %s\n", ro.getName());
		System.out.printf("국가: %s\n", ro.getSys().getCountry());
		System.out.printf("날씨 상태: %s (%s)\n", ro.getWeather().get(0).getMain(), ro.getWeather().get(0).getDescription());
		System.out.printf("현재 온도: %.2f°C (체감: %.2f°C)\n", ro.getMain().getTemp(), ro.getMain().getFeels_like());
		System.out.printf("온도 범위: 최저 %.2f°C / 최고 %.2f°C\n", ro.getMain().getTemp_min(), ro.getMain().getTemp_max());
		System.out.printf("기압: %d hPa, 습도: %d%%\n", ro.getMain().getPressure(), ro.getMain().getHumidity());

		if (ro.getMain().getSea_level() != 0) {
		    System.out.printf("해수면 기압: %d hPa\n", ro.getMain().getSea_level());
		}
		if (ro.getMain().getGrnd_level() != 0) {
		    System.out.printf("지면 기압: %d hPa\n", ro.getMain().getGrnd_level());
		}

		System.out.printf("가시 거리: %,d m\n", ro.getVisibility());
		System.out.printf("구름량: %d%%\n", ro.getClouds().getAll());
		System.out.printf("바람 속도: %.2f m/s (방향: %d°)\n", ro.getWind().getSpeed(), ro.getWind().getDeg());

		if (ro.getWind().getGust() != 0) {
		    System.out.printf("돌풍 속도: %.2f m/s\n", ro.getWind().getGust());
		}
		// 좌표 정보 출력
		System.out.printf("위도: %.2f, 경도: %.2f\n", ro.getCoord().getLat(), ro.getCoord().getLon());

		System.out.printf("일출 시간: %d\n", ro.getSys().getSunrise());
		System.out.printf("일몰 시간: %d\n", ro.getSys().getSunset());
	}

	private static class Clouds {
		
		
		public Clouds(int all) {
			super();
			this.all = all;
		}

		public int all;

		public int getAll() {
			return all;
		}

		public void setAll(int all) {
			this.all = all;
		}
	}

	private static class Coord {
		public double lon;
		public double lat;

		public double getLon() {
			return lon;
		}

		public void setLon(double lon) {
			this.lon = lon;
		}

		public double getLat() {
			return lat;
		}

		public void setLat(double lat) {
			this.lat = lat;
		}
	}

	private static class Main {
		public double temp;
		public double feels_like;
		public double temp_min;
		public double temp_max;
		public int pressure;
		public int humidity;
		public int sea_level;
		public int grnd_level;

		public double getTemp() {
			return temp;
		}

		public void setTemp(double temp) {
			this.temp = temp;
		}

		public double getFeels_like() {
			return feels_like;
		}

		public void setFeels_like(double feels_like) {
			this.feels_like = feels_like;
		}

		public double getTemp_min() {
			return temp_min;
		}

		public void setTemp_min(double temp_min) {
			this.temp_min = temp_min;
		}

		public double getTemp_max() {
			return temp_max;
		}

		public void setTemp_max(double temp_max) {
			this.temp_max = temp_max;
		}

		public int getPressure() {
			return pressure;
		}

		public void setPressure(int pressure) {
			this.pressure = pressure;
		}

		public int getHumidity() {
			return humidity;
		}

		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}

		public int getSea_level() {
			return sea_level;
		}

		public void setSea_level(int sea_level) {
			this.sea_level = sea_level;
		}

		public int getGrnd_level() {
			return grnd_level;
		}

		public void setGrnd_level(int grnd_level) {
			this.grnd_level = grnd_level;
		}

	}

	private static class Root {
		public Coord coord;
		public ArrayList<Weather> weather;
		public String base;
		public Main main;
		public int visibility;
		public Wind wind;
		public Clouds clouds;
		public int dt;
		public Sys sys;
		public int timezone;
		public int id;
		public String name;
		public int cod;

		public Coord getCoord() {
			return coord;
		}

		public void setCoord(Coord coord) {
			this.coord = coord;
		}

		public ArrayList<Weather> getWeather() {
			return weather;
		}

		public void setWeather(ArrayList<Weather> weather) {
			this.weather = weather;
		}

		public String getBase() {
			return base;
		}

		public void setBase(String base) {
			this.base = base;
		}

		public Main getMain() {
			return main;
		}

		public void setMain(Main main) {
			this.main = main;
		}

		public int getVisibility() {
			return visibility;
		}

		public void setVisibility(int visibility) {
			this.visibility = visibility;
		}

		public Wind getWind() {
			return wind;
		}

		public void setWind(Wind wind) {
			this.wind = wind;
		}

		public Clouds getClouds() {
			return clouds;
		}

		public void setClouds(Clouds clouds) {
			this.clouds = clouds;
		}

		public int getDt() {
			return dt;
		}

		public void setDt(int dt) {
			this.dt = dt;
		}

		public Sys getSys() {
			return sys;
		}

		public void setSys(Sys sys) {
			this.sys = sys;
		}

		public int getTimezone() {
			return timezone;
		}

		public void setTimezone(int timezone) {
			this.timezone = timezone;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getCod() {
			return cod;
		}

		public void setCod(int cod) {
			this.cod = cod;
		}

	}

	private static class Sys {
		public String country;
		public int sunrise;
		public int sunset;

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public int getSunrise() {
			return sunrise;
		}

		public void setSunrise(int sunrise) {
			this.sunrise = sunrise;
		}

		public int getSunset() {
			return sunset;
		}

		public void setSunset(int sunset) {
			this.sunset = sunset;
		}

	}

	private static class Weather {
		public int id;
		public String main;
		public String description;
		public String icon;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMain() {
			return main;
		}

		public void setMain(String main) {
			this.main = main;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

	}

	private static class Wind {
		public double speed;
		public int deg;
		public double gust;

		public double getSpeed() {
			return speed;
		}

		public void setSpeed(double speed) {
			this.speed = speed;
		}

		public int getDeg() {
			return deg;
		}

		public void setDeg(int deg) {
			this.deg = deg;
		}

		public double getGust() {
			return gust;
		}

		public void setGust(double gust) {
			this.gust = gust;
		}

	}

}
