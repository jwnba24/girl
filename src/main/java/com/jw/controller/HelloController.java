package com.jw.controller;

import com.jw.util.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/5/9.
 */
@Controller
public class HelloController {

   @Autowired
   private GirlProperties girlProperties;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        //return girlProperties.getCupsize()+girlProperties.getAge();
        return "index";
    }
}
