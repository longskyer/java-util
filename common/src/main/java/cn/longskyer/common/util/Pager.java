package cn.longskyer.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pager {
	
	private int start; // 开始条数
	private int end; // 结束条数
	private int totalPage; // 总页数
	private int currentPage=1; // 当前页
	private long totalRow; // 总记录数
	private int limit = 10; // 每页显示数量
	private Map<Object, Object> queryConditions = new HashMap<Object, Object>(); // 查询条件
	private List<Object> list;  //查询数据/当前页的数据
 
	public List<Object> getList() {
		return list;
	}
 
	public void setList(List<Object> list) {
		this.list = list;
	}
 
	public int getStart() {
		return start;
	}
 
	public int getEnd() {
		return end;
	}
 
	public int getTotalPage() {
		return totalPage;
	}
 
	public int getcurrentPage() {
		return currentPage;
	}
 
	public long getTotalRow() {
		return totalRow;
	}
 
	public int getLimit() {
		return limit;
	}
 
	public void setStart(int start) {
		this.start = start;
	}
 
	public void setEnd(int end) {
		this.end = end;
	}
 
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
 
	public void setcurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
 
	public void setTotalRow(long totalRow) {
		this.totalRow = totalRow;
		this.totalPage = (int) (totalRow / limit);
		if (totalRow % limit > 0)
			this.totalPage = this.totalPage + 1;		
		this.currentPage = (currentPage <= 0) ? 1 : currentPage;	
		if (this.currentPage > this.totalPage)
			this.currentPage = this.totalPage;
		if(totalPage==0){
			this.currentPage=1;
		}
		this.start = (this.currentPage - 1) * limit;
		this.end = this.start + limit-1;
	}
 
	public void setLimit(int limit) {
		this.limit = limit;
	}
 
	public Pager() {
		super();
	}
 
	public Map<Object, Object> getQueryConditions() {
		return queryConditions;
	}
 
	public void setLink(Map<Object, Object> queryConditions) {
		this.queryConditions = queryConditions;
	}

}
