package com.yfy.app.net.notice;

import com.yfy.base.Base;
import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/5/22.
 */
@Root(name = TagFinal.NOTICE_GET_SEND_BOX_DETAIL, strict = false)
@Namespace(reference = Base.NAMESPACE)
@Order(elements = {Base.session_key,Base.id})
public class NoticeGetSendBoxDetailReq {
    @Namespace(reference = Base.NAMESPACE)
    @Element(name = "session_key", required = false)
    private String session_key= Base.user.getSession_key();

    @Namespace(reference = Base.NAMESPACE)
    @Element(name = "id", required = false)
    private int id;


    public void setId(int id) {
        this.id = id;
    }
}
