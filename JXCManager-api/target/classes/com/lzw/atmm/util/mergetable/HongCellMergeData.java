package com.lzw.atmm.util.mergetable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.google.common.collect.Lists;
import com.lzw.atmm.tsd.util.HongCell;
/**   
 * 版权所有：2017-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：存放合并单元格的合并数据
 * 类名称：com.lzw.atmm.util.mergetable.HongCellMergeData     
 * 创建人：杨洪
 * 创建时间：2017年1月4日 下午6:57:39   
 * 修改人：
 * 修改时间：2017年1月4日 下午6:57:39   
 * 修改备注：   
 * @version   V1.0    
 */

public class HongCellMergeData {
	
	private Map<String,MergeInfo> map = new HashMap<String,MergeInfo>(100,0.5f);
	public static final String SEPARATOR = ",";
	
	/**
	 * 返回合并单元格的总映射,键值为合并单元格组的左上角的单元格row+","+col的字符串
	 */
	public Map<String,MergeInfo> getMergeInfoMap(){
		return map;
	}
	
	/**
	 * 合并单元格
	 * @param lt 左上角单元格
	 * @param rb 右下角单元格
	 */
	public void merge(HongCell lt,HongCell rb)
	{
		int rowx=rb.row-lt.row;//纵跨的行
		int colx=rb.col-lt.col;//横跨的列
		List<HongCell> list=new ArrayList<HongCell>();
		for(int i=0;i<=rowx;i++)
		{
			for(int j=0;j<=colx;j++)
			{
				HongCell cell=new HongCell(lt.row+i,lt.col+j);
				if(!cell.equals(lt))
				{
					list.add(cell);
				}
			}
		}
		map.put(lt.row+","+lt.col, new MergeInfo(new HongCell(rowx, colx), list));
	}

	/**
	 * @return 如果行列值是合并单元格数组左上角单元格,返回true
	 */
	public boolean contain(int row,int col)
	{
		return getMergeInfo(row, col)!=null;
	}
	
	/**
	 * @return 如果行列值是合并单元格数组左上角单元格,返回该合并单元格信息,如果不是,返回null
	 */
	public MergeInfo getMergeInfo(int row,int col)
	{
		return map.get(row+","+col);
	}
	
	/**
	 * @return 如果行列值是合并单元格数组左上角单元格,返回该合并单元格的跨度行列值,如果不是,返回null
	 */
	public HongCell getCellGap(int row,int col)
	{
		if(contain(row, col))
		{
			return getMergeInfo(row,col).cellGap;
		}
		return null;
	}
	
	/**
	 * @return 如果行列值是合并单元格数组左上角单元格,返回合并单元格数组中右下角的单元格行列值
	 */
	public HongCell getLastUnvisibleCell(int row,int col)
	{
		if(contain(row, col))
		{
			List<HongCell> list=getMergeInfo(row, col).unvisibles;
			return list.get(list.size()-1);
		}
		return null;
	}
	
	/**
	 * @return 如果行列值是参与合并的单元格返回true,即为合并单元格数组中除左上角单元格之外的其他单元格
	 */
	public boolean isUnvisible(int row,int col)
	{
		for(MergeInfo info:map.values())
		{
			for(HongCell cell:info.unvisibles)
			{
				if(cell.equals(row,col))
				{
					return true;	
				}
			}
		}
		return false;
	}
	
