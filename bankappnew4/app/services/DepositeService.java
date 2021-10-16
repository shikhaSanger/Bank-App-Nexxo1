package services;

import Dao.DepositeDao;
import dto.DepositeRequestDto;
import dto.DepositeResponseDto;
import models.Transaction;
import models.TransactionAction;
import models.TransactionType;
import models.User;

import java.util.Date;

public class DepositeService {
    //@Inject
    //private final DepositeDao depositeDao;

//   // public static DepositeService(DepositeDao depositeDao) {
//        this.depositeDao = depositeDao;
//    }

    public DepositeResponseDto addBalance(DepositeRequestDto depositeRequestDto){

        DepositeResponseDto depositeResponseDto=new DepositeResponseDto();
        Transaction transaction=new Transaction();
        if(depositeRequestDto.getAmount()>0) {
try {
    User user = User.find.byId(depositeRequestDto.getId());
    transaction.setUserId(user);
    transaction.setAmount(depositeRequestDto.getAmount());
    transaction.setDescription(depositeRequestDto.getDescription());
   // transaction.setTransactionType(TransactionType.getInstanceOf(TransactionType.TransactionTypeEnum.CREDIT.getId()));
    transaction.setTransactionAction(TransactionAction.getInstanceOf(TransactionAction.TransactionActionEnum.Deposite.getId()));
    transaction.setCreatedOn(new Date());
   // transaction.setId(user.getId());
    transaction.setTransactionType(TransactionType.find.byId(1));

     DepositeDao.saveAmount(transaction);
     depositeResponseDto.setStatus(200);

     //depositeResponseDto.setId(transaction.getId());
     depositeResponseDto.setMessage("successfully done");

    }catch(Exception exception){

    System.out.println(exception);
    depositeResponseDto.setMessage("exception occurred" +exception);
    return depositeResponseDto;
}
            }else{
            depositeResponseDto.setMessage("Please enter valid amount");
            return depositeResponseDto;
        }
       // loginResponseDto.setUsername(user.getUsername());
       // loginResponseDto.setUserStatus(user.getStatus().getName());
        return depositeResponseDto;
    }

}
