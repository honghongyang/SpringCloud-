package com.lzw.atmm.tsd.configer;

public interface SystemInfo {
    public static final String CRAFT_FOCUS_COLOR = "craft.focus.color";
    public static final String CRAFT_TAG_COLOR = "craft.tag.color";
    public static final String CRAFT_DEFAULT_COLOR = "craft.default.color";
    public static final String CRAFT_CIVIL_COLOR = "craft.civil.color";
    public static final String CRAFT_ARMY_COLOR = "craft.army.color";
    public static final String CRAFT_APP_COLOR = "craft.app.color";
    public static final String CRAFT_LOWACC_COLOR = "craft.lowacc.color";
    public static final String CRAFT_HIGHACC_COLOR = "craft.highacc.color";
    public static final String CRAFT_DOM2DOM_COLOR = "craft.dom2dom.color";//内机国内
    public static final String CRAFT_DOM2FOR_COLOR = "craft.dom2for.color";//内机国际
    public static final String CRAFT_FOR2FOR_COLOR = "craft.for2for.color";//外机飞越
    public static final String CRAFT_FOR2DOM_COLOR = "craft.for2dom.color";//外机落地
    public static final String CRAFT_REGION_COLOR = "craft.region.color";//地区航班
	
    public static final String CRAFT_TAG_VISIBLE = "craft.tag.visible";
	public static final String CRAFT_MAP_SHAPE="craft.map.shape";
	public static final String CRAFT_NAME_VISIBLE = "craft.name.visible";
	public static final String CRAFT_MAP_SORT = "craft.map.sort";
	
    public static final String PAD_LINE_COLOR = "pad.line.color";
    public static final String PAD_BACK_COLOR = "pad.back.color";
    public static final String PAD_WORD_COLOR = "pad.word.color";

	public static final String TRAJ_WORD_COLOR = "traj.word.color";
	public static final String TRAJ_PASSED_COLOR = "traj.passed.color";
	public static final String TRAJ_PREDICT_COLOR = "traj.predict.color";
	public static final String TRAJ_RADAR_COLOR  = "traj.radar.color";
	public static final String TRAJ_WORD_VISIBLE = "traj.word.visible";
    public static final String TRAJ_TAIL_VISIBLE = "traj.tail.visible";
    public static final String TRAJ_TAIL_SHAPE = "traj.tail.shape";
    public static final String TRAJ_PREDICT_VISIBLE = "traj.predict.visible";

    public static final String ALERT_VISIBLE_KEY = "alert.visible.sector";
    public static final String ALERT_TIME_KEY = "alert.time.minute";
    public static final String ALERT_LEVEL_KEY = "alert.level.type";
    
    public static final String WAYPOINT_NOPASS_VISIBLE_KEY = "waypoint.nopass.visible";
    public static final String WAYPOINT_NAME_VISIBLE_KEY = "waypoint.name.visible";
    public static final String AIRPORT_NAME_VISIBLE_KEY = "airport.name.visible";
    public static final String AIRWAY_NAME_VISIBLE_KEY = "airway.name.visible";
    public static final String AIRWAY_TEMP_VISIBLE_KEY = "airway.temp.visible";
	public static final String AIRWAY_APPTER_VISIBLE_KEY = "airway.appter.visible";
    public static final String SECTOR_NAME_VISIBLE_KEY = "sector.name.visible";
    public static final String APPTER_NAME_VISIBLE_KEY = "appter.name.visible";
    public static final String APPSEC_NAME_VISIBLE_KEY = "appsec.name.visible";
    public static final String RESTRICT_NAME_VISIBLE_KEY = "restrict.name.visible";
    
