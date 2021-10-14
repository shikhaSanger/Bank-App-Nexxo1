package services;

import dto.ListOfCustomerRequestDto;
import dto.ListOfCustomerResponseDto;
import models.RoleType;
import models.Status;
import models.Transaction;
import models.User;

import java.util.ArrayList;
import java.util.List;

import static models.Status.*;

public class ListOfCustomerService {

    public List<ListOfCustomerResponseDto> listOfCustomer(){


        List<ListOfCustomerResponseDto> listOfCustomerResponseDtoList=new ArrayList<>();
        User user=new User();

        // List<User> userList=User.find.query().where().eq("roleType.id",listOfCustomerRequestDto.getRoleType()).findList();
        List<User> userList=User.find.query().where().eq("roleType.id",RoleType.RoleTypeEnum.Customer.getId()).findList();


        for (User user1: userList) {
            ListOfCustomerResponseDto listOfCustomerResponseDto=new ListOfCustomerResponseDto();
            listOfCustomerResponseDto.setId(user1.getId());;
            listOfCustomerResponseDto.setUsername(user1.getUsername());
            listOfCustomerResponseDto.setMobileNumber(user1.getMobileNumber());
            listOfCustomerResponseDto.setAadharNumber(user1.getAadharNumber());
            listOfCustomerResponseDto.setDob(user1.getDOB());
            listOfCustomerResponseDto.setCreatedOn(user1.getCreatedOn());
            listOfCustomerResponseDto.setEmail(user1.getEmail());
            System.out.println(user1.getRoleType().getId());
            System.out.println(user1.getStatus().getId());
            listOfCustomerResponseDto.setStatus(user1.getStatus().getId());
            listOfCustomerResponseDto.setRoleType(user1.getRoleType().getId());
            listOfCustomerResponseDtoList.add(listOfCustomerResponseDto);
        }

        return listOfCustomerResponseDtoList;

    }
}
