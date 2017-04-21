package restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class NetClientGet {

	public String sendGet(String url) throws Exception {

		URL url1 = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));
		String output;
		String jsonArr = "";
		while ((output = br.readLine()) != null) {
			jsonArr += output;
		}
		return jsonArr;
	}

	public String getLocation(String jsonArr) throws ParseException {
		Double lat = null;
		Double lng = null;
		JSONParser parser = new JSONParser();
		JSONArray jA = (JSONArray) parser.parse(jsonArr);
		Iterator<?> i = jA.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			JSONObject event = (JSONObject) innerObj.get("event");
			lat = (Double) event.get("lat");
			lng = (Double) event.get("lng");
		}
		return "[" + lat + "," + lng + "]";
	}

	public Double getLng(String jsonArr) throws ParseException {
		Double lng = null;
		JSONParser parser = new JSONParser();
		JSONArray jA = (JSONArray) parser.parse(jsonArr);
		Iterator<?> i = jA.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			JSONObject event = (JSONObject) innerObj.get("event");
			lng = (Double) event.get("lng");
		}
		return lng;
	}

	public Double getLat(String jsonArr) throws ParseException {
		Double lat = null;

		JSONParser parser = new JSONParser();
		JSONArray jA = (JSONArray) parser.parse(jsonArr);
		Iterator<?> i = jA.iterator();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			JSONObject event = (JSONObject) innerObj.get("event");
			lat = (Double) event.get("lat");
		}
		return lat;
	}

	public String getUserName(String jsonArr) throws ParseException {
		String username = null;
		JSONParser parser = new JSONParser();
		JSONArray jA = (JSONArray) parser.parse(jsonArr);
		Iterator<?> i = jA.iterator();
		String arr = "";
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			JSONObject event = (JSONObject) innerObj.get("event");
			username = (String) event.get("username");

			arr += username + "\n";
		}
		return arr;
	}

	public List<String> getUserNames(String jsonArr) throws ParseException {
		String username = null;
		JSONParser parser = new JSONParser();
		JSONArray jA = (JSONArray) parser.parse(jsonArr);
		Iterator<?> i = jA.iterator();
		List<String> arr = new ArrayList<String>();
		while (i.hasNext()) {
			JSONObject innerObj = (JSONObject) i.next();
			JSONObject event = (JSONObject) innerObj.get("event");
			username = (String) event.get("username");

			arr.add(username);
		}

		return arr;
	}

	public String getUserName1(String jsonArr) throws ParseException {
		String allUserName = "";
		String userName = "";
		JSONParser parser = new JSONParser();
		JSONArray jA = (JSONArray) parser.parse(jsonArr);

		for (int i = 0; i < jA.size(); i++) {
			JSONObject innerObj = (JSONObject) jA.get(i);
			JSONObject event = (JSONObject) innerObj.get("event");
			userName = (String) event.get("username");
			allUserName += userName + ",";
		}

		return allUserName;
	}

	public static void main(String[] args) throws Exception {
		try {

			NetClientGet net = new NetClientGet();
			String jsonArr = net.sendGet("http://192.168.12.124:8008/user/tram");
			System.out.println(jsonArr);
			String userName = net.getUserName1(jsonArr);
			System.out.println(userName);

			System.out.println("--> LIST: ");
			List<String> userNames = net.getUserNames(jsonArr);
			int i = 0;
			for (String userNameX : userNames) {
				System.out.println(i++ + ": " + userNameX);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassCastException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}