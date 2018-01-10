
package com.httt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import com.example.demo.model.Thongtindatphong;
import com.example.demo.model.Chitietdp;


public interface ChitietdpRepository extends CrudRepository<Chitietdp, Integer>{
	@Query("SELECT t FROM Chitietdp  t WHERE t.MaDP =?1")
    public List<Chitietdp> findThongtinchitietdatphong(int ma_dp);
    public void deleteByid(int id);

}
