package com.ranz.swagger.controller;

import com.ranz.swagger.pojo.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @program: springboot-swagger
 * @description:
 * @author: J.Flying
 * @create: 2020-11-02 11:16
 */
@Api(tags = "hello word" ,description="测试类" )
@RestController
public class HelloSwaggerController {



    @ApiOperation(value = "helloSwagger",notes = "返回输入的参数")
    @GetMapping("/helloSwagger")
    public String helloSwagger(@ApiParam("输入参数") @RequestParam("name") String name) {
        return "输入："+name;
    }


    @ApiOperation(value = "postUser",notes = "返回对象")
    @PostMapping("/postUser")
    public SysUser postUser() {
        return new SysUser();
    }

}
