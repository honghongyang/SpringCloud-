package com.lzw.atmm.util.worker;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint.CycleMethod;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
/**   
 * 版权所有：2016-中实智达
 * 项目名称：JXCManager-api   
 * 类描述：异步处理器
 * 类名称：com.lzw.atmm.util.worker.HongSwingWorker     
 * 创建人：杨洪
 * 创建时间：2016年12月13日 下午3:20:19   
 * 修改人：
 * 修改时间：2016年12月13日 下午3:20:19   
 * 修改备注：   
 * @version   V1.0    
 */
/**
 * 封装JDK的SwingWorker,主要用来执行长时间异步任务,将启用多个线程执行,因不产生任何结果而取消泛型,
 * 将弹出异常信息界面报告而不是在异步蒸发发生的异常
 * .并伴有加载进度界面可做当前任务描述.
 * 如果仅仅需要加载进度界面而调用此类,可将其内部方法尽可能的设置成同步或锁住.如果已不好同步推荐使用JohnProgressSynchroWorker
 * @author yanghong
 */

public abstract class HongSwingWorker extends SwingWorker<Void,Void> implements PropertyChangeListener,HongWorker{//实现属性变化监听器,和异步进度条加载接口
	/**异常发生时的建议*/
	protected String exceptionSuggests;
	/**异常信息界面和加载进度界面的父窗口*/
	protected Window parentWindow;
	/**当发生异常弹出异常信息界面后点击继续按钮时的动作*/
	protected Action continueActionButton;
	/**使用此后台执行的长时间任务的主题*/
	protected String taskName;
	/**当前正在执行的步骤描述*/
	protected String doingString;
	/**加载进度界面的进度条*/
	protected JProgressBar progressBar;
	/**加载进度界面的取消按钮*/
	protected JButton cancel;
	/**加载进度界面对话框*/
	protected JDialog dialog;
	/**加载进度界面放置任务主题的渐变背景区域*/
	protected JLabel bkImgTitle;
	/**具体的当前执行步骤描述的显示区域*/
	protected JTextArea progressTip;
	/**是否在执行后台任务时发生了异常,如果发生异常将不再调用safe_done方法作为收尾*/
	protected boolean occurExceptionInBack;
	
