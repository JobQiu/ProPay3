package com.qcm.controller;

import java.sql.Timestamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qcm.dao.impl.NewsDaoImpl;
import com.qcm.entity.News;
import com.qcm.entity.SplitPage;

@Controller
@RequestMapping("/news")
public class NewsManageCtrl {

	private SplitPage splitPage;
	private NewsDaoImpl ndi;
	private News news;

	@RequestMapping("/showNews")
	public String showNews(Model model) {
		splitPage.setCurPage(1);
		splitPage.setPageSize(2);
		splitPage.setTitleKey("1");
		String result = ndi.showNews(splitPage);
		model.addAttribute("splitPage", splitPage);
		return result;
	}

	@RequestMapping("/showNewsPage")
	public String showPage(int curPage,String selName,Model model){
		splitPage.setCurPage(curPage);
		splitPage.setPageSize(2);
		splitPage.setTitleKey(selName);
		String result = ndi.showNews(splitPage);
		model.addAttribute("splitPage", splitPage);
		return result;
	}
	
	@RequestMapping(value="/jumpNewsPage",method=RequestMethod.POST)
	public String jumpPage(int curPage1,String selName,Model model){
		splitPage.setCurPage(curPage1);
		splitPage.setPageSize(2);
		splitPage.setTitleKey(selName);
		String result = ndi.showNews(splitPage);
		model.addAttribute("splitPage", splitPage);
		return result;
	}
	
	@RequestMapping("/addNews")
	public void addNews(String title,Timestamp time,String abstract_,String text,Model model){
		news.setTitle(title);
		news.setTime(time);
		news.setAbstract_(abstract_);
		news.setText(text);
		ndi.addNews(news);
		model.addAttribute("Addinfo","添加成功");
	}
	
	@RequestMapping("editNews")
	public void editNews(int id,String title,Timestamp time,String abstract_,String text,Model model){
		news.setId(id);
		news.setTitle(title);
		news.setTime(time);
		news.setAbstract_(abstract_);
		news.setText(text);
		ndi.addNews(news);
		model.addAttribute("Editinfo","修改成功");
	}
	public void delNews(String number){
		ndi.delNews(number);
	}
	
	public SplitPage getSplitPage() {
		return splitPage;
	}

	public void setSplitPage(SplitPage splitPage) {
		this.splitPage = splitPage;
	}

	public NewsDaoImpl getNdi() {
		return ndi;
	}

	public void setNdi(NewsDaoImpl ndi) {
		this.ndi = ndi;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

}
