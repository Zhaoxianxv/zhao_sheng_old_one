package com.yfy.app.net.base;

import com.yfy.base.Base;
import com.yfy.base.Variables;
import com.yfy.final_tag.TagFinal;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/26.
 */
@Root(name = TagFinal.USER_GET_MOBILE, strict = false)
@Namespace(reference = TagFinal.NAMESPACE)
public class UserGetCallReq {
    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "session_key", required = false)
    private String session_key= Base.user.getSession_key();     ///
}
