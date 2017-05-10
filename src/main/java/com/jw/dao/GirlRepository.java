package com.jw.dao;

import com.jw.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {

    //根据该法名称来查询
    public List<Girl> findByAge(int age);




}
