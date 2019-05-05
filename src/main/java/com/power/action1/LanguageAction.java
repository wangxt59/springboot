package com.power.action1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.power.service.IMenuService;
import com.power.service.IPowerGroupService;
import com.power.service.IRolesService;
import com.power.service.IWorkerInfoService;

/**
 * 员工信息类
 * 
 * @author bizf
 */
@Controller
@RequestMapping("/language")
public class LanguageAction {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(LanguageAction.class);
	@Autowired
	private IWorkerInfoService workerInfoService;
	@Autowired
	private IRolesService rolesService;
	@Autowired
	private IPowerGroupService powerGroupService;
	@Autowired
	private IMenuService menuService;
	
	
	private List topMenuList = new ArrayList();//上导航列表
	private List childMenuList = new ArrayList();//做导航列表
	
	
	@RequestMapping("/langsdsChange.do")
	public void langChange(HttpServletRequest request,HttpSession session,String langType){
            
		System.out.print("1111");
            if(langType.equals("zh")){
                Locale locale = new Locale("zh", "CN"); 
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale); 
            }
            else if(langType.equals("en")){
                Locale locale = new Locale("en", "US"); 
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
            }
            else 
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,LocaleContextHolder.getLocale());
            
    }

	
	
}
