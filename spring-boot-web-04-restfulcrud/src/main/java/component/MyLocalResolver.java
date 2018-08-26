package component;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

/**点击链接的时候携带上区域信息即可*/
public class MyLocalResolver implements LocaleResolver{

	 @Override
	    public Locale resolveLocale(HttpServletRequest request) {
	        String lan = request.getParameter("lan");
	        Locale locale = Locale.getDefault();
	        if(!StringUtils.isEmpty(lan)){
	            String[] split = lan.split("_");
	            locale = new Locale(split[0],split[1]);
	        }
	        return locale;
	    }

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// TODO Auto-generated method stub
		
	}
	
}
