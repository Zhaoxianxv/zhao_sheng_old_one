package com.yfy.app.school.bean;

import java.util.List;

public class SchoolRes {

    /**
     * ----------------------school menu---------------
     */
    private List<SchoolMenu> websitemenu;

    public List<SchoolMenu> getWebsitemenu() {
        return websitemenu;
    }

    public void setWebsitemenu(List<SchoolMenu> websitemenu) {
        this.websitemenu = websitemenu;
    }

    /**
     * -----------------new item----------------
     */

    private List<SchoolNews> news;

    public List<SchoolNews> getNews() {
        return news;
    }

    public void setNews(List<SchoolNews> news) {
        this.news = news;
    }
    /**
     * ---------------image-------------------
     */
    private List<Newsbanner> scroll_image;

    public List<Newsbanner> getScroll_image() {
        return scroll_image;
    }

    public void setScroll_image(List<Newsbanner> scroll_image) {
        this.scroll_image = scroll_image;
    }
}
