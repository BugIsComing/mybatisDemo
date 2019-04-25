package com.lc.test;

import com.lc.model.Department;

import java.lang.reflect.Field;

/**
 * 生成mybatis xml文件中insert语句的value部分
 */
public class MybatisInsertStatement {
    public static void main(String[] args) {
        Class cl = Department.class;
        Field[] fields = cl.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        for (Field item : fields) {
            sb.append("#{item.").append(item.getName()).append(",jdbcType=");
            //类型映射需要参考sql类型和java类型映射关系
            String temp = item.getType().getSimpleName();
            if ("String".equals(temp)) {
                sb.append("VARCHAR");
            } else if ("Double".equals(temp) || "Float".equals(temp)) {
                sb.append("DOUBLE");
            } else if("Integer".equals(temp)){
                sb.append("INTEGER");
            }
            sb.append("},").append('\n');
        }
        System.out.println(sb.toString());
    }
}
