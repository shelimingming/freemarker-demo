package com.myway.freemarker.demo;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

public class FreeMarkerDemo {

    private static final String TEMPLATE_PATH = "E:\\study\\Freemaker\\workspace\\myway-demo-freemaker\\src\\main\\java\\com\\myway\\freemarker\\demo\\templates";

    public static void main(String[] args) {
        // step1 创建freeMarker配置实例
        Configuration configuration = new Configuration();
        Writer out = null;
        try {
            // step2 获取模版路径
            configuration.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
            // step3 创建数据模型
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("name", "itdragon博客");
            dataMap.put("dateTime", new Date());

            List<User> users = new ArrayList<User>();
            users.add(new User(1, "ITDragon 博客"));
            users.add(new User(2, "欢迎"));
            users.add(new User(3, "You！"));
            dataMap.put("users", users);
            // step4 加载模版文件
            Template template = configuration.getTemplate("stringFreeMarker.ftl");
            // step5 生成数据
            out = new OutputStreamWriter(System.out);
            // step6 输出文件
            template.process(dataMap, out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.flush();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}