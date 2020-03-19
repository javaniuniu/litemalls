package com.javaniuniu.litemall.core.notify;

/**
 * 短信模版
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/javaniuniu
 * @Date: 2020/3/19 9:34 PM
 */
public interface SmsSender {
    /**
     * 发送短信息
     *
     * @param phone   接收通知的电话号码
     * @param content 短消息内容
     */
    SmsResult send(String phone, String content);


    /**
     * 通过短信模版发送短信息
     *
     * @param phone      接收通知的电话号码
     * @param templateId 通知模板ID
     * @param params     通知模版内容里的参数，类似"您的验证码为{1}"中{1}的值
     */
    SmsResult sendWithTemplate(String phone, String templateId, String[] params);
}
