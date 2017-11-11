package com.koo.springmybatis.constant;

import com.koo.springmybatis.config.SpringRootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by gu on 2017/11/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = SpringRootConfig.class)
public class ExpressiveConfigTest {

    @Autowired
    ExpressiveConfig expressiveConfig;

    @Test
    public void testProperties() throws Exception {
        Assert.assertEquals("study-spring",expressiveConfig.getTitle());
    }

}