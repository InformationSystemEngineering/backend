package com.example.IIS.service;

import com.example.IIS.dto.PostDto;
import com.example.IIS.dto.RegisteredUserDto;
import com.example.IIS.dto.WorkShopDto;

import java.util.List;

public interface WorkshopService {
    WorkShopDto createWorkshop(WorkShopDto workShopDto);

    WorkShopDto userAdded(WorkShopDto workShopDto, long id,long user_id);

    List<RegisteredUserDto> getAllUsersByWorkshop(long id);

}
