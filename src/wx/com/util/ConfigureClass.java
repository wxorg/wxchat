package wx.com.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


public class ConfigureClass {
	
	
	private static Logger logger = Logger.getLogger(ConfigureClass.class);
	private static String proFilePath ="/application.properties";
	
	/**
	 * weixin token
	 */
	private static String TOKEN;
	private static String WEBURL;
	
	
	static {
		try{
			
		
		Properties prop = new Properties();
		InputStream in = ConfigureClass.class.getResourceAsStream(proFilePath);
 
        prop.load(in);
        
		setTOKEN(prop.getProperty("token"));
		setWEBURL(prop.getProperty("wepappurl"));
		
		}catch(FileNotFoundException e){
			e.printStackTrace();
			logger.error("FileNotFoundException"+e);
		} catch (IOException e) {

			e.printStackTrace();
			logger.error("IOException"+e);
		}
		
	}


	public static String getTOKEN() {
		return TOKEN;
	}


	public static void setTOKEN(String tOKEN) {
		TOKEN = tOKEN;
	}


	public static String getWEBURL() {
		return WEBURL;
	}


	public static void setWEBURL(String wEBURL) {
		WEBURL = wEBURL;
	}
	
	
	

}
