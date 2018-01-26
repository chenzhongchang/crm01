package com.zking.crm.bas.biz.impl;

import com.zking.crm.bas.biz.ITreeNodeBiz;
import com.zking.crm.bas.mapper.TreeNodeMapper;
import com.zking.crm.bas.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeNodeBizImpl implements ITreeNodeBiz {

    @Autowired
    private TreeNodeMapper treeNodeMapper;

    @Override
    public List<TreeNode> list(TreeNode treeNode) {
        return treeNodeMapper.list(treeNode);
    }
}