	public static final String LAYER_RESTRICT_COLOR = "restrict.color";
	public static final String LAYER_SECTOR_COLOR = "sector.color";
	public static final String LAYER_APPROACH_COLOR = "approach.color";
	public static final String LAYER_FIR_COLOR = "fir.color";
	public static final String LAYER_AIRWAY_COLOR = "airway.color";
	public static final String LAYER_AIRPORT_COLOR = "airport.color";
	public static final String LAYER_ACC_COLOR = "acc.color";
	public static final String LAYER_WAYPOINT_COLOR = "waypoint.color";
	public static final String LAYER_APPSEC_COLOR="appsec.color";
	public static final String LAYER_FEAFCA_COLOR = "feafca.color";
	
	public static final String LAYER_AIRPORT_NAME = "layer.airport";
	public static final String LAYER_APPROACH_NAME = "layer.approach";
	public static final String LAYER_SECTOR_NAME = "layer.sector";
	public static final String LAYER_WAYPOINT_NAME = "layer.waypoint";
	public static final String LAYER_AIRWAY_NAME = "layer.airway";
	public static final String LAYER_APPTER_NAME = "layer.appter";
	public static final String LAYER_APPSEC_NAME = "layer.appsec";
	public static final String LAYER_CRAFT_NAME = "layer.craft";
	public static final String LAYER_FIR_NAME = "layer.fir";
	public static final String LAYER_ACC_NAME = "layer.acc";
	public static final String LAYER_RESTRICT_NAME = "layer.restrict";
	public static final String LAYER_FEAFCA_NAME = "layer.feafca";
	public static final String LAYER_ATMO_NAME = "layer.atmo";
	public static final String LAYER_CHINA_NAME = "layer.china";
	public static final String LAYER_PROVINCE_NAME = "layer.province";
	public static final String LAYER_RANGING_NAME = "layer.ranging";
	
	public static final String CHINAMAP_BACKGROUND_COLOR="chinamapBackground.color";
	public static final String BASEMAP_BACKGROUND_COLOR="basemapBackground.color";
	public static final String PROVINCE_BACKGROUND_COLOR="provinceborderBackground.color";

	public static final String CRAFT_ARR_COLOR = "craft.arr.color";
	public static final String CRAFT_DEP_COLOR = "craft.dep.color";
	public static final String CRAFT_FPL_COLOR = "craft.fpl.color";
	public static final String CRAFT_SCHEDULE_COLOR = "craft.schedule.color";
	public static final String CRAFT_RADAR_COLOR = "craft.radar.color";
	public static final String CRAFT_CNL_COLOR = "craft.cnl.color";
	public static final String CRAFT_CLD_COLOR = "craft.cld.color";
	public static final String CRAFT_PREDICT_COLOR = "craft.predict.color";

	public static final String MAP_FONT="map.font";
	public static final String MAP_BIGFONT="map.bigFont";
	public static final String MAP_FEAFCAID="map.feafcaId";
	
	public static final String AIPS_VERSION = "aips.version";
    
	public static final String LOGIN_HOMEPAGE = "login.homepage";
	public static final String LOGIN_TYPE = "login.type";
	
	public static final String TOOLBAR_VISIBLE_RESTORE = "toolbar.visible.restore";
	
	public static final String TCLIENT_AIRPORT = "tclient.airport";
	
	public static final String PLAN_TABLE_FONT = "plan.font.small";
	public static final String PLAN_DETAIL_WIDTH = "plan.detail.width";
	public static final String PLAN_DETAIL_HEIGHT = "plan.detail.height";
	
	public static final String GEO_DEFAULT_CENTER="geo.default.center";
	public static final String GEO_DEFAULT_ZOOMRATIO="geo.default.zoomRatio";
	public static final String GEO_USER_CENTER="geo.user.center";
	public static final String GEO_USER_ZOOMRATIO="geo.user.zoomRatio";
	
	public static final String GEO_MERCATORZOOMRATIO="geo.mercator.zoomratio";
	public static final String GEO_LAMBERTZOOMRATIO="geo.lambert.zoomratio";
	
