package com.yfy.app.net.event;

import com.yfy.base.Base;
import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/26.
 */
@Root(name = TagFinal.EVENT_GET_WEEK_LIST+Base.RESPONSE)
public class EventGetWeekListRes {

    @Attribute(name = "xmlns", empty = TagFinal.NAMESPACE, required = false)
    public String nameSpace;

    @Element(name =  TagFinal.EVENT_GET_WEEK_LIST+Base.RESULT, required = false)
    public String result;
}
