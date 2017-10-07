package com.lzw.atmm.tclient.view;

import java.awt.Color;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述    ：统一颜色接口常量类
 * 类名称    ：com.lzw.atmm.tclient.view.ColorSet     
 * 创建人    ：杨洪
 * 创建时间：2016年12月29日 下午4:57:40   
 * 修改人    ：
 * 修改时间：2016年12月29日 下午4:57:40   
 * 修改备注：   
 * @version   V1.0    
 */

public interface ColorSet {
	final int alpha = 200;
	final Color FPLPLUSCOLOR = null;

	// 指针颜色
	public static final Color DEPPOINTERCOLOR = new Color(0, 255, 255, alpha);

	public static final Color ARRPOINTERCOLOR = new Color(204, 153, 0, alpha);

	public static final Color ALLPOINTERCOLOR = new Color(236, 233, 216, alpha);

	// 机场起降分类
	public static final Color DEPAPCOLOR = new Color(0, 255, 255, alpha);

	public static final Color ARRAPCOLOR = new Color(204, 153, 0, alpha);

	// 状态分类
	public static final Color FPLCOLOR = new Color(0, 204, 0, alpha);

	public static final Color DEPCOLOR = new Color(0, 255, 255, alpha);

	public static final Color ARRCOLOR = new Color(204, 153, 0, alpha);

	public static final Color SCHEDULECOLOR = new Color(0, 51, 255, alpha);

	public static final Color RADARCOLOR = new Color(102, 102, 0, alpha);

	public static final Color RADARMISSCOLOR = new Color(102, 102, 102, alpha);
	// 航路剖面标牌颜色
	public static final Color RADARROUTECOLOR = new Color(0, 0, 0, alpha);
	// 航路剖面背景色
	public static final Color RADARROUTE_BACK_COLOR = new Color(204, 204, 204,
			alpha);
	// 航路标牌高度层颜色
	public static final Color RADARROUTE_HLEVEL_COLOR = new Color(153, 153,
			153, alpha);

	// 航班任务类型分类
	public static final Color NAV2NAV = new Color(0, 255, 255, alpha);

	public static final Color NAV2FOR = new Color(255, 153, 0, alpha);

	public static final Color FOR2NAV = new Color(153, 0, 204, alpha);

	public static final Color FOR2FOR = new Color(1, 191, 1, alpha);

	public static final Color HON2NAV = new Color(103, 153, 103, alpha);// 水绿色

	public static final Color DRA2NAV = new Color(255, 255, 204, alpha);

	public static final Color REGION = new Color(255, 153, 255, alpha);// 水绿色

	// 尾流类型分类
	public static final Color H_TAILCOLOR = new Color(204, 153, 0, alpha);

	public static final Color M_TAILCOLOR = new Color(0, 102, 255, alpha);

	public static final Color L_TAILCOLOR = new Color(0, 204, 0, alpha);

	// 按航空公司划分
	public static final Color CCACOLOR = new Color(0, 255, 255, alpha);

	public static final Color CSNCOLOR = new Color(0, 153, 255, alpha);

	public static final Color CESCOLOR = new Color(255, 204, 0, alpha);

	public static final Color CXACOLOR = new Color(204, 255, 103, alpha);// 浅橙色

	public static final Color CSHCOLOR = new Color(255, 102, 102, alpha);// 水绿色

	public static final Color CSCCOLOR = new Color(255, 255, 204, alpha);

	public static final Color CHHCOLOR = new Color(51, 255, 0, alpha);// 酸橙色

	public static final Color CSZCOLOR = new Color(153, 103, 153, alpha);// 紫罗兰

	public static final Color DEFAULT = new Color(204, 204, 204, alpha);// new

	// 容量线颜色
	public static final Color CAPCOLOR = new Color(153, 153, 153, alpha);

	public static final Color OVERCAPCOLOR = new Color(250, 0, 0, alpha);

	// 流量分布颜色
	public static final Color FLOWIN_AREA_COLOR = new Color(204, 153, 0, alpha);

	public static final Color FLOWOUT_AREA_COLOR = new Color(9, 160, 255, alpha);

	// 航班飞越类型划分
	public static final Color INAP_COLOR = new Color(204, 153, 0, alpha);

	public static final Color OUTAP_COLOR = new Color(0, 255, 255, alpha);

	public static final Color THROUGHAP_COLOR = new Color(51, 204, 0, alpha);

	// 本时段动态
	public static final Color ONEHOUR_FPL_24HOUR_COLOR = new Color(51, 204, 0,
			alpha);
	// 本时段实际
	public static final Color ONEHOUR_EXECUTE_24HOUR_COLOR = new Color(255,
			204, 204, alpha);
	// 本时段总量
	public static final Color ONEHOUR_THROUGHPUT_24HOUR_COLOR = new Color(10,
			255, 255, alpha);
	// 折线图选中点颜色
	public static final Color choosedPointColor = new Color(0, 206, 103);
	// 起飞航班柱体颜色-柱体
	public static final Color DEP_INSCHEDULE_24HOUR_COLOR = new Color(0, 51, 255);
	// 降落航班柱体颜色-柱体
	public static final Color ARR_INSCHEDULE_24HOUR_COLOR = new Color(204, 153, 0);
	/** 饼状图'起飞'扇区颜色 */
	public static final Color DEP24HOUR_COLOR = new Color(51, 255, 255);
	/** 饼状图'预起飞'扇区颜色 */
	public static final Color FPL24HOUR_COLOR = new Color(0, 255, 0);
	/** 饼状图'未执行'扇区颜色 */
	public static final Color SCHEDULE24HOUR_COLOR = new Color(0, 102, 255);
	/** 饼状图'降落'扇区颜色 */
	public static final Color ARR24HOUR_COLOR = new Color(204, 153, 0);
	// 本时段小时执行
	public static final Color HOUR_EXECUTE_24HOUR_COLOR = new Color(153,51,255, alpha);

}