	public static final String CONSERVER_PREDICTION="conserver.prediction.seconds";
	public static final String CONSERVER_ALERT="conserver.alert.minutes";
	public static final String CONSERVER_MAP_REFRESH="conserver.maprefresh.seconds";
	public static final String CONSERVER_CORESIZE="conserver.coresize.size";
	public static final String CONSERVER_TRAJ_VALIDATION = "conserver.trajvalidation.seconds";
	public static final String CONSERVER_TODAYPLAN = "conserver.todayplan.seconds";
	public static final String CONSERVER_TODAYDEP = "conserver.todaydep.seconds";
	public static final String CONSERVER_CORRELATE_FME = "conserver.correlatefme.seconds";
	public static final String CONSERVER_FEAFCA = "conserver.feafca.seconds";
	public static final String CONSERVER_FC = "conserver.fc.seconds";
	public static final String CONSERVER_RUNWAY = "conserver.runway.seconds";
	public static final String CONSERVER_CAPACITY = "conserver.capacity.seconds";
	public static final String CONSERVER_FLOWCONTROL = "conserver.flowcontrol.seconds";
	public static final String CONSERVER_DAILYREPORT = "conserver.dailyreport.seconds";
	public static final String CONSERVER_NOTICE = "conserver.notice.seconds";
	public static final String CONSERVER_WEATHER_IMAGE = "conserver.weatherimage.seconds";
	public static final String CONSERVER_SECTORSTATUS = "conserver.sectorstatus.seconds";
	public static final String CONSERVER_CRAFT_DISPEAR = "conserver.craftdispear.seconds";
	public static final String CONSERVER_AWOS = "conserver.awos.seconds";
	public static final String CONSERVER_RUNWAY_WARN = "conserver.runwaywarn.minutes";
	public static final String CONSERVER_SYS_RATE = "conserver.sysrate.minutes";
	public static final String CONSERVER_AIPS = "conserver.aips.hours";
	public static final String CONSERVER_CLIENT = "conserver.client.seconds";
	public static final String CONSERVER_FOCUS_FME = "conserver.focusfme.seconds";
		
	public static final String SERVER_AIRSPACE = "server.airspace";
	public static final String SERVER_FMESTATIC = "server.fmeStatic";
	public static final String SERVER_USERMANAGE = "server.userManage";
	public static final String SERVER_LOG = "server.log";
	
	public static final String CUSTOM_SECTOR="custom.sector";
	public static final String CUSTOM_APPROACH="custom.approach"; 
	public static final String CUSTOM_AIRPORT="custom.airport"; 
	public static final String CUSTOM_APPSECTOR="custom.appsector";
	
	public static final String RANGING_POINT_COLOR = "rangingPoint.color";
	public static final String RANGING_SEGMENT_COLOR = "rangingSegment.color";
	public static final String RANGING_WORD_COLOR = "rangingWord.color";
	
	public static final String WINDBASE_VISIBLE_KEY = "windbase.visible";
	public static final String WINDSYMBOL_VISIBLE_KEY = "windSymbol.visible";
	
	public static final String MENU_ATMOSPHERE = "menu.atmosphere";
	public static final String MENU_SECTORREVISE = "menu.sectorRevise";
	public static final String MENU_RANGING = "menu.ranging";
    public static final String MENU_RADARWEATHER = "menu.radarWeather";
    
    public static final String EFFICIENCY_PERIOD = "efficiency.period";
	public static final String EFFICIENCY_PIXEL = "efficiency.pixel";
    public static final String EFFICIENCY_STARTTIME = "efficiency.starttime";
	public static final String EFFICIENCY_ENDTIME = "efficiency.endtime";
    	
	public static final String AIRPORT_DELAY_TYPE = "airport.delay.type";
		
	public static final String FTP_USERNAME = "ftp.username";
	public static final String FTP_PASSWORD = "ftp.password";
	public static final String FTP_IP = "ftp.ip";
	
