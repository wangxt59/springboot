package com.website.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.website.service.IGenArea;
import com.website.utils.CommonsUtil;

/**  
 * 描述: 
 * @Company: 博众援创 
 * @author shengtaihua 
 * @date  2018-10-11 
 */
@Controller
@RequestMapping("/genArea")
public class GenAreaAction {
	@Autowired
	private IGenArea genAreaService;
	/**wxt
	 * 地区列表
	 * @return 
	 * @throws IOException 
	 */
	@RequestMapping("/getArea.do")
	@ResponseBody
	public List getArea(@RequestParam Map<String, Object> param) throws IOException{
		String parentId = param.get("parentId")+"";
		if(CommonsUtil.isEmpty(parentId)){
			parentId = "0";//如果传的父结点为空，则默认赋值为中国的父结点，也就是每一级查询所有省份。
		}
    	List list = genAreaService.getArea(parentId);
    	return list;
	}

}
