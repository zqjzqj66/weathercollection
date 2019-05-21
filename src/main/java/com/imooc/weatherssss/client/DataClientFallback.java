package com.imooc.weatherssss.client;

import com.imooc.weatherssss.vo.City;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:
 *
 * @author 周启江
 * @ClassName: DataClientFallback
 * @date 2019/5/21 9:10
 */
@Component
public class DataClientFallback implements DataClient {
    @Override
    public List<City> getCityData() {
        return null;
    }
}
