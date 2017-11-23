package PruebaWorkbook.app;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MAC{
private InetAddress ip;
private String mac;

   public MAC(){

	   try {

		ip = InetAddress.getLocalHost();
		NetworkInterface network = NetworkInterface.getByInetAddress(ip);

		byte[] mac = network.getHardwareAddress();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
		}
		this.mac = sb.toString();
	} catch (UnknownHostException e) {

		e.printStackTrace();

	} catch (SocketException e){

		e.printStackTrace();

	}

   }
   
   public String getMAC() {
	   return this.mac;
	   
   }
   
   public int getSerial () {
	   
	   int serial = 0;
	   for (int i = 0; i< mac.length(); i++) {
		 serial = serial + mac.charAt(i);
	   }
	   return serial;
   }

}