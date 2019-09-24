package com.liangzai.springboot.controller;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liangzai.springboot.util.IPUtil;

@RestController
public class RquestController {
	
	@RequestMapping("/request")
	public String index(HttpServletRequest request, HttpServletResponse response){
		StringBuilder sb = new StringBuilder();
		sb.append("<font color='red'>Headers :</font><br>");
		sb.append(getHeader(request));
		
		sb.append("<br><font color='red'>IP : </font>").append(IPUtil.getIpAddr(request)).append("<br>");
		sb.append(getIP(request));
		
		sb.append("<br><font color='red'>Parameter :</font><br>");
		sb.append(getParam(request));
		
		sb.append("<br>");
		sb.append("Scheme : " + request.getScheme()).append("<br>");
		sb.append("ServerName : " + request.getServerName()).append("<br>");
		sb.append("ServerPort : " + request.getServerPort()).append("<br>");
		sb.append("ServletPath : " + request.getServletPath()).append("<br>");
		sb.append("DispatcherType : " + request.getDispatcherType().name()).append("<br>");
		
		sb.append("<br>");
		sb.append("AuthType : " + request.getAuthType()).append("<br>");
		sb.append("Method : " + request.getMethod()).append("<br>");
		sb.append("CharacterEncoding : " + request.getCharacterEncoding()).append("<br>");
		sb.append("ContentType : " + request.getContentType()).append("<br>");
		sb.append("ContentLength : " + request.getContentLength()).append("<br>");
		sb.append("ContextPath : " + request.getContextPath()).append("<br>");
		sb.append("UserPrincipal : " + request.getUserPrincipal()).append("<br>");

		sb.append("<br>");
		sb.append("Protocol : " + request.getProtocol()).append("<br>");
		sb.append("RequestURI : " + request.getRequestURI()).append("<br>");
		sb.append("RequestedSessionId : " + request.getRequestedSessionId()).append("<br>");
		sb.append("PathInfo : " + request.getPathInfo()).append("<br>");
		sb.append("PathTranslated : " + request.getPathTranslated()).append("<br>");
		sb.append("QueryString : " + request.getQueryString()).append("<br>");
		
		sb.append("<br>");
		sb.append("LocalAddr : " + request.getLocalAddr()).append("<br>");
		sb.append("LocalName : " + request.getLocalName()).append("<br>");
		sb.append("LocalPort : " + request.getLocalPort()).append("<br>");
		sb.append("RemoteAddr : " + request.getRemoteAddr()).append("<br>");
		sb.append("RemoteHost : " + request.getRemoteHost()).append("<br>");
		sb.append("RemotePort : " + request.getRemotePort()).append("<br>");
		// sb.append("RemoteUser : " + request.getRemoteUser()).append("<br>");
		
		sb.append("<br><font color='red'>Cookies :</font><br>");
		sb.append(getCookies(request));
		return sb.toString();
	}
	
	private String getIP(HttpServletRequest request){
		StringBuilder sb = new StringBuilder();
		sb.append("Cdn-Src-Ip : ").append(request.getHeader("Cdn-Src-Ip")).append("<br>");
		sb.append("X-Forwarded-For : ").append(request.getHeader("X-Forwarded-For")).append("<br>");
		sb.append("X-Real-IP : ").append(request.getHeader("X-Real-IP")).append("<br>");
		sb.append("Proxy-Client-IP : ").append(request.getHeader("Proxy-Client-IP")).append("<br>");
		sb.append("WL-Proxy-Client-IP : ").append(request.getHeader("WL-Proxy-Client-IP")).append("<br>");
		sb.append("RemoteAddr : ").append(request.getRemoteAddr()).append("<br>");
		
		return sb.toString();
	}
	
	private String getParam(HttpServletRequest request){
		StringBuilder sb = new StringBuilder();
		Map<String, String[]> map = request.getParameterMap();
		if(map != null){
			for(String key : map.keySet()){
				sb.append(key).append(" : ");
				String[] values = map.get(key);
				for(String v : values){
					sb.append(v).append(" ,");
				}
				sb.append("<br>");
			}
		}
		return sb.toString();
	}
	
	private String getCookies(HttpServletRequest request){
		StringBuilder sb = new StringBuilder();
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
			return sb.toString();
		}
		for(Cookie c : cookies){
			sb.append(c.getName()).append(" : ").append(c.getValue()).append(" : ");
			sb.append(c.getDomain()).append(" : ").append(c.getMaxAge()).append("<br>");
		}
		return sb.toString();
	}
	
	private String getHeader(HttpServletRequest request){
		Enumeration<String> enumer = request.getHeaderNames();
		StringBuilder sb = new StringBuilder();

		while(enumer.hasMoreElements()){
			String name = enumer.nextElement();
			sb.append(name).append(" : ");
			sb.append(request.getHeader(name)).append("<br>");
		}
		
		return sb.toString();
	}

}
