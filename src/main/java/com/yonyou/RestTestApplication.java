package com.yonyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;

import com.yonyou.rest.client.AbsRestClient;
import com.yonyou.rest.client.JsonReqClient;
/**
 * 云之讯sms推送 OK
 * @author Administrator
 *
 */
@SpringBootApplication
public class RestTestApplication {
	static AbsRestClient InstantiationRestAPI() {
		return new JsonReqClient();
	}

	public static void testSendSms(String sid, String token, String appid, String templateid, String param,
			String mobile, String uid) {
		try {
			String result = InstantiationRestAPI().sendSms(sid, token, appid, templateid, param, mobile, uid);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testSendSmsBatch(String sid, String token, String appid, String templateid, String param,
			String mobile, String uid) {
		try {
			String result = InstantiationRestAPI().sendSmsBatch(sid, token, appid, templateid, param, mobile, uid);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testAddSmsTemplate(String sid, String token, String appid, String type, String template_name,
			String autograph, String content) {
		try {
			String result = InstantiationRestAPI().addSmsTemplate(sid, token, appid, type, template_name, autograph,
					content);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testGetSmsTemplate(String sid, String token, String appid, String templateid, String page_num,
			String page_size) {
		try {
			String result = InstantiationRestAPI().getSmsTemplate(sid, token, appid, templateid, page_num, page_size);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testEditSmsTemplate(String sid, String token, String appid, String templateid, String type,
			String template_name, String autograph, String content) {
		try {
			String result = InstantiationRestAPI().editSmsTemplate(sid, token, appid, templateid, type, template_name,
					autograph, content);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testDeleterSmsTemplate(String sid, String token, String appid, String templateid) {
		try {
			String result = InstantiationRestAPI().deleterSmsTemplate(sid, token, appid, templateid);
			System.out.println("Response content is: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试说明 启动main方法后，请在控制台输入数字(数字对应 相应的调用方法)，回车键结束 参数名称含义，请参考rest api 文档
	 * 
	 * @throws IOException
	 * @method main
	 */
	public static void main(String[] args) throws IOException {

		SpringApplication.run(RestTestApplication.class, args);

		System.out.println("请输入方法对应的数字(例如1),Enter键结束:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String methodNumber = br.readLine();

		if (StringUtils.isBlank(methodNumber)) {
			System.out.println("请输入正确的数字，不可为空");
			return;
		}

		if (methodNumber.equals("1")) { // 指定模板-单发
			String sid = "7573371f1db9bb2d28747e387516e2a4";
			String token = "f783db36f8b9d7de1ad6fd71c9dbaaac";
			String appid = "58d7bc6cf17a48be84ae279e6f88d3eb";
			String templateid = "383782"; // 开发者控制台自己申请的 模板id
			String param = "6287,9";// 验证码参数 和 时间参数
			String mobile = "15136331892";
			String uid = "";// 选填
			testSendSms(sid, token, appid, templateid, param, mobile, uid);
		} else if (methodNumber.equals("2")) { // 指定模板-群发
			String sid = "7573371f1db9bb2d28747e387516e2a4";
			String token = "f783db36f8b9d7de1ad6fd71c9dbaaac";
			String appid = "58d7bc6cf17a48be84ae279e6f88d3eb";
			String templateid = "383921";// 模板id2
			String param = "8888,8";
			String mobile = "13162088395,15136331892";
			String uid = "";
			testSendSmsBatch(sid, token, appid, templateid, param, mobile, uid);
		} else if (methodNumber.equals("3")) { // 增加模板
			String sid = "";
			String token = "";
			String appid = "";
			String type = "";
			String template_name = "";
			String autograph = "";
			String content = "";
			testAddSmsTemplate(sid, token, appid, type, template_name, autograph, content);
		} else if (methodNumber.equals("4")) { // 查询模板
			String sid = "";
			String token = "";
			String appid = "";
			String templateid = "";
			String page_num = "";
			String page_size = "";
			testGetSmsTemplate(sid, token, appid, templateid, page_num, page_size);
		} else if (methodNumber.equals("5")) { // 编辑模板
			String sid = "";
			String token = "";
			String appid = "";
			String templateid = "";
			String type = "";
			String template_name = "";
			String autograph = "";
			String content = "";
			testEditSmsTemplate(sid, token, appid, templateid, type, template_name, autograph, content);
		} else if (methodNumber.equals("6")) { // 删除模板
			String sid = "";
			String token = "";
			String appid = "";
			String templateid = "";
			testDeleterSmsTemplate(sid, token, appid, templateid);
		}
	}
}
