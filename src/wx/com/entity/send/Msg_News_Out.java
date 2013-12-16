package wx.com.entity.send;

import java.util.ArrayList;
import java.util.List;

import wx.com.entity.Msg_Base;

import com.thoughtworks.xstream.annotations.XStreamAlias;


public class Msg_News_Out extends Msg_Base {
	
	@XStreamAlias("MsgType")
	private String	msgType	= "news";
	
	@XStreamAlias("Articles")
	private List<Article> articles = new ArrayList<Article>();
	
	@XStreamAlias("ArticleCount")
	private int	articleCount;

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	
	
	
	
	
	

}
