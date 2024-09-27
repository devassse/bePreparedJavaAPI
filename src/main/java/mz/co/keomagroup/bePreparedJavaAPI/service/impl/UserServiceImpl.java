package mz.co.keomagroup.bePreparedJavaAPI.service.impl;

import lombok.RequiredArgsConstructor;
import mz.co.keomagroup.bePreparedJavaAPI.dto.response.StatsResponse;
import mz.co.keomagroup.bePreparedJavaAPI.exception.BadRequestException;
import mz.co.keomagroup.bePreparedJavaAPI.exception.EntityNotFoundException;
import mz.co.keomagroup.bePreparedJavaAPI.model.User;
import mz.co.keomagroup.bePreparedJavaAPI.repository.AlertRepository;
import mz.co.keomagroup.bePreparedJavaAPI.repository.CitizenRepository;
import mz.co.keomagroup.bePreparedJavaAPI.repository.UserRepository;
import mz.co.keomagroup.bePreparedJavaAPI.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AlertRepository alertRepository;
    private final CitizenRepository citizenRepository;

    @Override
    @Transactional
    public String createUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new BadRequestException("Já existe o Email no Sistema");
        }
        userRepository.save(user);
        return "Utilizador gravado com sucesso!";
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Utilizador não Encontrado!"));
    }

    @Override
    @Transactional(readOnly = true)
    public StatsResponse getAllStats() {
        return StatsResponse.builder()
                .citizens(citizenRepository.count())
                .totalAlerts(alertRepository.count())
                .totalActiveAlerts(alertRepository.countByActive(true))
                .build();
    }
}
