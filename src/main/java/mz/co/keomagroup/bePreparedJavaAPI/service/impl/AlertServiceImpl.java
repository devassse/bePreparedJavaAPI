package mz.co.keomagroup.bePreparedJavaAPI.service.impl;

import lombok.RequiredArgsConstructor;
import mz.co.keomagroup.bePreparedJavaAPI.exception.EntityNotFoundException;
import mz.co.keomagroup.bePreparedJavaAPI.model.Alert;
import mz.co.keomagroup.bePreparedJavaAPI.model.City;
import mz.co.keomagroup.bePreparedJavaAPI.model.Province;
import mz.co.keomagroup.bePreparedJavaAPI.repository.AlertRepository;
import mz.co.keomagroup.bePreparedJavaAPI.service.AlertService;
import mz.co.keomagroup.bePreparedJavaAPI.service.LocationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;
    private final LocationService locationService;

    @Override
    @Transactional
    public String createAlert(Alert alert, Long cityId, Long provinceId) {
        City city = locationService.getCityById(cityId);
        Province province = locationService.getProvinceById(provinceId);

        alert.setActive(false);
        alert.setCity(city);
        alert.setProvince(province);

        alertRepository.save(alert);

        return "Alerta criado com sucesso!";
    }

    @Override
    @Transactional(readOnly = true)
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Alert> getAllActiveAlerts() {
        return alertRepository.findAllByActive(true);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Alert> getAllAlertsByCityId(Long cityId) {
        return alertRepository.findAllByActiveAndCityId(true, cityId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Alert> getAllAlertsByProvinceId(Long provinceId) {
        return alertRepository.findAllByActiveAndProvinceId(true, provinceId);
    }

    @Override
    @Transactional(readOnly = true)
    public Alert getAlertById(Long alertId) {
        return alertRepository.findById(alertId).orElseThrow(() ->
                new EntityNotFoundException("Alerta não Encontrado")
                );
    }

    @Override
    @Transactional
    public String activeAlert(Long alertId) {
        Alert alert = getAlertById(alertId);
        alert.setActive(true);
        alertRepository.save(alert);
        return "Alerta Activado, Perigo eminente, protejam-se!!";
    }
}
