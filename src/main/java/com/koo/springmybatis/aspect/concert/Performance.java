package com.koo.springmybatis.aspect.concert;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by gu on 2017/11/11.
 */
public interface Performance {
    @Pointcut()
    public void perform();
}
