package com.wjk.sprlay.web.model;

import java.io.Serializable;

/**
 * 
 * @ClassName:  Role   
 * @Description:角色实体  
 * @author: WangJKui
 * @date:   2019年1月30日 上午10:38:56   
 *
 */
public class Role implements Serializable{
    /**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    /*角色编码*/
    private String code;

    /*状态（0：锁定，1：正常）*/
    private Integer status;

    private String remark;

    private String ctime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", code=" + code + ", status=" + status + ", remark=" + remark
				+ ", ctime=" + ctime + "]";
	}
    
    
}