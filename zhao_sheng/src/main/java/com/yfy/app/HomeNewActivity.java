package com.yfy.app;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.zhao_sheng.R;
import com.yfy.app.affiche.AfficheActivity;
import com.yfy.app.allclass.ShapeSingleActivity;
import com.yfy.app.answer.AnswerMainActivity;
import com.yfy.app.appointment.OrderActivity;
import com.yfy.app.attennew.AttenNewActivity;
import com.yfy.app.bean.KeyValue;
import com.yfy.app.check.CheckClassActivity;
import com.yfy.app.check.CheckTjActivity;
import com.yfy.app.cyclopedia.CyclopediaSchoolActivity;
import com.yfy.app.delay_service.ChoiceClassActivity;
import com.yfy.app.delay_service.DelayServiceMasterMainActivity;
import com.yfy.app.duty.DutyMainActivity;
import com.yfy.app.ebook.EbookListMainActivity;
import com.yfy.app.event.EventMainActivity;
import com.yfy.app.exchang.ExchangeMainActivity;
import com.yfy.app.footbook.FootBookMainActivity;
import com.yfy.app.goods.GoodsIndexctivity;
import com.yfy.app.info_submit.activity.AuthenticationActivity;
import com.yfy.app.integral.IntegralMainActivity;
import com.yfy.app.login.AlterPassActivity;
import com.yfy.app.login.bean.ClassBean;
import com.yfy.app.login.LoginActivity;
import com.yfy.app.bean.TermId;
import com.yfy.app.login.bean.UserAdmin;
import com.yfy.app.net.RetrofitGenerator;
import com.yfy.app.net.base.UserGetAdminReq;
import com.yfy.app.net.base.UserGetCurrentTermReq;
import com.yfy.app.net.base.NticeNumReq;
import com.yfy.app.net.ReqBody;
import com.yfy.app.net.ReqEnv;
import com.yfy.app.net.ResEnv;
import com.yfy.app.net.ResBody;
import com.yfy.app.maintainnew.MaintainNewActivity;
import com.yfy.app.net.base.UserSignReq;
import com.yfy.app.net.login.UserLoginReq;
import com.yfy.app.notice.cyc.NoticeActivity;
import com.yfy.app.pro.PropertyActivity;
import com.yfy.app.property.PropertyMainActivity;
import com.yfy.app.school.SchoolNewsActivity;
import com.yfy.app.seal.SealMainListActivity;
import com.yfy.app.studen_award.AwardClassTabActivity;
import com.yfy.app.studen_award.AwardMainActivity;
import com.yfy.app.tea_evaluate.TeaEvaluateActivity;
import com.yfy.app.tea_evaluate.TeatabActivity;
import com.yfy.app.tea_event.TeaActivity;
import com.yfy.app.tea_event.TeaMainActivity;
import com.yfy.app.video.VideoListMainActivity;
import com.yfy.app.vote.VoteListActivity;
import com.yfy.banner.ADInfo;
import com.yfy.banner.CycleViewPager;
import com.yfy.banner.ViewFactory;
import com.yfy.base.App;
import com.yfy.base.Base;
import com.yfy.base.Variables;
import com.yfy.base.activity.WcfActivity;
import com.yfy.db.GreenDaoManager;
import com.yfy.db.MainIndex;
import com.yfy.db.UserPreferences;
import com.yfy.final_tag.AppLess;
import com.yfy.final_tag.BadgeUtil;
import com.yfy.final_tag.ConvertObjtect;
import com.yfy.final_tag.StringJudge;
import com.yfy.final_tag.StringUtils;
import com.yfy.final_tag.TagFinal;
import com.yfy.glide.GlideTools;
import com.yfy.jpush.Logger;
import com.yfy.json.JsonParser;
import com.yfy.net.loading.interf.WcfTask;
import com.yfy.net.loading.task.ParamsTask;
import com.yfy.recycerview.DividerGridItemDecoration;
import com.yfy.recycerview.OnRecyclerItemClickListener;
import com.yfy.recycerview.RecycAnimator;
import com.yfy.upload.UploadDataService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import butterknife.Bind;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeNewActivity extends WcfActivity implements Callback<ResEnv> {

	private static final String TAG = HomeNewActivity.class.getName();
	private List<ImageView> views = new ArrayList<>();
	private List<ADInfo> infos = new ArrayList<>();
	private CycleViewPager cycleViewPager;
	@Bind(R.id.home_head)
	ImageView login_tv;
	@Bind(R.id.main_bottom_layout)
	RelativeLayout bottom_layout;
	@Bind(R.id.main_edit)
	CheckBox main_edit;
	@Bind(R.id.main_set_point)
	AppCompatTextView set_point;
	@Bind(R.id.main_edit_content)
	TextView main_contetn;


	@Bind(R.id.main_all_clear)
	AppCompatTextView clear_all;

	private List<HomeIntent> funs = new ArrayList<HomeIntent>();
	private HomeMainAdapter adapter;


	private int[] imageUrls = {
			R.drawable.home_header_0,
			R.drawable.home_header_1,
			R.drawable.home_header_2,
			R.drawable.home_header_3,
			R.drawable.home_header_4,
			R.drawable.home_header_5,
			R.drawable.home_header_6,
			R.drawable.home_header_7,

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_new_activity);
		if (App.isServiceRunning(mActivity,UploadDataService.class.getSimpleName())){
			Logger.e(TagFinal.ZXX, "UploadDataService: " );
		}else{
			startService(new Intent(App.getApp().getApplicationContext(),UploadDataService.class));//开启更新
		}
		registerBroadCast();
		initialize();
		initToolbar();
		initCollapsing();
		initRecycler();
		if (UserPreferences.getInstance().getFIRST().equals(""))
			UserPreferences.getInstance().saveFIRST(TagFinal.TRUE);



	}




	@OnClick(R.id.main_set_point)
	void setSet(){
		bottom_layout.setVisibility(View.GONE);
		UserPreferences.getInstance().saveFIRST(TagFinal.TRUE);
		isDbset();
	}

	private void isDbset(){
		List<MainIndex> db_index=GreenDaoManager.getInstance().loadAllMainIndex();
		String index_s=UserPreferences.getInstance().getIndex();

		if (StringJudge.isEmpty(db_index)){

		}else{
			if (db_index.size()!=30){
				GreenDaoManager.getInstance().clearMainIndex();
				UserPreferences.getInstance().saveIndex("");
				UserPreferences.getInstance().saveFIRST(TagFinal.FALSE);
				db_index.clear();
				index_s="";
			}
		}
		Logger.e(UserPreferences.getInstance().getFIRST());
		funs.clear();
		if (UserPreferences.getInstance().getFIRST().equals(TagFinal.TRUE)){
			if (StringJudge.isEmpty(db_index)){
				for (int i=0;i<30;i++){
					MainIndex mainIndex=new MainIndex();
					mainIndex.setKey(StringUtils.getTextJoint("%1$d",i));
					mainIndex.setNum(i);
					GreenDaoManager.getInstance().saveMainIndex(mainIndex);
				}
			}
			db_index=GreenDaoManager.getInstance().loadAllMainIndex();
			Collections.sort(db_index, new Comparator<MainIndex>() {
				@Override
				public int compare(MainIndex p1, MainIndex p2) {
					if(p1.getNum() > p2.getNum()){
						return -1;
					}
					if(p1.getNum() == p2.getNum()){
						return 0;
					}
					return 1;
					//可以按User对象的其他属性排序，只要属性支持compareTo方法
				}
			});
			for (MainIndex one:db_index){
				dbIndex(ConvertObjtect.getInstance().getInt(one.getKey()));
			}
		}else{
			if (StringJudge.isEmpty(index_s)){
				for (int i=0;i<30;i++){
					dbIndex(i);
				}
				StringBuilder sb=new StringBuilder();
				for (HomeIntent h:funs){
					sb.append(h.getIndex()).append(",");
				}
				if (sb.length()>2){
					UserPreferences.getInstance().saveIndex(sb.substring(0,sb.length()-1));
				}
			}else{
				list = Arrays.asList(index_s.split(","));
				for (String index:list){
					dbIndex(ConvertObjtect.getInstance().getInt(index));
				}
			}
		}
		adapter.setDataList(funs);
		adapter.setLoadState(2);
	}
	/**
	 * Toolbar 的NavigationIcon大小控制mipmap
	 */
	public void initToolbar() {
		Toolbar mToolbar =  findViewById(R.id.home_title_bar);
		setSupportActionBar(mToolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		mToolbar.setNavigationIcon(null);  //隐藏掉返回键比如首页，可以调用
	}

	//配置CollapsingToolbarLayout布局
	public void initCollapsing() {
		CollapsingToolbarLayout mCollapsingToolbarLayout =  findViewById(R.id.home_collapsing);
		mCollapsingToolbarLayout.setTitle(" ");
		mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
		mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色
	}




	private AppBarLayout appBarLayout;
	@Bind(R.id.home_recyclerview)
	RecyclerView recyclerView;
	public RecyclerView.OnItemTouchListener onitem;
	public DividerGridItemDecoration gray_line=new DividerGridItemDecoration();
	public DividerGridItemDecoration white_line=new DividerGridItemDecoration(Color.parseColor("#ffffff"));
	public void initRecycler(){
		appBarLayout =  findViewById(R.id.appbar_layout);
		//AppBarLayout 展开执行刷新
		appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
			@Override
			public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
				}
		});
		recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
		recyclerView.setItemAnimator(new RecycAnimator());
		//添加分割线
		recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
			// 用来标记是否正在向上滑动
			private boolean isSlidingUpward = false;
			@Override
			public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
				super.onScrollStateChanged(recyclerView, newState);
				GridLayoutManager manager = (GridLayoutManager) recyclerView.getLayoutManager();
				// 当不滑动时
				if (newState == RecyclerView.SCROLL_STATE_IDLE) {
					// 获取最后一个完全显示的itemPosition
					int lastItemPosition = manager.findLastCompletelyVisibleItemPosition();
					int itemCount = manager.getItemCount();

					// 判断是否滑动到了最后一个item，并且是向上滑动
					if (lastItemPosition == (itemCount - 1) && isSlidingUpward) {
						// 加载更多
						if (Variables.user !=null)
						bottom_layout.setVisibility(View.VISIBLE);
					}else{
						bottom_layout.setVisibility(View.GONE);
					}
				}
			}
			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
				super.onScrolled(recyclerView, dx, dy);
				// 大于0表示正在向上滑动，小于等于0表示停止或向下滑动
				isSlidingUpward = dy > 0;
			}
		});

		recyclerView.addItemDecoration(gray_line);
		adapter = new HomeMainAdapter(this,funs);
		recyclerView.setAdapter(adapter);
		mItemTouchHelper = new ItemTouchHelper(callback);
		onitem = new OnRecyclerItemClickListener(recyclerView) {
			@Override
			public void onItemClick(RecyclerView.ViewHolder vh) {
			}

			@Override
			public void onItemLongClick(RecyclerView.ViewHolder vh) {
				//判断被拖拽的是否是前两个，如果不是则执行拖拽
				//如果item不是最后一个，则执行拖拽
				if (vh.getLayoutPosition() != funs.size() - 1) {
					mItemTouchHelper.startDrag(vh);
					//获取系统震动服务
					Vibrator vib = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);//震动70毫秒
					vib.vibrate(70);
				}
			}
		};

		//编辑可拖动木块
		main_edit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked){
					main_edit.setText("完成");
					main_edit.setTextColor(Color.parseColor("#407b00"));
					main_contetn.setVisibility(View.VISIBLE);
					clear_all.setVisibility(View.GONE);
					set_point.setVisibility(View.GONE);
//					bottom_layout.setBackgroundResource(R.color.white);
					recyclerView.addOnItemTouchListener(onitem);
					mItemTouchHelper.attachToRecyclerView(recyclerView);
					recyclerView.setBackgroundResource(R.color.BrulyWood);
					recyclerView.removeItemDecoration(gray_line);
					recyclerView.addItemDecoration(white_line);
					recyclerView.setFocusable(false);
				}else{
					main_edit.setText("自定义排序");//
					main_edit.setTextColor(Color.parseColor("#858585"));
					UserPreferences.getInstance().saveFIRST(TagFinal.FALSE);
					main_contetn.setVisibility(View.GONE);
					clear_all.setVisibility(View.VISIBLE);
					set_point.setVisibility(View.VISIBLE);
					bottom_layout.setBackgroundResource(R.color.white);
					recyclerView.removeOnItemTouchListener(onitem);
					recyclerView.setBackgroundResource(R.color.white);
					recyclerView.removeItemDecoration(white_line);
					recyclerView.addItemDecoration(gray_line);
					recyclerView.setFocusable(true);
					StringBuilder sb=new StringBuilder();
					for (HomeIntent h:funs){
						sb.append(h.getIndex()).append(",");
					}
					if (sb.length()>2){
						UserPreferences.getInstance().saveIndex(sb.substring(0,sb.length()-1));
					}
					isDbset();
				}
			}
		});
	}
	public ItemTouchHelper.Callback callback=new ItemTouchHelper.Callback() {
		/**
		 * 是否处理滑动事件 以及拖拽和滑动的方向 如果是列表类型的RecyclerView的只存在UP和DOWN，
		 * 如果是网格类RecyclerView则还应该多有LEFT和RIGHT
		 * @return
		 */
		@Override
		public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
			if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
				final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
				final int swipeFlags = 0;
				return makeMovementFlags(dragFlags, swipeFlags);
			} else {
				final int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
				final int swipeFlags = 0;
//                    final int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
				return makeMovementFlags(dragFlags, swipeFlags);
			}
		}

		@Override
		public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
			//得到当拖拽的viewHolder的Position
			int fromPosition = viewHolder.getAdapterPosition();
			//拿到当前拖拽到的item的viewHolder
			int toPosition = target.getAdapterPosition();
			Logger.e(TagFinal.ZXX, "onMove: "+fromPosition+" " +toPosition);
			Logger.e(TagFinal.ZXX, "Count : "+adapter.getItemCount());
			if (fromPosition < toPosition) {
				for (int i = fromPosition; i < toPosition; i++) {
					Collections.swap(funs, i, i + 1);
				}
			} else {
				for (int i = fromPosition; i > toPosition; i--) {
					Collections.swap(funs, i, i - 1);
				}
			}
			adapter.notifyItemMoved(fromPosition, toPosition);
			//保存顺序

			return true;
		}

		@Override
		public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
			int position = viewHolder.getAdapterPosition();
			adapter.notifyItemRemoved(position);
			funs.remove(position);
		}

		/**
		 * 重写拖拽可用
		 * @return
		 */
		@Override
		public boolean isLongPressDragEnabled() {
			return false;
		}

		/**
		 * 长按选中Item的时候开始调用
		 *
		 * @param viewHolder
		 * @param actionState
		 */
		@Override
		public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
			if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
				viewHolder.itemView.setBackgroundColor(Color.LTGRAY);
			}
			super.onSelectedChanged(viewHolder, actionState);
		}
		/**
		 * 手指松开的时候还原
		 */
		@Override
		public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
			super.clearView(recyclerView, viewHolder);
			viewHolder.itemView.setBackgroundColor(0);
		}
	};
	public ItemTouchHelper mItemTouchHelper=new ItemTouchHelper(callback);


	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onResume() {
		super.onResume();
		if (Base.user != null) {
			if (Base.user.getUsertype().equals(TagFinal.USER_TYPE_TEA)){
				getNoticeNum();
			}else{
				if (Variables.user.getPwd().equals("111111")){
					toast("请修改初始密码！");
					login_tv.postDelayed(new Runnable() {
						@Override
						public void run() {
							Intent intent=new Intent(mActivity,AlterPassActivity.class);
							startActivity(intent);
						}
					}, 1000);
				}
			}
			getTerm();
			sign();
			getAdmin();
			if (Variables.user.getHeadPic()!=null){
				GlideTools.chanCircle(mActivity ,Variables.user.getHeadPic(), login_tv, R.drawable.oval_gray);
			}else{
				GlideTools.chanCircle(mActivity ,R.drawable.head_user, login_tv);
			}
		} else {
			GlideTools.chanCircle(mActivity ,R.drawable.head_user, login_tv);
		}
		isDbset();
	}


	@SuppressLint("NewApi")
	private void initialize() {
		cycleViewPager = (CycleViewPager) getSupportFragmentManager().findFragmentById(R.id.fragment_cycle_viewpager_content);
		for (int i = 0; i < imageUrls.length; i++) {
			ADInfo info = new ADInfo();
			info.setDi_d(imageUrls[i]);
			info.setContent("图片-->" + i);
			infos.add(info);
		}

		// 将最后一个ImageView添加进来
		views.add(ViewFactory.getImageViewToR(this, infos.get(infos.size() - 1).getDi_d()));
		for (int i = 0; i < infos.size(); i++) {
			views.add(ViewFactory.getImageViewToR(this, infos.get(i).getDi_d()));
		}
		// 将第一个ImageView添加进来
		views.add(ViewFactory.getImageViewToR(
				this, infos.get(0).getDi_d()));

		// 设置循环，在调用setData方法前调用
		cycleViewPager.setCycle(true);

		// 在加载数据前设置是否循环
		cycleViewPager.setData(views, infos, mAdCycleViewListener);
		//设置轮播
		cycleViewPager.setWheel(true);

		// 设置轮播时间，默认5000ms
		cycleViewPager.setTime(4000);
		//设置圆点指示图标组居中显示，默认靠右
		cycleViewPager.setIndicatorCenter();
	}

	private CycleViewPager.ImageCycleViewListener mAdCycleViewListener = new CycleViewPager.ImageCycleViewListener() {

		@Override
		public void onImageClick(ADInfo info, int position, View imageView) {
			if (cycleViewPager.isCycle()) {

			}
		}

	};

	/**
	 *
	 * @param name title
	 * @param drawableId 图标
	 * @param obj intent
	 * @param ischioce  false 瑾教师 true教师 和学生
	 * @param admin 权限
	 * @param inedx 下标
	 * @param isbase 图标颜色
	 */
	public void addItem(String name,int drawableId, Class<?> obj,boolean ischioce,String admin,String inedx,boolean isbase) {
		Intent intent=new Intent(mActivity,obj);
		HomeIntent bean=new HomeIntent(name,drawableId,intent);
		bean.setChoice(ischioce);
		bean.setBase(isbase);
		bean.setAdmin(admin);
		bean.setIndex(inedx);
		funs.add(bean);

	}
	String istrue="true";
	String notice="通知";
	String book_tab ="课程表",maintain="后勤报修";
	String vote ="投票",class_pb="班级评比",atten="请假";
	String property_clean ="校产管理",choice_class="调课",share_peo="个人分享";
	String cyc_lopide ="校园百科",home_cycop="功能室预约";
	String main_award ="学生奖励",home_answer="问答";


	public void dbIndex(int index){

		switch (index){
			case 0:
				addItem("校园新闻", R.drawable.school_news,SchoolNewsActivity.class,true,istrue,"0",true);
				break;
			case 1:
				addItem("公告", R.drawable.affiche,AfficheActivity.class,true,istrue,"1",true);
				break;
			case 2:
				addItem("每周食谱", R.drawable.dealbook,FootBookMainActivity.class,true,istrue,"2",true);
				break;
			case 3:
				addItem("新生系统", R.drawable.authen,AuthenticationActivity.class,true,istrue,"3",true);
				break;
			case 4:
				addItem("视频", R.drawable.home_video,VideoListMainActivity.class,true,istrue,"4",true);
				break;
			case 5:
				addItem("电子书学习", R.drawable.home_ebook,EbookListMainActivity.class,true,istrue,"5",true);
				break;
			case 6:
				if (isLogin(home_answer, R.drawable.home_answer,"6")){
					addItem(home_answer, R.drawable.home_answer,AnswerMainActivity.class,true,istrue,"6",true);
				}
				break;
			case 7:
				if (isLogin(cyc_lopide, R.drawable.cyc_lopide,"7")){
					addItem(cyc_lopide, R.drawable.cyc_lopide,CyclopediaSchoolActivity.class,true,istrue,"7",true);
				}
				break;
			case 8:
				if (isLogin(vote, R.drawable.vote,"8")){
					addItem(vote, R.drawable.vote,VoteListActivity.class,true,istrue,"8",true);
				}
				break;
			case 9:
				if (isLogin(class_pb, R.drawable.deyu_gray,"9")){
					addItem(class_pb, R.drawable.deyu,DeyuCheckActivity.class,true,istrue,"9",true);
				}
				break;
			case 10:
				if (isLogin(main_award, R.drawable.main_award,"10")){
					if (isTea()){
						addItem(main_award, R.drawable.main_award,AwardClassTabActivity.class,true,istrue,"10",true);
					}else{
						addItem(main_award, R.drawable.main_award,AwardMainActivity.class,true,istrue,"10",true);
					}
				}
				break;
			case 11:
				if (isLogin(book_tab, R.drawable.schedule,"11")){

					addItem(book_tab, R.drawable.schedule,WebActivity.class,true,istrue,"11",true);
				}
				break;
			case 12:
				if (isLogin("评测", R.mipmap.event,"12")){
					if (isTea()){
						addItem("评测", R.mipmap.event,TeaActivity.class,true,Variables.admin.getIsoffice_supply(),"12",true);
					}else{
						addItem("评测", R.mipmap.event,TeaMainActivity.class,true,istrue,"12",true);
					}
				}
				break;
			case 13:
				if (isLogin(maintain, R.drawable.repair,"13")){
					if (isTea()){
						addItem(maintain, R.drawable.repair,MaintainNewActivity.class,true,Variables.admin.getIshqadmin(),"13",true);
					}else{
						addItem(maintain, R.drawable.repair,MaintainNewActivity.class,false,istrue,"13",false);
					}
				}
				break;
			case 14:
				if (isLogin(atten, R.drawable.leave_day,"14")){
					if (isTea()){
						addItem(atten, R.drawable.leave_day,AttenNewActivity.class,true,Variables.admin.getIsqjadmin(),"14",true);
					}else{
						addItem(atten, R.drawable.leave_day,AttenNewActivity.class,false,istrue,"14",false);
					}
				}
				break;
			case 15:
				if (isLogin(property_clean, R.drawable.property_cleaning,"15")){
					if (isTea()){
//						addItem(property_clean, R.drawable.property_cleaning,PropertyActivity.class,true,Variables.admin.getIsxcadmin(),"15",true);
						addItem(property_clean, R.drawable.property_cleaning,PropertyMainActivity.class,true,Variables.admin.getIsxcadmin(),"15",true);
					}else{
						addItem(property_clean, R.drawable.property_cleaning,PropertyActivity.class,false,istrue,"15",false);
					}
				}
				break;
			case 16:
				if (isLogin(choice_class, R.drawable.change_class,"16")){
					if (isTea()){
						addItem(choice_class, R.drawable.change_class,ExchangeMainActivity.class,true,istrue,"16",true);
					}else{
						addItem(choice_class, R.drawable.change_class,ExchangeMainActivity.class,false,istrue,"16",false);
					}
				}
				break;
			case 17:
				if (isLogin(share_peo, R.drawable.share,"17")){
					if (isTea()){
						addItem(share_peo, R.drawable.share,ShapeSingleActivity.class,true,istrue,"17",true);
					}else{
						addItem(share_peo, R.drawable.share,ShapeSingleActivity.class,false,istrue,"17",false);
					}
				}
				break;
			case 18:
				if (isLogin(home_cycop, R.drawable.home_cycop,"18")){
					if (isTea()){
						addItem(home_cycop, R.drawable.home_cycop,OrderActivity.class,true,Variables.admin.getIsfuncRoom(),"18",true);
					}else{
						addItem(home_cycop, R.drawable.home_cycop,OrderActivity.class,false,istrue,"18",false);
					}
				}
				break;
			case 19:
				if (isLogin(notice, R.drawable.notice,"19")){
					if (isTea()){
						addItem(notice, R.drawable.notice, NoticeActivity.class,true,Variables.admin.getIsnoticeadmin(),"19",true);
					}else{
						addItem(notice, R.drawable.notice,NoticeActivity.class,false,istrue,"19",false);
					}
				}
				break;
			case 20:
				if (isLogin("教师考评统计", R.mipmap.tea_show,"20")){
					if (isTea()){
						addItem("教师考评统计", R.mipmap.tea_show,TeatabActivity.class,true,istrue,"20",true);
					}else{
						addItem("教师考评统计", R.mipmap.tea_show,TeatabActivity.class,false,istrue,"20",false);
					}
				}
				break;
			case 21:
				if (isLogin("教师考评申请", R.mipmap.tea_add,"21")){
					if (isTea()){
						addItem("教师考评申请", R.mipmap.tea_add,TeaEvaluateActivity.class,true,istrue,"21",true);
					}else{
						addItem("教师考评申请", R.mipmap.tea_add,TeaEvaluateActivity.class,false,istrue,"21",false);
					}
				}
				break;
			case 22:
				if (isLogin("物品申领", R.mipmap.goods_main,"22")){
					if (isTea()){
						addItem("物品申领", R.mipmap.goods_main,GoodsIndexctivity.class,true,Variables.admin.getIsoffice_supply(),"22",true);
					}else{
						addItem("物品申领", R.mipmap.goods_main,GoodsIndexctivity.class,false,istrue,"22",false);
					}
				}
				break;
			case 23:
				if (isLogin("行政值周", R.mipmap.main_22,"23")){
					if (isTea()){
						addItem("行政值周", R.mipmap.main_22,DutyMainActivity.class,true,Variables.admin.getIsoffice_supply(),"23",true);
					}else{
						addItem("行政值周", R.mipmap.main_22,DutyMainActivity.class,false,istrue,"23",false);
					}
				}
				break;
			case 24:
				if (isLogin("大事记", R.mipmap.main_24,"24")){
					if (isTea()){
						addItem("大事记", R.mipmap.main_24,EventMainActivity.class,true,Variables.admin.getIsoffice_supply(),"24",true);
					}else{
						addItem("大事记", R.mipmap.main_24,EventMainActivity.class,false,istrue,"24",false);
					}
				}
				break;
			case 25:
				if (isLogin("健康检查", R.mipmap.main_25,"25")){
					if (isTea()){
						addItem("健康检查", R.mipmap.main_25,CheckClassActivity.class,true,Variables.admin.getIsoffice_supply(),"25",true);
					}else{
						addItem("健康检查", R.mipmap.main_25,CheckClassActivity.class,false,istrue,"25",false);
					}
				}
				break;
			case 26:
				if (isLogin("健康检查统计", R.mipmap.main_26,"26")){
					if (isTea()){
						addItem("健康检查统计", R.mipmap.main_26,CheckTjActivity.class,true,Variables.admin.getIsstuillcheck(),"26",true);
					}else{
						addItem("健康检查统计", R.mipmap.main_26,CheckTjActivity.class,false,istrue,"26",false);
					}
				}
				break;
			case 27:
				if (isLogin("用章申请", R.mipmap.oa_seal,"27")){
					if (isTea()){
						addItem("用章申请", R.mipmap.oa_seal,SealMainListActivity.class,true,Variables.admin.getIssignetadmin(),"27",true);
					}else{
						addItem("用章申请", R.mipmap.oa_seal,SealMainListActivity.class,false,istrue,"27",false);
					}
				}
				break;

            case 28:
                if (isLogin("课后服务考勤", R.mipmap.main_delay_end,"28")){
                    if (isTea()){
                        addItem("课后服务考勤", R.mipmap.main_delay_end,ChoiceClassActivity.class,true,Variables.admin.getIssignetadmin(),"28",true);
                    }else{
                        addItem("课后服务考勤", R.mipmap.main_delay_end,ChoiceClassActivity.class,false,istrue,"28",false);
                    }
                }
                break;
            case 29:
                if (isLogin("课后服务管理", R.mipmap.main_delay_service,"29")){
                    if (isTea()){
                        addItem("课后服务管理", R.mipmap.main_delay_service,DelayServiceMasterMainActivity.class,true,Variables.admin.getIselectiveadmin(),"29",true);
                    }else{
                        addItem("课后服务管理", R.mipmap.main_delay_service,DelayServiceMasterMainActivity.class,false,istrue,"29",false);
                    }
                }
                break;


		}
	}


	private List<KeyValue> base_data;
	private void initView(){
		base_data=new ArrayList<>();
//		addItem("校园新闻", R.drawable.school_news,SchoolNewsActivity.class,true,istrue,"0",true);
		addData(TagFinal.TYPE_ITEM, "#ebb35e", base_data, R.drawable.school_news, "校园新闻", "0", "0201");
	}
	private void addData(int view, String color, List<KeyValue> data, int image, String name, String type){

		KeyValue keyValue=new KeyValue(view);
		keyValue.setName(name);
		keyValue.setKey(color);
		keyValue.setRes_image(image);
		keyValue.setType(type);
		keyValue.setSpan_size(1);
		data.add(keyValue);
	}
	private void addData(int view,String color,List<KeyValue> data,int image,String name,String type,String value){

		KeyValue keyValue=new KeyValue(view);
		keyValue.setName(name);
		keyValue.setKey(color);
		keyValue.setRes_image(image);
		keyValue.setType(type);
		keyValue.setValue(value);
		keyValue.setSpan_size(1);
		data.add(keyValue);
	}


	private List<String> list;



	public void registerBroadCast() {
		Bundle b=new Bundle();
		b.putInt(TagFinal.BADGE,0);
		Intent mintent3 = new Intent();
		mintent3.putExtras(b);
		mintent3.setAction(TagFinal.ACTION_INTENT_FILTER);
		sendBroadcast(mintent3);
		Logger.e(TagFinal.ZXX, "registerBroadCast: " );
	}


	/**
	 * 双击退出函数
	 */

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exitBy2Click();
		}
		return false;
	}

	private static Boolean isExit = false;

	private void exitBy2Click() {
		Timer tExit = null;
		if (isExit == false) {
			isExit = true;
			toastShow("再按一次退出程序");
			tExit = new Timer();
			tExit.schedule(new TimerTask() {
				@Override
				public void run() {
					isExit = false;
				}
			}, 2000);

		} else {
			finish();
			System.exit(0);
		}
	}


	private boolean isGetAdmin=false;
	public void getUserAdmin() {

		if (isGetAdmin){
			return;
		}
		isGetAdmin=true;

		getAdmin();
	}

	public void getNoticeNum(){
		if (Variables.user !=null){
			getnoticeNum();
		}
	}



	@OnClick(R.id.main_all_clear)
    void setClearAll(){
	    clearNotice();
    }
	public boolean onSuccess(String result, WcfTask wcfTask) {
	    if (!isActivity())return false;
		String taskName = wcfTask.getName();
//		if (taskName.equals(TagFinal.USER_SIGN)) {
//			TermId sign=gson.fromJson(result,TermId.class);
//			if (sign.getIslogin().equals("false")){
//				login();
//			}
//			return false;
//		}
		if (taskName.equals(TagFinal.CLEAR_NOTICE_NUM)){

			clear_all.setText("清空消息(0)");
        }
		return false;
	}

	@Override
	public void onError(WcfTask wcfTask) {
		String name=wcfTask.getName();
		if (name.equals("admin")) {
			toastShow(R.string.fail_do_not);
			return ;
		}
		if (name.equals(TagFinal.CLEAR_NOTICE_NUM)) {
			toastShow(R.string.fail_do_not);
			return ;
		}
	}

	public boolean isLogin(String name,int drawableId,String index) {
		if (Variables.user != null) {
			return true;
		}else{
			addItem(name,drawableId, LoginActivity.class,true,"true",index,false);
			return false;
		}
	}

	public boolean isTea() {
		if (Variables.user.getUsertype().equals(TagFinal.USER_TYPE_TEA)){
			return true;
		}
		return false;
	}

	/**
	 * ******************************应用小红点
	 */

	private int badge_num=0;
	private Handler handler = new Handler();

	private Runnable runnable = new MyRunnable();
	public class MyRunnable implements Runnable {
		@Override
		public void run() {
			handler.postDelayed(runnable, 9000);
			BadgeUtil.setBadgeCount(getApplicationContext(), getCount(), R.drawable.logo);
		}
	}
	private int getCount() {
		return badge_num;
	}
	private void checkPush(String name,boolean is) {
		switch (name){
			case "public_notice"://公告
				break;
			case "private_notice"://通知
				for (HomeIntent index:funs){
					if (index.getIndex().equals("19")){
						if (is){
							index.setPushCount(1);
						}else{
							index.setPushCount(0);
						}
						break;
					}
				}
				break;
			case "homework"://作业
				break;
			case "maintain"://维修
				for (HomeIntent index:funs){
					if (index.getIndex().equals("13")){
						if (is){
							index.setPushCount(1);
						}else{
							index.setPushCount(0);
						}
						break;
					}
				}
				break;
			case "attendance"://考勤
				for (HomeIntent index:funs){
					if (index.getIndex().equals("14")){
						if (is){
							index.setPushCount(1);
						}else{
							index.setPushCount(0);
						}
						break;
					}
				}
				break;
			case "schedule"://调课
				for (HomeIntent index:funs){
					if (index.getIndex().equals("16")){
						if (is){
							index.setPushCount(1);
						}else{
							index.setPushCount(0);
						}
						break;
					}

				}
				break;
			case "select_courses"://
				break;
			case "system_update"://更新
				break;
			case "function_room"://功能室
				for (HomeIntent index:funs){
					if (index.getIndex().equals("18")){
						if (is){
							index.setPushCount(1);
						}else{
							index.setPushCount(0);
						}
						break;
					}

				}
				break;
		}
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode==RESULT_OK){
			switch (requestCode){
				case TagFinal.UI_REFRESH:
					break;
			}
		}
	}



	@OnClick(R.id.home_head)
	void setHead(){
		Intent intent;
		if (Variables.user !=null){
			String term_id=UserPreferences.getInstance().getTermId();
			if (StringJudge.isEmpty(term_id)){
				toastShow("获取当前学期信息");
				getTerm();
				return;
			}
			intent = new Intent(this, IntegralMainActivity.class);
			startActivity(intent);
		}else{
			intent = new Intent(this, LoginActivity.class);
			startActivity(intent);
		}

	}



	/**
	 * ----------------------------retrofit-----------------------
	 */


