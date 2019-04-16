package com.antke.website.model.bean;

import java.io.Serializable;
import java.util.List;



public class PageInfo<T> implements Serializable {

	private int currentPage;//当前页
	private int pageSize = 10;//显示信息数量
	private int totalPage;//总页数
	private int totalRecord;//总数据数量
	private List<T> datas;//储存查询出来的数据

//	定义默认构造函数
	public PageInfo() {
	}

	/**
	 * 设置当前页
	 * @param currentPage String类型便于界面赋值
	 */
	public void setCurrentPage(String currentPage) {
		int temp = Integer.valueOf(currentPage);
		this.currentPage = temp;
	}
	
	/**
	 * 数据库操作函数
	 */
//	定义数据库初始化函数
	public void init(String currentPage, int totalRecord, List<T> datas){
//		 设置当前页 
		this.setCurrentPage(currentPage);
//		 设置总记录数 
		this.totalRecord = totalRecord;
//		 设置总页数  
		this.setTotalPage();
//		设置查询数据
		this.datas = datas;
	}
	
//	设置总页数
	public void setTotalPage(){
		if(totalRecord != 0){
			if(totalRecord % pageSize == 0){
				totalPage = totalRecord / pageSize;
			}else{
				totalPage = totalRecord / pageSize + 1;
			}
		}else{
			totalPage = 1;
		}
	}
	
//	获取起始行
	public int getStartRow(){
		return (currentPage - 1) * pageSize;
	}
	
//	获取每页显示条数  
	public int getPageSize() {
		return pageSize;
	}
	
//	封装数据列表
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	//修改每页条数
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 界面操作函数
	 */
//	获取当前页
	public int getCurrentPage() {
		return currentPage;
	}
	
//	查询总页数
	public int getTotalPage() {
		return totalPage;
	}

//	界面获取数据列表
	public List<T> getDatas() {
		return datas;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	
	
	
}
