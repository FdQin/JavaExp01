package jsoup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.mysql.jdbc.PreparedStatement;

public class jsoup {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault(); // 创建httpclient实例
        HttpGet httpget = new HttpGet("http://vip.stock.finance.sina.com.cn/corp/go.php/"
        		+ "vMS_FuQuanMarketHistory/stockid/sh600000.phtml"
        		+ "?year=2014&jidu=1"); // 创建httpget实例
         
        CloseableHttpResponse response = httpclient.execute(httpget); // 执行get请求
        HttpEntity entity=response.getEntity(); // 获取返回实体
        String content=EntityUtils.toString(entity, "utf-8");
        response.close(); // 关闭流和释放系统资源
        
        Document doc = Jsoup.parse(content);
        Elements ef1 = doc.getElementsByClass("tdr");
        
        ArrayList temp = new ArrayList();
        ArrayList factor = new ArrayList();
        for (int i = 0; i < ef1.size(); i++) {
        	if(i>3)
        		temp.add(ef1.get(i).text());
		}
        for (int i = 0; i < temp.size(); i++) {
        	if(i%4==3)
        		factor.add(temp.get(i));
		}

    	String sql = "insert into stock (factor) values(?)";
        PreparedStatement pstmt = null;
        int i = 0;

    	try {
	    	Connection conn = getCon();

	    	for (int j = 0; j < factor.size(); j++) {
		    	pstmt = (PreparedStatement) conn.prepareStatement(sql);
		        pstmt.setDouble(1, Double.parseDouble(factor.get(j).toString()));
		        i = pstmt.executeUpdate();
			}

	        pstmt.close();
	        conn.close();
		} catch (ClassNotFoundException | SQLException e ) {
			e.printStackTrace();
		}

	}
	
	public static Connection getCon() throws ClassNotFoundException, SQLException{
    	String driver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/hibernate";
    	String user = "root";
    	String pass = "qw134679";
    	
		Class.forName(driver);
    	Connection conn = DriverManager.getConnection(url,user,pass);
    	
    	return conn;
    	
    	
	}
}
