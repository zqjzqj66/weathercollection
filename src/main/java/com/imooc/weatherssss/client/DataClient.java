package com.imooc.weatherssss.client;

import com.imooc.weatherssss.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: CityClient
 * @date 2019/5/20 13:00
 */
@FeignClient("WEATHER-ZUUL")
public interface DataClient {

    @GetMapping("/weatherCityList/cityList")
    List<City> getCityData();

}

/*@FeignClient("WEATHER-CITYLIST")
public interface CityClient {

    @GetMapping("/cityList")
    List<City> getCityData();

}*/
