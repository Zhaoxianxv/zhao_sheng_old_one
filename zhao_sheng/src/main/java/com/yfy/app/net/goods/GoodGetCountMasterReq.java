package com.yfy.app.net.goods;

import com.yfy.base.Variables;
import com.yfy.final_tag.TagFinal;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/27.
 */
@Root(name = TagFinal.GOODS_GET_COUNT_MASTER, strict = false)
@Namespace(reference = TagFinal.NAMESPACE)
public class GoodGetCountMasterReq {
    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "session_key", required = false)
    private String session_key= Variables.user.getSession_key();
}
