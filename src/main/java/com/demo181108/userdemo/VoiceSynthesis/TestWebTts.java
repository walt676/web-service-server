package com.demo181108.userdemo.VoiceSynthesis;

import io.netty.util.internal.StringUtil;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class TestWebTts {
	// 评测webapi接口地址
	private static final String WEBTTS_URL = "http://api.xfyun.cn/v1/service/v1/tts";
	// 测试应用ID
	private static final String TEST_APPID = "5c067af3";
	// 测试接口密钥
	private static final String TEST_API_KEY = "086113877eb0d0e3e66d8b47b0d53801";

	public static void main(String[] args) throws IOException {
//		String aue = "raw";
//		Map<String, String> header = getHeader("audio/L16;rate=16000", aue, "xiaoyan", "50", "50", "", "text", "50");
//		String text = "新的一个橘子";
//		Map<String, Object> resultMap = HttpUtil.doMultiPost(WEBTTS_URL, header, "text=" + text);
	}

	/**
	 * 组装http请求头
	 * 
	 * @param aue
	 * @param resultLevel
	 * @param language
	 * @param category
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private static Map<String, String> getHeader(String auf, String aue, String voiceName, String speed, String volume, String engineType, String textType, String pitch) throws UnsupportedEncodingException {
		String curTime = System.currentTimeMillis() / 1000L + "";
		String param = "{\"auf\":\"" + auf + "\"";
		if (!StringUtil.isNullOrEmpty(aue)) {
			param += ",\"aue\":\"" + aue + "\"";
		}
		if (!StringUtil.isNullOrEmpty(voiceName)) {
			param += ",\"voice_name\":\"" + voiceName + "\"";
		}
		if (!StringUtil.isNullOrEmpty(speed)) {
			param += ",\"speed\":\"" + speed + "\"";
		}
		if (!StringUtil.isNullOrEmpty(volume)) {
			param += ",\"volume\":\"" + volume + "\"";
		}
		if (!StringUtil.isNullOrEmpty(pitch)) {
			param += ",\"pitch\":\"" + pitch + "\"";
		}
		if (!StringUtil.isNullOrEmpty(engineType)) {
			param += ",\"engine_type\":\"" + engineType + "\"";
		}
		if (!StringUtil.isNullOrEmpty(textType)) {
			param += ",\"text_type\":\"" + textType + "\"";
		}
		param += "}";

		String paramBase64 = new String(Base64.encodeBase64(param.getBytes("UTF-8")));
		String checkSum = DigestUtils.md5Hex(TEST_API_KEY + curTime + paramBase64);
		Map<String, String> header = new HashMap<String, String>();
		header.put("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
		header.put("X-Param", paramBase64);
		header.put("X-CurTime", curTime);
		header.put("X-CheckSum", checkSum);
		header.put("X-Real-Ip", "192.168.1.102");
		header.put("X-Appid", TEST_APPID);
		System.out.println(header);
		return header;
	}
}