	/**
	 * @param exceptionSuggests 异常发生时的建议
	 * @param parentWindow 异常信息界面和加载进度界面的父窗口
	 * @param continueButtonAction 当发生异常弹出异常信息界面后点击继续按钮时的动作
	 * @param taskName 使用此后台执行的长时间任务的主题
	 */
	public HongSwingWorker(String exceptionSuggests,Window parentWindow,Action continueButtonAction,String taskName){
		this.exceptionSuggests=exceptionSuggests;
		this.parentWindow=parentWindow;
		this.continueActionButton=continueButtonAction;
		this.taskName=taskName;
		dialog = new JDialog(parentWindow);
		
		bkImgTitle = new JLabel(){//重写该类
			private static final long serialVersionUID = 1L;
			@Override
			public void paintComponents(Graphics g) {
				Graphics2D g2d =(Graphics2D) g;
				g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				g2d.setPaint(new LinearGradientPaint(new Point(0,0), new Point(this.getWidth(),this.getHeight()), 
						     new float[]{0.0f,0.2f,0.6f,0.8f,1.0f},
						     new Color[]{Color.WHITE,new Color(206,221,240),new Color(140,177,213),new Color(53,94,133),new Color(36,113, 144)},
						     CycleMethod.NO_CYCLE));
				g2d.fillRect(0, 0, this.getWidth(),this.getHeight());
				g2d.setColor(Color.BLACK);
				g2d.setFont(new Font("微软雅黑",Font.PLAIN,18));
				g2d.drawString(getTaskName(), 25, 30);
				super.paintComponents(g);
			}
			
		};
		
		progressTip = new JTextArea();
		progressTip.setEnabled(false);//设置不能使用
		progressTip.setDisabledTextColor(Color.BLACK);
		progressTip.setFont(new Font("微软雅黑",Font.PLAIN,12));
		progressTip.setOpaque(false);//设置透明
		
		progressBar = new JProgressBar(0,100);//设置进度条的最大值和最小值
		progressBar.setValue(0);//设置初始值
		/**
		 * 不明确就是滚动条的当前值自动在最小到最大值之间来回移动，形成这样一个动画效果，
		 * 这个只是告诉别人“我正在工作”，但不能提示工作进度到哪个阶段。
		 * 主要是在进行一些无法确定操作时间的任务时作为提示。
		 * 而“明确”就是根据你的进度可以设置现在的进度值
		 */
		progressBar.setIndeterminate(true);
		
		cancel=new JButton("取消");
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent paramActionEvent)
			{
				cancel(true);
			}
		});
		prepareProgressPane();
		dialog.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));////该代码是当光标移到窗体内部时候,光标呈现的状态
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//关闭的时候释放内存
		dialog.setResizable(false);
		dialog.setLocationRelativeTo(null);//总是居中
		dialog.setVisible(true);
		this.addPropertyChangeListener(this);//为当前类对象注册类监听器
		execute();//执行工作调度器
	}
	
	
	/**首先终止覆写,返回任务主题*/
	public final String getTaskName()
	{
		return taskName;
	}
	
	/**首先终止覆写,查看是否执行过程发生过异常*/
	public final boolean isOccurExceptionInBack()
	{
		return occurExceptionInBack;
	}
	
	/**首先终止覆写,因progress属性变更,调整进度条和步骤描述已经标题栏标题*/
	@Override
	public void propertyChange(PropertyChangeEvent evt) {//属性监听器
		if("progress"==evt.getPropertyName()){//属性名称
			Integer value=(Integer) evt.getNewValue();
			/*不明确(false)就是滚动条的当前值自动在最小到最大值之间来回移动，
			形成这样一个动画效果，这个只是告诉别人“我正在工作”，
			但不能提示工作进度到哪个阶段。主要是在进行一些无法确定操作时间的任务时作为提示。
			而“明确”(true)就是根据你的进度可以设置现在的进度值*/
			progressBar.setIndeterminate(false);
			progressBar.setValue(value);//设置进度条的当前值
			dialog.setTitle(value+"%——"+doingString);
			progressTip.setText("请稍候，选定任务已开始执行，可能需要几分钟。\n\n状态：\t"+doingString);
		}
	}
	
	/**首先终止覆写,设置进度值和步骤描述,进度值应大于0并小于100,步骤描述应尽可能言简意赅;
	 * 应在safe_doInBackground方法中调用,如果safe_doInBackground没有逻辑,而是创建了一个对象,但此对象创建过程耗时,则可将本类传入对象构造,调用此方法
	 */
	@Override
	public void setProgressValue(int value, String doingString) {
		setProgress(value);//设置进度的条的动态值
		this.doingString = doingString;
		
	}
	
	/**首先终止覆写,该方法无返回值,其中设置progress属性的0,100值,而且捕获了任何异常,并调用safe_doInBackground方法*/
	@Override
	protected final Void doInBackground(){
		try {
			setProgress(0);//设置进度条的初始值
			safe_doInBackground();
			setProgress(100);//设置最大值
		} catch (Exception e) {
			occurExceptionInBack=true;
		}
		return null;
	}

	/**相当于原SwingWorker的doInBackground方法,不过在发生异常时弹出信息窗口*/
	protected abstract void safe_doInBackground();//抽象的方法
	
	
	@Override
	protected void process(List<Void> chunks) {
		super.process(chunks);
	}
	/**首先终止覆写,该方法无返回值,其中发出嘟嘟声,恢复光标,回收加载进度窗口资源,而且捕获了任何异常,如果没有取消任务并未发生异常将调用safe_done方法*/
	@Override
	protected final void done() {
		Toolkit.getDefaultToolkit().beep();
	}
	
	
	/**采用绝对布局布局加载进度界面,如果需要添加其他组件,请覆写此方法,并添加到dialog成员上,再在其类外添加事件监听*/
	protected void prepareProgressPane(){
		bkImgTitle.setBounds(0, 0, 414, 42);
		dialog.add(bkImgTitle);//添加到弹出窗体
		
		progressTip.setText("正在计算....");
		progressTip.setBounds(25,50,365,50);
		dialog.add(progressTip);//添加提示文本框
		
		progressBar.setBounds(25,110,365,18);
		dialog.add(progressBar);
		
		JPanel optionPanel = new JPanel(null);
		optionPanel.setBounds(0,140,414,42);
		dialog.add(optionPanel);//对话框窗口中添加面板
		
		cancel.setBounds(320, 8,70, 25);
		optionPanel.add(cancel);//面板中添加取消按钮
		
		//设置对话框面板的北京颜色
		dialog.getContentPane().setBackground(Color.WHITE);//设置背景色为白色
		dialog.setTitle("正在计算....");
		dialog.setLayout(null);//设置布局为空布局,取消默认布局
		dialog.setSize(420,210);
	}

}
