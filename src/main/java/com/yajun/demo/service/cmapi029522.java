package com.yajun.demo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * aliyun实名认证demo
 */
public class cmapi029522 {


    public static void main(String[] args) throws Exception {
        String host = "https://idcardcert.market.alicloudapi.com";
        String path = "/idCardCert";
        String appcode = "你自己的AppCode";
        String idCard = "511126199112064713";
        String name = "杨过";
        String urlSend = host + path + "?idCard=" + idCard + "&name=" + name;

        URL url = new URL(urlSend);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        //格式Authorization:APPCODE (中间是英文空格)
        httpURLConnection.setRequestProperty("Authorization", "APPCODE " + appcode);
        int httpCode = httpURLConnection.getResponseCode();
        String json = read(httpURLConnection.getInputStream());
        System.out.println("/* 获取服务器响应状态码 200 正常；400 权限错误 ； 403 次数用完； */ ");
        System.out.println(httpCode);
        System.out.println("/* 获取返回的json   */ ");
        System.out.print(json);
    }

    /**
     * 读取返回结果
     *
     * @param is
     * @return
     * @throws IOException
     */
    private static String read(InputStream is) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = br.readLine()) != null) {
            line = new String(line.getBytes(), "utf-8");
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}