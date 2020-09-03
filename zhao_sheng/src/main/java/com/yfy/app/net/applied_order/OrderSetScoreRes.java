package com.yfy.app.net.applied_order;

import com.yfy.base.Base;
import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/5/9.
 */
@Root(name =  TagFinal.ORDER_SET_SCORE +Base.RESPONSE)
public class OrderSetScoreRes {
    @Attribute(name = "xmlns", empty = TagFinal.NAMESPACE, required = false)
    public String nameSpace;

    @Element(name =  TagFinal.ORDER_SET_SCORE +Base.RESULT, required = false)
    public String result;
}
