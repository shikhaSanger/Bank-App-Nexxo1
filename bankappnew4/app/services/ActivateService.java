package services;

import Dao.ActivateDao;
import dto.ActivateRequestDto;
import dto.ActivateResponseDto;
import models.Status;
import models.User;

public class ActivateService {

    public ActivateResponseDto activateService(ActivateRequestDto activateRequestDto) {
        ActivateResponseDto activateResponseDto = new ActivateResponseDto();
        if(activateRequestDto.getId()!=null) {
            User user = User.find.byId(activateRequestDto.getId());

            try {
                if (user == null) {
                    activateResponseDto.setMessage("please check id");
                    activateResponseDto.setStatus(404);
                    return activateResponseDto;
                }


                if (user.getStatus().getId() == Status.CurrentStatusEnum.Inactive.getId()) {

                    user.setStatus(Status.getInstanceOf(Status.CurrentStatusEnum.Active.getId()));
                    activateResponseDto.setMessage("successfully done");
                    activateResponseDto.setStatus(200);
                    ActivateDao.activateDao(user);
                    return activateResponseDto;
                }


            } catch (Exception exception) {
                System.out.println(exception);
                activateResponseDto.setStatus(400);
                activateResponseDto.setMessage("exception occurs");
                return activateResponseDto;
            }
        }else{
            activateResponseDto.setMessage("id is null");
            activateResponseDto.setStatus(204);
            return activateResponseDto;
        }



        activateResponseDto.setMessage("already activated");
        activateResponseDto.setStatus(400);
        return activateResponseDto;
    }
}
