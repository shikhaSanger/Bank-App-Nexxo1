package services;


import Dao.WithDrawDao;
import dto.WithdrawRequestDto;
import dto.WithdrawResponseDto;
import models.Transaction;
import models.TransactionAction;
import models.TransactionType;
import models.User;

import java.util.Date;

public class WithDrawService {

    public WithdrawResponseDto withDrawMoney(WithdrawRequestDto withdrawRequestDto) {


        WithdrawResponseDto withdrawResponseDto = new WithdrawResponseDto();
        Transaction transaction1 = new Transaction();
        if(withdrawRequestDto.getAmount()>1) {
            try {

                User user = User.find.byId(withdrawRequestDto.getId());
                transaction1.setUserId(user);

                transaction1.setAmount(withdrawRequestDto.getAmount());
                transaction1.setDescription(withdrawRequestDto.getDescription());
                transaction1.setTransactionType(TransactionType.getInstanceOf(TransactionType.TransactionTypeEnum.DEBIT.getId()));
                transaction1.setTransactionAction(TransactionAction.getInstanceOf(TransactionAction.TransactionActionEnum.WITHDRAW.getId()));
                transaction1.setCreatedOn(new Date());
                WithDrawDao.withDrawAmount(transaction1);
                withdrawResponseDto.setMessage("done");
                withdrawResponseDto.setStatus(200);


            } catch (Exception exception) {
                System.out.println(exception);
                withdrawResponseDto.setStatus(400);
                withdrawResponseDto.setMessage("exception occurs" + exception);
                return withdrawResponseDto;
            }
        }else{
            withdrawResponseDto.setMessage("Please enter valid amount");

        }

        return withdrawResponseDto;
    }
}

