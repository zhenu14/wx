package com.cdl.wx.controller;

import com.alibaba.fastjson.JSONObject;
import com.cdl.wx.util.MenuUtil;
import com.cdl.wx.util.WeiXinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/menu")
@RestController
public class MenuController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/create")
    public JSONObject menuCreate(){
        log.info("menuCreate");
        JSONObject object = new JSONObject();
        String accessToken  = WeiXinUtil.getAccess_Token();
        String menu = MenuUtil.initMenu();
        System.out.println(menu);
        int result = MenuUtil.createMenu(accessToken,menu);
        if(result==0){
            log.info("菜单创建成功");
            object.put("code",result);
            object.put("msg","菜单创建成功");
        }else{
            log.info("错误码"+result);
            object.put("code",result);
            object.put("msg","菜单创建失败");
        }
        return object;
    }
}
