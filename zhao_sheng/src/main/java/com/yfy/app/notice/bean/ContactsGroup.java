package com.yfy.app.notice.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.yfy.final_tag.TagFinal;

import java.util.ArrayList;
import java.util.List;

public class ContactsGroup implements Parcelable {

    /**
     * depid : 6
     * depname : 行政部
     */

    private String depid;
    private String depname;
    private List<ChildBean> userinfob;

    public String getDepid() {
        return depid;
    }

    public void setDepid(String depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public List<ChildBean> getUserinfob() {
        return userinfob;
    }

    public void setUserinfob(List<ChildBean> userinfob) {
        this.userinfob = userinfob;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.depid);
        dest.writeString(this.depname);
        dest.writeList(this.userinfob);
    }

    public ContactsGroup() {
    }

    protected ContactsGroup(Parcel in) {
        this.depid = in.readString();
        this.depname = in.readString();
        this.userinfob = new ArrayList<ChildBean>();
        in.readList(this.userinfob, ChildBean.class.getClassLoader());
    }

    public static final Parcelable.Creator<ContactsGroup> CREATOR = new Parcelable.Creator<ContactsGroup>() {
        @Override
        public ContactsGroup createFromParcel(Parcel source) {
            return new ContactsGroup(source);
        }

        @Override
        public ContactsGroup[] newArray(int size) {
            return new ContactsGroup[size];
        }
    };
}
