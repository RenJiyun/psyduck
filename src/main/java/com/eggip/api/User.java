package com.eggip.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("用户")
public class User {
    @ApiModelProperty("id")
    private long id;
    @ApiModelProperty("姓名")
    private String name;
    private long age;
}
