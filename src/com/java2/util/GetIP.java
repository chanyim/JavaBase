package com.java2.util;

public class GetIP {
	public static String getIP(String ip){
		ip = request.getHeader("X-Real-IP");
		if(ip!=null&&!"".equals(ip)&&!"unknown".equalsIgnoreCase(ip)){
			System.out.println(ip);
		}else{
			ip = request.getHeader("X-Forwarded-For");
			if(ip != null &&!"".equals(ip)&&!"unknown".equalsIgnoreCase(ip)){
				//多次反向代理后会有多个IP值，第一个为真是IP
				int index = ip.indexOf(",");
				if(index != -1){
					System.out.println(ip.substring(0, index));
				}else{
					System.out.println(ip);
				}
			}else{
				System.out.println(request.getRemoteAddr());
			}
		}
	}
}
