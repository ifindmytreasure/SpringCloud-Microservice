package com.colin.order.repository;

import com.colin.order.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: BlueMelancholy
 * 2019/10/2 16:56
 * @desc:
 */
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
