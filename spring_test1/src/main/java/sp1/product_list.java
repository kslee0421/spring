package sp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;



public class product_list {
	Connection conn = null;
	PreparedStatement ps = null; //interface
	
	public product_list() {
		try {
			this.conn = dbconfig.info();
			//System.out.println(this.conn);
		}
		catch(Exception e) {
			System.out.println("Database 연결오류 발생!!");
		}
	}

	public List<ArrayList<String>> listdata(){
		List<ArrayList<String>> product =new ArrayList<ArrayList<String>>();
		try {
			String sql = "select * from product order by pidx desc";
			this.ps = this.conn.prepareStatement(sql);
			ResultSet rs = this.ps.executeQuery(); // javaspl interface
			System.out.println(this.ps);
			product_dto dto = new product_dto(); //dto setter, getter, Array생성
			while(rs.next()) {
				dto.setPidx(rs.getString("pidx"));  //getString("mno") :실제 데이터베이스 필드 명
				dto.setPcode(rs.getString("pcode"));
				dto.setPname(rs.getString("pname"));
				dto.setPmoney(rs.getString("pmoney"));
				dto.setPimg(rs.getString("pimg"));
				dto.setPsale(rs.getString("psale"));
				dto.setPuse(rs.getString("puse"));
				product.add(dto.db_data());
			}
			this.ps.close();
			this.conn.close();
		}
		catch(Exception e) {
			System.out.println("Database 컬럼 및 dto 오류발생!!");
		}
		
		return product;
	}
}