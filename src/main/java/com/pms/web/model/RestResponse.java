package com.pms.web.model;


import com.pms.json.JSONObject;

public class RestResponse {
	private String msg;
	private int code;
	private Object data;
	
	public RestResponse(){
		
	}
	public RestResponse(int code) {
		this.code = code;
	}
	public RestResponse(String msg, int code) {
		this.msg = msg;
		this.code = code;
	}
	public RestResponse(String msg, int code, Object data) {
		this.msg = msg;
		this.code = code;
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	/*
	 * Success with msg & data
	 */
	public static RestResponse success(String msg) {
		return new RestResponse(msg, 200);
	}
	public static RestResponse success(Object data) {
		return new RestResponse("success", 200, data);
	}
	public static RestResponse successWithData(String data) {
		return new RestResponse("success", 200, data);
	}
	public static RestResponse noContent() {
		return new RestResponse(204);
	}
	public static RestResponse success(int code, String msg) {
		return new RestResponse(msg, code);
	}
	public static RestResponse success(int code, String msg, Object data) {
		return new RestResponse(msg, code, data);
	}

	/*
	 * Client Error
	 */
	public static RestResponse projectNotFound() {
		return new RestResponse("Apm Project Not Found", 400);
	}
	public static RestResponse badRequst(String msg) {
		return new RestResponse(msg, 400);
	}
	public static RestResponse accessDenied(String msg) {
		return new RestResponse(msg, 403);
	}
	public static RestResponse notFound(String msg) {
		return new RestResponse(msg, 404);
	}
	public static RestResponse methodNotAllowed(String msg) {
		return new RestResponse(msg, 405);
	}
	
	/*
	 * Server Error
	 */
	public static RestResponse serverError(String msg) {
		return new RestResponse(msg, 500);
	}
	
	/*
	 * custom code & msg
	 */
	public static RestResponse error(int code, String msg) {
		return new RestResponse(msg, code);
	}
	public static RestResponse error(String msg, int code, Object data) {
		return new RestResponse(msg, code, data);
	}
	public String toJson() {
		JSONObject jo = new JSONObject();
		jo.put("msg", msg);
		jo.put("code", code);
		jo.put("data", data);
		return jo.toString();
	}
	public boolean isOk() {
		return code == 200;
	}
	@Override
	public String toString() {
		return "RestResponse [msg=" + msg + ", code=" + code + ", data=" + data + "]";
	}
	
}
