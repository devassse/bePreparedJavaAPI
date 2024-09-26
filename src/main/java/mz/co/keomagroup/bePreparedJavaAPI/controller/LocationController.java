package mz.co.keomagroup.bePreparedJavaAPI.controller;

import lombok.RequiredArgsConstructor;
import mz.co.keomagroup.bePreparedJavaAPI.dto.response.CityResponseDto;
import mz.co.keomagroup.bePreparedJavaAPI.dto.response.ProvinceResponseDto;
import mz.co.keomagroup.bePreparedJavaAPI.mapper.Mapper;
import mz.co.keomagroup.bePreparedJavaAPI.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final Mapper mapper;
    private final LocationService locationService;

    @GetMapping("/provinces")
    public ResponseEntity<List<ProvinceResponseDto>> getAllProvinces(){
        return ResponseEntity.ok(mapper.mapProvinceToResponseList(
                locationService.getAllProvinces()
        ));
    }

    @GetMapping("/province")
    public ResponseEntity<ProvinceResponseDto> getProvinceById(@RequestParam Long id){
        return  ResponseEntity.ok(mapper.mapProvinceToResponseDto(
                locationService.getProvinceById(id)
        ));
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CityResponseDto>> getAllCities(){
        return ResponseEntity.ok(mapper.mapCityToResponseDtoList(
                locationService.getAllCities()
        ));
    }

    @GetMapping("/cities/{provinceId}")
    public ResponseEntity<List<CityResponseDto>> getCityById(@PathVariable Long provinceId){
        return ResponseEntity.ok(mapper.mapCityToResponseDtoList(
                locationService.getAllCitiesByProvinceId(provinceId)
        ));
    }

    @GetMapping("/city")
    public ResponseEntity<CityResponseDto> getCityByProvinceId(@RequestParam Long id){
        return ResponseEntity.ok(mapper.mapCityToResponseDto(
                locationService.getCityById(id)
        ));
    }

}
