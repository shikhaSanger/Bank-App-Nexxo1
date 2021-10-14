package services;

import dto.AdminRequestDto;
import dto.AdminResponseDto;
import models.User;

public class AdminService {

    public static AdminResponseDto adminPage(AdminRequestDto adminRequestDto){
        AdminResponseDto adminResponseDto = new AdminResponseDto();

        User user = User.find.query().where().eq("email", adminRequestDto.getEmail()).findOne();

        adminResponseDto.setId(user.getId());
        adminResponseDto.setUsername(user.getUsername());
        return adminResponseDto;
    }
}