	/**
	 * @return 如果行列值是参与合并的单元格,返回合并单元格数组左上角单元格行列值
	 */
	public HongCell getKeyFromUnvisible(int row,int col)
	{
		for(String cellInf:map.keySet())
		{
			MergeInfo info=map.get(cellInf);
			for(HongCell cell:info.unvisibles)
			{
				if(cell.equals(row,col))
				{
					String[] tmp=cellInf.split(SEPARATOR);
					return new HongCell(tmp[0],tmp[1]);	
				}
			}
		}
		return null;
	}
			
	}
	
	
	
	
	
	 class MergeInfo{
		public HongCell cellGap;
		List<HongCell> unvisibles;
		public MergeInfo(){
		}
		/**
		 * @param cellGap 行跨和列跨信息
		 * @param unvisibles 参与合并的单元格信息,比如合并左上角(1,1)单元格到右下角(2,2)单元格,参与合并的有(1,2),(2,1),(2,2)
		 */
		public MergeInfo(HongCell cellGap,List<HongCell> unvisibles){
			this.cellGap = cellGap;
			this.unvisibles = unvisibles;
		}
	
	 
//===============================================the beginer of the table======================================================
	private List<HeaderMergeInfo> list = Lists.newArrayList();//表头的集合
	private int rowCount = 0;
	private int columnCount = 0;
	/**
	 * @return 返回表头合并信息的总列表
	 */
	public List<HeaderMergeInfo> getHeaderMergeInfoList(){
		return list;
	}
	
	/**
	 * @return 最大的行跨数
	 */
	public int getRowColumn(){
		return rowCount;
	}
	/**
	 * @return 最大的列跨数
	 */
	public int getColumnCount(){
		return columnCount;
	}
	
	/**
	 * 添加正常的1行1列的表头单元格
	 * @param cell 单元格的行列值
	 * @param value 单元格值
	 */
	public void addNormalHeaderCell(HongCell cell,Object value){
		list.add(new HeaderMergeInfo(cell,new HongCell(1,1),value));
		rowCount = Math.max(rowCount, cell.row + 1);
		columnCount = Math.max(columnCount, cell.col + 1);
	}
	/**
	 * 添加合并的表头单元格
	 * @param cell 单元格的行列值
	 * @param span 单元格的行列跨度,行值为行跨
	 * @param value 单元格值
	 */
	public void addMergedHeaderCell(HongCell cell,HongCell span,Object value){
		list.add(new HeaderMergeInfo(cell,span,value));
		rowCount = Math.max(rowCount, cell.row + span.col);
		columnCount = Math.max(columnCount,cell.col + span.col);
		
	}
	/**
	 * @return 针对表头返回某列中的合并信息列表
	 */
	public List<HeaderMergeInfo> getHeaderMergeInfoAtColumn(int columnIndex){
		List<HeaderMergeInfo> infos = Lists.newArrayList();
		for(HeaderMergeInfo info : list){
			int mixColumnIndex = info.cell.col;
			int maxColumnIndex = mixColumnIndex + info.span.col - 1;
			if(mixColumnIndex <= columnIndex && maxColumnIndex >= columnIndex){
				infos.add(info);
			}
		}
		return infos;
	}
	/**
	 * @return 针对表头返回某行中的合并信息列表
	 */
	public List<HeaderMergeInfo> getHeaderMergeInfoAtRow(int rowIndex){
		List<HeaderMergeInfo> infos = Lists.newArrayList();
		for(HeaderMergeInfo info : list){
			int mixRowIndex = info.cell.row;
			int maxRowIndex = mixRowIndex + info.span.row - 1;
			if(mixRowIndex <= rowIndex && maxRowIndex >= rowIndex){
				infos.add(info);
			}
		}
		return infos;
		
	}
	
	/**
	 * @return 如果行列值处在合并表头单元格里,则返回该合并表头单元格的合并信息,否则返回null
	 */
	public HeaderMergeInfo getHeaderMergeInfo(int row, int column)
	{
		for (HeaderMergeInfo info : list)
		{
			int rowIndex = info.cell.row;
			int columnIndex = info.cell.col;
			int rowSpan = info.span.row;
			int colSpan = info.span.col;
			if (rowIndex <= row && rowIndex + rowSpan > row && columnIndex <= column
					&& columnIndex + colSpan > column)
				return info;
		}
		return null;
	}
	
	
	/**
	 * 表头合并数据
	 * @author 杨洪
	 */
	public class HeaderMergeInfo{
		public HongCell cell;
		public HongCell span;
		public Object value;
		public HeaderMergeInfo(){
		}
		/**
		 * @param cell 待合并单元格"组"的左上角单元格行列索引
		 * @param span 合并跨度,行值代表行跨度
		 * @param value 合并后单元格的列标题
		 */
		public HeaderMergeInfo(HongCell cell,HongCell span,Object value){
			this.cell = cell;
			this.span = span;
			this.value = value;
		}
	}
//=============================================the header of the table================================================================
}
