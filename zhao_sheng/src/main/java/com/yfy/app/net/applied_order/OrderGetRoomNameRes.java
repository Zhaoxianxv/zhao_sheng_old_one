package com.yfy.app.net.applied_order;

import com.yfy.base.Base;
import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/5/10.
 */
@Root(name =  TagFinal.ORDER_GET_ROOM_NAME +Base.RESPONSE)
public class OrderGetRoomNameRes {
    @Attribute(name = Base.XMLNS, empty = Base.NAMESPACE, required = false)
    public String nameSpace;

    @Element(name =  TagFinal.ORDER_GET_ROOM_NAME +Base.RESULT, required = false)
    public String result;
}
