package com.tanghaohang.bs.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanghaohang.bs.entity.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> duobiao(@Param("id") String id);

    @Update("UPDATE student SET tel = tel+1 WHERE id = 'a18102963'")
    void mtel();

    @Update("UPDATE student SET year = year+1 WHERE id = 'a18102963'")
    void myear();

  /*  @Select("select * from student")
    List<Student> findAll();*/

    /*@Insert("INSERT into `student` VALUES(#{id},#{name},#{sex},#{year}," +
            "#{major}, #{cls},#{tel})")
    int insert(Student student);

    int update(Student student);
*/
/*    @Delete("delete from student where id = #{id}")
    int deleteById(@Param("id") String id);*/

/*    @Select("select * from student where name like #{name} limit #{pageNum}, #{pageSize}")
    List<Student> selectPage(Integer pageNum, Integer pageSize, String name);

    @Select("select count(*) from student where name like concat('%', #{name}, '%') ")
    Integer selectTotal(String name);*/
}
