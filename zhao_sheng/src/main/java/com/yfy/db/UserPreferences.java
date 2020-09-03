package com.yfy.db;

import android.content.Context;
import android.content.SharedPreferences;

import com.yfy.app.login.bean.UserAdmin;
import com.yfy.base.App;


/**
 *
 */
public class UserPreferences extends Preferences {

    /**
     * 配置文件名儿
     */
    private static final String PREFERENCE_NAME = "USER_INFO";
    /** 用户登录状态*/
    private static final String TAG_FIRST = "frist";


    private static UserPreferences userPreferences;

    private UserPreferences() {
    }

    public static UserPreferences getInstance() {
        if (userPreferences == null) {
            userPreferences = new UserPreferences();
        }
        return userPreferences;
    }



    public void clearUserAll(){
        clearAll();
    }



    public SharedPreferences getPreference() {
        return App.getApp().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    /**
     * 保存用户是否是第一次
     */
    public void saveFIRST(String first) {
        saveString(TAG_FIRST, first);
    }
    public String getFIRST() {
        return getString(TAG_FIRST, "");
    }




    /**
     *  保存推送 apikey
     */
    public void saveJPushKey(String key) {
        saveString("jpush_api_key", key);
    }
    public String getJPushKey() {
        return getString("jpush_api_key", "");
    }

    /**
     * 保存MD5
     */
    public void saveClassId(int code){
        saveInt("app_md5_code",code);
    }
    public int getClassId(){
        return getInt("app_md5_code",0);
    }

    public void saveClassIds(String code){
        saveString("app_class_id",code);
    }
    public String getClassIds(){
        return getString("app_class_id","");
    }
    /**
     * 保存学期
     */
    public void saveTermId(String code){
        saveString("time_term_id",code);
    }
    public String getTermId(){
        return getString("time_term_id","");
    }
    public void saveTermName(String name){
        saveString("time_term_name",name);
    }
    public String getTermName(){
        return getString("time_term_name","");
    }
    /**
     * 用户权限存储
     * @return
     */
    public UserAdmin getUserAdmin() {
        UserAdmin admin=new UserAdmin();
        admin.setIsassessadmin(userPreferences.getString("admin_isassessadmin",""));
        admin.setIshqadmin(userPreferences.getString("admin_ishqadmin",""));
        admin.setIsnoticeadmin(userPreferences.getString("admin_isnoticeadmin",""));
        admin.setIsqjadmin(userPreferences.getString("admin_isqjadmin",""));
        admin.setIsxcadmin(userPreferences.getString("admin_isxcadmin",""));
        admin.setIsfuncRoom(userPreferences.getString("admin_isfuncRoom",""));
        admin.setIslogistics(userPreferences.getString("admin_islogistics",""));
        admin.setIsoffice_supply(userPreferences.getString("admin_isoffice_supply",""));
        admin.setIsoffice_supply_master(userPreferences.getString("admin_isoffice_supply_master",""));
        admin.setIsdutyreport(userPreferences.getString("duty_my",""));
        admin.setIseventadmin(userPreferences.getString("event_admin",""));
        admin.setIssupplycount(userPreferences.getString("issupplycount",""));
        admin.setIsstuillcheck(userPreferences.getString("isstuillcheck",""));
        admin.setIssignetadmin(userPreferences.getString("issignetadmin",""));
        admin.setIselectiveadmin(userPreferences.getString("iselectiveadmin",""));
        admin.setIsheadmasters(userPreferences.getString("isheadmasters",""));
        return admin;
    }
    public UserAdmin saveUserAdmin( UserAdmin admin) {
        saveString("admin_isassessadmin",admin.getIsassessadmin());
        saveString("admin_ishqadmin",admin.getIshqadmin());
        saveString("admin_isnoticeadmin",admin.getIsnoticeadmin());
        saveString("admin_isqjadmin",admin.getIsqjadmin());
        saveString("admin_isxcadmin",admin.getIsxcadmin());
        saveString("admin_isfuncRoom",admin.getIsfuncRoom());
        saveString("admin_islogistics",admin.getIslogistics());
        saveString("admin_isoffice_supply",admin.getIsoffice_supply());
        saveString("admin_isoffice_supply_master",admin.getIsoffice_supply_master());
        saveString("duty_my",admin.getIsdutyreport());
        saveString("event_admin",admin.getIseventadmin());
        saveString("issupplycount",admin.getIssupplycount());
        saveString("isstuillcheck",admin.getIsstuillcheck());
        saveString("issignetadmin",admin.getIssignetadmin());
        saveString("iselectiveadmin",admin.getIselectiveadmin());
        saveString("isheadmasters",admin.getIsheadmasters());
        return admin;
    }



    public void saveEbook(String tag,String code){
        saveString(tag,code);
    }
    public String getEbook(String tag){
        return getString(tag,"");
    }

    /**
     * 保存流程输入类容
     */
    public void saveContent(String password) {
        saveString("maintain_content", password);
    }
    public String getContent() {return getString("maintain_content", "");
    }


    /**
     * 保存主页模块顺序
     */
    public void saveIndex(String index_s){
        saveString("main_index",index_s);
    }
    public String getIndex(){
        return getString("main_index","");
    }

    /**
     * 保存Goods语言顺序
     */
    public void saveGoodsIndex(String index_s){
        saveString("goods_index",index_s);
    }
    public String getGoodsIndex(){
        return getString("goods_index","");
    }
    /**
     * 保存Goods语言json
     */
    public void saveGoodsJson(String index_s){
        saveString("goods_json",index_s);
    }
    public String getGoodsJson(){
        return getString("goods_json","");
    }
    /**
     * 保存tell
     */
    public void saveTell(String tell){
        saveString("tell_string",tell);
    }
    public String getTell(){
        return getString("tell_string","");
    }

    public User getUserInfo() {
        User info = new User();
        info.setSession_key(userPreferences.getString("session_key", ""));
        info.setIdU(userPreferences.getString("id", ""));
        info.setUsername(userPreferences.getString("username", ""));
        info.setName(userPreferences.getString("name", ""));
        info.setHeadPic(userPreferences.getString("headPic", "")) ;
        info.setPwd(userPreferences.getString("pwd", ""));
        info.setFxid(userPreferences.getInt("role_id", -1));
        return info;
    }

    public void setUserInfo(User userInfo) {
        saveString("session_key", userInfo.getSession_key());
        saveString("id", userInfo.getIdU());
        saveString("username", userInfo.getUsername());
        saveString("name", userInfo.getName());
        saveString("headPic", userInfo.getHeadPic());
        saveString("pwd", userInfo.getPwd());
        saveInt("role_id", userInfo.getFxid());
    }


    public void saveSession_key(String name) {
        saveString("session_key", name);
    }
    public String getSession_key() {
        return getString("session_key","");
    }



}
