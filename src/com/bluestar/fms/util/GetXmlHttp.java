package com.bluestar.fms.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;




public class GetXmlHttp{


    public static void main(String[] args) {

    	getXMLData();

    }

    public static void getXMLData(){
    	
    	StringBuilder responseBuilder = new StringBuilder();
    	try {
    	 // Create a URLConnection object for a URL
    	 URL url = new URL( "http://192.172.2.23:8080/geoserver/wfs?request=GetFeature&version=1.1.0&outputFormat=GML2&typeName=topp:networkcoverage,topp:tehsil&bbox=73.07846689124875,33.67929015631999,73.07946689124876,33.68029015632,EPSG:4326" );
    	 URLConnection conn = url.openConnection();
    	 HttpURLConnection httpConn;

    	 httpConn = (HttpURLConnection)conn;
    	 BufferedReader rd = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
    	 String line;

    	 while ((line = rd.readLine()) != null)
    	 {
    	  responseBuilder.append(line + '\n');
    	  System.out.println("responseBuilder :::::"+responseBuilder.toString());
    	 }
    	}
    	catch(Exception e){
    	 System.out.println(e);
    	}
    	
    } 

}
