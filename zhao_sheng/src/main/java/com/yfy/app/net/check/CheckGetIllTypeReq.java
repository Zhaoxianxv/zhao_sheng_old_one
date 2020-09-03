package com.yfy.app.net.check;

import com.yfy.base.Base;
import com.yfy.base.Variables;
import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/26.
 */
@Root(name = TagFinal.CHECK_GET_ILL_TYPE, strict = false)
@Namespace(reference = TagFinal.NAMESPACE)
@Order(elements = {Base.session_key,"usertype"})
public class CheckGetIllTypeReq {
    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "session_key", required = false)
    private String session_key= Variables.user.getSession_key();     ///
    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "usertype", required = false)
    private String usertype= Base.user_check_type;

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
