package catcher;
/*原始的方法，用httpclient实现
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

//0：”大秦铁路”，股票名字；
//1：”27.55″，今日开盘价；
//2：”27.25″，昨日收盘价；
//3：”26.91″，当前价格；
//4：”27.55″，今日最高价；
//5：”26.20″，今日最低价；
//6：”26.91″，竞买价，即“买一”报价；
//7：”26.92″，竞卖价，即“卖一”报价；
//8：”22114263″，成交的股票数，由于股票交易以一百股为基本单位，所以在使用时，通常把该值除以一百；
//9：”589824680″，成交金额，单位为“元”，为了一目了然，通常以“万元”为成交金额的单位，所以通常把该值除以一万；
//10：”4695″，“买一”申请4695股，即47手；
//11：”26.91″，“买一”报价；
//12：”57590″，“买二”
//13：”26.90″，“买二”
//14：”14700″，“买三”
//15：”26.89″，“买三”
//16：”14300″，“买四”
//17：”26.88″，“买四”
//18：”15100″，“买五”
//19：”26.87″，“买五”
//20：”3100″，“卖一”申报3100股，即31手；
//21：”26.92″，“卖一”报价
//(22, 23), (24, 25), (26,27), (28, 29)分别为“卖二”至“卖四的情况”
//30：”2008-01-11″，日期；
//31：”15:05:32″，时间；



/**
 * @author burtonxu
 *
 */
/**
 * @author burtonxu
 *
 */
/**
 * @author burtonxu
 *
 */
/**
 * @author burtonxu
 *
 */
/**
 * @author burtonxu
 *
 */
public class CatchSinaData {
	public static final int SINA_SCALE_5 = 5;
	public static final int SINA_SCALE_15 = 15;
	public static final int SINA_SCALE_60 = 60;
	public static final int SINA_SCALE_240 = 240;
	public static final int SINA_SCALE_1680 = 1680;
	
	public static void main(String[] args) throws Exception {
		CatchSinaData tm = new CatchSinaData();
		tm.testsinaB();

	}


	public void testsinaB() throws org.apache.http.ParseException, IOException {
//		String[] symbol={"sz002097"};
		DefaultHttpClient httpclient = new DefaultHttpClient();
//		HttpGet httpGet = new HttpGet("http://hq.sinajs.cn/list=sz002097");
		HttpGet httpGet = new HttpGet("http://hq.sinajs.cn/list=sh600000");
			
			HttpResponse response=httpclient.execute(httpGet);
			System.out.println(response);
			String[] sinahq = EntityUtils.toString(response.getEntity()).split(",");
			System.out.print("实时股价:"+sinahq[0].substring(sinahq[0].indexOf("=\"")+2)+"@"+sinahq[31]+":"+sinahq[3]);
			System.out.println("#涨幅:"+ (Float.parseFloat(sinahq[3])/Float.parseFloat(sinahq[2])-1));
			
//			httpGet = new HttpGet("http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?symbol=sz002258&scale=5&ma=no&datalen=1023");
			httpGet = new HttpGet("http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?symbol=sh600000&scale=5&ma=no&datalen=1023");
			response=httpclient.execute(httpGet);
			String data=EntityUtils.toString(response.getEntity())
			.replace("},{", "#").replace("[{", "")
						.replace("}]", "").replace("\"", "")
						.replace("day:", "").replace("open:", "")
						.replace("high:", "").replace("low:", "")
						.replace("close:", "").replace("volume:", "");
			System.out.println("5分钟级股价:"+data);
			
			httpGet = new HttpGet("http://hq.sinajs.cn/list=sz002097,sz000753");
			response=httpclient.execute(httpGet);
			System.out.println("多股票实时股价:");
			System.out.println(EntityUtils.toString(response.getEntity()));
			
	}
			
}