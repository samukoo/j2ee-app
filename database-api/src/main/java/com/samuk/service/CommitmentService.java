package com.samuk.service;

import javax.ejb.Local;

import com.samuk.orm.DbCommitment;

@Local
public interface CommitmentService {

	public void saveCommitment(DbCommitment commitment);
	public void saveCommitment(Long member, String committedPoints, String sprintId);
}
