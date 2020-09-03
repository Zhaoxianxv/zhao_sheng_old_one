package com.yfy.app.net;



import com.yfy.base.Base;
import com.yfy.final_tag.TagFinal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 接口请求
 */
public interface InterfaceApi {

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SAVE_IMG})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> save_img(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.USER_GET_CURRENT_TERM})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> get_current_term(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GETNOTICENUM})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> getnoticenum(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.READNOTICE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> read_notice(@Body ReqEnv Envelope);



    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.AUTHEN_GET_STU})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> authen_get_stu(@Body ReqEnv Envelope);


    //----------------------------user--------------------
    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.USER_GET_TERM_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> user_get_term_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.USER_GET_ADMIN})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> user_get_right(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.USER_GET_MOBILE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> user_get_call(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.USER_SET_MOBILE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> user_reset_call(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.USER_ALTER_PASS_WORD})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> user_alter_pass(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.USER_LOGIN})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> user_login(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.USER_DUPLICATION_LOGIN})
    @POST(Base.POST_URI)
    Call<ResEnv> user_duplication_login(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.USER_GET_DUPLICATION_LIST})
    @POST(Base.POST_URI)
    Call<ResEnv> user_get_duplication_user(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.USER_ADD_HEAD})
    @POST(Base.POST_URI)
    Call<ResEnv> user_reset_head(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.USER_SIGN})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> user_sign(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.USER_LOGOUT})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> user_logout(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.USER_GET_CODE_TO_SYSTEM_PHONE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> send_phone_code(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.USER_GET_CODE_TO_EDIT_PHONE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> get_phone_code(@Body ReqEnv Envelope);
    /**
     * ---------------------------affiche  school---------------------
     */
    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.SCHOOL_GET_NEWS_BANNER})
    @POST(Base.POST_URI)
    Call<ResEnv> news_banner(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.SCHOOL_GET_NEWS_LIST})
    @POST(Base.POST_URI)
    Call<ResEnv> school_news_list(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.SCHOOL_GET_MENU})
    @POST(Base.POST_URI)
    Call<ResEnv> school_menu(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.VOTE_GET_MAIN_LIST})
    @POST(Base.POST_URI)
    Call<ResEnv> vote_get_main_list(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.VOTE_GET_ITEM_DETAIL})
    @POST(Base.POST_URI)
    Call<ResEnv> vote_get_detail(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.VOTE_SUBMIT})
    @POST(Base.POST_URI)
    Call<ResEnv> vote_do_submit(@Body ReqEnv Envelope);

    /**
     * ------------------------footbook----------------
     */

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.FOOT_BOOK_GET_WEEK})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> footbook_get(@Body ReqEnv Envelope);
    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.FOOT_BOOK_PRAISE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> footbook_praise(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.FOOT_BOOK_GET_POPULAR})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> footbook_get_popular(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.FOOT_BOOK_ADD_SUGGEST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> footbook_add_suggest(@Body ReqEnv Envelope);
    /**
     * ------------------------book----------------
     */

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.BOOK_GET_TAG})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> book_get_type(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.BOOK_GET_USER_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> book_get_user_list(@Body ReqEnv Envelope);


    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.VIDEO_GET_TAG})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> video_get_type(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.VIDEO_GET_MAIN_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> video_get_main_list(@Body ReqEnv Envelope);
    /**
     * ----------------------events----大事记-------
     */

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.EVENT_GET_SECTION})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> event_get_dep(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.EVENT_ADD})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> event_add(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.EVENT_DEL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> event_del(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.EVENT_DEL_IMAGE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> event_dep_image(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.EVENT_GET_DATE_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> event_get_main_data(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.EVENT_GET_USER_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> event_get_user_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.EVENT_GET_WEEK})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> event_get_week(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.EVENT_GET_WEEK_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> event_get_week_list(@Body ReqEnv Envelope);




    /**
     * --------------------------duty----------------------------------------
     */

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DUTY_TYPE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> duty_get_type(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DUTY_GET_USER})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> duty_user_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.USER_GET_WEEK_ALL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> get_week_all(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DUTY_GET_PLANE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> duty_get_plane(@Body ReqEnv Envelope);



//
    /**
     *----------------------atten-----------------------
     */
    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.ATTENDANCE_APPLY})
    @POST(Base.POST_URI)
    Call<ResEnv> atten_apply(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.ATTENDANCE_ADMIN_DO})
    @POST(Base.POST_URI)
    Call<ResEnv> atten_admin_set_state(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.ATTENDANCE_GET_USER_LIST})
    @POST(Base.POST_URI)
    Call<ResEnv> atten_get_user_list(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.ATTENDANCE_GET_ADMIN_LIST})
    @POST(Base.POST_URI)
    Call<ResEnv> atten_get_admin_list(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.ATTENDANCE_DELETE})
    @POST(Base.POST_URI)
    Call<ResEnv> atten_del_item(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ATTENDANCE_GET_COUNT})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> atten_get_count(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ATTENDANCE_GET_TYPE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> atten_get_type(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ATTENDANCE_GET_AUDITOR_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> atten_get_auditor_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.BOSS_ATTEN_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> atten_get_b_main(@Body ReqEnv Envelope);
    /**
     *----------------------order-----------------------
     */

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ORDER_GET_COUNT})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> order_get_count(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ORDER_GET_USER_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> order_get_user_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ORDER_GET_ADMIN_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> order_get_admin_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ORDER_GET_LOGISTICS_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> order_get_logistice_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ORDER_GET_DETAIL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> order_get_detail(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ORDER_ADD})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> order_apply_new(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ORDER_GET_ROOM_NAME})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> order_get_room_name(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ORDER_QUERY})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> order_query_room(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ORDER_GET_APPLY_GRADE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> order_get_apply_grade(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ORDER_ADMIN_SET})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> order_admin_set(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.ORDER_SET_SCORE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> order_set_score(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.BOSS_ORDER_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> order_get_b_main(@Body ReqEnv Envelope);



    //---------------------notice--------------------
    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.NOTICE_GET_USER_LIST})
    @POST(Base.POST_URI)
    Call<ResEnv> notice_get_user_list(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.NOTICE_GET_SEND_BOX_LIST})
    @POST(Base.POST_URI)
    Call<ResEnv> notice_get_send_list(@Body ReqEnv Envelope);//已发信息

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.NOTICE_GET_USER_DETAIL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> notice_get_user_detail(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.NOTICE_GET_SEND_BOX_DETAIL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> notice_get_send_detail(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.NOTICE_READ})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> notice_read(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.NOTICE_GET_TEA})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> notice_get_tea(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.NOTICE_GET_STU})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> notice_get_stu(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.NOTICE_SEND})
    @POST(Base.POST_URI)
    Call<ResEnv> notice_send(@Body ReqEnv Envelope);

    /**
     * --------------------------------maintain----------------------------------
     */

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.MAINTENANCE_GET_COUNT})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> maintain_get_count(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.MAINTENANCE_GET_MAIN_LIST_USER})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> maintain_get_user_list(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+TagFinal.MAINTENANCE_GET_MAIN_LIST_ADMIN})
    @POST(Base.POST_URI)
    Call<ResEnv> maintain_get_admin_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+ TagFinal.MAINTENANCE_GET_SECTION})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> maintain_get_section(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+ TagFinal.MAINTENANCE_SET_SECTION})
    @POST(Base.POST_URI)
    Call<ResEnv> maintain_set_section(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+ TagFinal.MAINTENANCE_ADD})
    @POST(Base.POST_URI)
    Call<ResEnv> maintain_add(@Body ReqEnv Envelope);
    @Headers({Base.Content_Type, Base.SOAP_ACTION+ TagFinal.MAINTENANCE_ADMIN_SET_STATE})
    @POST(Base.POST_URI)
    Call<ResEnv> maintain_admin_set_state(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+ TagFinal.MAINTENANCE_DELETE_MAINTAIN})
    @POST(Base.POST_URI)
    Call<ResEnv> maintain_del_item(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+ TagFinal.BOSS_MAINTAIN_LIST})
    @POST(Base.POST_URI)
    Call<ResEnv> maintain_get_b_main(@Body ReqEnv Envelope);

    @Headers({Base.Content_Type, Base.SOAP_ACTION+ TagFinal.BOSS_MAINTAIN_LIST_DETAIL})
    @POST(Base.POST_URI)
    Call<ResEnv> maintain_get_b_detail(@Body ReqEnv Envelope);



    /**
     * -----------------------tea评测--------------------------
     */
    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.TEA_JUDGE_GET_ADD_TYPE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> judge_get_add_type(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.TEA_JUDGE_GET_STATISTICS_TYPE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> judge_get_tj_type(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.TEA_JUDGE_GET_STATISTICS_DATA})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> judge_get_statistics_data(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.TEA_JUDGE_GET_YEAR})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> judge_get_year(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.TEA_JUDGE_GET_ADD_PARAMETER})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> judge_get_add_parameter(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.TEA_JUDGE_GET_INFO_DETAIL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> judge_get_info_detail(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.TEA_JUDGE_GET_INFO_YEAR_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> judge_get_info_year_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.TEA_JUDGE_DEL_ITEM})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> judge_del_item(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.TEA_JUDGE_DEL_PIC})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> judge_del_image(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.TEA_JUDGE_ADD})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> judge_add(@Body ReqEnv Envelope);


    /**
     * ---------------------goods---------------------
     */

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_GET_COUNT_ADMIN})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_get_count_admin(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_GET_COUNT_MASTER})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_get_count_master(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_GET_COUNT_SCHOOL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_get_count_school(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_GET_STATIONERY_TYPE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_get_stationery_type(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_GET_MASTER_USER})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_get_master_user(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_GET_SCHOOL_RECORD_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_get_record_list_school(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_GET_USER_RECORD_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_get_record_list_user(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_GET_ADMIN_RECORD_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_get_record_list_admin(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_GET_MASTER_RECORD_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_get_record_list_master(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_GET_ITEM_DETAILS})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_get_item_detail(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_DELETE_ITEM})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_del_item(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_ADD_APPLY})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_add_apply(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_ADD_STATIONERY_TYPE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_add_stationery_type(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_ADMIN_APPLY})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_admin_apply(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_SEARCH_GET_STATIONERY_TYPE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_search_get_stationery_type(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_NUM_ADD})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_num_add(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_NUM_GET_COUNT})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_num_count(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_NUM_GET_BYID})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_num_byid(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_NUM_GET_USER_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_num_user_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_NUM_GET_ADMIN_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_num_admin(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.GOODS_NUM_DO_STATE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> goods_num_do(@Body ReqEnv Envelope);


    /**
     * ---------------------------satisfaction------
     */
    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SATISFACTION_STU_GET_TEAS})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> satisfaction_get_tea_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SATISFACTION_STU_GET_SCHOOL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> satisfaction_get_school(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SATISFACTION_STU_SET_TEA_SCORE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> satisfaction_stu_set_tea_score(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SATISFACTION_STU_SET_SCHOOL_SCORE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> satisfaction_stu_set_school_score(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SATISFACTION_GET_DETAILS})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> satisfaction_get_detail(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SATISFACTION_TEA_GET_MAIN})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> satisfaction_tea_get_main(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SATISFACTION_TEA_GET_STU})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> satisfaction_tea_get_stu(@Body ReqEnv Envelope);


    /**
     * ---------------------check---------------------
     */

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.CHECK_GET_TJ})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> check_tj_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.CHECK_GET_TYPE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> check_get_type(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.CHECK_GET_ILL_TYPE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> check_get_ill_type(@Body ReqEnv Envelope);


    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.CHECK_GET_CLASS})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> check_get_class(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.CHECK_GET_STU})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> check_get_stu(@Body ReqEnv Envelope);
    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.CHECK_GET_STU_TO_TYPE_ILL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> check_get_stu_to_ill(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.CHECK_GET_STU_ITEM_DETAIL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> check_get_stu_parent_detail(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.CHECK_GET_STU_ALL_DETAIL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> check_get_stu_child_detail(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.CHECK_SUBMIT_YES})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> check_submit_yes(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.CHECK_ADD_PARENT})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> check_add_parent(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.CHECK_ADD_CHILD})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> check_add_child(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.CHECK_DEL_CHILD})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> check_stu_del_child(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.CHECK_DEL_PARENT})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> check_stu_del_parent(@Body ReqEnv Envelope);


    //----------------seal--------------------------
    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SEAL_GET_SEAL_TYPE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> seal_get_seal_type(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SEAL_GET_MASTER_COUNT})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> seal_get_admin_count(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SEAL_GET_USER_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> seal_get_user_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SEAL_GET_ADMIN_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> seal_get_admin_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SEAL_GET_APPLY_MASTER_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> seal_get_apply_master_user(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SEAL_SUBMIT})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> seal_submit(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SEAL_GET_ITEM_BYID})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> seal_get_byid(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SEAL_GET_ALL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> seal_get_all(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.SEAL_DO})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> seal_set_do(@Body ReqEnv Envelope);


    //-------------------------delay---------------

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DELAY_ADMIN_GET_TODAY_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> delay_admin_get_today_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DELAY_ADMIN_GET_CLASS_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> delay_admin_get_class_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DELAY_ADMIN_get_TO_CLASS_EVENT_DETAIL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> delay_admin_get_to_class_detail(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DELAY_ADMIN_CLASS_SET})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> delay_admin_class_set(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DELAY_GET_TYPE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> delay_get_type(@Body ReqEnv Envelope);
    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DELAY_GET_ITEM_DETAIL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> delay_get_item_detail(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DELAY_GET_CLASS_STU_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> delay_get_class_stu(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DELAY_DEL})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> delay_del_stu_item(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DELAY_GET_CLASS_LIST_TEA})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> delay_get_class_list_tea(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION + TagFinal.DELAY_GET_CLASS_LIST_REPLACE})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> delay_get_class_list_replace(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DELAY_GET_COPY_LIST})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> delay_get_copy_list(@Body ReqEnv Envelope);

    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DELAY_COPY_SET})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> delay_copy_set(@Body ReqEnv Envelope);
    @Headers({TagFinal.Content_Type, TagFinal.SOAP_ACTION+TagFinal.DELAY_TEA_ADD})
    @POST(TagFinal.POST_URI)
    Call<ResEnv> delay_tea_add(@Body ReqEnv Envelope);

}
