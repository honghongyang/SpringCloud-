package com.lzw.atmm.tsd.util;
import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
/**   
 * 版权所有：2017-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：封装特定单元格索引的类
 * 类名称：com.lzw.atmm.tsd.util.HongCell     
 * 创建人：杨洪
 * 创建时间：2017年1月4日 下午6:59:06   
 * 修改人：
 * 修改时间：2017年1月4日 下午6:59:06   
 * 修改备注：   
 * @version   V1.0    
 */

public class HongCell implements Serializable{
	private static final long serialVersionUID = 3745689736057973497L;
	public int row;
	public int col;
	public HongCell(){
	}
	
	public HongCell(int row,int col){
		this.row = row;
		this.col = col;
	}
	
	public HongCell(String row,String col){
		this.row = new Integer(row);
		this.col = new Integer(col);
	}
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	@Override
	public int hashCode(){//重写hashCode
		int result = 17;
		result = result*37 + row;
		result = result*37 + col;
		return result;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof HongCell){
			HongCell c = (HongCell) obj;
			if(c.row == this.row && c.col == this.col){
				return true;
			}
		}
		return false;
	}
	
	public boolean equals(int row,int col){
		if(row == this.row && col == this.col){
			return true;
		}
		return false;
	}

}
