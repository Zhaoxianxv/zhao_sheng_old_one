package com.yfy.app.net.footbook;

import com.yfy.base.Base;
import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/26.
 */
@Root(name = TagFinal.FOOT_BOOK_ADD_SUGGEST, strict = false)
@Namespace(reference = TagFinal.NAMESPACE)
@Order(elements = {Base.session_key,Base.id,Base.content,Base.date})
public class FootBookAddSuggestReq {
    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = Base.session_key, required = false)
    private String session_key;

    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = Base.date, required = false)
    private String date;

    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = Base.content, required = false)
    private String content;
    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = Base.id, required = false)
    private String id;


    public void setDate(String date) {
        this.date = date;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
}
