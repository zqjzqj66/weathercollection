package com.imooc.weatherssss.job;

import com.imooc.weatherssss.client.CityClient;
import com.imooc.weatherssss.service.WeatherCollectionService;
import com.imooc.weatherssss.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: GetCityDataJob
 * @date 2019/5/16 21:37
 */
@Component
public class CityDataJob {

    @Autowired
    private WeatherCollectionService weatherCollectionService;

    @Autowired
    private CityClient cityClient;

    //schedule注解形式的四种方式
    //两次任务之间的固定时间
    //@Scheduled(fixedDelay = 5000)
    //cron表达式
    //@Scheduled(cron = "*/5 * * * * MON-FRI")
    //两次任务之间的固定频率，不管之前的任务是否完成
    //@Scheduled(fixedRate = 5000)
    //系统启动之后，多少秒执行
    @Scheduled(fixedDelay = 1800000 )
    public void getCityDataJob() {

        System.out.println("定时执行");
        long start = System.nanoTime();

        //TODO 调用citylist微服务
        List<City> cityData = cityClient.getCityData();

        for (City city :cityData) {
            weatherCollectionService.syncWeatherData(city.getCityId());
        }
        System.out.printf("同步数据完成，共花费%.3f秒",(System.nanoTime()-start)*1.0/1000000000);
    }



}
