package com.lzw.atmm.sys.internalFrame.panel;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;
import com.lzw.atmm.dao.DBDao;
import com.lzw.atmm.internalFrame.guanli.Item;
import com.lzw.atmm.model.TbGysinfo;
import com.lzw.atmm.model.TbSpinfo;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：
 * 类名称：com.lzw.sys.internalFrame.panel.ShangPinXiuGaiPanel     
 * 创建人：杨洪
 * 创建时间：2016年10月12日 下午4:43:21   
 * 修改人：
 * 修改时间：2016年10月12日 下午4:43:21   
 * 修改备注：   
 * @version   V1.0    
 */

public class ShangPinXiuGaiPanel extends JPanel {
	private static final long serialVersionUID = 9169008599747645303L;
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
	private JLabel goodChooseLabel;//选择商品标签
	private JPanel panel;//放置修改和删除按钮的面板
	private JButton modifyButton;
	private JButton deleteButton;
	
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
	private JComboBox<Object> goodChooseField ;
	
	
	
	public ShangPinXiuGaiPanel(){
		dbDao = DBDao.newInstance();
		setLayout(new GridBagLayout());//设置面板布局为网格组布局
		setBounds(10,10,550,400);//设置面板为绝对布局
		initWindowComponent();
	}
	
	
	private void initWindowComponent(){//初始化各组件
		goodsNameLabel = new JLabel("商品名称:");
		setComponentConstraints(goodsNameLabel,0,0,1,1,false);// 第一列,第一行
		goodsNameField = new JTextField();
		setComponentConstraints(goodsNameField,1,0,3,450,true);// 第二列,第一行
		
		goodsSimpleNameLabel = new JLabel("简称:");
		setComponentConstraints(goodsSimpleNameLabel,0,1,1,1,false);
		goodsSimpleNameField = new JTextField();
		setComponentConstraints(goodsSimpleNameField,1,1,3,1,true);
		
		
		addressLabel = new JLabel("产地:");
		setComponentConstraints(addressLabel,0,2,1,1,false);
		addressField = new JTextField();
		setComponentConstraints(addressField,1,2,3,1,true);
		
		
		danWeiLabel = new JLabel("单位:");
		setComponentConstraints(danWeiLabel,0,3,1,1,false);
		danWeiField = new JTextField();
		setComponentConstraints(danWeiField,1,3,1,200,true);//设置的200 对后面的文本框有同样的参考作用
		
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
		setComponentConstraints(pzwhaoField,1,5,3,1,true);
		
		
		gysQuanChengLabel = new JLabel("供应商全称:");
		setComponentConstraints(gysQuanChengLabel,0,6,1,1,false);
		gysQuanChengFieldComboBox = new JComboBox<Object>();
		setComponentConstraints(gysQuanChengFieldComboBox,1,6,3,1,true);
		
		noteLabel = new JLabel("备注:");
		setComponentConstraints(noteLabel,0,7,1,1,false);
		noteField = new JTextField();
		setComponentConstraints(noteField,1,7,3,1,true);
		
		goodChooseLabel = new JLabel("选择商品:");
		setComponentConstraints(goodChooseLabel,0,8,1,1,false);
		goodChooseField = new JComboBox<Object>();
		setComponentConstraints(goodChooseField,1,8,2,1,true);
		goodChooseField.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				doSpSelectActiondoSpSelectAction();
			}
		});
		panel = new JPanel();
		modifyButton = new JButton("修改");
		deleteButton = new JButton("删除");
		panel.add(modifyButton);
		panel.add(deleteButton);//默认为流布局
		setComponentConstraints(panel,3,8,1,1,false);//设置面板
		
		modifyButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				do_this_modifyActionListener();
			}
		});
		deleteButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
			    do_this_deleteActionListener(); 
			}
		});
	}
	
	
	private void setComponentConstraints(JComponent component,int gridx,
			int gridy,int gridwidth,int ipadx,boolean fill){
		final GridBagConstraints  gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx=gridx;
		gridBagConstraints.gridy=gridy;
		if(gridwidth>1){
			gridBagConstraints.gridwidth=gridwidth;
		}
		if(ipadx>0){
			gridBagConstraints.ipadx=ipadx;
		}
		if(fill){
			gridBagConstraints.fill= GridBagConstraints.HORIZONTAL;//延水平平铺
		}
		gridBagConstraints.insets = new Insets(5,1,3,1);
		//为组件添加约束,同时添加组件到面板
		add(component,gridBagConstraints);
		
	}
	//选择商品下拉框
	public void initGoodsItem(){
		List<List<String>> lists =dbDao.getSpInfos();
		List<Item> items = Lists.newArrayList();
		goodChooseField.removeAllItems();//移除下拉框中的选项
		for(Iterator<List<String>> iter=lists.iterator();iter.hasNext();){
			List<String> elements=iter.next();
			Item item = new Item();
			item.setId(elements.get(0).toString().trim());
			item.setName(elements.get(1).toString().trim());
			if(items.contains(item)){
				continue;
			}
			items.add(item);
			goodChooseField.addItem(item);
		}
		doSpSelectActiondoSpSelectAction();//设置商品对应的供应商名称
		
	}
	
	
	public void initGysComboBox(){//初始化供应商全称选择下拉框
		List<List<String>> lists =dbDao.getGysInfos();
		List<Item> items = Lists.newArrayList();
		gysQuanChengFieldComboBox.removeAllItems();
		//把list转换为iterator迭代器
		for(Iterator<List<String>> iter = lists.iterator();iter.hasNext();){
			List<String> element=iter.next();//取出迭代器中的值
			Item item = new Item();
			item.setId(element.get(0).toString().trim());
			item.setName(element.get(1).toString().trim());
			if(items.contains(item)){
				continue;
			}
			items.add(item);
			gysQuanChengFieldComboBox.addItem(item);
		}
		doSpSelectActiondoSpSelectAction();
	}
	
	//处理商品选择时,找到对于的供应商,及填充文本框中的相应字段
	private void doSpSelectActiondoSpSelectAction(){
		Item selectedItem = null ;
		if(!(goodChooseField.getSelectedItem() instanceof Item)){
			return;
		}
		selectedItem = (Item) goodChooseField.getSelectedItem();
		TbSpinfo ts =dbDao.getSpInfo(selectedItem);
		if(StringUtils.isNotBlank(ts.getId())){
			goodsNameField.setText(ts.getSpname());
			goodsSimpleNameField.setText(ts.getJc());
			addressField.setText(ts.getCd());
			danWeiField.setText(ts.getDw());
			guiGeField.setText(ts.getGg());
			baoZhuangField.setText(ts.getBz());
			piHaoField.setText(ts.getPh());
			pzwhaoField.setText(ts.getPzwh());
			noteField.setText(ts.getBz());
			// 设置供应商下拉框的当前选择项
		    Item item = new Item();
		    item.setId(ts.getGysname());//设置供应商名称
		    TbGysinfo tgs=dbDao.getGysInfo(item);//获得供应商
		    item.setId(tgs.getId());
		    item.setId(tgs.getName());
		    //循环获取供应商下拉框中的客户,跟该供应商比较,如果相等,则设置下拉框中被选中的为该供应商
		    for(int n =0;n<gysQuanChengFieldComboBox.getItemCount();n++){
		    	Item tempItem=(Item) gysQuanChengFieldComboBox.getItemAt(n);
		    	if(tempItem.getName().equals(item.getName())){
		    		item = tempItem;
		    	}
		    }
		    gysQuanChengFieldComboBox.setSelectedItem(item);//设置下拉框中被选中的对象
		}
	}
	
	private void do_this_modifyActionListener(){//修改按钮事件处理器
		Item item =(Item) goodChooseField.getSelectedItem();
		TbSpinfo ts = new TbSpinfo();
		ts.setId(item.getId());
		ts.setBz(baoZhuangField.getText().trim());
		ts.setCd(addressField.getText().trim());
		ts.setDw(danWeiField.getText().trim());
		ts.setGg(guiGeField.getText().trim());
		ts.setGysname(gysQuanChengFieldComboBox.getSelectedItem().toString().trim());
		ts.setJc(goodsSimpleNameField.getText().trim());
		ts.setMemo(noteField.getText().trim());
		ts.setPh(piHaoField.getText().trim());
		ts.setPzwh(pzwhaoField.getText().trim());
		ts.setSpname(goodsNameField.getText().trim());
		if(dbDao.updateSp(ts)==1){
			JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this,//该对话框只有一个确认按钮,标题为消息
					"修改完成");
		}else{
			JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this,
					"修改失败!");
		}
	}
	
	private void do_this_deleteActionListener(){//删除按钮事件处理
		Item item =(Item) goodChooseField.getSelectedItem();
		if(item == null || !(item instanceof Item)){
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(ShangPinXiuGaiPanel.this,
				"你确定要删除商品信息吗?");
		if(confirm == JOptionPane.YES_OPTION){
			int rs = dbDao.delete("delete tb_spinfo where id='"
					+ item.getId() + "'");
			if (rs > 0) {
				JOptionPane.showMessageDialog(ShangPinXiuGaiPanel.this,
						"商品：" + item.getName() + "。删除成功");
				goodChooseField.removeItem(item);//把该项从下拉框中移除
			}
		}
	}



}
