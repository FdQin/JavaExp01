package catcher;

/*鐎圭偟骞囩�规碍妞傞崳顭掔礉閻⑩暏ttpclient鐎圭偟骞�
*/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;








import java.util.TimerTask;






import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

//0閿涙埃锟芥繂銇囩粔锕傛惂鐠侯垪锟芥繐绱濋懖锛勩偍閸氬秴鐡ч敍锟�
//1閿涙埃锟斤拷27.55閳ョ绱濇禒濠冩）瀵拷閻╂ü鐜敍锟�
//2閿涙埃锟斤拷27.25閳ョ绱濋弰銊︽）閺�鍓佹磸娴犲嚖绱�
//3閿涙埃锟斤拷26.91閳ョ绱濊ぐ鎾冲娴犻攱鐗搁敍锟�
//4閿涙埃锟斤拷27.55閳ョ绱濇禒濠冩）閺堬拷妤傛ü鐜敍锟�
//5閿涙埃锟斤拷26.20閳ョ绱濇禒濠冩）閺堬拷娴ｅ簼鐜敍锟�
//6閿涙埃锟斤拷26.91閳ョ绱濈粩鐐版嫳娴犲嚖绱濋崡鏂ワ拷婊�鎷辨稉锟介垾婵囧Г娴犲嚖绱�
//7閿涙埃锟斤拷26.92閳ョ绱濈粩鐐插礌娴犲嚖绱濋崡鏂ワ拷婊冨礌娑擄拷閳ユ繃濮ゆ禒鍑ょ幢
//8閿涙埃锟斤拷22114263閳ョ绱濋幋鎰唉閻ㄥ嫯鍋傜粊銊︽殶閿涘瞼鏁辨禍搴ゅ亗缁併劋姘﹂弰鎾蹭簰娑擄拷閻ф崘鍋傛稉鍝勭唨閺堫剙宕熸担宥忕礉閹碉拷娴犮儱婀担璺ㄦ暏閺冭绱濋柅姘埗閹跺﹨顕氶崐濂告珟娴犮儰绔撮惂鎾呯幢
//9閿涙埃锟斤拷589824680閳ョ绱濋幋鎰唉闁叉垿顤傞敍灞藉礋娴ｅ秳璐熼垾婊冨帗閳ユ繐绱濇稉杞扮啊娑擄拷閻╊喕绨￠悞璁圭礉闁艾鐖舵禒銉拷婊�绔鹃崗鍐ｏ拷婵呰礋閹存劒姘﹂柌鎴︻杺閻ㄥ嫬宕熸担宥忕礉閹碉拷娴犮儵锟芥艾鐖堕幎濠咁嚉閸婂ジ娅庢禒銉ょ娑撳浄绱�
//10閿涙埃锟斤拷4695閳ョ绱濋垾婊�鎷辨稉锟介垾婵堟暤鐠囷拷4695閼测槄绱濋崡锟�47閹靛绱�
//11閿涙埃锟斤拷26.91閳ョ绱濋垾婊�鎷辨稉锟介垾婵囧Г娴犲嚖绱�
//12閿涙埃锟斤拷57590閳ョ绱濋垾婊�鎷辨禍灞革拷锟�
//13閿涙埃锟斤拷26.90閳ョ绱濋垾婊�鎷辨禍灞革拷锟�
//14閿涙埃锟斤拷14700閳ョ绱濋垾婊�鎷辨稉澶嗭拷锟�
//15閿涙埃锟斤拷26.89閳ョ绱濋垾婊�鎷辨稉澶嗭拷锟�
//16閿涙埃锟斤拷14300閳ョ绱濋垾婊�鎷遍崶娑掞拷锟�
//17閿涙埃锟斤拷26.88閳ョ绱濋垾婊�鎷遍崶娑掞拷锟�
//18閿涙埃锟斤拷15100閳ョ绱濋垾婊�鎷辨禍鏂猴拷锟�
//19閿涙埃锟斤拷26.87閳ョ绱濋垾婊�鎷辨禍鏂猴拷锟�
//20閿涙埃锟斤拷3100閳ョ绱濋垾婊冨礌娑擄拷閳ユ繄鏁甸幎锟�3100閼测槄绱濋崡锟�31閹靛绱�
//21閿涙埃锟斤拷26.92閳ョ绱濋垾婊冨礌娑擄拷閳ユ繃濮ゆ禒锟�
//(22, 23), (24, 25), (26,27), (28, 29)閸掑棗鍩嗘稉琛★拷婊冨礌娴滃备锟芥繆鍤﹂垾婊冨礌閸ユ稓娈戦幆鍛枌閳ワ拷
//30閿涙埃锟斤拷2008-01-11閳ョ绱濋弮銉︽埂閿涳拷
//31閿涙埃锟斤拷15:05:32閳ョ绱濋弮鍫曟？閿涳拷



public class CatchSinaData2 {
	public static final int SINA_SCALE_5 = 5;
	public static final int SINA_SCALE_15 = 15;
	public static final int SINA_SCALE_60 = 60;
	public static final int SINA_SCALE_240 = 240;
	public static final int SINA_SCALE_1680 = 1680;
	
