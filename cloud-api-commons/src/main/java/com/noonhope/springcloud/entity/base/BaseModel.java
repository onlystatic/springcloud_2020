package com.noonhope.springcloud.entity.base;

import lombok.Getter;
import lombok.Setter;

/**
 * @author onlystatic
 * @date 2020-10-17 08:55 PM
 */
@Getter
@Setter
public abstract class BaseModel implements IModel {

    private Long id;
}
