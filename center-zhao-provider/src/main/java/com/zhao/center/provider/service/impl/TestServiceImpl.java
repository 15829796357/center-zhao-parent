package com.zhao.center.provider.service.impl;

import com.zhao.center.api.TestService;
import com.zhao.center.provider.utils.FileCopyThymeleaf;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ZCH
 * @Description
 * @since 2020/12/10$ 12:01$
 */
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public String staticPageBuild(String name) {
        FileWriter fileWriter = null;
        try {

            int number = (int) (Math.random()*99999);
            File file = new File("C:\\root\\thymeleaf\\"+number+".html");
            if(!file.getParentFile().exists()){
                file.mkdirs();
            }
            if(!file.exists()){
                file.createNewFile();
            }
            fileWriter = new FileWriter(file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Context context = new Context();
        context.setVariable("hello", "hello spring and thymeleaf!"+name);
        context.setVariable("word", "在，啊"+name);
        templateEngine.process("hello", context, fileWriter);
        return "OK";
    }

    public static void main(String[] args) throws IOException {
        int number = (int) (Math.random()*99999);
        File file = new File("C:\\root\\thymeleaf\\"+number+".html");
        if(!file.getParentFile().exists()){
            file.mkdirs();
        }
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println(file.getName());

    }

}