	public static final String USER_LASTNAME = "user.lastname";
	public static final String USER_DESCRIPTION_CN = "user.description.CN";
	public static final String USER_DESCRIPTION_EN = "user.description.EN";
	public static final String USER_ROLE = "user.role";
	public static final String USER_CARRIERS = "user.carriers";
	public static final String USER_AIRPORTS = "user.airports";
	public static final String USER_PLAN_CODE = "user.plan.code";
	public static final String USER_PLAN_NAME = "user.plan.name";
	public static final String USER_FILEPATH = "user.filepath";
	public static final String USER_CENTER = "user.center";
	public static final String USER_TYPE = "user.type";
	//消息队列相关的配置
	public static final String ATFMMQ_USERNAME = "atfmmq.url.username";
	public static final String ATFMMQ_PASSWORD = "atfmmq.url.password";
	public static final String ATFMMQ_CONSUMER_BROKERURL = "atfmmq.url.consumerBrokerURL";
	public static final String ATFMMQ_PRODUCTER_BROKERURL = "atfmmq.url.producerBrokerURL";
	public static final String ATFMMQ_JMX_BROKERURL = "atfmmq.url.jmxBrokerURL";
	public static final String ATFMMQ_JMX_BROKERNAME = "atfmmq.url.jmxBrokerName";
	public static final String ATFMMQ_JMX_CHECKTIME = "atfmmq.url.jmxCheckTime";
	
	public static final String ATFMMQ_TOPIC_RADAR_CENTER = "atfmmq.topic.radar.center";
	public static final String ATFMMQ_TOPIC_RADAR_REGION = "atfmmq.topic.radar.region";
	public static final String ATFMMQ_TOPIC_CAPACITY = "atfmmq.topic.capacity";
	public static final String ATFMMQ_TOPIC_SERVERINFO = "atfmmq.topic.serverInfo";
	public static final String ATFMMQ_TOPIC_CLIENTINFO = "atfmmq.topic.clientInfo";
	public static final String ATFMMQ_TOPIC_FLOWCONTROL = "atfmmq.topic.flowcontrol";
	public static final String ATFMMQ_TOPIC_FEAFCA = "atfmmq.topic.feafca";
	public static final String ATFMMQ_TOPIC_SECTORSTATUS = "atfmmq.topic.sectorstatus";
	public static final String ATFMMQ_TOPIC_RUNWAY = "atfmmq.topic.runway";
	public static final String ATFMMQ_TOPIC_FMETODAY = "atfmmq.topic.fmetoday";
	public static final String ATFMMQ_TOPIC_AIPORT = "atfmmq.topic.airport";
	
	public static final String ATFMMQ_MESSAGE_RADAR = "atfmmq.topic.message.radar";
	public static final String ATFMMQ_MESSAGE_FLOWCONTROL = "atfmmq.topic.message.flowcontrol";
	public static final String ATFMMQ_MESSAGE_FEAFCA = "atfmmq.topic.message.feafca";
	public static final String ATFMMQ_MESSAGE_SECTORSTATUS = "atfmmq.topic.message.sectorstatus";
	public static final String ATFMMQ_MESSAGE_CAPACITY = "atfmmq.topic.message.capacity";
	public static final String ATFMMQ_MESSAGE_RUNWAY = "atfmmq.topic.message.runway";
	public static final String ATFMMQ_MESSAGE_FMETODAY = "atfmmq.topic.message.fmetoday";
	public static final String ATFMMQ_MESSAGE_AIRPORT = "atfmmq.topic.message.airport";
	
