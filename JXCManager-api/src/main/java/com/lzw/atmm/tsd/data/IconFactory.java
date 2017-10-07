package com.lzw.atmm.tsd.data;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * 
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：    图标工具类
 * 类名称：com.lzw.tsd.data.IconFactory     
 * 创建人：杨洪
 * 创建时间：2016年8月4日 下午6:05:43   
 * 修改人：
 * 修改时间：2016年8月4日 下午6:05:43   
 * 修改备注：   
 * @version   V1.0
 */
public class IconFactory {
	public static final String EXIT_MENUITEM_FILEPATH = "images/exitMenu.png";

	public static final String LANG_TITLE_FILEPATH = "images/狼_Image4.png";
	
	public static final String ADD_GYS_FILEPATH ="images/添加图标.png";
	
	public static final String MODIY_FILEPATH = "images/修改图标.png";
	
	public static final String TSD_UI_FILEPATH = "images/tsd.png";
	
	public static final String TSD_LOGIN_FILEPATH = "images/loginSW.jpg";
	
	public static final String TCLIENT_LOGIN_FILEPATH = "images/loginTclient.jpg";
	
	public static final String FOCUS_MENUITEM_FILEPATH = "images/focusMenu.png";
	
	public static final String USERDEF_MENUITEM_FILEPATH = "images/userdefMenu.png";
	
	public static final String FLOW_MENUITEM_FILEPATH = "images/tclientMenu.png";
	
	public static final String MAPLOCATE_MENUITEM_FILEPATH = "images/maplocateMenu.png";
	
	public static final String MAPLOCATE_FILEPATH = "images/maplocate.png";
	
	public static final String RECMAP_MENUITEM_FILEPATH = "images/recmapMenu.png";
	
	public static final String FULLSCR_MENUITEM_FILEPATH = "images/fullscrMenu.png";
	
	public static final String FULLSCRNOT_MENUITEM_FILEPATH = "images/fullscrnotMenu.png";
	
	public static final String DISPLAY_UI_FILEPATH = "images/m_mergeshow_s.png";
	
	public static final String DISPLAY_MENUITEM_FILEPATH = "images/displayMenu.png";
	
	public static final String FLOWCONTROL_MENUITEM_FILEPATH = "images/flowcontrolMenu.png";
	
	public static final String FEAFCA_CREATE_FILEPATH = "images/feafcaCreate.png";
	
	public static final String FEAFCACREATE_MENUITEM_FILEPATH = "images/feafcaCreateMenu.png";
	
	public static final String FLIGHTLIST_FILEPATH = "images/flightList.png";
	
	public static final String ZOOMOUT_FILEPATH = "images/zoomout.png";
	
	public static final String ZOOMIN_FILEPATH = "images/zoomin.png";
	
	public static final String ALERTFLOW_MENUITEM_FILEPATH = "images/alertFlowMenu.png";
	
	public static final String ALERTSET_MENUITEM_FILEPATH = "images/alertSetMenu.png";
	
	public static final String FLIGHTQUERY_FILEPATH = "images/flightInfo.gif";
	
	public static final String FILTER1_FILEPATH = "images/filter1.gif";
	
	public static final String FILTER2_FILEPATH = "images/filter2.gif";
	
	public static final String NETWORK_FILEPATH = "images/network.png";
	
	public static final String CRAFTQUERY_MENUITEM_FILEPATH = "images/craftQueryMenu.png";

	public static final String FILTER_MENUITEM_FILEPATH = "images/filterMenu.png";
	
	public static final String BUTTON_AIRPORT_FILEPATH = "images/m_airport_s.png";
	
	public static final String BUTTON_PLAN_FILEPATH = "images/m_plan_s.png";
	
	public static final String BUTTON_SECTORMONITOR_FILEPATH = "images/m_flowalert_s.png";
	
	public static final String BUTTON_AIPS_FILEPATH = "images/m_aips_s.png";
	
	public static final String BUTTON_PASSWORD_FILEPATH = "images/m_password_s.png";
	
	public static final String BUTTON_ABOUT_FILEPATH = "images/m_about_s.png";
	
	public static final String BUTTON_FLOWMANAGER_PATH = "images/m_flowmanager_s.png";
	
	public static final String BUTTON_FLOWCONTROL_PATH = "images/m_flowcontrol_s.png";
	
