package com.mappers;


import com.constants.TableNameConstant;
import com.entity.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.IntegerTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.StringTypeHandler;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Results(id = "BaseResultMap", value = {
            @Result(column = "Sno", jdbcType = JdbcType.VARCHAR, javaType = String.class, typeHandler = StringTypeHandler.class, property = "sno"),
            @Result(column = "Sname", jdbcType = JdbcType.VARCHAR, javaType = String.class, typeHandler = StringTypeHandler.class, property = "Sname"),
            @Result(column = "sex", jdbcType = JdbcType.VARCHAR, javaType = String.class, typeHandler = StringTypeHandler.class, property = "sex"),
            @Result(column = "age", jdbcType = JdbcType.VARCHAR, javaType = Integer.class, typeHandler = IntegerTypeHandler.class, property = "age"),
            @Result(column = "dept", jdbcType = JdbcType.VARCHAR, javaType = String.class, typeHandler = StringTypeHandler.class, property = "dept")
    })

    @Select("select * from student")
    List<Student> findAllData();

    @Insert("insert into " + TableNameConstant.STUDENT_TABLE + " (Sno, Sname, sex, age, dept) values (#{Sno}, #{Sname}, #{sex}, #{age}, #{dept})")
    int createData(Student student);
}
