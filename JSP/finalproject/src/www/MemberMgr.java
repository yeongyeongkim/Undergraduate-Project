package www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import ch11.RegisterBean;

public class MemberMgr {

	private DBConnectionMgr pool;

	public MemberMgr() {
		try {
			pool = DBConnectionMgr.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ID 중복확인
	public boolean checkId(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select id from tblMember where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			flag = pstmt.executeQuery().next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
	}

	// 우편번호 검색
	public Vector<ZipcodeBean> zipcodeRead(String area3) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<ZipcodeBean> vlist = new Vector<ZipcodeBean>();
		try {
			con = pool.getConnection();
			sql = "select * from tblZipcode where area3 like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + area3 + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ZipcodeBean bean = new ZipcodeBean();
				bean.setZipcode(rs.getString(1));
				bean.setArea1(rs.getString(2));
				bean.setArea2(rs.getString(3));
				bean.setArea3(rs.getString(4));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}

	// 회원가입
	public boolean insertMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert tblMember(id,pwd,name,gender,birthday,email,zipcode"
					+ ",address,hobby,job)values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPwd());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getGender());
			pstmt.setString(5, bean.getBirthday());
			pstmt.setString(6, bean.getEmail());
			pstmt.setString(7, bean.getZipcode());
			pstmt.setString(8, bean.getAddress());
			String hobby[] = bean.getHobby();
			char hb[] = { '0', '0', '0', '0', '0' };
			String lists[] = { "인터넷", "여행", "게임", "영화", "운동" };
			for (int i = 0; i < hobby.length; i++) {
				for (int j = 0; j < lists.length; j++) {
					if (hobby[i].equals(lists[j]))
						hb[j] = '1';
				}
			}
			pstmt.setString(9, new String(hb));
			pstmt.setString(10, bean.getJob());
			if (pstmt.executeUpdate() == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
	
	//회원탈퇴
	//*******************************************
	public boolean deleteMember(String id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
		con = pool.getConnection();
		sql = "delete from tblMember where id = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		if (pstmt.executeUpdate() == 1)
			flag = true;
		} catch (Exception e) {
		System.out.println("delete error : " + e);
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag;
		}

	// 로그인
	public boolean loginMember(String id, String pwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "select id from tblMember where id = ? and pwd = ?";//쿼리문인데 조건문이 붙었다. ?는 변수처럼 가변적이다.>>?는*같은 특수문자.
			//첫번째 ?는 1이 인덱스 두번째는 2가 인덱스 >>이거를 121-123에서 세팅 >>**중요한 것은 첫 인덱스가 0이라는 거
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();//조건에 맞는 거만 가져와.
			flag = rs.next(); //디비에 조건에 맞는 게 있으면 그럼 flag가 true값이 된다.
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return flag; //불 타입만 던진다.
	}
	
//	//관리자 로그인
//	public boolean admin_login(String admin_id,String admin_pwd){
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = null;
//		boolean flag = false;
//		if (admin_id!=null && admin_id.equals("admin")) {
//		try {
//			con = pool.getConnection();
//			sql = "select * from admin where admin_id = ? and admin_pass = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, admin_id);
//			pstmt.setString(2, admin_pwd);
//			rs = pstmt.executeQuery();
//			flag=rs.next();
//			} catch (Exception e) {
//			System.out.println("admin_login error : " + e);
//			} finally {
//				pool.freeConnection(con, pstmt, rs);
//			}}
//			return flag;
//			}

	/*************
	 * ch17 필요한 메소드
	 * ************/

	//*******************************************
	// 회원정보가져오기
	public MemberBean getMember(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberBean bean = null;
		try {
			con = pool.getConnection();
			String sql = "select * from tblMember where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bean = new MemberBean();
				bean.setId(rs.getString("id"));
				bean.setPwd(rs.getString("pwd"));
				bean.setName(rs.getString("name"));
				bean.setGender(rs.getString("gender"));
				bean.setBirthday(rs.getString("birthday"));
				bean.setEmail(rs.getString("email"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setAddress(rs.getString("address"));
				String hobbys[] = new String[5];
				String hobby = rs.getString("hobby");// 01001
				for (int i = 0; i < hobbys.length; i++) {
					hobbys[i] = hobby.substring(i, i + 1);
				}
				bean.setHobby(hobbys);
				bean.setJob(rs.getString("job"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con);
		}
		return bean;
	}
	
	//회원정보 전체 출력
    public Vector<MemberBean> getMemberList() {
	   Connection con = null;
	   Statement stmt = null;
	   ResultSet rs = null;
	   Vector<MemberBean> vlist = new Vector<MemberBean>();	   
       try {
          con = pool.getConnection();
          String strQuery = "select * from tblMember";
          stmt = con.createStatement();
          rs = stmt.executeQuery(strQuery);
		  while (rs.next()) {
			  MemberBean bean = new MemberBean();
			  bean.setId(rs.getString("id"));
			  bean.setPwd(rs.getString("pwd"));
			  bean.setName(rs.getString("name"));
			  bean.setGender(rs.getString("gender"));
			  bean.setBirthday(rs.getString("birthday"));
			  bean.setEmail(rs.getString("email"));
			  bean.setZipcode(rs.getString("zipcode"));
			  bean.setAddress(rs.getString("address"));
			  String hobbys[] = new String[5];
			  String hobby = rs.getString("hobby");
			  for (int i = 0; i < hobbys.length; i++) {
				  hobbys[i] = hobby.substring(i, i + 1);
			  }
			  bean.setHobby(hobbys);
			  bean.setJob(rs.getString("job"));
			  vlist.addElement(bean);
          }
       } catch (Exception ex) {
          System.out.println("Exception" + ex);
       } finally {
	      pool.freeConnection(con); 
       }
       return vlist;
    }

	// 회원정보수정
	public boolean updateMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			String sql = "update tblMember set pwd=?, name=?, gender=?, birthday=?,"
					+ "email=?, zipcode=?, address=?, hobby=?, job=? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getPwd());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getGender());
			pstmt.setString(4, bean.getBirthday());
			pstmt.setString(5, bean.getEmail());
			pstmt.setString(6, bean.getZipcode());
			pstmt.setString(7, bean.getAddress());
			char hobby[] = { '0', '0', '0', '0', '0' };
			if (bean.getHobby() != null) {
				String hobbys[] = bean.getHobby();
				String list[] = { "인터넷", "여행", "게임", "영화", "운동" };
				for (int i = 0; i < hobbys.length; i++) {
					for (int j = 0; j < list.length; j++)
						if (hobbys[i].equals(list[j]))
							hobby[j] = '1';
				}
			}
			pstmt.setString(8, new String(hobby));
			pstmt.setString(9, bean.getJob());
			pstmt.setString(10, bean.getId());
			int count = pstmt.executeUpdate();
			if (count > 0)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
}