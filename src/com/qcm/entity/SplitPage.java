package com.qcm.entity;

import java.util.List;

public class SplitPage {

	// 当前页
	private int curPage = 1;
	// 最大页数
	private int maxPage;
	// 每页显示数量
	private int pageSize;
	// 总数据量
	private int totalNum;
	// 每页的数据
	private List<News> list;
	// 搜索标题关键字
	private String titleKey;

	public int getCurPage() {
		if (curPage < 1) {
			curPage = 1;
		}
		if (curPage > getMaxPage()) {
			curPage = getMaxPage();
		}
		return curPage;
	}

	public void setCurPage(int curPage) {
		
		this.curPage = curPage;
	}

	public int getMaxPage() {
		maxPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum
				/ pageSize + 1;
		if(maxPage < 1){
			maxPage = 1;
		}
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public List<News> getList() {
		return list;
	}

	public void setList(List<News> list) {
		this.list = list;
	}

	public String getTitleKey() {
		return titleKey;
	}

	public void setTitleKey(String titleKey) {
		this.titleKey = titleKey;
	}

}
