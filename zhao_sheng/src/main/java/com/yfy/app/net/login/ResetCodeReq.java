package com.yfy.app.net.login;

import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/26.
 */
@Root(name = TagFinal.USER_GET_CODE_TO_EDIT_PHONE, strict = false)
@Namespace(reference = TagFinal.NAMESPACE)
public class ResetCodeReq {
    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "phone", required = false)
    private String phone;     ///

    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "usertype", required = false)
    private String usertype="tea";

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
