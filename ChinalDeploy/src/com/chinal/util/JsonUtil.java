package com.chinal.util;

import java.util.Collection;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class JsonUtil {

	public static String getJsonString(Collection collection){
		String jsonString = null;
		JsonConfig jsonConfig = new JsonConfig();
		jsonString = JSONArray.fromObject(collection, jsonConfig).toString();  
		return jsonString;
	}
}
