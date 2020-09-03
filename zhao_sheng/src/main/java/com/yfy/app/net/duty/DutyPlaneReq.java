package com.yfy.app.net.duty;

import com.yfy.base.Variables;
import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/26.
 */
@Root(name = TagFinal.DUTY_GET_PLANE, strict = false)
@Namespace(reference = TagFinal.NAMESPACE)
@Order(elements = {TagFinal.session_key,"typeid","date"})
public class DutyPlaneReq {
    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "session_key", required = false)
    private String session_key=Variables.user.getSession_key();

    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "typeid", required = false)
    private int typeid;

    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "date", required = false)
    private String date;


    public void setTypeid(int typeid) {
        this.typeid = typeid;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
