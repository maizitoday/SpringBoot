package com.example.demo.model;

/**
 * 描述:permission_role_ref表的实体类
 * @version
 * @author:  maizi
 * @创建时间: 2018-09-15
 */
public class PermissionRoleRef {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private Integer permissionid;

    /**
     * 
     */
    private Integer roleid;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return permissionId 
     */
    public Integer getPermissionid() {
        return permissionid;
    }

    /**
     * 
     * @param permissionid 
     */
    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    /**
     * 
     * @return roleId 
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * 
     * @param roleid 
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }
}