	public static final String TRIGGER_DATATIMESTAMP = "TRIGGER_DATATIMESTAMP";
	public static final String TRIGGER_CRAFTFOUCS = "TRIGGER_CRAFTFOUCS";
	public static final String TRIGGER_RANGING = "TRIGGER_RANGING";
	public static final String TRIGGER_MOUSEMOVING = "TRIGGER_MOUSEMOVING";
	public static final String TRIGGER_TRANSIENTDATA = "TRIGGER_TRANSIENTDATA";
	public static final String TRIGGER_FEAFCA_UPDATE = "TRIGGER_FEAFCA_UPDATE";
	public static final String TRIGGER_WEATHER_UPDATE = "TRIGGER_WEATHER_UPDATE";
	public static final String TRIGGER_NOTICE_UPDATE = "TRIGGER_NOTICE_UPDATE";
	public static final String TRIGGER_IMAGE_UPDATE = "TRIGGER_IMAGE_UPDATE";
	public static final String TRIGGER_AIPS_UPDATE = "TRIGGER_AIPS_UPDATE";
	public static final String TRIGGER_FMETODAY_UPDATE = "TRIGGER_FMETODAY_UPDATE";
	public static final String TRIGGER_FMESCHEDULE_UPDATE = "TRIGGER_FMESCHEDULE_UPDATE";
	public static final String TRIGGER_FMEFOCUS_UPDATE = "TRIGGER_FMEFOCUS_UPDATE";
	public static final String TRIGGER_CNL_UPDATE = "TRIGGER_CNL_UPDATE";
	public static final String TRIGGER_PLANCONFIG_UPDATE = "TRIGGER_PLANCONFIG_UPDATE";
	
	public static final String TCLIENT_DEP24HOUR_COLOR = "tclient.dep24Hour.color";
	public static final String TCLIENT_ARR24HOUR_COLOR = "tclient.arr24Hour.color";
	public static final String TCLIENT_FPL24HOUR_COLOR = "tclient.fpl24Hour.color";
	public static final String TCLIENT_SCHDULE_EXECUTE_24HOUR_COLOR = "tclient.schduleExecute24Hour.color";
	public static final String TCLIENT_HOUR_EXECUTE_24HOUR_COLOR = "tclient.hourExecute24Hour.color";
	public static final String TCLIENT_EXECUTE_24HOUR_COLOR = "tclient.execute24Hour.color";
	public static final String TCLIENT_DELAY_24HOUR_COLOR = "tclient.delay24Hour.color";
	public static final String TCLIENT_NORMALRATE_DEP_24HOUR_COLOR = "tclient.normalRateDep24Hour.color";
	public static final String TCLIENT_NORMALRATE_ARR_24HOUR_COLOR = "tclient.normalRateArr24Hour.color";
	public static final String TCLIENT_NORMALRATE_PASS_24HOUR_COLOR = "tclient.normalRatePass24Hour.color";
	public static final String TCLIENT_NORMALRATE_OUT_24HOUR_COLOR = "tclient.normalRateOut24Hour.color";
	public static final String TCLIENT_NORMALRATE_IN_24HOUR_COLOR = "tclient.normalRateIn24Hour.color";
	public static final String TCLIENT_DELAYTIME_OUT_24HOUR_COLOR = "tclient.delayTimeOut24Hour.color";
	public static final String TCLIENT_DELAYTIME_IN_24HOUR_COLOR = "tclient.delayTimeIn24Hour.color";
	public static final String TCLIENT_CAPACITY_COLOR = "tclient.capacity.color";
	
	public static final String TCLIENT_DEP24HOUR_VISIVLE = "tclient.dep24Hour.visible";
	public static final String TCLIENT_ARR24HOUR_VISIVLE = "tclient.arr24Hour.visible";
	public static final String TCLIENT_FPL24HOUR_VISIVLE = "tclient.fpl24Hour.visible";
	public static final String TCLIENT_SCHEDULEEXECUTE24HOUR_VISIVLE = "tclient.schduleExecute24Hour.visible";
	public static final String TCLIENT_HOUREXECUTE24HOUR_VISIVLE = "tclient.hourExecute24Hour.visible";
	public static final String TCLIENT_EXECUTE24HOUR_VISIVLE = "tclient.execute24Hour.visible";
    public static final String TCLIENT_DELAY24HOUR_VISIVLE = "tclient.delay24Hour.visible";
	public static final String TCLIENT_NORMALRATEDEP24HOUR_VISIVLE = "tclient.normalRateDep24Hour.visible";
	public static final String TCLIENT_NORMALRATEARR24HOUR_VISIVLE = "tclient.normalRateArr24Hour.visible";
	public static final String TCLIENT_NORMALRATEOUT24HOUR_VISIVLE = "tclient.normalRateOut24Hour.visible";
	public static final String TCLIENT_NORMALRATEIN24HOUR_VISIVLE = "tclient.normalRateIn24Hour.visible";
	public static final String TCLIENT_NORMALRATEPASS24HOUR_VISIVLE = "tclient.normalRatePass24Hour.visible";
	public static final String TCLIENT_DELAYTIMEOUT24HOUR_VISIVLE = "tclient.delayTimeOut24Hour.visible";
	public static final String TCLIENT_DELAYTIMEIN24HOUR_VISIVLE = "tclient.delayTimeIn24Hour.visible";
	public static final String TCLIENT_CAPACITY24HOUR_VISIVLE = "tclient.capacity24Hour.visible";
	
