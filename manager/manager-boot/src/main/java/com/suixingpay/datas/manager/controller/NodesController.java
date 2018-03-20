package com.suixingpay.datas.manager.controller;

import static com.suixingpay.datas.manager.web.message.ResponseMessage.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suixingpay.datas.common.dic.NodeStatusType;
import com.suixingpay.datas.manager.core.entity.Nodes;
import com.suixingpay.datas.manager.service.NodesService;
import com.suixingpay.datas.manager.web.message.ResponseMessage;
import com.suixingpay.datas.manager.web.page.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 节点信息表 controller控制器
 *
 * @author: FairyHood
 * @date: 2018-03-07 17:26:55
 * @version: V1.0-auto
 * @review: FairyHood/2018-03-07 17:26:55
 */
@Api(description = "节点信息表管理")
@RestController
@RequestMapping("/nodes")
public class NodesController {

    @Autowired
    protected NodesService nodesService;

    /**
     * 查询列表
     *
     * @author FuZizheng
     * @date 2018/3/16 下午3:34
     * @param: [pageNo, pageSize, ipAddress, state, machineName, type]
     * @return: com.suixingpay.datas.manager.web.message.ResponseMessage
     */
    @GetMapping
    @ApiOperation(value = "查询列表", notes = "查询列表")
    public ResponseMessage list(@RequestParam(value = "pageNo", required = true) Integer pageNo,
                                @RequestParam(value = "pageSize", required = true) Integer pageSize,
                                @RequestParam(value = "ipAddress", required = false) String ipAddress,
                                @RequestParam(value = "state", required = false) Integer state,
                                @RequestParam(value = "machineName", required = false) String machineName) {
        Page<Nodes> page = nodesService.page(new Page<Nodes>(pageNo, pageSize), ipAddress, state, machineName);
        return ok(page);
    }

    @PostMapping
    @ApiOperation(value = "新增", notes = "新增")
    public ResponseMessage add(@RequestBody Nodes nodes) {
        Integer number = nodesService.insert(nodes);
        return ok(number);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除", notes = "删除")
    public ResponseMessage delete(@PathVariable("id") Long id) {
        Integer number = nodesService.delete(id);
        return ok(number);
    }

    @PostMapping("/taskpushstate")
    @ApiOperation(value = "任务状态推送", notes = "任务状态推送")
    public ResponseMessage taskPushState(@RequestParam(value = "id", required = true) Long id,@RequestParam(value = "taskPushState", required = true) NodeStatusType taskPushState) {
        Nodes nodes = nodesService.taskPushState(id, taskPushState);
        return ok(nodes);
    }

    @PostMapping("/stoptask")
    @ApiOperation(value = "停止任务", notes = "停止任务")
    public ResponseMessage stopTask(@RequestParam(value = "id", required = true) Long id) {
        System.out.println("停止任务:"+id);
        return ok();
    }

    /*@PutMapping("/{id}")
    @ApiOperation(value = "修改", notes = "修改")
    public ResponseMessage update(@PathVariable("id") Long id, @RequestBody Nodes nodes) {
        Integer number = nodesService.update(id, nodes);
        return ok(number);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除", notes = "删除")
    public ResponseMessage delete(@PathVariable("id") Long id) {
        nodesService.delete(id);
        return ok();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询明细", notes = "查询明细")
    public ResponseMessage info(@PathVariable("id") Long id) {
        Nodes nodes = nodesService.selectById(id);
        return ok(nodes);
    }

    @ApiOperation(value = "查询列表", notes = "查询列表")
    @GetMapping
    public ResponseMessage list(@RequestParam(value = "pageNo", required = false) Integer pageNo,
            @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        Page<Nodes> page = nodesService.page(new Page<Nodes>(pageNo, pageSize));
        return ok(page);
    }*/

}