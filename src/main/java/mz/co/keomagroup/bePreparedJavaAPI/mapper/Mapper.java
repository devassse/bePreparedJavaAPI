package mz.co.keomagroup.bePreparedJavaAPI.mapper;

import lombok.RequiredArgsConstructor;
import mz.co.keomagroup.bePreparedJavaAPI.dto.response.CityResponseDto;
import mz.co.keomagroup.bePreparedJavaAPI.dto.response.ProvinceResponseDto;
import mz.co.keomagroup.bePreparedJavaAPI.model.City;
import mz.co.keomagroup.bePreparedJavaAPI.model.Province;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final ModelMapper modelMapper;

    public ProvinceResponseDto mapProvinceToResponseDto(Province province){
        return modelMapper.map(province, ProvinceResponseDto.class);
    }

    public List<ProvinceResponseDto> mapProvinceToResponseList(List<Province> provinces){
        return  provinces.stream().map(this::mapProvinceToResponseDto).collect(Collectors.toList());
    }

    public CityResponseDto mapCityToResponseDto(City city){
        return modelMapper.map(city, CityResponseDto.class);
    }

    public List<CityResponseDto> mapCityToResponseDtoList(List<City> cities){
        return cities.stream().map(this::mapCityToResponseDto).collect(Collectors.toList());
    }
}
