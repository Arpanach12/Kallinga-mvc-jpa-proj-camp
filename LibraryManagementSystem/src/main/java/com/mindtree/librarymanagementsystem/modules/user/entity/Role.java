package com.mindtree.librarymanagementsystem.modules.user.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mindtree.librarymanagementsystem.modules.common.enums.RoleName;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Byte roleId;
	@Enumerated(EnumType.STRING)
	private RoleName roleName;

	public Role() {
		super();
	}

	public Role(Byte roleId, RoleName roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public Byte getRoleId() {
		return roleId;
	}

	public void setRoleId(Byte roleId) {
		this.roleId = roleId;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
