package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品id查询套餐id
     * @param dishIds
     * @return
     */
    //select setmeal id from setmeal dish where dish_id in (1,2,3,4)
    List<Long> getSetmealIdByDishId(List<Long> dishIds);
}