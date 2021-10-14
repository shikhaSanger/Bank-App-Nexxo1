package services;

import dto.LoginRequestDto;
import dto.LoginResponseDto;
import models.Password;
import models.User;

public class LoginService {


    public LoginResponseDto loginValidation(LoginRequestDto loginRequestDto) {

        //int count=0;
        LoginResponseDto loginResponseDto = new LoginResponseDto();

        try {
            User user = User.find.query().where().eq("email", loginRequestDto.getEmail()).findOne();
            System.out.println(user.getUsername());
            System.out.println("Login Service");
            if (user == null) {
                loginResponseDto.setMessage("User doesn't exist");
                loginResponseDto.setResponseStatus(404);
                System.out.println(loginResponseDto);
                return loginResponseDto;
            }
            Password password=Password.find.query().where().eq("userId.id", user.getId())
                    .eq("password", loginRequestDto.getPassword()).findOne();
            if (password == null) {
                loginResponseDto.setMessage("Invalid Credentials");
                loginResponseDto.setResponseStatus(400);
                loginResponseDto.setRoleId(null);
                return loginResponseDto;
            }
            System.out.println(user.getId());
            System.out.println(password.getPassword());
            loginResponseDto.setResponseStatus(200);
            loginResponseDto.setMessage("Login Successfully");
            loginResponseDto.setRoleId(user.getRoleType().getId());
            loginResponseDto.setUserStatus(user.getStatus().getId());
            loginResponseDto.setUsername(user.getUsername());
            loginResponseDto.setId(user.getId());
//               loginResponseDto.setAadharNumber(user.getAadharNumber());
            //loginResponseDto.setRoleId(user.getRoleType().getName());
//          loginResponseDto.setDob(user.getDOB());
//          loginResponseDto.setEmail(user.getEmail());
//          loginResponseDto.setMobileNumber(user.getMobileNumber());
        }
        //}

        catch(Exception exception){
            System.out.println(exception);
            loginResponseDto.setMessage("Check credentials" +exception);
            return loginResponseDto;
        }

        return loginResponseDto;
    }
}
