package mz.co.keomagroup.bePreparedJavaAPI.service.impl;

import lombok.RequiredArgsConstructor;
import mz.co.keomagroup.bePreparedJavaAPI.exception.EntityNotFoundException;
import mz.co.keomagroup.bePreparedJavaAPI.model.City;
import mz.co.keomagroup.bePreparedJavaAPI.model.Province;
import mz.co.keomagroup.bePreparedJavaAPI.repository.CityRepository;
import mz.co.keomagroup.bePreparedJavaAPI.repository.ProvinceRepository;
import mz.co.keomagroup.bePreparedJavaAPI.service.LocationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final ProvinceRepository provinceRepository;
    private final CityRepository cityRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Province> getAllProvinces() {
        return provinceRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<City> getAllCitiesByProvinceId(Long provinceId) {
        return cityRepository.findAllByProvinceId(provinceId);
    }

    @Override
    @Transactional(readOnly = true)
    public Province getProvinceById(Long provinceId) {
        return provinceRepository.findById(provinceId).orElseThrow(()->
                new EntityNotFoundException("A província não foi Encontrada"));
    }

    @Override
    @Transactional(readOnly = true)
    public City getCityById(Long cityId) {
        return cityRepository.findById(cityId).orElseThrow(()->
                new EntityNotFoundException("O distrito não foi Encontrado"));
    }
}
