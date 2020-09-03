package com.yfy.app.login.bean;

import com.yfy.app.login.bean.Stunlist;

import java.util.List;

/**
 * Created by yfy1 on 2016/11/23.
 */
public class UserRes {

    /**
     * id : 1
     * fxid : 13
     * headPic : http:/sy.yfyit.com/uploadfile/photo/20160530101310.jpg
     * name : 管理员
     * username : yfy
     */

    private UserinfoBean userinfo;
    /**
     * userinfo : {"id":"1","fxid":13,"headPic":"http:/sy.yfyit.com/uploadfile/photo/20160530101310.jpg","name":"管理员","username":"yfy"}
     * session_key : tea1_2263
     * result : true
     * error_code : null
     */

    private String session_key;
    private String result;
    private String  error_code;

    public UserinfoBean getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserinfoBean userinfo) {
        this.userinfo = userinfo;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public static class UserinfoBean {
        private String id;
        private int fxid;
        private int classid;
        private String headPic;
        private String name;
        private String username;

        public int getClassid() {
            return classid;
        }

        public void setClassid(int classid) {
            this.classid = classid;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getFxid() {
            return fxid;
        }

        public void setFxid(int fxid) {
            this.fxid = fxid;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }


    /**
     * 重名
     */
    private List<Stunlist> stunlist;

    public List<Stunlist> getStunlist() {
        return stunlist;
    }

    public void setStunlist(List<Stunlist> stunlist) {
        this.stunlist = stunlist;
    }
}
