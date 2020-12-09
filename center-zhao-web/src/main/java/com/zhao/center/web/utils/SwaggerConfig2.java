package com.zhao.center.web.utils;

import com.zhao.center.web.config.Swagger2Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ZCH
 * @Description swagger配置实现2
 * @since 2020/12/9$ 9:57$
 */
//@Configuration
//@EnableSwagger2
//@ConditionalOnProperty(prefix = "mconfig", name = "swagger-ui-open", havingValue = "true")
public class SwaggerConfig2 extends Swagger2Config{

    public SwaggerConfig2() {
        super("管理", "后台模块", "zch", "1.2","com.zhao.center.web.controller");
    }
}
