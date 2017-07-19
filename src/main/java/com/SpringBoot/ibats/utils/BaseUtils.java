package com.SpringBoot.ibats.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Random;

/**
 * Created by Administrator on 2017/6/14 0014.
 */
public class BaseUtils {
    public static Random random = new Random();
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected ServletContext application;

    public static String getRandom(int length) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < length; i++) {
            boolean isChar = (random.nextInt(2) % 2 == 0);// 输出字母还是数字
            if (isChar) { // 字符串
                int choice = (random.nextInt(2) % 2 == 0) ? 65 : 97; // 取得大写字母还是小写字母
                ret.append((char) (choice + random.nextInt(26)));
            } else { // 数字
                ret.append(Integer.toString(random.nextInt(10)));
            }
        }
        return ret.toString();
    }

    /**
     * 将字符串返回给前端
     * @param str
     */
    public void backClient(String str){
        PrintWriter pw = null;
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/application;charset=utf-8");
        try {
            pw = response.getWriter();
            Object json = JSON.parse(str);
            pw.write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        this.application = session.getServletContext();
    }

}
