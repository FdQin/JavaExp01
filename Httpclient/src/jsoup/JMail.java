package jsoup;

import java.util.HashMap;

import catcher.CatchSinaData2;
import utils.MailUtils;

public class JMail {
	public static void main(String[] args) {
		
		HashMap hq = CatchSinaData2.getHq();
		System.out.println("格力电器实施涨幅："+CatchSinaData2.getHq());
		
		if((float)CatchSinaData2.getHq().get("increase")>=0.005){
			try {
				MailUtils.sendMail("201562651482@qq.com", hq);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
}
