package com.mindtree.librarymanagementsystem.modules.user.dto;

import com.mindtree.librarymanagementsystem.modules.common.enums.RoleName;

public class RoleDto {

	private Byte roleId;

	private RoleName roleName;

	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleDto(Byte roleId, RoleName roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	/**
	 * @return the roleId
	 */
	public Byte getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Byte roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the roleName
	 */
	public RoleName getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "RoleDto [roleId=" + roleId + ", roleName=" + roleName + "]";
	}


}
