package mz.co.keomagroup.bePreparedJavaAPI.service;

import mz.co.keomagroup.bePreparedJavaAPI.model.Citizen;

import java.util.List;

public interface CitizenService {

    String createCitizen(Citizen citizen, Long cityId);

    Citizen getCitizenById(Long id);

    String verifyAccount(String otp);

    List<Citizen> getAllCitizens();

    List<Citizen> getAllCitizensByCityId(Long cityId);

    List<Citizen> getAllCitizensByProvinceId(Long provinceId);
}
