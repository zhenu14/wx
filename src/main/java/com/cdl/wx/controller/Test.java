package com.cdl.wx.controller;

import com.cdl.wx.util.WeiXinUtil;

public class Test {

    public static void main(String[] args) {
        String access_token = WeiXinUtil.getAccess_Token();
        System.out.println("调用成功access_token:"+access_token);
    }
}
