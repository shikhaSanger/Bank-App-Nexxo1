package services;

import Dao.DbConnector;
import Dao.UserDao;
import akka.stream.impl.fusing.Log;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import controllers.HomeController;
import dto.LoginRequestDto;
import dto.LoginResponseDto;
import dto.RegistrationRequestDto;

import dto.RegistrationResponseDto;
import io.ebean.DuplicateKeyException;
import models.Password;
import models.RoleType;
import models.Status;
import models.User;
import play.data.Form;

import java.util.Date;

@Singleton
public class RegistrationService {

    //@Inject
   private final UserDao userDao;

    private final UserDao userDao2;

    /* if we want to inject the data from userDao to service, we need to create constructor and inject constructor */

    @Inject
    public RegistrationService(UserDao userDao, UserDao userDao2) {
        this.userDao = userDao;
        this.userDao2 = userDao2;
    }


    public RegistrationResponseDto save(RegistrationRequestDto requestDto) {

        RegistrationResponseDto registrationResponseDto=new RegistrationResponseDto();
        User user = new User();
        Password password = new Password();
        try {
            user.setUsername(requestDto.getUsername());
            user.setEmail(requestDto.getEmail());
            user.setAadharNumber(requestDto.getAadharNumber());
            user.setDOB(requestDto.getDob());
            user.setMobileNumber(requestDto.getMobileNumber());
            user.setCreatedOn(new Date());
            user.setAddress(requestDto.getAddress());
            user.setAddress(requestDto.getAddress());
            user.setStatus(Status.getInstanceOf(Status.CurrentStatusEnum.Active.getId()));
            user.setRoleType(RoleType.getInstanceOf(RoleType.RoleTypeEnum.Customer.getId()));

            //  user.setRoleType(requestDto.getRoleId());
            password.setUserId(user);
            password.setPassword(requestDto.getPassword());
            userDao.saveUser(user);
            userDao.saveUserPassword(password);
        }
        catch (DuplicateKeyException duplicateKeyException)
        {
            registrationResponseDto.setMessage("User Already Exist");
            return registrationResponseDto;
        }
        catch (Exception exception) {
            System.out.println(exception);
            registrationResponseDto.setMessage("exception occurs" + exception   );
            return registrationResponseDto;

        }
        registrationResponseDto.setMessage("Succesfully done");
        registrationResponseDto.setStatus(201);
        return registrationResponseDto;
    }

    public void delete() {

        //User user=new User();
        //user.setId(5);

        User user=User.find.query().where()
                .eq("email", "shikha")
                .eq("id", 7)
                .findOne();
        DbConnector.delete(user);
    }

    public void update(){

        User user=User.find.query().where()
                .eq("username","Shikha")
                .findOne();
        // user.setAadharNumber();
        DbConnector.update(user);
    }
    /* public void status(){
        Status status=new Status();
        status.setId(1);
        Status st=Status.find.query().where().eq("id", 1).findOne();

    }*/



}
