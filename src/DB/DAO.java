package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
	Connection con = null;
	PreparedStatement pst = null;
	Statement st = null;
	ResultSet rs = null;
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String dbid = "system";
	String pass = "111111";
	public static DAO goDB = null;

	private DAO() {
	}

	public static DAO getInstance() {
		if (goDB == null) {
			goDB = new DAO();
		}
		return goDB;
	}

	private Connection getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, dbid, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public ArrayList<BBR_DTO> getIndex() {
		ArrayList<BBR_DTO> list = new ArrayList<>();
		String sql = "select * from bbr";
		try {
			con = getCon();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				BBR_DTO line = new BBR_DTO();
				line.setNo(rs.getInt("no"));
				line.setTitle(rs.getString("title"));
				line.setId(rs.getString("id"));
				line.setNdate(rs.getString("ndate"));
				list.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public BBR_DTO Contests(int no) {
		String sql = "select * from bbr where no=?";
		BBR_DTO contents = new BBR_DTO();
		try {
			con = getCon();
			pst = con.prepareStatement(sql);
			pst.setInt(1, no);
			rs = pst.executeQuery();
			if (rs.next()) {
				contents.setNo(no);
				contents.setTitle(rs.getString("title"));
				contents.setContents(rs.getString("contents"));
				contents.setId(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contents;
	}

	public int singup(member_DTO dto) {
		member_DTO insert = dto;
		int k = 0;
		String sql = "insert into member values(?,?,?,?)";
		try {
			con = getCon();
			pst = con.prepareStatement(sql);
			pst.setString(1, insert.getId());
//			System.out.println(insert.getId()+" DB로 가는 ID의 값");
			pst.setString(2, insert.getPw());
//			System.out.println(insert.getPw()+" DB로 가는 pw의 값");
			pst.setString(3, insert.getName());
//			System.out.println(insert.getName()+" DB로 가는 이름");
			pst.setString(4, insert.getMail());
//			System.out.println(insert.getMail()+" DB로 가는 메일");
			k = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return k;
	}

	public boolean login(String id, String pw) {
		String sql = "select count(*) cnt from member where id=? and pw=?";
		try {
			con = getCon();
			pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery();
			if (rs.next()) {
				int cnt = rs.getInt("cnt");
				if (cnt > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public int InWrite(BBR_DTO bdto) {
		BBR_DTO Bdto = bdto;
		int k = 0;
		String sql = "insert into bbr values(no.nextval,?,?,?,?)";
		try {
			con = getCon();
			pst = con.prepareStatement(sql);
			pst.setString(1, Bdto.getTitle());
//			System.out.println("글 제목 :" + Bdto.getTitle());
			pst.setString(2, Bdto.getContents());
//			System.out.println("글 내용 :" + Bdto.getContents());
			pst.setString(3, Bdto.getId());
//			System.out.println("글 작성자 :" + Bdto.getId());
			pst.setString(4, Bdto.getNdate());
//			System.out.println("글 작성일 :" + Bdto.getNdate());
			k = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return k;
	}

	public void delBBR(int no, String nowID) {
		String sql = "delete from bbr where no=" + no + "and id='" + nowID + "'";
		try {
			con = getCon();
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean idcheckBBR(int no, String nowID) {
		String sql = "select count(*) cnt from bbr where no=? and id=?";
		try {
			con = getCon();
			pst = con.prepareStatement(sql);
			pst.setInt(1, no);
			pst.setString(2, nowID);
			rs = pst.executeQuery();
			if (rs.next()) {
				int cnt = rs.getInt("cnt");
				if (cnt > 0) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public int modBBR(BBR_DTO bdto) {
		BBR_DTO Bdto = bdto;
		int k = 0;
		String sql = "update bbr set title=?, contents=? where no=?";
		try {
			con = getCon();
			pst = con.prepareStatement(sql);
			pst.setString(1, Bdto.getTitle());
//			System.out.println("dao글 제목 :" + Bdto.getTitle());
			pst.setString(2, Bdto.getContents());
//			System.out.println("dao글 내용 :" + Bdto.getContents());
			pst.setInt(3, Bdto.getNo());
//			System.out.println("dao글 작성자 :" + Bdto.getNo());		
			k = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return k;
	}
}