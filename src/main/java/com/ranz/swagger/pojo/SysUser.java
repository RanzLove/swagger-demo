package com.ranz.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: springboot-swagger
 * @description:
 * @author: J.Flying
 * @create: 2020-11-02 17:15
 */
@ApiModel("用户类")
public class SysUser {


    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
