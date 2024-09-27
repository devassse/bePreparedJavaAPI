package mz.co.keomagroup.bePreparedJavaAPI.controller;

import lombok.RequiredArgsConstructor;
import mz.co.keomagroup.bePreparedJavaAPI.dto.request.UserRequestDto;
import mz.co.keomagroup.bePreparedJavaAPI.dto.response.StatsResponse;
import mz.co.keomagroup.bePreparedJavaAPI.dto.response.UserResponseDto;
import mz.co.keomagroup.bePreparedJavaAPI.mapper.Mapper;
import mz.co.keomagroup.bePreparedJavaAPI.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private  final Mapper mapper;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserRequestDto userRequestDto){
        return new ResponseEntity<>(userService.createUser(
                mapper.mapUserRequestToModel(userRequestDto)),
                HttpStatus.CREATED);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable("id") Long id){
        return ResponseEntity.ok(mapper.mapUserToResponseDto(userService.getUserById(id)));
    }

    @GetMapping("/metrics")
    public ResponseEntity<StatsResponse> getMetrics(){
        return ResponseEntity.ok(userService.getAllStats());
    }

}
