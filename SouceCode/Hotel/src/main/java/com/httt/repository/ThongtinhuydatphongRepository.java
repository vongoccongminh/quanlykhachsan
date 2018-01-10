
package com.httt.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import com.example.demo.model.Thongtindatphong;
import com.example.demo.model.Thongtinhuydatphong;


public interface ThongtinhuydatphongRepository extends CrudRepository<Thongtinhuydatphong, Integer>{
	//@Query("INSERT INTO 'thongtinhuydatphong'('Madatphong', 'Maphong', 'Ngayhuy', 'Nguyennhan', 'Manv') VALUES (?1,?2,?3,'?4',?5)")
	//public void insertdata(int ma_dp,int maphong,String ngay,String nguyennhan,int ma_nv);

}