	public static final String BUTTON_SECTORSTATUS_FILEPATH = "images/m_sectorstatus_s.png";
	
	public static final String BUTTON_MONITOR_PATH = "images/m_monitor_s.png";
	
	public static final String BUTTON_CAPACITY_FILEPATH = "images/m_capacity_s.png";
	
	public static final String FLOWMANAGER_RP_FILEPATH = "images/rp.gif";

	public static final String FLOWMANAGER_ROUTE_FILEPATH = "images/route.gif";

	public static final String FLOWMANAGER_AP_FILEPATH = "images/airport.gif";

	public static final String FLOWMANAGER_SECTOR_FILEPATH = "images/sector.gif";

	public static final String FLOWMANAGER_APP_FILEPATH = "images/approach.gif";

	public static final String FLOWMANAGER_FEAFCA_FILEPATH = "images/feafca.gif";
	
	public static final String ARROW_BACK = "images/arrow_back.gif";
	
	public static final String ARROW_FORWARD = "images/arrow_forward.gif";
	
	public static final String BUTTON_PENCIL = "images/pencil.png";
	
	public static final String MESSAGE_FILEPATH = "images/message.png";
	
	public static final String QUESTION_FILEPATH = "images/question.png";
	
	public static final String INFOMATION_FILEPATH = "images/info.png";

	public static final String ERROR_FILEPATH = "images/error.png";
	
	public static final String STATISTICS_FILEPATH = "images/m_statistics_s.png";
	
	public static final String FLOAT_FILEPATH = "images/m_float.png";
	
	public static final String ALERT_FILEPATH ="images/alert.png";
	
	public static final String KEHU_FILEPATH="images/客户图标.png";
	
	public static final String LOGIN_FILEPATH="res/login.jpg";

	/**
	 * 生成Image
	 * @param imagePath
	 * @return
	 */
	public static Image getImage(String imagePath){
		if(imagePath == null){
			return null;
		}else{
			return Toolkit.getDefaultToolkit().createImage(imagePath);
		}
	}
	
	/**
	 * 生成Icon
	 * @param iconPath
	 * @return
	 */
	public static ImageIcon getIcon(String iconPath) { 
		if (iconPath == null){
			return null; 
		}else{
			return new ImageIcon(iconPath); 
		}
	}
	
	/**
	 * 柱状图图例
	 * @param colorTmp
	 * @return
	 */
	public static Icon createRectImgIcon(Color colorTmp)
	{
		if (colorTmp == null)
		{
			return null;
		}
		ImageIcon icon = new ImageIcon();
		BufferedImage img = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		Color color = new Color(colorTmp.getRed(), colorTmp.getGreen(), colorTmp.getBlue());
		g.setColor(color);
		g.fillRect(0, 0, 10, 10);
		icon.setImage(img);
		return icon;
	}
	
	/**
	 * 折线图图例
	 * @param colorTmp
	 * @return
	 */
	public static Icon createChartLegendImgIcon(Color colorTmp)
	{
		if (colorTmp == null)
		{
			return null;
		}
		ImageIcon icon = new ImageIcon();
		BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		img=g2d.getDeviceConfiguration().createCompatibleImage(16,16,Transparency.TRANSLUCENT);
		g2d.dispose();
		g2d = img.createGraphics();
		
		Color color = new Color(colorTmp.getRed(), colorTmp.getGreen(), colorTmp.getBlue());
		g2d.setColor(color);
		g2d.drawLine(0, 7, 16, 7);
		g2d.fillOval(3, 3, 10, 10);
		icon.setImage(img);
		return icon;
	}
	
	/**
	 * 容量线图例
	 * @param colorTmp
	 * @return
	 */
	public static Icon createLineLegendImgIcon(Color colorTmp){
		if (colorTmp == null)
		{
			return null;
		}
		ImageIcon icon = new ImageIcon();
		BufferedImage img = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		img=g2d.getDeviceConfiguration().createCompatibleImage(16,16,Transparency.TRANSLUCENT);
		g2d.dispose();
		g2d = img.createGraphics();
		
		Color color = new Color(colorTmp.getRed(), colorTmp.getGreen(), colorTmp.getBlue());
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(2.5f));
		g2d.drawLine(0, 7, 16, 7);
		icon.setImage(img);
		return icon;
	}
}

