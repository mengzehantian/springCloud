package com.halo.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.halo.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author halo
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
