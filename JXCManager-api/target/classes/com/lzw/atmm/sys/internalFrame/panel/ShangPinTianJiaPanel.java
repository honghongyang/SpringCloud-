package com.lzw.atmm.sys.internalFrame.panel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.google.common.collect.Lists;
import com.lzw.atmm.dao.DBDao;
import com.lzw.atmm.internalFrame.guanli.Item;
import com.lzw.atmm.model.TbSpinfo;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：商品信息添加面板
 * 类名称：com.lzw.sys.internalFrame.panel.ShangPinTianJiaPanel     
 * 创建人：杨洪
 * 创建时间：2016年8月15日 下午5:10:48   
 * 修改人：
 * 修改时间：2016年8月15日 下午5:10:48   
 * 修改备注：   
 * @version   V1.0    
 */

public class ShangPinTianJiaPanel extends JPanel {
	private static final long serialVersionUID = 6383894608494110450L;
	private JLabel goodsNameLabel;//商品名称
	private JLabel goodsSimpleNameLabel;//商品简称
	private JLabel addressLabel;//产地
	private JLabel danWeiLabel;//单位
	private JLabel guiGeLabel;//规格
	private JLabel baoZhuangLabel;//包装
	private JLabel piHaoLabel;//批号
	private JLabel pzwhaoLabel;//批准文号
	private JLabel gysQuanChengLabel;//供应商全称
	private JLabel noteLabel;//备注
	private DBDao dbDao;
    private JTextField goodsNameField;	
    private JTextField goodsSimpleNameField;
    private JTextField addressField;
    private JTextField danWeiField;
    private JTextField guiGeField;
    private JTextField baoZhuangField;
    private JTextField piHaoField;
    private JTextField pzwhaoField;
    private JComboBox<Object> gysQuanChengFieldComboBox;
	private JTextField noteField;
	private JButton jbutton;
	private JButton resetButton;
	
