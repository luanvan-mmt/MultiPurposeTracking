package com.dev.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;

import Decoder.BASE64Encoder;

public class ReadAPIFromURL {
	// get 1 user tu kaa
	public JSONArray getUserKaaApi(String strUrl) {
			String result = "";
			try {
				URL url = new URL(strUrl);
				byte[] auth = "user1:password1".getBytes();
				String encoding = new BASE64Encoder().encode(auth);

				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setDoOutput(true);
				connection.setConnectTimeout(30000);
				connection.setRequestProperty("Authorization", "Basic " + encoding);
				InputStream content = (InputStream) connection.getInputStream();
				BufferedReader in = new BufferedReader(new InputStreamReader(content));
				String line;
				while ((line = in.readLine()) != null) {
					result = result + line;
					// System.out.println(line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			JSONArray array = new JSONArray();
			try {
				array = new JSONArray(result);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return array;
		}
	

	public static void main(String []args){
		String strUrl = "http://192.168.43.103:8080/Map/apiKaa/getAlltUserTrack/cec457653901327bfb6f747d9614e2c183ebc3de";
		JSONArray arr = new ReadAPIFromURL().getUserKaaApi(strUrl);
		System.out.println(arr);
	}
}
