package com.zsy.hr.service;

import com.zsy.hr.domian.po.Position;

import java.util.List;

public interface PositionService {
    public List<Position> getAllPositions();
    public Integer addPosition(Position position);
    public Integer updatePositions(Position position);
    public Integer deletePositionById(Integer id);
    public Integer deletePositionsByIds(Integer[] ids);
}