	public static final String TCLIENT_SCHEDULE_COLOR = "tclient.schedule.color";
	public static final String TCLIENT_DEP_COLOR = "tclient.dep.color";
	public static final String TCLIENT_FPL_COLOR = "tclient.fpl.color";
	public static final String TCLIENT_ARR_COLOR = "tclient.arr.color";

	public static final String TCLIENT_NAV2NAV_COLOR = "tclient.nav2nav.color";
	public static final String TCLIENT_NAV2FOR_COLOR = "tclient.nav2for.color";
	public static final String TCLIENT_FOR2FOR_COLOR = "tclient.for2for.color";
	public static final String TCLIENT_FOR2NAV_COLOR = "tclient.for2nav.color";
    public static final String TCLIENT_REGION_COLOR = "tclient.region.color";
    
    public static final String TCLIENT_DEPAP_COLOR = "tclient.depAp.color";
    public static final String TCLIENT_ARRAP_COLOR = "tclient.arrAp.color";
    
    public static final String TCLIENT_INAP_COLOR = "tclient.inAp.color";
    public static final String TCLIENT_OUTAP_COLOR = "tclient.outAp.color";
    public static final String TCLIENT_THROUGHAP_COLOR = "tclient.throughAp.color";
    
    public static final String TCLIENT_RADAR_COLOR = "tclient.radar.color";
    public static final String TCLIENT_RADAR_MISS_COLOR = "tclient.radarMiss.color";
    
    public static final String TCLIENT_RADARROUTE_COLOR = "tclient.radarRoute.color";
    public static final String TCLIENT_RADARROUTE_BACK_COLOR = "tclient.radarRouteBack.color";
    public static final String TCLIENT_RADARROUTE_HLEVEL_COLOR = "tclient.radarRouteHlevel.color";
    
    public static final String TCLIENT_FLOWIN_AREA_COLOR = "tclient.flowInArea.color";
    public static final String TCLIENT_FLOWOUT_AREA_COLOR = "tclient.flowOutArea.color";
    
    public static final String TCLIENT_LTAIL_COLOR = "tclient.lTail.color";
    public static final String TCLIENT_HTAIL_COLOR = "tclient.hTail.color";
    public static final String TCLIENT_MTAIL_COLOR = "tclient.mTail.color";
    
    public static final String TCLIENT_DEP_POINTER_COLOR = "tclient.depPointer.color";
    public static final String TCLIENT_ARR_POINTER_COLOR = "tclient.arrPointer.color";
    public static final String TCLIENT_ALL_POINTER_COLOR = "tclient.allPointer.color";
    
    public static final String TCLIENT_CCA_COLOR = "tclient.cca.color";
    public static final String TCLIENT_CXA_COLOR = "tclient.cxa.color";
    public static final String TCLIENT_CSN_COLOR = "tclient.csn.color";
    public static final String TCLIENT_CES_COLOR = "tclient.ces.color";
    public static final String TCLIENT_CSH_COLOR = "tclient.csh.color";
    public static final String TCLIENT_CSC_COLOR = "tclient.csc.color";
    public static final String TCLIENT_CHH_COLOR = "tclient.chh.color";
    public static final String TCLIENT_CSZ_COLOR = "tclient.csz.color";
	
}
