package com.yfy.app.net.judge;

import com.yfy.base.Base;
import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/5/22.
 */
@Root(name = TagFinal.TEA_JUDGE_GET_ADD_PARAMETER, strict = false)
@Namespace(reference = TagFinal.NAMESPACE)
public class TeaJudgeGetAddParameterReq {
    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "session_key", required = false)
    private String session_key= Base.user.getSession_key();

    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "id", required = false)
    private int id;

    public void setId(int id) {
        this.id = id;
    }
}
