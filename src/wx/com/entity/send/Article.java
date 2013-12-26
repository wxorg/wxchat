package wx.com.entity.send;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("item")
public class Article {
	
	
	  private String id;

	  @XStreamAlias("Title")
	  private String title;

	  @XStreamAlias("Discription")
	  private String discription;

	  @XStreamAlias("PicUrl")
	  private String picUrl;

	  @XStreamAlias("Url")
	  private String url;

	  public String getTitle()
	  {
	    return this.title;
	  }

	  public void setTitle(String title) {
	    this.title = title;
	  }

	  public String getDiscription()
	  {
	    return this.discription;
	  }

	  public void setDiscription(String discription) {
	    this.discription = discription;
	  }

	  public String getPicUrl() {
	    return this.picUrl;
	  }

	  public void setPicUrl(String picUrl) {
	    this.picUrl = picUrl;
	  }

	  public String getUrl() {
	    return this.url;
	  }

	  public void setUrl(String url) {
	    this.url = url;
	  }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	  
	  
}
