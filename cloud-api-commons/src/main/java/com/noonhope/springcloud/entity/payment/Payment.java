package com.noonhope.springcloud.entity.payment;

import com.noonhope.springcloud.entity.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author onlystatic
 * @date 2020-10-17 08:26 PM
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends BaseModel {

    private String serial;
}
