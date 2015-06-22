package org.koushik.javabrains;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import net.webservicex.GeoIPServiceSoap;

/**
 * Testing a SOAP webservice.
 * WSDL: http://www.webservicex.net/geoipservice.asmx?WSDL
 * Link: http://webservicex.net/ws/WSDetails.aspx?CATID=12&WSID=64
 * 
 *
 */
public class IPLocationFinder {

	public static void main(String[] args) {
		if(args.length!=1)
			System.out.println("You need to pass in one IP address.");
		else{
			String ipAddress = args[0];
			GeoIPService ipService = new GeoIPService();
			GeoIPServiceSoap geoIpServiceSoap = ipService.getGeoIPServiceSoap();
			GeoIP geoIp = geoIpServiceSoap.getGeoIP(ipAddress);
			System.out.println(geoIp.getCountryName());
		
		}
	}

}
