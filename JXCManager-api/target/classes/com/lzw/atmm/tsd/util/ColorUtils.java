package com.lzw.atmm.tsd.util;
import java.awt.Color;
import java.util.StringTokenizer;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：颜色的工具类
 * 类名称：com.lzw.attm.util.ColorUtils     
 * 创建人：杨洪
 * 创建时间：2016年6月17日 下午1:56:50   
 * 修改人：
 * 修改时间：2016年6月17日 下午1:56:50   
 * 修改备注：   
 * @version   V1.0    
 */

public class ColorUtils {
	/**
	 * 将颜色转换为如#xxxxxx web颜色表达方式
	 * 
	 * @param color
	 * @return
	 */
	public static String toHexColor(Color color) {
		return "#" + Integer.toHexString(color.getRGB() | 0xFF000000).substring(2);
	}

	public static String toRgbColor(Color color) {

		String str =  color.getRed() + "," + color.getGreen() + ","
				+ color.getBlue();
		return str;
	}

	/**
	 * 将str颜色表达转换为color颜色
	 * 支持rgb、#颜色表示以及color的int值表示
	 * 
	 * @return
	 */
	public static Color toColor(String str) {
		try {
			boolean isRgb = str.indexOf(",") > 0;
			if (isRgb) {
				StringTokenizer st = new StringTokenizer(str, ",");
				Color color = new Color(Integer.parseInt(st.nextToken()), Integer
						.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				return color;
			} else {
				int rgb = Integer.decode(str);
				Color color = new Color(rgb | 0xFF000000);
				return color;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public static Color reverseColor(Color theDrawColor) {
		Color theColor = new Color(255 - theDrawColor.getRed(),
				255 - theDrawColor.getGreen(), 255 - theDrawColor.getBlue());
		return theColor;
	}
}
