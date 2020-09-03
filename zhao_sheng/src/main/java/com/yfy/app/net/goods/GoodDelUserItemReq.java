package com.yfy.app.net.goods;

import com.yfy.base.Base;
import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/27.
 */
@Root(name = TagFinal.GOODS_DELETE_ITEM, strict = false)
@Namespace(reference = TagFinal.NAMESPACE)
@Order(elements = {Base.session_key,Base.id})
public class GoodDelUserItemReq {
    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = Base.session_key, required = false)
    private String session_key= Base.user.getSession_key();

    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = Base.id, required = false)
    private int id;

    public void setId(int id) {
        this.id = id;
    }
}
