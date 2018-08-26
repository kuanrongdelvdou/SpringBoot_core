package component;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

// 定义我们自己的 ErrorAttribute
@Component
public class MyErrorAttributes extends DefaultErrorAttributes{
	
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		
		Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
		
		// 放入我们自己定制的错误信息.
		map.put("desc", "光年-精灵");
		
		// 我们的异常处理器携带的数据
		Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
		
		map.put("ext", map);
		
		// 返回值的 map 就是页面和 json 能获取的所有字段
		return map;
	}
}
