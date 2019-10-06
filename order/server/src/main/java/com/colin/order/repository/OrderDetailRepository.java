package com.colin.order.repository;

import com.colin.order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: BlueMelancholy
 * 2019/10/2 16:55
 * @desc:
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {
}
