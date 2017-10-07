package com.lzw.atmm.tsd.util;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import org.jbarcode.JBarcode;
import org.jbarcode.encode.Code39Encoder;
import org.jbarcode.encode.EAN13Encoder;
import org.jbarcode.paint.BaseLineTextPainter;
import org.jbarcode.paint.EAN13TextPainter;
import org.jbarcode.paint.WideRatioCodedPainter;
import org.jbarcode.paint.WidthCodedPainter;
import org.jbarcode.util.ImageUtil;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：条形码生产类
 * 类名称：com.lzw.attm.util.OneBarcodeUtil     
 * 创建人：杨洪
 * 创建时间：2016年12月28日 下午4:57:33   
 * 修改人：
 * 修改时间：2016年12月28日 下午4:57:33   
 * 修改备注：   
 * @version   V1.0    
 */

public class OneBarcodeUtil {
	public static void main(String[] paramArrayOfString)    
	  {    
	    try   
	    {    
	      JBarcode localJBarcode = new JBarcode(EAN13Encoder.getInstance(), WidthCodedPainter.getInstance(), EAN13TextPainter.getInstance());    
	      //生成. 欧洲商品条码(=European Article Number)    
	      //这里我们用作图书条码    
	      //String str = "788515004012";   
	      String str = "000000000000";   //生成的条形码可以识别  手机微信扫描可识别  推荐商品选购
	    
	      BufferedImage localBufferedImage = localJBarcode.createBarcode(str); 
	      
	      saveToGIF(localBufferedImage, "EAN13.gif"); 
	     
	      localJBarcode.setEncoder(Code39Encoder.getInstance());    
	      localJBarcode.setPainter(WideRatioCodedPainter.getInstance());    
	      localJBarcode.setTextPainter(BaseLineTextPainter.getInstance());    
	      localJBarcode.setShowCheckDigit(false);    
	      //xx    
	      str = "JBARCODE-39";    
	      localBufferedImage = localJBarcode.createBarcode(str);    
	      saveToPNG(localBufferedImage, "Code39.png");    
	   
	    }    
	    catch (Exception localException)    
	    {    
	      localException.printStackTrace();    
	    }    
	  }    
	   
	  static void saveToJPEG(BufferedImage paramBufferedImage, String paramString)    
	  {    
	    saveToFile(paramBufferedImage, paramString, "jpeg");    
	  }    
	   
	  static void saveToPNG(BufferedImage paramBufferedImage, String paramString)    
	  {    
	    saveToFile(paramBufferedImage, paramString, "png");    
	  }    
	   
	  static void saveToGIF(BufferedImage paramBufferedImage, String paramString)    
	  {    
	    saveToFile(paramBufferedImage, paramString, "gif");    
	  }    
	   
	  static void saveToFile(BufferedImage paramBufferedImage, String paramString1, String paramString2)    
	  {    
	    try   
	    {    
	      FileOutputStream localFileOutputStream = new FileOutputStream("d:/images/" + paramString1);    
	      ImageUtil.encodeAndWrite(paramBufferedImage, paramString2, localFileOutputStream, 96, 96);    
	      localFileOutputStream.close();    
	    }    
	    catch (Exception localException)    
	    {    
	      localException.printStackTrace();    
	    }    
	  }    
}
