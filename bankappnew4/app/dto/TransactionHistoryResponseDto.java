package dto;

import java.util.Date;

public class TransactionHistoryResponseDto {
   // List<TransactionHistoryResponseDto> transactionHistoryResponseDtoList=new List<TransactionHistoryResponseDto>();



    private Integer id;
    private String username;
    private Integer amount;
    private Date createdOn;
    private String description;
    private int transactionType;
    private String message;

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getMessage() {
        return message;
    }

    public TransactionHistoryResponseDto setMessage(String message) {
        this.message = message;
        return null;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreatedOn(Date createdOn) {
        return this.createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
