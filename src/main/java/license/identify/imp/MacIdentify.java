package license.identify.imp;

import java.net.InetAddress;
import java.net.NetworkInterface;

import license.identify.IUniqueIdentify;

public class MacIdentify implements IUniqueIdentify{
	
	public String UniqueCode(){
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			byte[] mac = NetworkInterface.getByInetAddress(inetAddress)
			          .getHardwareAddress();
			 StringBuilder sb = new StringBuilder();
		      for (int i = 0; i < mac.length; i++) {
		        if (i != 0) {
		          sb.append("-");
		        }
		        // mac[i] & 0xFF 是为了把byte转化为正整数
		        String s = Integer.toHexString(mac[i] & 0xFF);
		        sb.append(s.length() == 1 ? 0 + s : s);
		      }
		     String  macAddress = sb.toString().trim().toUpperCase();
			return macAddress;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
