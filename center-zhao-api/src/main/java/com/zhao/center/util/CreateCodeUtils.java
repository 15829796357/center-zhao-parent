package com.zhao.center.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZCH
 * @Description 编码生成配置
 * @since 2020/9/4$ 14:23$
 */
public class CreateCodeUtils {
    /** 订单号生成(NEW) **/
    private static final AtomicInteger SEQ = new AtomicInteger(1000);
    private static final DateTimeFormatter DF_FMT_PREFIX = DateTimeFormatter.ofPattern("yyMMddHHmmssSS");
    private static ZoneId ZONE_ID = ZoneId.of("Asia/Shanghai");

    public static String generateOrderNo(){
        LocalDateTime dataTime = LocalDateTime.now(ZONE_ID);
        if(SEQ.intValue()>9990){
            SEQ.getAndSet(1000);
        }
        return  dataTime.format(DF_FMT_PREFIX)+SEQ.getAndIncrement();
    }

    public static void main(String[] args) {
        System.out.println(generateOrderNo());
    }
}
