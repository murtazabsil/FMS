package com.fms.dao;

public class DAOCustom {

	public static final String GET_PROJECT_AS_PER_MANAGER = "SELECT pml.projectId as projectId FROM ProjectManagerLink pml where pml.managerId.managerId=:managerId";
}
