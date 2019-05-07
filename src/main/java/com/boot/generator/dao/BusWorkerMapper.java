package com.boot.generator.dao;

import com.boot.generator.bean.BusWorker;

public interface BusWorkerMapper {
    int insert(BusWorker record);

    int insertSelective(BusWorker record);

    BusWorker selectByPrimaryKey(String workerId);

    int updateByPrimaryKeySelective(BusWorker record);

    int updateByPrimaryKey(BusWorker record);
}