package services;

import dto.*;

public class DepositePageService {

    public DepositePageResponseDto depositePage(DepositePageRequestDto depositePageRequestDto){
        DepositePageResponseDto depositePageResponseDto=new DepositePageResponseDto();
        depositePageResponseDto.setId(depositePageRequestDto.getId());
        return depositePageResponseDto;

    }

}
