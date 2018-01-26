package com.zking.crm.bas.controller;


import com.zking.crm.bas.biz.ITreeNodeBiz;
import com.zking.crm.bas.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TreeNodeController {

    @Autowired
    private ITreeNodeBiz treeNodeBiz;

    @RequestMapping("/treeNode/list")
    @ResponseBody
    public List<Map<String, Object>> list(HttpServletRequest request, HttpServletResponse response){
        String parentNodeId = request.getParameter("id");
        String forward = request.getParameter("forward");
        System.out.println("parentNodeId:"+parentNodeId+",forward:"+forward);
        TreeNode treeNode = new TreeNode();
        treeNode.setParentNodeId(parentNodeId);
        List<TreeNode> list = treeNodeBiz.list(treeNode);

        List<Map<String, Object>> nodes = new ArrayList<Map<String, Object>>();
        Map<String, Object> node = null;
        Map<String, Object> attributes = null;
        for (TreeNode t : list) {

            node = new HashMap<String, Object>();
            node.put("id", t.getTreeNodeId());
            node.put("text", t.getTreeNodeName());
            node.put("state", t.isLeaf() ? "open" : "closed");

            attributes = new HashMap<String, Object>();
            attributes.put("url", t.getUrl());
            node.put("attributes", attributes);

            nodes.add(node);
        }
        if ("null".equals(forward)) {
            request.setAttribute("nodes", nodes);
            return nodes;
        } else {
            response.setContentType("text/plain;charset=utf-8");
            return nodes;
        }
    }

}
