package com.antke.website.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.antke.power.model.bean.WorkerInfo;
import com.antke.website.model.bean.Category;
import com.antke.website.model.bean.GoodsInfoWithBLOBs;
import com.antke.website.model.bean.PageInfo;
import com.antke.website.model.bean.PlatTeam;
import com.antke.website.model.bean.PlatTeamDetails;
import com.antke.website.model.bean.PlatTeamGoods;
import com.antke.website.model.bean.PlatTeamRegion;
import com.antke.website.service.IGoodsInfoService;
import com.antke.website.service.IPlatTeamDetailsService;
import com.antke.website.service.IPlatTeamRegionService;
import com.antke.website.service.IPlatTeamService;
import com.antke.website.utils.CommonsUtil;
import com.antke.website.utils.DateUtil;
import com.antke.website.utils.ExcelExportUtil;
import com.antke.website.utils.RandomUtil;


@Controller
@RequestMapping("/platTeam")
public class PlatTeamAction  extends BaseAction {

	@Autowired
	private IPlatTeamService platTeamService;
	@Autowired
	private IPlatTeamRegionService platTeamRegionService;
	@Autowired
	private IPlatTeamDetailsService platTeamDetailsService;
	@Autowired
	private IGoodsInfoService goodsInfoService;
	
//	团购列表 wxt
	@RequestMapping("/platTeamList.do")
	public ModelAndView platTeamList(PageInfo pageInfo,@RequestParam Map<String, Object> param) throws ParseException {
		//status 1 开团中 2 已结束
		//返回结果Map
		Map<String,Object> returnMap = new HashMap<String,Object>();
		if(CommonsUtil.isNotEmpty(param.get("team_name") + "")) {
			returnMap.put("team_name", param.get("team_name") + "");
		}
		if(CommonsUtil.isNotEmpty(param.get("team_code") + "")) {
			returnMap.put("team_code", param.get("team_code") + "");
		}
		if(CommonsUtil.isNotEmpty(param.get("start_time") + "")) {
			returnMap.put("start_time", param.get("start_time") + "");
		}
		if(CommonsUtil.isNotEmpty(param.get("end_time") + "")) {
			returnMap.put("end_time", param.get("end_time") + "");
		}
		//如果是初次访问或新的查询时，重置分页
		if(pageInfo == null || pageInfo.getCurrentPage() == 0){
			pageInfo = new PageInfo<Category>();
			pageInfo.setCurrentPage("1");
		}
		PageInfo<Map> list=platTeamService.selectPlatTeamListByMap(param,pageInfo);
		returnMap.put("pageInfo", pageInfo);
		return new ModelAndView("pteamBuy/teamBuyList.jsp","map",returnMap);
	}
	
//	发布团
	@RequestMapping("/creatPlatTeam.do")
	public void creatTeamBuy(@RequestParam Map<String, Object> param,HttpSession session,HttpServletResponse response) throws UnsupportedEncodingException, ParseException {
		
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		/*if (worker == null) {
			return new ModelAndView("redirect:/login/workLogin.action");
		}*/
		String team_name = param.get("team_name")+"";
		String team_code = param.get("team_code")+"";
		String region_type = param.get("region_type")+"";
		String contact = param.get("contact")+"";
		String startTime = param.get("startTime")+"";
		String endTime = param.get("endTime")+"";
		String logistics_type = param.get("logistics_type")+"";
		
		PlatTeam platTeam = new PlatTeam();
		platTeam.setTeamCode(RandomUtil.getCode_no());
		if (CommonsUtil.isNotEmpty(team_code)) {
			platTeam.setTeamCode(team_code);
		}
		platTeam.setTeamName(team_name);
		if (CommonsUtil.isNotEmpty(region_type)) {
			platTeam.setRegionType(Integer.valueOf(region_type));
		}
		if (CommonsUtil.isNotEmpty(contact)) {
			platTeam.setContact(contact);
		}
		if (CommonsUtil.isNotEmpty(startTime)) {
			platTeam.setStartTime(DateUtil.StrToAllDate(startTime));
		}
		if (CommonsUtil.isNotEmpty(endTime)) {
			platTeam.setEndTime(DateUtil.StrToAllDate(endTime));
		}
		if (CommonsUtil.isNotEmpty(logistics_type)) {
			platTeam.setLogisticsType(Integer.valueOf(logistics_type));
		}
		platTeam.setCreateUser(worker.getWorker_id());
		platTeam.setTeamType(1);
		platTeam.setCreateDate(new Date());
		platTeam.setUpdateDate(new Date());
		int count = platTeamService.savePlatTeam(platTeam);
		if(count>0){
			//保存区域商品信息
			String goodsStrs = "" + param.get("goodsStr");
			String cityIds = ""+param.get("cityIds");
			String cityNames = ""+param.get("cityNames");
			Map reqMap = new HashMap();
			if (CommonsUtil.isNotEmpty(goodsStrs)) {
				String[] goodsStr = goodsStrs.split(",");
				if (CommonsUtil.isNotEmpty(cityIds)&& CommonsUtil.isNotEmpty(cityNames)) {
					String[] cityId = cityIds.split(",");
					String[] cityName =cityNames.split(",");
					for (String goodsCode : goodsStr) {
//						reqMap.clear();
//						reqMap.put("goodsCode", goodsCode);
						GoodsInfoWithBLOBs goodsInfo = goodsInfoService.selectByPrimaryKey(Integer.valueOf(goodsCode));
						if(goodsInfo!=null){
							PlatTeamRegion teamRegion = new PlatTeamRegion();
							
							teamRegion.setGoodsId(goodsInfo.getGoodsId());
							teamRegion.setGoodsName(goodsInfo.getGoodsName());
							teamRegion.setGoodsPic(goodsInfo.getGoodsPic());
							teamRegion.setMarketPrice(goodsInfo.getMarketPrice());
							teamRegion.setPteamId(platTeam.getPteamId());
//							teamRegion.setRebateType(goodsInfo.getReturnType());
//							teamRegion.setRebateValue(goodsInfo.getr);
//							teamRegion.setRegionPrice();
//							teamRegion.setRegionType(Integer.valueOf(goodsInfo.get("region_type") + ""));
							teamRegion.setStock(goodsInfo.getStock());
							for (int i = 0; i < cityId.length; i++) {
								teamRegion.setRegionId(Integer.valueOf(cityId[i]));
								teamRegion.setRegionName(cityName[i]);
								teamRegion.setCreateDate(new Date());
								teamRegion.setUpdateDate(new Date());
								platTeamRegionService.insertPlatTeamRegion(teamRegion);
							}
							PlatTeamGoods platTeamGoods = new PlatTeamGoods();
							platTeamGoods.setGoodsId(goodsInfo.getGoodsId());
							platTeamGoods.setPteamId(platTeam.getPteamId());
							platTeamGoods.setCreateDate(new Date());
							platTeamGoods.setUpdateDate(new Date());
							platTeamService.insertPlatTeamGoods(platTeamGoods);
						}
						
					}
				}
			}
			
			//插入团详情
			platTeamDetailsService.saveTeamDetails(param,platTeam.getPteamId());
			
		}
		
		response(response, "0", "发团成功");
	}

	
	@RequestMapping("/updatePlatTeam.do")
	public void updatePlatTeam(@RequestParam Map<String, Object> param,HttpSession session,HttpServletResponse response) throws UnsupportedEncodingException, ParseException {
		
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		/*if (worker == null) {
			return new ModelAndView("redirect:/login/workLogin.action");
		}*/
		
		
		String pteamId = param.get("pteamId")+"";
		String team_name = param.get("team_name")+"";
		String team_code = param.get("team_code")+"";
		String region_type = param.get("region_type")+"";
		String contact = param.get("contact")+"";
		String startTime = param.get("startTime")+"";
		String endTime = param.get("endTime")+"";
		String logistics_type = param.get("logistics_type")+"";
		
		if(pteamId!=null){
			PlatTeam platTeam = platTeamService.slectPlatTeamByPlatmId(Integer.valueOf(pteamId));
			if(platTeam!=null){
				platTeam.setTeamCode(RandomUtil.getCode_no());
				if (CommonsUtil.isNotEmpty(team_code)) {
					platTeam.setTeamCode(team_code);
				}
				platTeam.setTeamName(team_name);
				if (CommonsUtil.isNotEmpty(region_type)) {
					platTeam.setRegionType(Integer.valueOf(region_type));
				}
				if (CommonsUtil.isNotEmpty(contact)) {
					platTeam.setContact(contact);
				}
				if (CommonsUtil.isNotEmpty(startTime)) {
					platTeam.setStartTime(DateUtil.StrToAllDate(startTime));
				}
				if (CommonsUtil.isNotEmpty(endTime)) {
					platTeam.setEndTime(DateUtil.StrToAllDate(endTime));
				}
				if (CommonsUtil.isNotEmpty(logistics_type)) {
					platTeam.setLogisticsType(Integer.valueOf(logistics_type));
				}
				platTeam.setCreateUser(worker.getWorker_id());
				platTeam.setTeamType(1);
				platTeam.setUpdateDate(new Date());
				int count = platTeamService.updatePlatTeam(platTeam);
				if(count>0){
					int deleteCount = platTeamService.deletePlatTeamGoods(Integer.valueOf(pteamId));
					if(deleteCount>0){
						//保存区域商品信息
						String goodsStrs = "" + param.get("goodsStr");
						String cityIds = ""+param.get("cityIds");
						String cityNames = ""+param.get("cityNames");
						Map reqMap = new HashMap();
						if (CommonsUtil.isNotEmpty(goodsStrs)) {
							String[] goodsStr = goodsStrs.split(",");
							if (CommonsUtil.isNotEmpty(cityIds)&& CommonsUtil.isNotEmpty(cityNames)) {
								String[] cityId = cityIds.split(",");
								String[] cityName =cityNames.split(",");
								for (String goodsCode : goodsStr) {
//									reqMap.clear();
//									reqMap.put("goodsCode", goodsCode);
									GoodsInfoWithBLOBs goodsInfo = goodsInfoService.selectByPrimaryKey(Integer.valueOf(goodsCode));
									if(goodsInfo!=null){
										PlatTeamRegion teamRegion = new PlatTeamRegion();
										
										teamRegion.setGoodsId(goodsInfo.getGoodsId());
										teamRegion.setGoodsName(goodsInfo.getGoodsName());
										teamRegion.setGoodsPic(goodsInfo.getGoodsPic());
										teamRegion.setMarketPrice(goodsInfo.getMarketPrice());
										teamRegion.setPteamId(platTeam.getPteamId());
//										teamRegion.setRebateType(goodsInfo.getReturnType());
//										teamRegion.setRebateValue(goodsInfo.getr);
//										teamRegion.setRegionPrice();
//										teamRegion.setRegionType(Integer.valueOf(goodsInfo.get("region_type") + ""));
										teamRegion.setStock(goodsInfo.getStock());
										for (int i = 0; i < cityId.length; i++) {
											teamRegion.setRegionId(Integer.valueOf(cityId[i]));
											teamRegion.setRegionName(cityName[i]);
											teamRegion.setCreateDate(new Date());
											teamRegion.setUpdateDate(new Date());
											platTeamRegionService.insertPlatTeamRegion(teamRegion);
										}
										PlatTeamGoods platTeamGoods = new PlatTeamGoods();
										platTeamGoods.setGoodsId(goodsInfo.getGoodsId());
										platTeamGoods.setPteamId(platTeam.getPteamId());
										platTeamGoods.setCreateDate(new Date());
										platTeamGoods.setUpdateDate(new Date());
										platTeamService.insertPlatTeamGoods(platTeamGoods);
									}
									
								}
							}
						}
						
						//插入团详情
						platTeamDetailsService.saveTeamDetails(param,platTeam.getPteamId());
					}
					
				}
				
			}
		}
		
		
		
		response(response, "0", "修改团信息成功");
	}
	
	
	/**
	 * 查询平台团详情
	 * @param pteamId
	 * @param session
	 * @param response
	 * @throws UnsupportedEncodingException
	 * @throws ParseException
	 */
	@RequestMapping("/queryPlatTeam.do")
	public ModelAndView queryPlatTeam(String pteamId,String queryType,HttpSession session,HttpServletResponse response) throws UnsupportedEncodingException, ParseException {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		WorkerInfo worker = (WorkerInfo) session.getAttribute("workerInfo");
		/*if (worker == null) {
			return new ModelAndView("redirect:/login/workLogin.action");
		}*/
		if(pteamId!=null && !"".equals(pteamId)){
			PlatTeam platTeam = platTeamService.slectPlatTeamByPlatmId(Integer.valueOf(pteamId));
			Map reqMap = new HashMap();
			reqMap.put("pteamId", pteamId);
			List<PlatTeamRegion> PlatTeamRegionList = platTeamRegionService.selectPlatTeamRegionList(reqMap);
			returnMap.put("platTeam", platTeam);
			returnMap.put("PlatTeamRegionList", PlatTeamRegionList);
			
			List<Map> regionList = platTeamRegionService.selectRegionList(reqMap);
			returnMap.put("regionList", regionList);
			List<PlatTeamDetails> platTeamDetailsList= platTeamDetailsService.selectPlatTeamDetailsList(reqMap);
			Map detailsMap = new HashMap();
			
			List morePicList = new ArrayList();
			if(platTeamDetailsList!=null){
				for(PlatTeamDetails platTeamDetails : platTeamDetailsList){
					int detailsType = platTeamDetails.getDetailsType();//详情类型：1、文字；2、多图；3、视频；4、单图'
					String description = platTeamDetails.getDescription();
					if(detailsType!=2){
						detailsMap.put("detailsType"+detailsType, description);
					}else{
						detailsMap.put(detailsType, "yes");
						Map morepicMap = new HashMap();
						morepicMap.put("description", description);
						morePicList.add(morepicMap);
					}
				}
			}
			returnMap.put("detailsMap", detailsMap);
			returnMap.put("morePicList", morePicList);
			returnMap.put("platTeamDetailsList", platTeamDetailsList);
		}
		if("1".equals(queryType)){
			return new ModelAndView("pteamBuy/teamdetails.jsp", "map", returnMap);
		}else{
			return new ModelAndView("pteamBuy/updateTeamBuy.jsp", "map", returnMap);
		}
		
	}
	
	
	/**
	 * 下载模板
	 * @param param
	 */
	@RequestMapping("/downloadPlateam.do")
	public void downloadPlateam(@RequestParam Map<String, Object> param,HttpServletRequest request,HttpServletResponse response){
		String[] title = { "区域Id", "区域", "商品ID", "商品名称", "市场价","区域价","VIP价","返利", "库存",};
		List<Map> datas = platTeamService.slectAllByPlatmId(Integer.valueOf(param.get("plateamId") + ""));
		PlatTeam platTeam = platTeamService.slectPlatTeamByPlatmId(Integer.valueOf(param.get("plateamId") + ""));
		String [][] content = new String[datas.size()][title.length];
		for (int i = 0; i < datas.size(); i++) {
            content[i] = new String[title.length];
            Map obj = datas.get(i);
            content[i][0] = obj.get("region_id").toString();
            content[i][1] = obj.get("region_name").toString();
            content[i][2] = obj.get("goods_id").toString();
            content[i][3] = obj.get("goods_name").toString();
            content[i][4] = obj.get("market_price").toString();
            content[i][5] = obj.get("market_price").toString();
            content[i][6] = obj.get("market_price").toString();
            if(CommonsUtil.isNotEmpty(obj.get("rebate_value") + "")){
            	content[i][7] = obj.get("rebate_value").toString();
            }else {
            	content[i][7] = "";
            }
            if(CommonsUtil.isNotEmpty(obj.get("stock") + "")){
            	content[i][8] = CommonsUtil.replaceNullToSpace(obj.get("stock").toString());
            }else {
            	content[i][8] = "";
            }
		}
		try {
			 String fileName = platTeam.getTeamName()+platTeam.getTeamCode()+".xls";
			//sheet名
	        String sheetName = platTeam.getTeamName();
	        HSSFWorkbook wb = new HSSFWorkbook();
			ExcelExportUtil.getHSSFWorkbook(sheetName, title, content, wb);
			//响应到客户端
			this.setResponseHeader(response, fileName);
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	//发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
	/**
	 * 上传excal
	 * @param file
	 * @param paramUrl
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/export.action")
	@ResponseBody
    public void export(@RequestParam(value = "file", required = false)MultipartFile file,@RequestParam Map<String, Object> param,
    		HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		int count = platTeamService.export(file,param);
		if(count>0){
			response(response, "0", "上传成功");
		}else{
			response(response, "1", "上传失败");
		}
		
    }  
}
