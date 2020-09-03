package com.yfy.app.net.delay_service;

import com.yfy.base.Base;
import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/26.
 */
@Root(name = TagFinal.DELAY_GET_CLASS_LIST_REPLACE, strict = false)
@Namespace(reference = TagFinal.NAMESPACE)
@Order(elements = {Base.session_key,Base.date,"isdateclass"})
public class DelayGetClassListReplaceReq {
    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = Base.session_key, required = false)
    private String session_key=Base.user.getSession_key();

    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = Base.date, required = false)
    private String date;

    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "isdateclass", required = false)
    private boolean isdateclass;



    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setIsdateclass(boolean isdateclass) {
        this.isdateclass = isdateclass;
    }


}
