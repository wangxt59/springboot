package com.website.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.bean.PlatTeamDetails;
import com.website.dao.PlatTeamDetailsMapper;
import com.website.service.IPlatTeamDetailsService;
import com.website.utils.CommonsUtil;

@Service
public class PlatTeamDetailsServiceImpl implements IPlatTeamDetailsService {

	@Autowired
	PlatTeamDetailsMapper platTeamDetailsMapper;
	
	/* 
	 * 插入团附件接口
	 * @see com.website.service.IPlatTeamDetailsService#saveTeamDetails(java.util.Map, int)
	 */
	@Override
	public void saveTeamDetails(Map<String, Object> param, int platid) {
		PlatTeamDetails platTeamDetails = new PlatTeamDetails();
		platTeamDetails.setCreateDate(new Date());
		platTeamDetails.setUpdateDate(new Date());
		if(CommonsUtil.isNotEmpty(param.get("teamDescMsg") + "")){
			platTeamDetails.setPteamId(platid);
			platTeamDetails.setDetailsType(1);
			platTeamDetails.setDescription(param.get("teamDescMsg") + "");
			/*if(CommonsUtil.isNotEmpty(param.get("sort") + "")){
				platTeamDetails.setSort(Integer.valueOf(param.get("sort") + ""));
			}*/
			platTeamDetailsMapper.newPlatTeamDetails(platTeamDetails);
		}
		if(CommonsUtil.isNotEmpty(param.get("imgUrl") + "")){
			platTeamDetails.setPteamId(platid);
			platTeamDetails.setDetailsType(4);
			platTeamDetails.setDescription(param.get("imgUrl") + "");
			/*if(CommonsUtil.isNotEmpty(param.get("sort") + "")){
				platTeamDetails.setSort(Integer.valueOf(param.get("sort") + ""));
			}*/
			platTeamDetailsMapper.newPlatTeamDetails(platTeamDetails);
			
		}
		if(CommonsUtil.isNotEmpty(param.get("videoUrl") + "")){
			platTeamDetails.setPteamId(platid);
			platTeamDetails.setDetailsType(3);
			platTeamDetails.setDescription(param.get("videoUrl") + "");
			/*if(CommonsUtil.isNotEmpty(param.get("sort") + "")){
				platTeamDetails.setSort(Integer.valueOf(param.get("sort") + ""));
			}*/
			platTeamDetailsMapper.newPlatTeamDetails(platTeamDetails);
			
		}
		if(CommonsUtil.isNotEmpty(param.get("imgsUrl") + "")){
			String [] details = (param.get("imgsUrl") + "").split(",");
			for (String string : details) {
				platTeamDetails.setPteamId(platid);
				platTeamDetails.setDetailsType(2);
				platTeamDetails.setDescription(string);
				/*if(CommonsUtil.isNotEmpty(param.get("sort") + "")){
					platTeamDetails.setSort(Integer.valueOf(param.get("sort") + ""));
				}*/
				platTeamDetailsMapper.newPlatTeamDetails(platTeamDetails);
			}
		}
	}
	
	@Override
	public List<PlatTeamDetails> selectPlatTeamDetailsList(Map param){
		return platTeamDetailsMapper.selectPlatTeamDetailsList(param);
	}
	

}