//clear notice num
	private void clearNotice() {
		if (Variables.user ==null){
			return;
		}
		Object[] params = new Object[] {
				Variables.user.getSession_key(),
				""
		};
		ParamsTask clear_task = new ParamsTask(params, TagFinal.CLEAR_NOTICE_NUM, TagFinal.CLEAR_NOTICE_NUM);
		execute(clear_task);
	}


	private void login() {
		//登陆时传的Constants.APP_ID：
		String apikey=JPushInterface.getRegistrationID(mActivity);
		if(apikey==null){
			apikey="";
		}


		ReqEnv evn = new ReqEnv();
		ReqBody reqBody = new ReqBody();
		UserLoginReq req = new UserLoginReq();
		//获取参数

		req.setUsername(Base.user.getName());
		req.setPassword(Base.user.getPwd());
		req.setRole_id(Base.user.getUsertype().equals(TagFinal.USER_TYPE_TEA)?"2":"1");
		req.setAppid(apikey);

		reqBody.userLoginReq = req;
		evn.body = reqBody;
		Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().user_login(evn);
		call.enqueue(this);
		showProgressDialog("");

	}


	//登陆时传的签到
	private void sign() {
		if (Base.user ==null) return;

		ReqEnv reqEnv = new ReqEnv();
		ReqBody reqBody = new ReqBody();
		UserSignReq req = new UserSignReq();
		//获取参数
		req.setAndios("and");
		req.setAppid(JPushInterface.getRegistrationID(mActivity));
		reqBody.userSignReq = req;
		reqEnv.body = reqBody;
		Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().user_sign(reqEnv);
		call.enqueue(this);
	}


	public void getTerm() {
		if (Base.user ==null) return;
		ReqEnv reqEnv = new ReqEnv();
		ReqBody reqBody = new ReqBody();
		UserGetCurrentTermReq req = new UserGetCurrentTermReq();
		//获取参数


		reqBody.userGetCurrentTermReq = req;
		reqEnv.body = reqBody;
		Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().get_current_term(reqEnv);
		call.enqueue(this);
//		showProgressDialog("正在登录");
	}
	public void getnoticeNum() {

		ReqEnv reqEnv = new ReqEnv();
		ReqBody reqBody = new ReqBody();
		NticeNumReq req = new NticeNumReq();
		//获取参数
		reqBody.getnoticenum = req;
		reqEnv.body = reqBody;
		Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().getnoticenum(reqEnv);
		call.enqueue(this);
	}

	public void getAdmin() {
		if (Base.user ==null) return;
		ReqEnv reqEnv = new ReqEnv();
		ReqBody reqBody = new ReqBody();
		UserGetAdminReq req = new UserGetAdminReq();
		//获取参数
		reqBody.userGetAdminReq = req;
		reqEnv.body = reqBody;
		Call<ResEnv> call = RetrofitGenerator.getWeatherInterfaceApi().user_get_right(reqEnv);
		call.enqueue(this);
	}

	@Override
	public void onResponse(Call<ResEnv> call, Response<ResEnv> response) {
		if (!isActivity())return;
		dismissProgressDialog();

		ResEnv respEnvelope = response.body();
		List<String> names=StringUtils.getListToString(call.request().headers().toString().trim(), "/");
		String name=names.get(names.size()-1);
		if (respEnvelope != null) {
			ResBody b=respEnvelope.body;
			if (b.getnoticenumResponse!=null){
				String result=b.getnoticenumResponse.getnoticenumResult;
				NumRe re=gson.fromJson(result,NumRe.class);
				List<Numbean> num=re.getNotices();
				Logger.e(StringUtils.getTextJoint("%1$s:\n%2$s",name,result));
				for (Numbean bean:num){
					if (bean.getTypenum().equals("0")){
						checkPush(bean.getType(),false);
					}else{
						checkPush(bean.getType(),true);
						badge_num+=ConvertObjtect.getInstance().getInt(bean.getTypenum());
					}
				}
				clear_all.setText("清空消息（"+badge_num+"）");
				adapter.setDataList(funs);
				adapter.setLoadState(2);
			}
			if (b.userGetAdminRes !=null){
				isGetAdmin=false;
				String result=b.userGetAdminRes.result;
				Logger.e(StringUtils.getTextJoint("%1$s:\n%2$s",name,result));
				if (StringJudge.isEmpty(result)){
//					toast("当前用户没有权限");
					return ;
				}else{
//					toast("成功获取权限");
				}
				UserAdmin admin= gson.fromJson(result,UserAdmin.class);
				Variables.admin=admin;
				UserPreferences.getInstance().saveUserAdmin(admin);
				List<ClassBean> class_list=admin.getClassinfo();
				if (StringJudge.isEmpty(class_list)){
					UserPreferences.getInstance().saveClassIds("");
				}else{
					List<String> stringList=new ArrayList<>();
					for (ClassBean bean:class_list){
						stringList.add(String.valueOf(bean.getClassid()));
					}
					UserPreferences.getInstance().saveClassIds(StringUtils.subStr(stringList,"," ));
				}

				isDbset();
			}
			if (b.userGetCurrentTermRes !=null){
				isGetAdmin=false;
				String result=b.userGetCurrentTermRes.result;
				if (StringJudge.isSuccess(gson,result)){
					TermId termId=gson.fromJson(result, TermId.class);
					UserPreferences.getInstance().saveTermId(termId.getTerm().getId());
					UserPreferences.getInstance().saveTermName(termId.getTerm().getName());
				}else{
					toastShow(JsonParser.getErrorCode(result)+"\n"+"提示：部分功能将无法使用请稍后再试！");
				}
			}
			if (b.saveImgRes!=null){
				String result=b.saveImgRes.result;
				Logger.e(StringUtils.getTextJoint("%1$s:\n%2$s",name,result));
			}
			if (b.userSignRes!=null){
				String result=b.userSignRes.result;
				TermId sign=gson.fromJson(result,TermId.class);
				Logger.e(StringUtils.getTextJoint("%1$s:\n%2$s",name,result));
				if (sign.getIslogin().equals("false")){
					login();
				}
			}

		}else{
			Logger.e(StringUtils.getTextJoint("%1$s:%2$d",name,response.code()));
		}

	}

	@Override
	public void onFailure(Call<ResEnv> call, Throwable t) {
		if (!isActivity())return;
		Logger.e("onFailure  :"+call.request().headers().toString());
		dismissProgressDialog();
	}

	@Override
	public boolean isActivity() {
		return AppLess.isTopActivy(TAG);
	}


}