	public ShangPinTianJiaPanel(){
		dbDao = DBDao.newInstance();
		setLayout(new GridBagLayout());
		setBounds(10,10,550,400);
		initWindowComponent();
		
	}
	
	
	private void initWindowComponent(){//初始化组件
		goodsNameLabel = new JLabel("商品名称:");
		setComponentConstraints(goodsNameLabel,0,0,1,1,false);
		goodsNameField = new JTextField();
		setComponentConstraints(goodsNameField,1,0,3,450,true);
		
		goodsSimpleNameLabel = new JLabel("简称:");
		setComponentConstraints(goodsSimpleNameLabel,0,1,1,1,false);
		goodsSimpleNameField = new JTextField();
		setComponentConstraints(goodsSimpleNameField,1,1,3,1,true);
		
		addressLabel = new JLabel("产地:");
		setComponentConstraints(addressLabel, 0, 2, 1, 1, false);
		addressField = new JTextField();
		setComponentConstraints(addressField,1,2,3,1,true);
		
		danWeiLabel = new JLabel("单位:");
		setComponentConstraints(danWeiLabel, 0, 3, 1, 1, false);
		danWeiField = new JTextField();
		setComponentConstraints(danWeiField,1,3,1,200,true);//第二列,第四行,水平方向占一个单元格,竖直方向占一个单元格
		
		guiGeLabel = new JLabel("规格:");
		setComponentConstraints(guiGeLabel,2,3,1,1,false);
		guiGeField = new JTextField();
		setComponentConstraints(guiGeField,3,3,1,1,true);
		
		baoZhuangLabel = new JLabel("包装:");
		setComponentConstraints(baoZhuangLabel,0,4,1,1,false);
		baoZhuangField = new JTextField();
		setComponentConstraints(baoZhuangField,1,4,1,1,true);
		
		piHaoLabel = new JLabel("批号:");
		setComponentConstraints(piHaoLabel,2,4,1,1,false);
		piHaoField = new JTextField();
		setComponentConstraints(piHaoField,3,4,1,1,true);
		
		pzwhaoLabel = new JLabel("批准文号:");
		setComponentConstraints(pzwhaoLabel,0,5,1,1,false);
		pzwhaoField = new JTextField();
		setComponentConstraints(pzwhaoField,1,5,3,1,true);//第二个单元格,第六行,3水平方向占三个单元格
		
		
		gysQuanChengLabel = new JLabel("供应商全称:");
		setComponentConstraints(gysQuanChengLabel,0,6,1,1,false);
		gysQuanChengFieldComboBox = new JComboBox<Object>();
		 /**
	     * Sets the maximum number of rows the <code>JComboBox</code> displays.
	     * If the number of objects in the model is greater than count,
	     * the combo box uses a scrollbar.当模型中的对象数量超过规定的数量时,会出现滚动条
	     *
	     * @param count an integer specifying the maximum number of items to
	     *              display in the list before using a scrollbar
	     * @beaninfo
	     *        bound: true
	     *    preferred: true
	     *  description: The maximum number of rows the popup should have
	     */
		gysQuanChengFieldComboBox.setMaximumRowCount(5);//设置最大函数,当超过该行数时,显示滚动条
		setComponentConstraints(gysQuanChengFieldComboBox,1,6,3,1,true);
		
		noteLabel = new JLabel("注备:");
		setComponentConstraints(noteLabel,0,7,1,1,false);
		noteField = new JTextField();
		setComponentConstraints(noteField,1,7,3,1,true);
		
		
		jbutton = new JButton("添加");
		jbutton.addActionListener(new ActionListener() {//位按钮添加动作监听器对象
			@Override
			public void actionPerformed(ActionEvent e) {
				do_this_actionPerformed(e);
			}
		});
		setComponentConstraints(jbutton,1,8,1,1,false);//第四列和第九行
		
		resetButton = new JButton("重置");
		resetButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				do_this_reset_actionPerformed(e);
			}
		});
		setComponentConstraints(resetButton,2,8,1,1,false);
		
	}
	
	//对组件添加约束----------控制条件
	private void setComponentConstraints(JComponent component,int gridx,int gridy,
			                             int gridwidth,int ipadx,boolean fill){
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx=gridx;
		gridBagConstraints.gridy=gridy;
		if(gridwidth>1){
			gridBagConstraints.gridwidth=gridwidth;
		}
		if(ipadx>0){
			gridBagConstraints.ipadx=ipadx;
		}
		if(fill){
			gridBagConstraints.fill=GridBagConstraints.HORIZONTAL;
		}
		gridBagConstraints.insets=new Insets(5,1,3,1);
		add(component,gridBagConstraints);//添加组件到面板.同时为组件添加约束
	}
	
	
	public void initDataComboBox(){//初始化供应商信息
		List<List<String>> lists=dbDao.getGysInfos();
		List<Item> items = Lists.newArrayList();
		gysQuanChengFieldComboBox.removeAllItems();//移除所有的选项
		for(Iterator<List<String>> iter =lists.iterator();iter.hasNext();){
			List<String> gysInfo=iter.next();
			Item item = new Item();
			item.setId(gysInfo.get(0).toString().trim());
			item.setName(gysInfo.get(1).toString().trim());
			if(items.contains(item))//如果容器中包含对象
				continue;//跳出该次循环
			items.add(item);//对象添加到容器
			gysQuanChengFieldComboBox.addItem(item);
		}
		
	}
	
	/**
     * Type meaning Look and Feel should not supply any options -- only
     * use the options from the <code>JOptionPane</code>.
     
    public static final int         DEFAULT_OPTION = -1;
    /** Type used for <code>showConfirmDialog</code>. *//*
    public static final int         YES_NO_OPTION = 0;
    *//** Type used for <code>showConfirmDialog</code>. *//*
    public static final int         YES_NO_CANCEL_OPTION = 1;
    *//** Type used for <code>showConfirmDialog</code>. *//*
    public static final int         OK_CANCEL_OPTION = 2;

    //
    // Return values.
    //
    *//** Return value from class method if YES is chosen. *//*
    public static final int         YES_OPTION = 0;
    *//** Return value from class method if NO is chosen. *//*
    public static final int         NO_OPTION = 1;
    *//** Return value from class method if CANCEL is chosen. *//*
    public static final int         CANCEL_OPTION = 2;
    *//** Return value form class method if OK is chosen. *//*
    public static final int         OK_OPTION = 0;
    *//** Return value from class method if user closes window without selecting
     * anything, more than likely this should be treated as either a
     * <code>CANCEL_OPTION</code> or <code>NO_OPTION</code>. *//*
    public static final int         CLOSED_OPTION = -1;

    //
    // Message types. Used by the UI to determine what icon to display,
    // and possibly what behavior to give based on the type.
    //
    *//** Used for error messages. *//*
    public static final int  ERROR_MESSAGE = 0;
    *//** Used for information messages. *//*
    public static final int  INFORMATION_MESSAGE = 1;
    *//** Used for warning messages. *//*
    public static final int  WARNING_MESSAGE = 2;
    *//** Used for questions. *//*
    public static final int  QUESTION_MESSAGE = 3;
    *//** No icon is used. *//*
    public static final int   PLAIN_MESSAGE = -1;
    
*/
	
	private void do_this_actionPerformed(ActionEvent e){
		
		if(goodsNameField.getText().equals("")||
				goodsSimpleNameField.getText().equals("")||
				addressField.getText().equals("")||
				danWeiField.getText().equals("")||
				guiGeField.getText().equals("")||
				baoZhuangField.getText().equals("")||
				piHaoField.getText().equals("")||
				pzwhaoField.getText().equals("")||
				noteField.getText().equals("")){
			JOptionPane.showConfirmDialog(ShangPinTianJiaPanel.this, 
					"请完成未填写的信息", "商品添加",
					                 JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		ResultSet   haveUser = dbDao
				.query("select * from tb_spinfo where spname='"
						+ goodsNameField.getText().trim() + "'");
		try {
			haveUser.next();
			
			JOptionPane.showConfirmDialog(ShangPinTianJiaPanel.this,
					"添加商品失败,存在同名的商品", 
					"客户添加信息提示", 
					JOptionPane.INFORMATION_MESSAGE);
			return;
		} catch (SQLException e1) {			
			e1.printStackTrace();
		}
		
		ResultSet rs =dbDao.query("select max(id) from tb_spinfo");
		String id=null;//构造商品库字符串id
	    try {
			if(rs != null && rs.next()){
				String sid=rs.getString(1);
				if(sid == null){
					id = "sp1001";
				}else{
					String str = sid.substring(2);
					id="sp"+(Integer.parseInt(str)+1);
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	
	    TbSpinfo tbSp = new TbSpinfo();
	    tbSp.setId(id);
	    tbSp.setSpname(goodsNameField.getText().trim());
	    tbSp.setJc(goodsSimpleNameField.getText().trim());
	    tbSp.setCd(addressField.getText().trim());
	    tbSp.setDw(danWeiField.getText().trim());
	    tbSp.setGg(guiGeField.getText().trim());
	    tbSp.setBz(baoZhuangField.getText().trim());
	    tbSp.setPh(piHaoField.getText().trim());
	    tbSp.setPzwh(pzwhaoField.getText().trim());
	    tbSp.setMemo(noteField.getText().trim());
	    dbDao.addSp(tbSp);
	    JOptionPane.showConfirmDialog(ShangPinTianJiaPanel.this,
	    		"商品信息已经成功添加",
	    		"商品添加",
	    		JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void do_this_reset_actionPerformed(ActionEvent e){
		goodsNameField.setText("");
		goodsSimpleNameField.setText("");
		addressField.setText("");
		danWeiField.setText("");
		guiGeField.setText("");
		baoZhuangField.setText("");
		piHaoField.setText("");
		pzwhaoField.setText("");
		noteField.setText("");
	}
	

}
