package com.yfy.app.net.login;

import com.yfy.base.Base;
import com.yfy.final_tag.TagFinal;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/26.
 */
@Root(name = TagFinal.USER_DUPLICATION_LOGIN, strict = false)
@Namespace(reference = Base.NAMESPACE)
@Order(elements = {"username","password","appid","andios","stuid"})
public class UserDuplicationLoginReq {

    @Namespace(reference = Base.NAMESPACE)
    @Element(name = "username", required = false)
    public String username;

    @Namespace(reference = Base.NAMESPACE)
    @Element(name = "password", required = false)
    public String password;

    @Namespace(reference = Base.NAMESPACE)
    @Element(name = "stuid", required = false)
    public int stuid;

    @Namespace(reference = Base.NAMESPACE)
    @Element(name = "appid", required = false)
    public String appid;

    @Namespace(reference = Base.NAMESPACE)
    @Element(name = "andios", required = false)
    private String andios="and";


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
