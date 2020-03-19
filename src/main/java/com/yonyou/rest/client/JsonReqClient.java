
package com.yonyou.rest.client;


import com.alibaba.fastjson.JSONObject;
import com.yonyou.rest.HttpClientUtil;


public class JsonReqClient extends AbsRestClient {
	
	@Override
	public String sendSms(String sid, String token, String appid, String templateid, String param, String mobile, 
			String uid) {
		
		String result = "";
		
		try {
			/**
			 * 指定变量/固定模板单发
			 */
			String url = getStringBuffer().append("/sendsms").toString();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);
			jsonObject.put("param", param);
			jsonObject.put("mobile", mobile);
			jsonObject.put("uid", uid);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String sendSmsBatch(String sid, String token, String appid, String templateid, String param, String mobile,
			String uid) {
		
		String result = "";
		
		try {
			/**
			 * 指定变量/固定模板群发
			 */
			String url = getStringBuffer().append("/sendsms_batch").toString();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);
			jsonObject.put("param", param);
			jsonObject.put("mobile", mobile);
			jsonObject.put("uid", uid);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String addSmsTemplate(String sid, String token, String appid, String type, String template_name,
			String autograph, String content) {
		
		String result = "";
		
		try {
			/**
			 * 通过接口增加模板
			 */
			String url = getStringBuffer().append("/addsmstemplate").toString();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("type", type);
			jsonObject.put("template_name", template_name);
			jsonObject.put("autograph", autograph);
			jsonObject.put("content", content);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getSmsTemplate(String sid, String token, String appid, String templateid, String page_num,
			String page_size) {
		
		String result = "";
		
		try {
			/**
			 * 获取账户内的全部模板
			 */
			String url = getStringBuffer().append("/getsmstemplate").toString();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);
			jsonObject.put("page_num", page_num);
			jsonObject.put("page_size", page_size);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String editSmsTemplate(String sid, String token, String appid, String templateid, String type,
			String template_name, String autograph, String content) {
		
		String result = "";
		
		try {
			/**
			 * 编辑指定模板
			 */
			String url = getStringBuffer().append("/editsmstemplate").toString();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);
			jsonObject.put("type", type);
			jsonObject.put("template_name", template_name);
			jsonObject.put("autograph", autograph);
			jsonObject.put("content", content);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String deleterSmsTemplate(String sid, String token, String appid, String templateid) {

		String result = "";
		
		try {
			/**
			 * 删除指定模板
			 */
			String url = getStringBuffer().append("/deletesmstemplate").toString();
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("sid", sid);
			jsonObject.put("token", token);
			jsonObject.put("appid", appid);
			jsonObject.put("templateid", templateid);
			
			String body = jsonObject.toJSONString();
			
			System.out.println("body = " + body);
			
			result = HttpClientUtil.postJson(url, body, null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
