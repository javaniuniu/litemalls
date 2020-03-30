package com.javaniuniu.litemall.core.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 快速失败返回模式
 *
 * @Author: java牛牛
 * @Web: http://javaniuniu.com
 * @GitHub https://github.com/javaniuniu
 * @Date: 2020/3/30 2:47 PM
 */
public class ValidatorConfiguration {
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .addProperty("hibernate.validator.fail_fast", "true")
                .buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        return validator;
    }
}
