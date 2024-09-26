package mz.co.keomagroup.bePreparedJavaAPI.service;

import mz.co.keomagroup.bePreparedJavaAPI.model.City;
import mz.co.keomagroup.bePreparedJavaAPI.model.Province;

import java.util.List;

public interface LocationService {

    List<Province> getAllProvinces();

    List<City> getAllCities();

    List<City> getAllCitiesByProvinceId(Long provinceId);

    Province getProvinceById(Long provinceId);

    City getCityById(Long city);

}
