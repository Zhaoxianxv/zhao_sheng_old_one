package com.yfy.app.net.login;

import com.yfy.base.Base;
import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/26.
 */
@Root(name = TagFinal.USER_ADD_HEAD, strict = false)
@Namespace(reference = Base.NAMESPACE)
@Order(elements = {Base.session_key,"fileContext","filename"})
public class UserResetPicReq {

    @Namespace(reference = Base.NAMESPACE)
    @Element(name = "session_key", required = false)
    private String session_key= Base.user.getSession_key();     ///

    @Namespace(reference = Base.NAMESPACE)
    @Element(name = "fileContext", required = false)
    private String fileContext;

    @Namespace(reference = Base.NAMESPACE)
    @Element(name = "filename", required = false)
    private String filename;

    public void setFileContext(String fileContext) {
        this.fileContext = fileContext;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
