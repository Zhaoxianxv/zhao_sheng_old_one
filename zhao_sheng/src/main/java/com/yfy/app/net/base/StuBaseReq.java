package com.yfy.app.net.base;

import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/26.
 */
@Root(name = TagFinal.AUTHEN_GET_STU, strict = false)
@Namespace(reference = TagFinal.NAMESPACE)
public class StuBaseReq {
    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "stuid", required = false)
    private String stuid;

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }
}