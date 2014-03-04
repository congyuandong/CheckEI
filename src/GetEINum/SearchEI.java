package GetEINum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.client.ClientProtocolException;

import HttpRequest.DoHttpGet;
import HttpRequest.DoHttpPost;

public class SearchEI {

	public String SearchBySearchWord1(String searchWord1) {
		
		searchWord1 = searchWord1.replaceAll("%20", "+");
		System.out.println("searchWord1:"+searchWord1);
		
		String url = "http://www.engineeringvillage.com/search/submit.url?CID=searchSubmit&searchtype=Quick&resetDataBase=1&database=1&searchWord1=";
		url += searchWord1;
		url += "&section1=NO-LIMIT&boolean1=AND&searchWord2=NULLNULL&section2=NO-LIMIT&boolean2=AND&searchWord3=NULLNULL&section3=NO-LIMIT&resetvar=1&doctype=NO-LIMIT&treatmentType=NO-LIMIT&language=NO-LIMIT&yearselect=yearrange&startYear=1969&endYear=2014&stringYear=CSY1884CST1969&updatesNo=1&sort=relevance&_sourcePage=nwNYFhx4sCDVWMYCskH10-_VEpYoCxgP2pgp04XxfpKJ_HzzHH4DTysqUMa2uZ1HSlCBRZjZPjI%3D&__fp=VpXY3G-0vGGZgCy3m5oeRMdfJFn2fW0gxYJ7UILlEZbN0gSaYcUDkLQUhU2UNX6GvrmxGEv8W7TitP26hjxGV3majLOwqm4gE--6bUonZv-XESw-NLq2mRWTxPS7eYN3l9nIienRNAfFcnRJPVFscyihz-eFHTGg0_BnghFZILotWA6K_T4u-g%3D%3D";
		
		String result = "";
		String getURL = "";
		String cookies = "";
		// 对url进行解析
		url = url.trim();
		int startInt = url.indexOf("?");
		String nurl = url.substring(0, startInt);
		String data = url.substring(startInt + 1);
		String[] arrayData = data.split("&");

		// （1）构造HttpClient的实例
		HttpClient httpClient = new HttpClient();
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
		headers
				.add(new Header(
						"Cookie",
						"CLIENTID=M5cbf6d261442f6ef33f3b7aprod2con2; SECUREID=M5cbf6d261442f6ef33f3b7bprod2con2-bf559981c080021eb90aaae6c31dc5d5; X-RE-Persist=5X3kbQej27iAONKJ2cj5YuODWqna3VYGnfHBKMl1jE1wqLixcNS+1DpdDResMqGrN3462+lGTQB8/2BUwUq0oicJ3umqjhdaMLdjV8BZtK40CtSsFGHOrItca1vZz1DVgUyhiQ==; acw=4af7-6f07d0044413dfda0114fc57c3ec8f3790a%7C%24%7Cmo16Imnn5K4Ff2KFDKVqVgo37c%2Fki9RqkyuNIO5NPQLX2IiHM5HKB9dP22R9nvN2AT11zY03dVvDK4GG%2BQDuuK0%2FnBAXLwHf; ev_mm_shown=3.2; JSESSIONID=A8AC7166219D3933F1391FFE0015224F.prod1con2; CARS_COOKIE=0050004500540066004600530047007900650062004D006A005500330055006C0063006400530036005400650066006B004E0046007A0077005600560053003000550071003800580062005A0070004D00690074004A002F007A004C002F00410051007100530038004400750052002F0067005100530075003200570054006B003200370037006200370042005A004B006A00530059003D; RXSESSION=5af7-6f07d0044413dfda0114fc57c3ec8f3790a; EISESSION=2_A7AC7166219D3933F1391FFE0015224F.prod1con2; __utma=15402594.293584734.1392520998.1392793182.1392797203.14; __utmb=15402594.34.10.1392797203; __utmc=15402594; __utmz=15402594.1392520998.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)"));
		headers.add(new Header("Host", "www.engineeringvillage.com"));
		headers.add(new Header("Origin", "http://www.engineeringvillage.com"));
		headers.add(new Header("Referer",
				"http://www.engineeringvillage.com/search/quick.url"));
		httpClient.getHostConfiguration().getParams().setParameter(
				"http.default-headers", headers);

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

			if (statusCode == 302) {
				Header headerLocation = postMethod
						.getResponseHeader("Location");
				getURL = headerLocation.toString();
				getURL = getURL.trim();
				// 'Location: '的长度为10
				getURL = getURL.substring(10);
				System.out.println(getURL);
			}

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

		GetMethod getMethod = new GetMethod(getURL);
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());

