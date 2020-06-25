package com.hykj.sc.bsc.lxq.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hykj.sc.bsc.lxq.ipo.GridIPO;
import com.hykj.sc.bsc.lxq.ipo.GridIPO3;
import com.hykj.sc.bsc.lxq.ipo.GridIPO2;
import com.hykj.sc.bsc.lxq.service.GridService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "/grid", tags = "grid")
@RestController
@RequestMapping(value = "grid", produces = "application/json")
public class GridController {
    @Autowired
    GridService gridService;

    @ApiOperation(value = "insert_solution1", notes = "", httpMethod = "POST")
    @PostMapping("insert/s1")
    public String insertGridDataSolution1(@RequestBody GridIPO gridIPO) {
        gridService.insertGridSolution1(gridIPO);
        return "success";
    }

    @ApiOperation(value = "get_solution1", notes = "", httpMethod = "GET")
    @GetMapping("getGrid/s1/{code}")
    public GridIPO getGridDataSolution1(@PathVariable("code") String code) {
        GridIPO gridData = gridService.getGridDataSolution1(code);
        return gridData;
    }

    @ApiOperation(value = "insert_solution2", notes = "", httpMethod = "POST")
    @PostMapping("insert/s2")
    public Object insertGridDataSolution2(@RequestBody GridIPO2 gridIPO) {
        gridService.insertGridSolution2(gridIPO);
        return "success";
    }

    @ApiOperation(value = "get_solution2", notes = "", httpMethod = "GET")
    @GetMapping("getGrid/s2/{code}")
    public GridIPO2 getGridDataSolution2(@PathVariable("code") String code) {
        GridIPO2 gridData = gridService.getGridDataSolution2(code);
        return gridData;
    }

    @ApiOperation(value = "insert_solution3", notes = "", httpMethod = "POST")
    @PostMapping("insert/s3")
    public Object insertGridDataSolution3(@RequestBody GridIPO3 gridIPO) {
        gridService.insertGridSolution3(gridIPO);
        return "success";
    }

    @ApiOperation(value = "get_solution3", notes = "", httpMethod = "GET")
    @GetMapping("getGrid/s3/{code}")
    public GridIPO3 getGridDataSolution3(@PathVariable("code") String code) {
        GridIPO3 gridData = gridService.getGridDataSolution3(code);
        return gridData;
    }

}
