package com.petmily.common;

public class PageBarTemplate {
	
	public static String getPageBar(String url,int cPage,int numPerPage,int totalData,int totalPage, int pageBarSize, String pageBar) {
		
		int pageNo = ((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd = pageNo + pageBarSize - 1;
		
		if(pageNo==1) {
			pageBar += "<span>[이전]&nbsp&nbsp&nbsp&nbsp</span>";
		}else {
			pageBar += "<a style='text-decoration:none' href='" + url + "?cPage=" + (pageNo-1) + "'>[이전]&nbsp&nbsp&nbsp&nbsp</a>";
		}
		
		while(!(pageNo>totalPage || pageNo>pageEnd)) {
			if(pageNo==cPage) {
				pageBar += "<span>" + pageNo + "&nbsp&nbsp&nbsp&nbsp</span>";
			}else {
				pageBar += "<a style='text-decoration:none' href='" + url + "?cPage=" + pageNo + "'>" + pageNo + "&nbsp&nbsp&nbsp&nbsp</a>";
			}
			pageNo++;
		}
		
		if(pageNo>totalPage) {
			pageBar += "<span>[다음]&nbsp&nbsp&nbsp&nbsp</span>";
		}else {
			pageBar += "<a style='text-decoration:none' href='" + url + "?cPage=" + pageNo + "'>" + "[다음]</a>";
		}
		
	      
		return pageBar;  
	}

}
