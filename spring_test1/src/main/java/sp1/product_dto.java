package sp1;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

//1. DTO 만들기 2. Modeul 1차원 3. dto 2차원넣기
@Getter
@Setter
public class product_dto {
	String pidx,pcode,pname,pmoney,pimg,psale,puse;
	
	
	//Database => 1차원 배열 => return 2차원 배열로 전달
	public ArrayList<String> db_data(){
		ArrayList<String> lists = new ArrayList<String>();
		lists.add(getPidx()); //auto
		lists.add(getPcode()); //아이디
		lists.add(getPname()); //이메일
		lists.add(getPmoney()); //연락처
		lists.add(getPimg()); //나이
		lists.add(getPsale()); //가입일자
		lists.add(getPuse()); //가입일자
		return lists;
	}
}
