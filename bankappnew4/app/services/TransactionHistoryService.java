package services;

import dto.TransactionHistoryRequestDto;
import dto.TransactionHistoryResponseDto;
import models.Transaction;
import models.User;

import java.util.*;

public class TransactionHistoryService {
    public List<TransactionHistoryResponseDto> transactionHistoryService(TransactionHistoryRequestDto transactionHistoryRequestDto) {

        User user = new User();


        // TransactionHistoryResponseDto transactionHistoryResponseDto=new TransactionHistoryResponseDto();
        List<Transaction> transactionList = Transaction.find.query().where().eq("user_id", transactionHistoryRequestDto.getId()).findList();
        List<TransactionHistoryResponseDto> transactionHistoryResponseDtoList = new ArrayList<>();

        for (Transaction transaction : transactionList) {
            TransactionHistoryResponseDto transactionHistoryResponseDto = new TransactionHistoryResponseDto();
            transactionHistoryResponseDto.setAmount(transaction.getAmount());
            transactionHistoryResponseDto.setId(transaction.getId());
            transactionHistoryResponseDto.setDescription(transaction.getDescription());
            transactionHistoryResponseDto.setCreatedOn(transaction.getCreatedOn());
            transactionHistoryResponseDto.setTransactionType(transaction.getTransactionType().getId());
           // transactionHistoryResponseDto.setUsername(user.getUsername());
            transactionHistoryResponseDtoList.add(transactionHistoryResponseDto);
        }
//        catch(Exception exception){
//        System.out.println(exception);
//            //TransactionHistoryResponseDto transactionHistoryResponseDto=new TransactionHistoryResponseDto();
//            transactionHistoryResponseDtoList.add(transactionHistoryResponseDto.setMessage("Exception occurs"));
//
//            }
            return transactionHistoryResponseDtoList;
        }

    }
