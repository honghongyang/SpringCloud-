package com.lzw.atmm.component;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
/**   
 * 版权所有：2017-中实智达
 * 项目名称：JXCManager-api   
 * 类描述    ：用于长文本字段的可自动换行的简单表格
 * 类名称    ：com.lzw.atmm.component.HongTextTable     
 * 创建人    ：杨洪
 * 创建时间：2017年1月4日 下午4:31:43   
 * 修改人    ：
 * 修改时间：2017年1月4日 下午4:31:43   
 * 修改备注：   
 * @version   V1.0    
 */

public class HongTextTable extends JTable {
	private static final long serialVersionUID = -5869155238619038689L;
	
	
	
	public HongTextTable()
	{
		super();
		initDefaults();
	}
	
	public HongTextTable(int rowNum,int colNum)
	{
		super(rowNum,colNum);
		initDefaults();
	}
	
	public HongTextTable(String[][] data,String[] columnName)
	{
		super(data,columnName);
		initDefaults();
	}
	
	public HongTextTable(TableModel model)
	{
		super(model);
		initDefaults();
	}
	
	protected void initDefaults(){//初始化默认的数据
		//重新设置表格的单元格的单元格的装饰器
		this.setDefaultRenderer(Object.class, new WrapCellRenderer());//为表格注册监听器
		this.getTableHeader().setReorderingAllowed(false);
	}
	
	
	@Override
	public boolean isCellEditable(int row, int column) {//表格的单元格是否能够被编辑
		return false;
	}


	//该装饰器------当单元格中的内容超过单元格的宽度时候,文本会自动换行
	public static class WrapCellRenderer extends JTextArea implements TableCellRenderer{//表格单元格装饰器
		private static final long serialVersionUID = 1L;	
		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,int column) {
			this.setText(value.toString());//设置单元格显示的文本
			
			//JTextArea本身默认的是不换行，不滚动条显示。你设置完他的大小之后，他就只是显示在这个窗口大小内的内容。
			this.setLineWrap(true);//激活自动换行功能
			this.setWrapStyleWord(true);// 激活断行不断字功能
			
			int maxPreferredHeight = 20;//单元格的首先最大高度为20
			for(int i=0;i<table.getColumnCount();i++){//table.getColumnModel().getColumn(column) 获得表格头的每一具体列
				this.setSize(table.getColumnModel().getColumn(column).getWidth(), 0);
				maxPreferredHeight = Math.max(maxPreferredHeight, getPreferredSize().height);
			}
			if(table.getRowHeight(row)!=maxPreferredHeight){
				table.setRowHeight(row, maxPreferredHeight);
			}
			return this;//返回该类本身
		}
		
	}

}
