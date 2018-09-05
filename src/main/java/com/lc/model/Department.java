package com.lc.model;

import java.util.List;

/**
 * 该Model用于实现mybatis的递归查询
 *
 * @author lc
 */
public class Department {
    private Long id;
    private String name;
    /**
     * 上级所对应的id
     */
    private String pid;
    /**
     * 下级链表
     */
    private List<Department> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        this.toString(temp,this,0);
        return temp.toString();
    }

    private void toString(StringBuilder temp,Department department,int depth) {
        if (department.getChildren() == null || department.getChildren().size() == 0) {
            return ;
        }
        getSpace(temp,depth);
        temp.append("id:" + this.id);
        temp.append("\n");
        getSpace(temp,depth);
        temp.append("name:" + this.name);
        temp.append("\n");
        getSpace(temp,depth);
        temp.append("pid:" + this.pid);
        temp.append("\n");
        getSpace(temp,depth);
        temp.append("children[\n");
        for (Department item:department.getChildren()){
            toString(temp,item,depth + 1);
        }
        temp.append("]\n");
    }

    private void getSpace(StringBuilder stringBuilder,int depth){
        for (int i=0;i<depth;i++){
            stringBuilder.append("  ");
        }
    }
}
