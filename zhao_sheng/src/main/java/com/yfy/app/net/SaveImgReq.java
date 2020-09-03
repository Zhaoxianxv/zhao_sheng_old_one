package com.yfy.app.net;

import com.yfy.base.Variables;
import com.yfy.final_tag.TagFinal;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

/**
 * Created by yfyandr on 2018/4/26.
 */
@Root(name = TagFinal.SAVE_IMG, strict = false)
@Namespace(reference = TagFinal.NAMESPACE)
@Order(elements = {"fileext","image_file"})
public class SaveImgReq {


    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "fileext", required = false)
    private String fileext;

    @Namespace(reference = TagFinal.NAMESPACE)
    @Element(name = "image_file", required = false)
    private String image_file;


    public void setFileext(String fileext) {
        this.fileext = fileext;
    }

    public void setImage_file(String image_file) {
        this.image_file = image_file;
    }
}