	public static void main(String[] args) throws Exception {
		CatchSinaData2 tm = new CatchSinaData2();
//		tm.testsinaTimer();
		tm.testsinaTimerHttpClient();

	}




	public void testsinaTimer() throws org.apache.http.ParseException,
			IOException {

				// System.out.println("-------鐠佹儳鐣剧憰浣瑰瘹鐎规矮鎹㈤崝锟�--------");
				HttpURLConnection conn;
				try {
					conn = (HttpURLConnection) new URL(
							"http://hq.sinajs.cn/list=sh600000")
							.openConnection();

					conn.setRequestProperty("contentType", "GBK");
					conn.setConnectTimeout(5 * 1000);
					conn.setRequestMethod("GET");
					InputStream inStream = conn.getInputStream();

					BufferedReader in = new BufferedReader(
							new InputStreamReader(inStream, "GBK"));
					StringBuffer buffer = new StringBuffer();
					String line = "";
					while ((line = in.readLine()) != null) {
						buffer.append(line);
					}
					String str = buffer.toString();
					// System.out.println(str);
					in.close();
					conn.disconnect();
					String[] sinahq = str.split(",");
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//鐠佸墽鐤嗛弮銉︽埂閺嶇厧绱�
					System.out.println(df.format(new Date()));
					System.out.print("鐎圭偞妞傞懖鈥茬幆:"
							+ sinahq[0].substring(sinahq[0].indexOf("=\"") + 2)
							+ "@" + sinahq[31] + ":" + sinahq[3]);
					System.out.println("#濞戙劌绠�:"
							+ (Float.parseFloat(sinahq[3])
									/ Float.parseFloat(sinahq[2]) - 1));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			

	
	  public void testsinaTimerHttpClient() throws org.apache.http.ParseException,
			IOException {
//		Timer timer = new Timer();
//		timer.schedule(new TimerTask() {
//			public void run() {
				// System.out.println("-------鐠佹儳鐣剧憰浣瑰瘹鐎规矮鎹㈤崝锟�--------");
//				HttpURLConnection conn;
				try {
					DefaultHttpClient httpclient = new DefaultHttpClient();
//					HttpGet httpGet = new HttpGet("http://hq.sinajs.cn/list=sz002097");
					HttpGet httpGet = new HttpGet("http://hq.sinajs.cn/list=sh600000");
						
						HttpResponse response=httpclient.execute(httpGet);
//						System.out.println(response);
						String[] sinahq = EntityUtils.toString(response.getEntity()).split(",");
						System.out.print("实时股价:"+sinahq[0].substring(sinahq[0].indexOf("=\"")+2)+"@"+sinahq[31]+":"+sinahq[3]);
						System.out.println("#涨幅:"+ (Float.parseFloat(sinahq[3])/Float.parseFloat(sinahq[2])-1));

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
//		}, 1000, 5000);
			
	
//	}
	
	  
	  public static HashMap getHq(){
			try {
				DefaultHttpClient httpclient = new DefaultHttpClient();
//				HttpGet httpGet = new HttpGet("http://hq.sinajs.cn/list=sz002097");
				HttpGet httpGet = new HttpGet("http://hq.sinajs.cn/list=sz000651");
					
					HttpResponse response=httpclient.execute(httpGet);
//					System.out.println(response);
					String[] sinahq = EntityUtils.toString(response.getEntity()).split(",");
//					System.out.print("鐎圭偞妞傞懖鈥茬幆:"+sinahq[0].substring(sinahq[0].indexOf("=\"")+2)+"@"+sinahq[31]+":"+sinahq[3]);
//					System.out.println("#濞戙劌绠�:"+ (Float.parseFloat(sinahq[3])/Float.parseFloat(sinahq[2])-1));
					
					HashMap hq = new HashMap<>();
					hq.put("name", sinahq[0].substring(sinahq[0].indexOf("=\"")+2));
					hq.put("time", sinahq[31]);
					hq.put("increase", (Float.parseFloat(sinahq[3])/Float.parseFloat(sinahq[2])-1));
					hq.put("price", sinahq[3]);
					return (hq);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			return null;
	  }


	public static void timer4() {
		    Calendar calendar = Calendar.getInstance();
		    calendar.set(Calendar.HOUR_OF_DAY, 12); // 閹貉冨煑閺冿拷
		    calendar.set(Calendar.MINUTE, 0);    // 閹貉冨煑閸掞拷
		    calendar.set(Calendar.SECOND, 0);    // 閹貉冨煑缁夛拷
		 
		    Date time = calendar.getTime();     // 瀵版鍤幍褑顢戞禒璇插閻ㄥ嫭妞傞梻锟�,濮濄倕顦╂稉杞扮矕婢垛晝娈�12閿涳拷00閿涳拷00
		 
		    Timer timer = new Timer();
		    timer.scheduleAtFixedRate(new TimerTask() {
		      public void run() {
		        System.out.println("-------鐠佹儳鐣剧憰浣瑰瘹鐎规矮鎹㈤崝锟�--------");
		      }
		    }, time, 1000 * 60 * 60 * 24);// 鏉╂瑩鍣风拋鎯х暰鐏忓棗娆㈤弮鑸电槨婢垛晛娴愮�规碍澧界悰锟�
		  }
}