package com.lzw.atmm.dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.google.common.collect.Lists;
import com.lzw.atmm.internalFrame.guanli.Item;
import com.lzw.atmm.model.TbGysinfo;
import com.lzw.atmm.model.TbKhinfo;
import com.lzw.atmm.model.TbSpinfo;
import com.lzw.atmm.model.TbUserlist;

public class DBDao {
	protected static String dbClassName = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
	protected static String dbUrl = "jdbc:microsoft:sqlserver://localhost:1433;"
			+ "DatabaseName=db_JXC;SelectMethod=Cursor";
	protected static String dbUser = "sa";
	protected static String dbPwd = "123456";
	protected static String second = null;
	public static Connection conn = null;
	static {
		try {
			if (conn == null) {
				Class.forName(dbClassName).newInstance();
				conn = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}
	
	//========================================== 读取所有客户信息============================================
	// 读取所有客户信息
		public  List<List<String>> getKhInfos() {
			List<List<String>> list = findForList("select id,khname from tb_khinfo");//客户
			return list;
		}
		public static List<List<String>> findForList(String sql) {
			List<List<String>> list = Lists.newArrayList();
			ResultSet rs = findForResultSet(sql);
			try {
				ResultSetMetaData metaData = rs.getMetaData();
				int colCount = metaData.getColumnCount();
				while (rs.next()) {
					List<String> row =Lists.newArrayList();
					for (int i = 1; i <= colCount; i++) {
						String str = rs.getString(i);
						if (str != null && !str.isEmpty())
							str = str.trim();
						row.add(str);
					}
					list.add(row);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		// 修改客户信息的方法
		public  int updateKeHu(TbKhinfo khinfo) {
			return update("update tb_khinfo set jian='" + khinfo.getJian()
					+ "',address='" + khinfo.getAddress() + "',bianma='"
					+ khinfo.getBianma() + "',tel='" + khinfo.getTel() + "',fax='"
					+ khinfo.getFax() + "',lian='" + khinfo.getLian() + "',ltel='"
					+ khinfo.getLtel() + "',mail='" + khinfo.getMail()
					+ "',xinhang='" + khinfo.getXinhang() + "',hao='"
					+ khinfo.getHao() + "' where id='" + khinfo.getId() + "'");
		}
		//================================ 结果集公共工具方法beginning==============更加sql获取结果集的工具方法===============================
		
		public static ResultSet findForResultSet(String sql){
			if(conn==null) return null;
			long time=System.currentTimeMillis();
			ResultSet rs=null;
			Statement stmt= null;
			   try {
				stmt =conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				rs =stmt.executeQuery(sql);
				second=((System.currentTimeMillis()-time)/1000d)+"";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			   return rs;
		}
		//======================================结果集公共工具方法结束=================================================================
		
		
		//===============================================获取各类主表最大ID  BEGIN=========================================================
		//获取各表最大ID的公共方法
		public  String getMainTypeTableMaxId(Date date,String table,
				String idChar,String idName){
			String dateStr = date.toString().replace("-", "");
			String id = idChar + dateStr;
			String sql="select max(" +idName+ ") from "+table
					+" where "+idName
					+" like '"+id +"%'";//主要空格
			ResultSet rs =query(sql);
			String baseId= null;
			try {
				if(rs.next()){
					baseId =rs.getString(1);//获得第一栏
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			baseId=baseId==null?"000":baseId.substring(baseId.length()-3);//赋值更三元运算符
			int idNum=Integer.parseInt(baseId) + 1;
			id += String.format("%03d", idNum);//格式字符串
			return id;
			
		}
		//===================================================获取各类主表最大ID  END===================================================================
		public  ResultSet query(String queryStr){
			ResultSet rs=findForResultSet(queryStr);
			return rs;
		}
		
		// 修改用户方法
		public int updateUser(TbUserlist user) {
			return update("update tb_userlist set username='" + user.getUsername()
					+ "',name='" + user.getName() + "',pass='" + user.getPass()
					+ "',quan='" + user.getQuan() + "' where name='"
					+ user.getName() + "'");
			
		}
		// 获取用户对象的方法
		public  TbUserlist getUser(Item item) {
			String where = "username='" + item.getName() + "'";
			if (item.getId() != null)
				where = "name='" + item.getId() + "'";
			ResultSet rs = findForResultSet("select * from tb_userlist where "
					+ where);
			TbUserlist user = TbUserlist.getInstance();
			try {
				if (rs.next()) {
					user.setName(rs.getString("name").trim());
					user.setUsername(rs.getString("username").trim());
					user.setPass(rs.getString("pass").trim());
					user.setQuan(rs.getString("quan").trim());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
		//获取系统操作员列表
		public TbUserlist getUser(String name,String password){
			TbUserlist user = null;
			String sql="select * from tb_userlist where username='"+name+"' and pass='"+password+"'";
			ResultSet rs =findForResultSet(sql);
			try {
				if(rs.next()){
					user =TbUserlist.getInstance();
					user.setUsername(name);//登陆名
					user.setPass(rs.getString("pass"));
					if(user.getPass().equals(password))
					{
						user.setName(rs.getString("name"));
						user.setQuan(rs.getString("quan"));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
	
		// 添加用户
		public  int addUser(TbUserlist ul) {
			return update("insert tb_userlist values('" + ul.getUsername() + "','"
					+ ul.getName() + "','" + ul.getPass() + "','" + ul.getQuan()
					+ "')");
		}
		public static int update(String sql) {
			int result = 0;
			try {
				Statement stmt = conn.createStatement();
				result = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		// 执行删除
		public int delete(String sql) {
			return update(sql);
		}
		
		public  List<List<String>> getUsers() {
			List<List<String>> list = findForList("select * from tb_userlist");
			return list;
		}
		private static class SingtonDBDaoHandler{
			private static DBDao newInstance = new DBDao();
		}
		private DBDao(){
		}
		public static DBDao newInstance(){
			return DBDao.SingtonDBDaoHandler.newInstance;
		}
		
		// 添加供应商信息的方法
		public  boolean addGys(TbGysinfo gysInfo) {
			if (gysInfo == null)
				return false;
			return insert("insert tb_gysinfo values('" + gysInfo.getId() + "','"
					+ gysInfo.getName() + "','" + gysInfo.getJc() + "','"
					+ gysInfo.getAddress() + "','" + gysInfo.getBianma() + "','"
					+ gysInfo.getTel() + "','" + gysInfo.getFax() + "','"
					+ gysInfo.getLian() + "','" + gysInfo.getLtel() + "','"
					+ gysInfo.getMail() + "','" + gysInfo.getYh() + "')");
		}
		
		public  boolean insert(String sql) {
			boolean result = false;
			try {
				Statement stmt = conn.createStatement();
				result = stmt.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
		
		// 读取所有供应商信息
		public  List<List<String>> getGysInfos() {
			List<List<String>> list = findForList("select id,name from tb_gysinfo");
			return list;
		}
		
		// 读取指定供应商信息
		public TbGysinfo getGysInfo(Item item) {
			String where = "name='" + item.getName() + "'";
			if (item.getId() != null)
				where = "id='" + item.getId() + "'";
			TbGysinfo info = new TbGysinfo();
			ResultSet set = findForResultSet("select * from tb_gysinfo where "
					+ where);
			try {
				if (set.next()) {
					info.setId(set.getString("id").trim());
					info.setAddress(set.getString("address").trim());
					info.setBianma(set.getString("bianma").trim());
					info.setFax(set.getString("fax").trim());
					info.setJc(set.getString("jc").trim());
					info.setLian(set.getString("lian").trim());
					info.setLtel(set.getString("ltel").trim());
					info.setMail(set.getString("mail").trim());
					info.setName(set.getString("name").trim());
					info.setTel(set.getString("tel").trim());
					info.setYh(set.getString("yh").trim());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return info;
		}
		// 修改供应商信息的方法
		public int updateGys(TbGysinfo gysInfo) {
			return update("update tb_gysinfo set jc='" + gysInfo.getJc()
					+ "',address='" + gysInfo.getAddress() + "',bianma='"
					+ gysInfo.getBianma() + "',tel='" + gysInfo.getTel()
					+ "',fax='" + gysInfo.getFax() + "',lian='" + gysInfo.getLian()
					+ "',ltel='" + gysInfo.getLtel() + "',mail='"
					+ gysInfo.getMail() + "',yh='" + gysInfo.getYh()
					+ "' where id='" + gysInfo.getId() + "'");
		}
		
		// 添加客户信息的方法
		public  boolean addKeHu(TbKhinfo khinfo) {
			if (khinfo == null)
				return false;
			return insert("insert tb_khinfo values('" + khinfo.getId() + "','"
					+ khinfo.getKhname() + "','" + khinfo.getJian() + "','"
					+ khinfo.getAddress() + "','" + khinfo.getBianma() + "','"
					+ khinfo.getTel() + "','" + khinfo.getFax() + "','"
					+ khinfo.getLian() + "','" + khinfo.getLtel() + "','"
					+ khinfo.getMail() + "','" + khinfo.getXinhang() + "','"
					+ khinfo.getHao() + "')");
		}
		
		// 读取客户信息
		public TbKhinfo getKhInfo(Item item) {
			String where = "khname='" + item.getName() + "'";
			if (item.getId() != null)
				where = "id='" + item.getId() + "'";
			TbKhinfo info = new TbKhinfo();
			ResultSet set = findForResultSet("select * from tb_khinfo where "
					+ where);
			try {
				if (set.next()) {
					info.setId(set.getString("id").trim());
					info.setKhname(set.getString("khname").trim());
					info.setJian(set.getString("jian").trim());
					info.setAddress(set.getString("address").trim());
					info.setBianma(set.getString("bianma").trim());
					info.setFax(set.getString("fax").trim());
					info.setHao(set.getString("hao").trim());
					info.setLian(set.getString("lian").trim());
					info.setLtel(set.getString("ltel").trim());
					info.setMail(set.getString("mail").trim());
					info.setTel(set.getString("tel").trim());
					info.setXinhang(set.getString("xinhang").trim());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return info;
		}
		
		// 添加商品
		public  boolean addSp(TbSpinfo spInfo) {
			if (spInfo == null)
				return false;
			return insert("insert tb_spinfo values('" + spInfo.getId() + "','"
					+ spInfo.getSpname() + "','" + spInfo.getJc() + "','"
					+ spInfo.getCd() + "','" + spInfo.getDw() + "','"
					+ spInfo.getGg() + "','" + spInfo.getBz() + "','"
					+ spInfo.getPh() + "','" + spInfo.getPzwh() + "','"
					+ spInfo.getMemo() + "','" + spInfo.getGysname() + "')");
		}
		
		
		// 获取所有商品信息
		public List<List<String>> getSpInfos() {
			List<List<String>> list = findForList("select * from tb_spinfo");
			return list;
		}
		// 读取商品信息
		public TbSpinfo getSpInfo(Item item) {
			String where = "spname='" + item.getName() + "'";
			if (item.getId() != null)
				where = "id='" + item.getId() + "'";
			ResultSet rs = findForResultSet("select * from tb_spinfo where "
					+ where);
			TbSpinfo spInfo = new TbSpinfo();
			try {
				if (rs.next()) {
					spInfo.setId(rs.getString("id").trim());
					spInfo.setBz(rs.getString("bz").trim());
					spInfo.setCd(rs.getString("cd").trim());
					spInfo.setDw(rs.getString("dw").trim());
					spInfo.setGg(rs.getString("gg").trim());
					spInfo.setGysname(rs.getString("gysname").trim());
					spInfo.setJc(rs.getString("jc").trim());
					spInfo.setMemo(rs.getString("memo").trim());
					spInfo.setPh(rs.getString("ph").trim());
					spInfo.setPzwh(rs.getString("pzwh").trim());
					spInfo.setSpname(rs.getString("spname").trim());
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return spInfo;
		}
		
		// 更新商品
		public int updateSp(TbSpinfo spInfo) {
			return update("update tb_spinfo set jc='" + spInfo.getJc() + "',cd='"
					+ spInfo.getCd() + "',dw='" + spInfo.getDw() + "',gg='"
					+ spInfo.getGg() + "',bz='" + spInfo.getBz() + "',ph='"
					+ spInfo.getPh() + "',pzwh='" + spInfo.getPzwh() + "',memo='"
					+ spInfo.getMemo() + "',gysname='" + spInfo.getGysname()
					+ "' where id='" + spInfo.getId() + "'");
		}
}
