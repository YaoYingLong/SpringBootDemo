package com.nokia.example.MyBatisRepository;

import com.nokia.example.model.MyBatisModel.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    @Select("select * from user_info")
    List<UserInfo> selectAll();


}
