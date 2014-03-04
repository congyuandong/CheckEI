package HttpRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.client.ClientProtocolException;

public class DoHttpGet {

	public String DoGetByURL(String url ) {

		String result = "";

		// 定义HttpClient
		HttpClient httpClient = new HttpClient();
		// 实例化HTTP方法
		GetMethod getMethod = new GetMethod(url);
		// getMethod.addRequestHeader("Content-type",
		// "text/html; charset=utf-8");
		// 使用系统提供的默认的恢复策略
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

				// System.out.println("Connection to " + getMethod.getURI()
				// + " Success!");

				Cookie[] cookies = httpClient.getState().getCookies();
				for (int i = 0; i < cookies.length; i++) {
					// System.out.println("cookiename==" +
					// cookies[i].getName());
					// System.out.println("cookieValue==" +
					// cookies[i].getValue());
					// System.out.println("Domain==" + cookies[i].getDomain());
					// System.out.println("Path==" + cookies[i].getPath());
					// System.out.println("Version==" +
					// cookies[i].getVersion());
				}

				// 获取到的内容
				BufferedReader in = new BufferedReader(new InputStreamReader(
						getMethod.getResponseBodyAsStream()));
				StringBuffer buffer = new StringBuffer();
				String line = "";
				while ((line = in.readLine()) != null) {
					buffer.append(line);
				}
				result = buffer.toString();

				// System.out.println(responseBody);
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

		return result;
	}

	public String DoGetWithCookies(String url, String cookie) {

		String result = "";

		// 定义HttpClient
		HttpClient httpClient = new HttpClient();
		// 实例化HTTP方法
		GetMethod getMethod = new GetMethod(url);
		// getMethod.addRequestHeader("Content-type",
		// "text/html; charset=utf-8");
		// 使用系统提供的默认的恢复策略

		if (cookie != null && !cookie.equals("")) {
			List<Header> headers = new ArrayList<Header>();
			// headers.add(new Header("Host","www.engineeringvillage.com"));
			// headers.add(new Header("User-Agent",
			// "Mozilla/5.0 (Windows NT 6.2; WOW64; rv:27.0) Gecko/20100101 Firefox/27.0"));
			// headers.add(new
			// Header("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"));
			// headers.add(new
			// Header("Accept-Language","zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3"));
			// headers.add(new Header("Accept-Encoding","gzip, deflate"));
			headers.add(new Header("Referer", url));
			headers.add(new Header("Cookie", cookie));
			// headers.add(new Header("Connection","keep-alive"));

			httpClient.getHostConfiguration().getParams().setParameter(
					"http.default-headers", headers);
		} else {

			getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler());
		}

		try {
			// 请求URI
			System.out.println("executing request " + getMethod.getURI());

			// 执行getMethod
			int status = httpClient.executeMethod(getMethod);

			System.out.println("status:" + status);

			// 连接返回的状态码
			if (HttpStatus.SC_OK == status) {

				// System.out.println("Connection to " + getMethod.getURI()
				// + " Success!");

				Cookie[] cookies = httpClient.getState().getCookies();
				for (int i = 0; i < cookies.length; i++) {
					// System.out.println("cookiename==" +
					// cookies[i].getName());
					// System.out.println("cookieValue==" +
					// cookies[i].getValue());
					// System.out.println("Domain==" + cookies[i].getDomain());
					// System.out.println("Path==" + cookies[i].getPath());
					// System.out.println("Version==" +
					// cookies[i].getVersion());
				}
				// System.out.println(getMethod.getResponseBodyAsString());
				// 获取到的内容
				BufferedReader in = new BufferedReader(new InputStreamReader(
						getMethod.getResponseBodyAsStream()));
				StringBuffer buffer = new StringBuffer();
				String line = "";
				while ((line = in.readLine()) != null) {
					buffer.append(line);
				}
				result = buffer.toString();

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

		return result;
	}

	public String[] DoGetForCookies(String url) {

		String result[] = { "", "", "" };

		// 定义HttpClient
		HttpClient httpClient = new HttpClient();
		// 实例化HTTP方法
		GetMethod getMethod = new GetMethod(url);
		// getMethod.addRequestHeader("Content-type",
		// "text/html; charset=utf-8");
		// 使用系统提供的默认的恢复策略
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

				Cookie[] cookies = httpClient.getState().getCookies();
				for (int i = 0; i < cookies.length; i++) {
					// System.out.println("cookiename==" +
					// cookies[i].getName());
					// System.out.println("cookieValue==" +
					// cookies[i].getValue());
					// System.out.println("Domain==" + cookies[i].getDomain());
					// System.out.println("Path==" + cookies[i].getPath());
					// System.out.println("Version==" +
					// cookies[i].getVersion());
					result[0] += cookies[i].getName() + "="
							+ cookies[i].getValue() + ";";
					if (cookies[i].getName().equals("EISESSION")) {
						result[1] = cookies[i].getValue();
					}
				}

				// 获取到的内容
				// String responseBody = new String(getMethod
				// .getResponseBodyAsString());
				// result = responseBody;

				// System.out.println(responseBody);
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

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoHttpGet doget = new DoHttpGet();
		//doget.DoGetByURL("http://www.baidu.com");
	}

}
