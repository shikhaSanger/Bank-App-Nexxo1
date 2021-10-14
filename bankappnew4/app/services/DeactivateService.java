package services;

import Dao.DeactivateDao;
import dto.DeactivateRequestDto;
import dto.DeactivateResponseDto;
import io.ebean.DuplicateKeyException;
import models.Status;
import models.User;

public class DeactivateService {


    public DeactivateResponseDto deactivateService(DeactivateRequestDto deactivateRequestDto) {
        DeactivateResponseDto deactivateResponseDto = new DeactivateResponseDto();
        if(deactivateRequestDto.getId()!=null) {
            User user = User.find.byId(deactivateRequestDto.getId());
            try {
                if (user == null) {
                    deactivateResponseDto.setMessage("please check id");
                    deactivateResponseDto.setStatus(404);
                    return deactivateResponseDto;
                }
                if (user.getStatus().getId() == Status.CurrentStatusEnum.Active.getId()) {

                    user.setStatus(Status.getInstanceOf(Status.CurrentStatusEnum.Inactive.getId()));
                    deactivateResponseDto.setMessage("successfully done");
                    deactivateResponseDto.setStatus(200);
                    DeactivateDao.deactivateDao(user);
                    return deactivateResponseDto;
                }
            } catch (NullPointerException nullPointerException) {
                System.out.println(nullPointerException);
                deactivateResponseDto.setStatus(400);
                deactivateResponseDto.setMessage("exception occurs");
                return deactivateResponseDto;
            } catch (Exception exception) {
                System.out.println(exception);
                deactivateResponseDto.setStatus(400);
                deactivateResponseDto.setMessage("exception occurs");
                return deactivateResponseDto;
            }
        }else{
            deactivateResponseDto.setMessage("Id is null");
            deactivateResponseDto.setStatus(204);
            return deactivateResponseDto;
        }
        deactivateResponseDto.setMessage("already deactivated");
        deactivateResponseDto.setStatus(400);
        return deactivateResponseDto;
    }
}
