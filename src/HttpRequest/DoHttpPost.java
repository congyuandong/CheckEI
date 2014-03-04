package HttpRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import GetEINum.SearchEI;

public class DoHttpPost {
	public String doPostBySearchWord1(String searchWord1, String cookies ) {
		String result = "";

		String url = "http://www.engineeringvillage.com/search/submit.url?CID=searchSubmit&searchtype=Quick&resetDataBase=1&database=1&searchWord1=";
		url += searchWord1;
		url += "&section1=NO-LIMIT&boolean1=AND&searchWord2=NULLNULL&section2=NO-LIMIT&boolean2=AND&searchWord3=NULLNULL&section3=NO-LIMIT&resetvar=1&doctype=NO-LIMIT&treatmentType=NO-LIMIT&language=NO-LIMIT&yearselect=yearrange&startYear=1969&endYear=2014&stringYear=CSY1884CST1969&updatesNo=1&sort=relevance&_sourcePage=nwNYFhx4sCDVWMYCskH10-_VEpYoCxgP2pgp04XxfpKJ_HzzHH4DTysqUMa2uZ1HSlCBRZjZPjI%3D&__fp=VpXY3G-0vGGZgCy3m5oeRMdfJFn2fW0gxYJ7UILlEZbN0gSaYcUDkLQUhU2UNX6GvrmxGEv8W7TitP26hjxGV3majLOwqm4gE--6bUonZv-XESw-NLq2mRWTxPS7eYN3l9nIienRNAfFcnRJPVFscyihz-eFHTGg0_BnghFZILotWA6K_T4u-g%3D%3D";

		String getURL = "";
		// 对url进行解析
		url = url.trim();
		int startInt = url.indexOf("?");
		String nurl = url.substring(0, startInt);
		String data = url.substring(startInt + 1);
		String[] arrayData = data.split("&");

		// （1）构造HttpClient的实例
		HttpClient  httpClient = new HttpClient();
		// （2）创建POST方法的实例
		PostMethod postMethod = new PostMethod(nurl);
		// （3）设置http request头
		List<Header> headers = new ArrayList<Header>();
		headers
				.add(new Header("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"));
		headers.add(new Header("Accept-Encoding", "gzip,deflate,sdch"));
		headers.add(new Header("Accept-Language",
				"zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4"));
		headers.add(new Header("Cache-Control", "max-age=0"));
		headers.add(new Header("Connection", "keep-alive"));
		headers.add(new Header("Content-Length", "640"));
		headers.add(new Header("Content-Type",
				"application/x-www-form-urlencoded"));

		// 看cookies是否为空
		if (cookies == null || cookies.equals(""))
			headers
					.add(new Header(
							"Cookie",
							"CLIENTID=M5cbf6d261442f6ef33f3b7aprod2con2; SECUREID=M5cbf6d261442f6ef33f3b7bprod2con2-bf559981c080021eb90aaae6c31dc5d5; X-RE-Persist=5X3kbQej27iAONKJ2cj5YuODWqna3VYGnfHBKMl1jE1wqLixcNS+1DpdDResMqGrN3462+lGTQB8/2BUwUq0oicJ3umqjhdaMLdjV8BZtK40CtSsFGHOrItca1vZz1DVgUyhiQ==; acw=4af7-6f07d0044413dfda0114fc57c3ec8f3790a%7C%24%7Cmo16Imnn5K4Ff2KFDKVqVgo37c%2Fki9RqkyuNIO5NPQLX2IiHM5HKB9dP22R9nvN2AT11zY03dVvDK4GG%2BQDuuK0%2FnBAXLwHf; ev_mm_shown=3.2; JSESSIONID=A8AC7166219D3933F1391FFE0015224F.prod1con2; CARS_COOKIE=0050004500540066004600530047007900650062004D006A005500330055006C0063006400530036005400650066006B004E0046007A0077005600560053003000550071003800580062005A0070004D00690074004A002F007A004C002F00410051007100530038004400750052002F0067005100530075003200570054006B003200370037006200370042005A004B006A00530059003D; RXSESSION=5af7-6f07d0044413dfda0114fc57c3ec8f3790a; EISESSION=2_A7AC7166219D3933F1391FFE0015224F.prod1con2; __utma=15402594.293584734.1392520998.1392793182.1392797203.14; __utmb=15402594.34.10.1392797203; __utmc=15402594; __utmz=15402594.1392520998.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)"));
		else {
			headers.add(new Header("Cookie", cookies));
		}
		headers.add(new Header("Host", "www.engineeringvillage.com"));
		headers.add(new Header("Origin", "http://www.engineeringvillage.com"));
		headers.add(new Header("Referer",
				"http://www.engineeringvillage.com/search/quick.url"));
		// headers
		// .add(new Header(
		// "User-Agent",
		// "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"));

		httpClient.getHostConfiguration().getParams().setParameter(
				"http.default-headers", headers);

		// List<NameValuePair> params = new ArrayList<NameValuePair>();
		// 添加参数
		for (int i = 0; i < arrayData.length; i++) {
			String[] values = (arrayData[i]).split("=");
			if (values[1].equals("NULLNULL"))
				values[1] = "";
			if (values[0].equals("_sourcePage"))
				values[1] += "=";
			if (values[0].equals("__fp"))
				values[1] += "==";
			// System.out.println(values[0] + "=" + values[1]);
			NameValuePair valuePair = new NameValuePair(values[0], values[1]);
			postMethod.addParameter(valuePair);
		}

		try {
			// （4）执行postMethod
			int statusCode = httpClient.executeMethod(postMethod);

			// 验证返回码，一般第一次为302，跳转
			System.out.println("statusCode:" + statusCode);
			// if (statusCode != HttpStatus.SC_OK) {
			// System.err.println("Method failed: "
			// + postMethod.getStatusLine());
			// }

			// （5）读取response头信息
			// Header headerResponse = postMethod
			// .getResponseHeader("response_key");
			// Header[] headerRequest = postMethod.getRequestHeaders();
			// for(int i=0;i<headerRequest.length;i++){
			// System.out.println(headerRequest[i]);
			// }

			if (statusCode == 302) {
				// Cookie[] cookies = httpClient.getState().getCookies();
				// for (int i = 0; i < cookies.length; i++) {
				// System.out.println("cookiename==" + cookies[i].getName());
				// System.out.println("cookieValue==" + cookies[i].getValue());
				// System.out.println("Domain==" + cookies[i].getDomain());
				// System.out.println("Path==" + cookies[i].getPath());
				// System.out.println("Version==" + cookies[i].getVersion());
				// }

				// Header[] headerResponse = postMethod.getResponseHeaders();
				// for (int i = 0; i < headerResponse.length; i++) {
				// System.out.println(headerResponse[i]);
				// }

				Header headerLocation = postMethod
						.getResponseHeader("Location");
				getURL = headerLocation.toString();
				// 'Location: '的长度为10
				result = getURL.substring(10);
				System.out.println(getURL);
			}
			
	
			

			// （6）读取内容
			// byte[] responseBody = postMethod.getResponseBody();
			// （7） 处理内容
			// System.out.println(headerStr);
			// System.out.println(new String(responseBody));
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			System.out.println("Please check your provided http address!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			postMethod.releaseConnection();
		}

		return result;
	}

	public int doPostByURL(String url, String cookies) {
		int result = 0 ;

		String getURL = "";
		// 对url进行解析
		//url = url.trim();
		//int startInt = url.indexOf("?");
		//String nurl = url.substring(0, startInt);
		//String data = url.substring(startInt + 1);
		//String[] arrayData = data.split("&");

		// （1）构造HttpClient的实例
		HttpClient httpClient = new HttpClient();
		// （2）创建POST方法的实例
		PostMethod postMethod = new PostMethod(url);
		// （3）设置http request头
		List<Header> headers = new ArrayList<Header>();
		headers.add(new Header("Accept", "*/*"));
		headers.add(new Header("Accept-Encoding", "gzip,deflate,sdch"));
		headers.add(new Header("Accept-Language",
				"zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4"));
		headers.add(new Header("Cache-Control", "max-age=0"));
		headers.add(new Header("Connection", "keep-alive"));
		headers.add(new Header("Content-Length", "62"));
		headers.add(new Header("Content-Type",
				"application/x-www-form-urlencoded; charset=UTF-8"));
		headers.add(new Header("Cookie", cookies));
		headers.add(new Header("Host", "www.engineeringvillage.com"));
		headers.add(new Header("Origin", "http://www.engineeringvillage.com"));
		headers.add(new Header("X-Requested-With", url));
		headers.add(new Header("Referer", "XMLHttpRequest"));
		// headers
		// .add(new Header(
		// "User-Agent",
		// "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.57 Safari/537.36"));

		httpClient.getHostConfiguration().getParams().setParameter(
				"http.default-headers", headers);

		// List<NameValuePair> params = new ArrayList<NameValuePair>();
		// 添加参数
//		for (int i = 0; i < arrayData.length; i++) {
//			String[] values = (arrayData[i]).split("=");
//			if (values[1].equals("NULLNULL"))
//				values[1] = "";
//			if (values[0].equals("_sourcePage"))
//				values[1] += "=";
//			if (values[0].equals("__fp"))
//				values[1] += "==";
			// System.out.println(values[0] + "=" + values[1]);

			NameValuePair valuePair = new NameValuePair("docid[]", "cpx_b753f811bfbe2aeb029a52061377553");
			postMethod.addParameter(valuePair);
			valuePair = new NameValuePair("handle[]", "1");
			postMethod.addParameter(valuePair);
	//	}

		try {
			// （4）执行postMethod
			int statusCode = httpClient.executeMethod(postMethod);

			// 验证返回码，一般第一次为302，跳转
			System.out.println("statusCode:" + statusCode);
			result = statusCode;
			// if (statusCode != HttpStatus.SC_OK) {
			// System.err.println("Method failed: "
			// + postMethod.getStatusLine());
			// }

			// （5）读取response头信息
			// Header headerResponse = postMethod
			// .getResponseHeader("response_key");
			// Header[] headerRequest = postMethod.getRequestHeaders();
			// for(int i=0;i<headerRequest.length;i++){
			// System.out.println(headerRequest[i]);
			// }

			//if (statusCode == 302) {
				// Cookie[] cookies = httpClient.getState().getCookies();
				// for (int i = 0; i < cookies.length; i++) {
				// System.out.println("cookiename==" + cookies[i].getName());
				// System.out.println("cookieValue==" + cookies[i].getValue());
				// System.out.println("Domain==" + cookies[i].getDomain());
				// System.out.println("Path==" + cookies[i].getPath());
				// System.out.println("Version==" + cookies[i].getVersion());
				// }

				// Header[] headerResponse = postMethod.getResponseHeaders();
				// for (int i = 0; i < headerResponse.length; i++) {
				// System.out.println(headerResponse[i]);
				// }

			//	Header headerLocation = postMethod
			//			.getResponseHeader("Location");
			//	getURL = headerLocation.toString();
				// 'Location: '的长度为10
			//	result = getURL.substring(10);
			//	System.out.println(getURL);
			//}

			// （6）读取内容
			// byte[] responseBody = postMethod.getResponseBody();
			// （7） 处理内容
			// System.out.println(headerStr);
			// System.out.println(new String(responseBody));
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			System.out.println("Please check your provided http address!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			//postMethod.releaseConnection();
		}

		return result;
	}
}
