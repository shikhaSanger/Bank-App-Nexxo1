package dto;

import models.Status;

public class DeactivateRequestDto {

    private Integer id;

   private Status statusAfterChange;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Status getStatusAfterChange() {
        return statusAfterChange;
    }

    public void setStatusAfterChange(Status statusAfterChange) {
        this.statusAfterChange = statusAfterChange;
    }
}
