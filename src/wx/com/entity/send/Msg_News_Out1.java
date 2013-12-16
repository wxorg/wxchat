package wx.com.entity.send;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import wx.com.entity.Msg_Base;

public class Msg_News_Out1 extends Msg_Base {
	
	@XStreamAlias("ArticleCount")
	private int  articleCount ;
	
	@XStreamAlias("Articles")
	private List<Article> articles = new ArrayList<Article>();

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	

}
