package com.koo.springmybatis.service.Disc;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by gu on 2017/11/11.
 */
public class BlankDisc {

    private String title;
    private String artist;

    /**
     * 占位符注入
     * @param title
     * @param artist
     */
    public BlankDisc(@Value("${disc.title}") String title,
                     @Value("${disc.artist}")String artist) {
        this.title = title;
        this.artist = artist;
    }

    /**
     * SqEL
     * @param title
     * @param artist
     */
    public void BlankDiscSqEL(@Value("#{systemProperties['disc.title']}") String title,
                              @Value("#{systemProperties['disc.artist']}")String artist) {
        this.title = title;
        this.artist = artist;
    }
}
