package com.example.demo.controller;

import com.example.demo.constant.BaseController;
import com.example.demo.constant.HttpResult;
import com.gitee.sop.servercommon.annotation.Open;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 功能描述
 *
 * @author tonghao
 * @date 2024/1/19 16:26
 */
@RestController
@RequestMapping("/demo")
public class DemoController extends BaseController {
    @GetMapping("/simulateError")
    public void simulateError(){
        throw new RuntimeException("模拟报错");
    }

    @Open("demo.hello")
    @GetMapping("/hello")
    @Operation(summary = "测试")
    public HttpResult<String> hello(){
        return httpOk("dsa");
    }

}
