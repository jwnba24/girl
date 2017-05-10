package com.jw.controller;

import com.jw.entity.Girl;
import com.jw.dao.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/5/9.
 */
@RestController

public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    //查询女生列表
    @GetMapping(value = "/girls")
    public List<Girl> getGirlList() {


        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@Valid Girl girl_add, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        Girl girl=new Girl();
        girl.setCupsize(girl_add.getCupsize());
        girl.setAge(girl_add.getAge());
        return girlRepository.save(girl);
    }

    //查询一个女生
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    //更新女生信息
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,@RequestParam("cupsize") String cupsize,@RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setCupsize(cupsize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }


    //删除女生
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }


}
