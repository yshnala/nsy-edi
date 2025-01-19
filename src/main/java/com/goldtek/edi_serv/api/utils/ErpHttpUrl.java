package com.goldtek.edi_serv.api.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goldtek.edi_serv.api.bean.ErpApiBean;
import com.goldtek.edi_serv.api.bean.ErpHeaderDigiHost;
import com.goldtek.edi_serv.api.bean.StdData;
import com.goldtek.edi_serv.api.bean.Wrapper;
import com.google.gson.Gson;

/**
 * 
 * @author macgyver_chung
 *
 */
public class ErpHttpUrl {
	static final Logger logger = LoggerFactory.getLogger(ErpHttpUrl.class);

	public ErpHttpUrl() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String str[]) {
		try {
			//替換為你要加密的字符串
        	String area = "test";	//test_測試區，prod_正式區
        	String sys = "pdm";		//呼叫鼎新 WEB API的系統，對照WorkflowERP_APIkey,DBaccount.xlsx
			String apiName = "wf.oapi.item.data.query.get";
	        String body = "{\"std_data\":{\"parameter\":{\"page_size\":10,\"page_no\":1,\"conditions\":{\"operator\":\"AND\",\"fields\":[{\"field_name\":\"item_no\",\"operator\":\"LIKE\",\"value\":\"2T71DDL00-JUB-G%\"}]},\"orders\":[{\"field_name\":\"item_no\",\"order_type\":\"asc\"}]}}}";
	        String companyId = "Goldtek";		 //WF公司代號，對應DSCSYS.DSCMB中的 company
	        String secretKey = "8200417821"; // 替換為你的Secret Key
            String appKey = "4F50C95C-C92D-492B-A86E-92C87BBD2D83";		//鼎新發行的APP KEY(每個系統的APP KEY都不一樣)
	        String iv = UniqueNumberGenerator.generateUniqueMillis(area, sys);	//不重複的16碼數
			String vKey = AESCrypt.encrypt(appKey, iv);					//AES加密後的APP_KEY
			String vSign = Base64SHA256.getVSign(body, secretKey);		//BODY進行BASE64加密，用鼎新系統控制員授權資料的客戶代號當Secret KEY，來進行SHA256雜湊，用hash_function轉字串
			String digiReqId = sys;					//查DEBUG LOG用的代碼，直接以系統名稱代替
			
			//設定header參數
    		ErpApiBean bean = new ErpApiBean();
    		bean.getDigiService().setName(apiName);	//操作的功能，對應DSCSYS.dbo.OAPMA的 MA001欄
    		bean.getDigiDataKey().setCompanyId(companyId);	//WF 公司代號
    		bean.setDigiReqId(digiReqId);			//調用端識別碼，建議使用GUID。供DEBUG LOG查找。
    		ErpHeaderDigiHost digiHost = new ErpHeaderDigiHost();
    		digiHost.setAcct("macgyver_chung");		//用於集成的WF帳號
    		digiHost.setLang("zh_TW");				//用於集成的WF帳號
    		digiHost.setTimestamp();				//時間戳，格式：yyyyMMddHHmmssSSS
    		digiHost.setProd(sys);					//對應鼎新開的調用產品代號
    		bean.setDigiHost(digiHost);
    		bean.setvKey(vKey);
    		bean.setvSign(vSign);
    		bean.setIv(iv);
    		bean.setBody(body);
    		
//    		SystemOutUtil.writeSystemOut("ErpHttpUrl", "PLM_WF_DATA", "...iv = " + iv);
//    		SystemOutUtil.writeSystemOut("ErpHttpUrl", "PLM_WF_DATA", "...vKey = " + vKey);
//    		SystemOutUtil.writeSystemOut("ErpHttpUrl", "PLM_WF_DATA", "...vSign = " + vSign);
//    		SystemOutUtil.writeSystemOut("ErpHttpUrl", "PLM_WF_DATA", "...getDigiServiceJson = " + bean.getDigiServiceJson());
//    		SystemOutUtil.writeSystemOut("ErpHttpUrl", "PLM_WF_DATA", "...getDigiDataKeyJson = " + bean.getDigiDataKeyJson());
//    		SystemOutUtil.writeSystemOut("ErpHttpUrl", "PLM_WF_DATA", "...getDigiHostJson = " + bean.getDigiHostJson());
    		
			//下載檔案取得要送NSY的BOM JSON
			String url = "http://172.21.2.28/WFOAP/openapi.dll/datasnap/rest/TServerMethods1/InvokeSrv";
			
//			//呼叫新 WEB API
			ErpHttpUrl rest = new ErpHttpUrl();
			String result = rest.POST(url, bean);
			String json = bean.getDeCodeResult();
//    		SystemOutUtil.writeSystemOut("ErpHttpUrl", "main", "...decodeToString.result = " + Base64SHA256.decodeToString(bean.getResult()));
			
    		//把呼叫結果轉為JavaBean
            Gson gson = new Gson();
            Wrapper wrapper = gson.fromJson(json, Wrapper.class);
            StdData stdData = wrapper.getStdData();
            System.out.println("ErpHttpUrl...main..stdData.toString() = " +stdData.toString());
            System.out.println(stdData.getExecution().getDescription());
            
	        
//	        
	        // 解析 JSON

//	          String json = "{\"std_data\": {\"execution\": {\"code\": \"-1\",\"sql_code\": \"\",\"description\": \"執行失敗\"},\"parameter\": {\"result\": {\"success\": [],\"error\": [{\"message\":\"datakeys is not valid.\",\"data\":\"\"}]}}}}";
//
//	          System.out.println("json = " + json.toString());
//
//              Gson gson = new Gson();
//                Wrapper wrapper = gson.fromJson(json, Wrapper.class);
//                StdData stdData = wrapper.getStdData();
//
//                // 測試輸出
//                System.out.println(stdData.getExecution().getDescription());
//                if (!stdData.getParameter().getResult().getSuccess().isEmpty()) {
//                    System.out.println(stdData.getParameter().getResult().getSuccess().get(0).getItem_basic_data().get(0).getCOMPANY());
//                }
    		
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	/**
	 * 用POST送 WEB API
	 * 
	 * @param url
	 * @param body
	 * @return
	 */
	public String POST(String url, ErpApiBean bean) throws Exception{
		StringBuffer str = new StringBuffer("");
		try{
	        URL endpoint = new URL(url);
	        HttpURLConnection httpConnection = (HttpURLConnection) endpoint.openConnection();
	        httpConnection.setRequestMethod("POST");
	        httpConnection.setDoInput(true);
	        httpConnection.setDoOutput(true);
	        
            // 設置標頭
	        httpConnection.setRequestProperty("Content-Type", "application/json");
	        httpConnection.setRequestProperty("digi-service", bean.getDigiServiceJson());
	        httpConnection.setRequestProperty("digi-datakey", bean.getDigiDataKeyJson());
	        httpConnection.setRequestProperty("digi-host", bean.getDigiHostJson());
	        httpConnection.setRequestProperty("digi-reqid", bean.getDigiReqId());
	        httpConnection.setRequestProperty("vkey", bean.getvKey());
	        httpConnection.setRequestProperty("vsign", bean.getvSign());
	        httpConnection.setRequestProperty("iv", bean.getIv());
	        
	        DataOutputStream outputStream = new DataOutputStream(httpConnection.getOutputStream());
	        outputStream.write(bean.getBodyJson().toString().getBytes("UTF-8"));
	        outputStream.flush();
	        outputStream.close();
    
	        InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream());
	        BufferedReader br = new BufferedReader(isr);
	        String line = "";
	        while( (line = br.readLine()) != null ) {
	            str.append(line);
	        	System.out.println(line);
	        }
	        
	        bean.setApiReturnJson(str.toString());
		}catch(Exception e){
    		System.out.println("ErpHttpUrl...POST...Exception : " + (e));
			throw e;
		}
		
		return str.toString();
	}
}
