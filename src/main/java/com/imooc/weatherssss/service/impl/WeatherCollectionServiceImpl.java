package com.imooc.weatherssss.service.impl;

import com.imooc.weatherssss.service.WeatherCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: WeatherCollectionServiceImpl
 * @date 2019/5/19 10:48
 */
@Service
@Slf4j
public class WeatherCollectionServiceImpl implements WeatherCollectionService {

    private static final int TIME_OUT=1800;

    private final String WEATHER_URL="http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RestTemplate restTemplate;


    //同步数据 每隔30分钟 自动调用远端的rest程序来同步数据
    @Override
    public void syncWeatherData(String cityId) {
        String url=WEATHER_URL+"citykey="+cityId;
        String strBody=null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        log.info("sync data");
        //使用restTemplate来获取数据
        //返回的是对象ResponseEntity里面包含的是json
        ResponseEntity<String> entity = restTemplate.getForEntity(url, String.class);
        //获取json字符串
        if(entity.getStatusCodeValue()==200){
            strBody = entity.getBody();
            ops.set(url,strBody , TIME_OUT, TimeUnit.SECONDS);
        }

    }
}
