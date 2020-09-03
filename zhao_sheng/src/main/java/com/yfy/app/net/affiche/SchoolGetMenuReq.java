package com.yfy.app.net.affiche;

import com.yfy.base.Base;
import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/26.
 */
@Root(name = TagFinal.SCHOOL_GET_MENU, strict = false)
@Namespace(reference = Base.NAMESPACE)
@Order(elements = {"no"})
public class SchoolGetMenuReq {
    @Namespace(reference = Base.NAMESPACE)
    @Element(name ="no", required = false)
    private String no;     ///

    public void setNo(String no) {
        this.no = no;
    }
}
