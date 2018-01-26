package com.zking.crm.bas.mapper;

import com.zking.crm.bas.model.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.List;

public interface TreeNodeMapper {
    int deleteByPrimaryKey(Integer treeNodeId);

    int insert(TreeNode record);

    int insertSelective(TreeNode record);

    TreeNode selectByPrimaryKey(Integer treeNodeId);

    int updateByPrimaryKeySelective(TreeNode record);

    int updateByPrimaryKey(TreeNode record);

    List<TreeNode> list(TreeNode treeNode);
}