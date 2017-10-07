package com.lzw.atmm.util.mergetable;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import com.lzw.atmm.tsd.util.HongCell;


/**   
 * 版权所有：2017-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：可合并单元格的表格
 * 类名称：com.lzw.atmm.util.mergetable.HongMergeTable     
 * 创建人：杨洪
 * 创建时间：2017年1月4日 下午6:56:00   
 * 修改人：
 * 修改时间：2017年1月4日 下午6:56:00   
 * 修改备注：   
 * @version   V1.0    
 */

public class HongMergeTable extends JTable {
	private static final long serialVersionUID = 1320316453007993453L;


	protected HongCellMergeData data = new HongCellMergeData();

	public HongMergeTable()
	{
		setUI(new HongMergeTableUI());
		init();
	}

	public HongMergeTable(TableModel model)
	{
		super(model);
		super.setUI(new HongMergeTableUI());
		init();
	}

	public HongMergeTable(int row, int col)
	{
		super(row, col);
		super.setUI(new HongMergeTableUI());
		init();
	}

	protected void init()
	{
		createModel();
		createRenderer();
		createEditor();
		installDefaults();
		installListeners();
		installMenuAction();
	}

	protected void createModel()
	{

	}

	protected void createRenderer()
	{

	}

	protected void createEditor()
	{

	}

	protected void installDefaults()
	{

	}

	protected void installListeners()
	{
		getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent e)
			{
				repaint();//当选择框状态发生变化时,需要重新绘制选择框的UI
			}
		});
	}

	protected void installMenuAction()
	{

	}

	/**
	 * 设置合并数据
	 */
	public void setCellMergeData(HongCellMergeData data)
	{
		this.data = data;
	}

	/**
	 * @return 合并数据
	 */
	public HongCellMergeData getCellMergeData()
	{
		return data;
	}

	@Override
	public Rectangle getCellRect(int row, int col, boolean includeSpacing)
	{
		Rectangle rect = super.getCellRect(row, col, includeSpacing);
		HongCell xcell = data.getCellGap(row, col);
		if (xcell != null)
		{
			List<HongCell> list = data.getMergeInfo(row, col).unvisibles;
			Set<Integer> set = new HashSet<Integer>();
			if (xcell.col > 0)
			{
				for (HongCell cell : list)
				{
					if (cell.col != col)
					{
						set.add(cell.col);
					}
				}
				for (Integer i : set)
				{
					rect.width += getTableHeader().getColumnModel()
							.getColumn(i).getWidth();
				}
			}
			set.clear();
			if (xcell.row > 0)
			{
				for (HongCell cell : list)
				{
					if (cell.row != row)
					{
						set.add(cell.row);
					}
				}
				for (Integer i : set)
				{
					rect.height += getRowHeight(i);
				}
			}
		}
		return rect;
	}

	@Override
	public int rowAtPoint(Point p)
	{
		int row = super.rowAtPoint(p);
		int col = super.columnAtPoint(p);
		HongCell cell = data.getKeyFromUnvisible(row, col);
		return cell == null ? row : cell.row;
	}

	@Override
	public int columnAtPoint(Point p)
	{
		int row = super.rowAtPoint(p);
		int col = super.columnAtPoint(p);
		HongCell cell = data.getKeyFromUnvisible(row, col);
		return cell == null ? col : cell.col;
	}

}