		// 重新建立对话
		httpClient = new HttpClient();
		try {
			// 请求URI
			System.out.println("executing request " + getMethod.getURI());

			// 执行getMethod
			int status = httpClient.executeMethod(getMethod);

			System.out.println("status:" + status);

			// 连接返回的状态码
			if (HttpStatus.SC_OK == status) {

				System.out.println("Connection to " + getMethod.getURI()
						+ " Success!");

				Cookie[] tcookies = httpClient.getState().getCookies();
				for (int i = 0; i < tcookies.length; i++) {
					cookies += tcookies[i].getName() + "="
							+ tcookies[i].getValue() + ";";
				}
				System.out.println("cookies:" + cookies);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (URIException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			getMethod.abort();
		}

		postMethod = new PostMethod(nurl);
		headers = new ArrayList<Header>();
		headers
				.add(new Header("Accept",
						"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8"));
		//headers.add(new Header("Accept-Encoding", "gzip,deflate,sdch"));
		headers.add(new Header("Accept-Language",
				"zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4"));
		headers.add(new Header("Cache-Control", "max-age=0"));
		headers.add(new Header("Connection", "keep-alive"));
		//headers.add(new Header("Content-Length", "640"));
		//headers.add(new Header("Content-Type",
		//		"application/x-www-form-urlencoded"));
		// 看cookies是否为空
		headers.add(new Header("Cookie", cookies));
		headers.add(new Header("Host", "www.engineeringvillage.com"));
		headers.add(new Header("Origin", "http://www.engineeringvillage.com"));
		headers.add(new Header("Referer",
				"http://www.engineeringvillage.com/search/quick.url"));
		httpClient.getHostConfiguration().getParams().setParameter(
				"http.default-headers", headers);

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

			if (statusCode == 302) {
				Header headerLocation = postMethod
						.getResponseHeader("Location");
				getURL = headerLocation.toString();
				getURL = getURL.trim();
				// 'Location: '的长度为10
				getURL = getURL.substring(10);
				System.out.println(getURL);
			}

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
		//这儿必须重新创建httpClient，否则会把post请求的头信息带入带get请求中去。
		//httpClient = new HttpClient();
		getMethod = new GetMethod(getURL);
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());

		try {
			// 请求URI
			System.out.println("executing request " + getMethod.getURI());

			// 执行getMethod
			int status = httpClient.executeMethod(getMethod);

			System.out.println("status:" + status);

			// 连接返回的状态码
			if (HttpStatus.SC_OK == status) {

				System.out.println("Connection to " + getMethod.getURI()
						+ " Success!");

				// Cookie[] tcookies = httpClient.getState().getCookies();
				// for (int i = 0; i < tcookies.length; i++) {
				// System.out.println("cookiename==" + tcookies[i].getName());
				// System.out.println("cookieValue==" + tcookies[i].getValue());
				// System.out.println("Domain==" + cookies[i].getDomain());
				// System.out.println("Path==" + cookies[i].getPath());
				// System.out.println("Version==" +
				// cookies[i].getVersion());
				// }
				// System.out.println(getMethod.getResponseBodyAsString());
				// 获取到的内容
				// BufferedReader in = new BufferedReader(new InputStreamReader(
				// getMethod.getResponseBodyAsStream()));
				// StringBuffer buffer = new StringBuffer();
				// String line = "";
				// while ((line = in.readLine()) != null) {
				// buffer.append(line);
				// }
				// String result = buffer.toString();
				//
				// System.out.println(result);
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (URIException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			getMethod.abort();
		}

		String detailURL = getDetailURL(getURL);
		System.out.println("detailURL:" + detailURL);
		getMethod = new GetMethod(detailURL);
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		//getMethod.setRequestHeader("Content-Type", "text/html,charset=utf-8");
		//getMethod.setRequestHeader("Accept-Encoding", "gzip, deflate");
		try {
			// 请求URI
			System.out.println("executing request " + getMethod.getURI());

			// 执行getMethod
			int status = httpClient.executeMethod(getMethod);

			System.out.println("status:" + status);

			// 连接返回的状态码
			if (HttpStatus.SC_OK == status) {

				System.out.println("Connection to " + getMethod.getURI()
						+ " Success!");
				if(getMethod.getURI().toString().indexOf("error")!=-1)
					return "";

				// Header[] headerRequest = getMethod.getRequestHeaders();
				// for (int i = 0; i < headerRequest.length; i++) {
				// System.out.println(headerRequest[i]);
				// }
				// Header[] headerResponse = getMethod.getResponseHeaders();
				// for (int i = 0; i < headerResponse.length; i++) {
				// System.out.println(headerResponse[i]);
				// }

				// Cookie[] tcookies = httpClient.getState().getCookies();
				// for (int i = 0; i < tcookies.length; i++) {
				// System.out.println("cookiename==" + tcookies[i].getName());
				// System.out.println("cookieValue==" + tcookies[i].getValue());
				// System.out.println("Domain==" + cookies[i].getDomain());
				// System.out.println("Path==" + cookies[i].getPath());
				// System.out.println("Version==" +
				// cookies[i].getVersion());
				// }
				//System.out.println(getMethod.getResponseBodyAsString());
				//byte[] body = getMethod.getResponseBody();
				//System.out.println(new String(body));
				// 获取到的内容
				BufferedReader in = new BufferedReader(new InputStreamReader(
						getMethod.getResponseBodyAsStream()));
				StringBuffer buffer = new StringBuffer();
				String line = "";
				while ((line = in.readLine()) != null) {
					buffer.append(line);
				}
				result = buffer.toString();
				//result = result.toString(result,ContentType.getOrDefault(entity));
				//System.out.println(result);
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (URIException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放连接
			getMethod.releaseConnection();
		}
		
		//result.replaceAll(" ", "");
		result = result.replaceAll("\t", "");
		result = result.replaceAll("/static/images/emailfolder.gif", "static/images/emailfolder.gif");
		result = getTable(result);
		//<table border="0" width="100%" id="detailed">
		System.out.println(result);
		return result;
	}
	
	public String getTable(String result){
		String table = "";
		int indexStart = result.indexOf("<table border=\"0\" width=\"100%\" id=\"detailed\">");
		int indexEnd = result.indexOf("</table>", indexStart);
		//System.out.println(indexStart + " " + indexEnd);
		//System.out.println(result.substring(indexStart, indexEnd+8));
		table = result.substring(indexStart, indexEnd+8);
		
		table = table.replaceAll("<h3>", "<h7>");
		table = table.replaceAll("</h3>","</h7>");
		
		indexStart = table.indexOf("<td style=\"white-space: nowrap\">");
		indexEnd = table.indexOf("</td>", indexStart);
		table = table.substring(0, indexStart)+"<td>&nbsp;</td>"+ table.substring(indexEnd+5);
		//table = table.substring(0, indexStart+11)+"display:none;"+table.substring(indexStart+11, table.length());
		
		return table;
	}

	public String getDetailURL(String getURL) {
		String url = "http://www.engineeringvillage.com/search/doc/detailed.url?";
		String searchID = "";
		int indexOfAsk = getURL.indexOf("SEARCHID");
		int indexOfAnd = getURL.indexOf('&', indexOfAsk);
		if (indexOfAnd != -1)
			searchID = getURL.substring(indexOfAsk, indexOfAnd);
		else
			searchID = getURL.substring(indexOfAsk, getURL.length());
		System.out.println("searchID:" + searchID);
		url += searchID;
		url += "&pageType=quickSearch&CID=quickSearchDetailedFormat&DOCINDEX=1&database=1&format=quickSearchDetailedFormat&tagscope=&displayPagination=yes";
		return url;
	}
	

}
