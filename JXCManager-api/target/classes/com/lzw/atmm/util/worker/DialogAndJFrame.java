package com.lzw.atmm.util.worker;

import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.lzw.atmm.tsd.data.IconFactory;

/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：窗体和对话框------鼠标在窗体或者对话框中时,鼠标呈现圆圈状的忙碌状态
 * 类名称：com.lzw.atmm.util.worker.DialogAndJFrame     
 * 创建人：杨洪
 * 创建时间：2016年12月26日 下午3:32:32   
 * 修改人：
 * 修改时间：2016年12月26日 下午3:32:32   
 * 修改备注：   
 * @version   V1.0    
 */

public class DialogAndJFrame {
	public static void main(String[] args) {
		JFrame aWindow = new JFrame(); 
		aWindow.setBounds(200, 200, 200, 200);
		aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//当鼠标移入窗体或者对话框中时，鼠标呈现圆圈状的而忙碌状体
		//由如下代码实现----@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@----函数功能：该函数确定光标的形状。
	/*	*//**
	     * The default cursor type (gets set if no cursor is defined).
	     *//*
	    public static final int     DEFAULT_CURSOR                  = 0;

	    *//**
	     * The crosshair cursor type.
	     *//*
	    public static final int     CROSSHAIR_CURSOR                = 1;

	    *//**
	     * The text cursor type.
	     *//*
	    public static final int     TEXT_CURSOR                     = 2;

	    *//**
	     * The wait cursor type.
	     *//*
	    public static final int     WAIT_CURSOR                     = 3;

	    *//**
	     * The south-west-resize cursor type.
	     *//*
	    public static final int     SW_RESIZE_CURSOR                = 4;

	    *//**
	     * The south-east-resize cursor type.
	     *//*
	    public static final int     SE_RESIZE_CURSOR                = 5;

	    *//**
	     * The north-west-resize cursor type.
	     *//*
	    public static final int     NW_RESIZE_CURSOR                = 6;

	    *//**
	     * The north-east-resize cursor type.
	     *//*
	    public static final int     NE_RESIZE_CURSOR                = 7;

	    *//**
	     * The north-resize cursor type.
	     *//*
	    public static final int     N_RESIZE_CURSOR                 = 8;

	    *//**
	     * The south-resize cursor type.
	     *//*
	    public static final int     S_RESIZE_CURSOR                 = 9;

	    *//**
	     * The west-resize cursor type.
	     *//*
	    public static final int     W_RESIZE_CURSOR                 = 10;

	    *//**
	     * The east-resize cursor type.
	     *//*
	    public static final int     E_RESIZE_CURSOR                 = 11;

	    *//**
	     * The hand cursor type.
	     *//*
	    public static final int     HAND_CURSOR                     = 12;

	    *//**
	     * The move cursor type.
	     *//*
	    public static final int     MOVE_CURSOR                     = 13;*/

        //如下代码主要是设置自定义的鼠标形状
		//aWindow.setCursor(Cursor.getDefaultCursor());//默认的鼠标形状
		//aWindow.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
		//aWindow.setCursor(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));
		aWindow.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		ImageIcon icon =IconFactory.getIcon(IconFactory.ALERT_FILEPATH);//图标工厂
		aWindow.setIconImage(icon.getImage());//设置系统图标
		aWindow.setVisible(true);
		aWindow.setResizable(false);//不能改变窗体的大小
	}

}
