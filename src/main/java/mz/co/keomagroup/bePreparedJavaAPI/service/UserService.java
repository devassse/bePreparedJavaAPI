package mz.co.keomagroup.bePreparedJavaAPI.service;

import mz.co.keomagroup.bePreparedJavaAPI.dto.response.StatsResponse;
import mz.co.keomagroup.bePreparedJavaAPI.model.User;

public interface UserService {

    String createUser(User user);

    User getUserById(Long id);

    StatsResponse getAllStats();

}
