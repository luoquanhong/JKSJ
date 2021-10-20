package com.mappers;

import com.entity.SC;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
@Mapper
public interface SCMapper {

//    @Select("select * from SC")
    List<SC> findAllData();
}
