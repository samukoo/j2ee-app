package com.samuk.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.samuk.operations.CommitmentOperations;
import com.samuk.orm.DbCommitment;
import com.samuk.service.CommitmentService;
import com.samuk.service.MemberService;
import com.samuk.service.SprintService;
import com.samuk.service.exceptions.EmptyPointsException;

/**
 * Session Bean implementation class CommitmentServiceImpl
 */
@Stateless
public class CommitmentServiceImpl implements CommitmentService {

	@EJB
	private SprintService sprintService;
	
	@EJB
	private MemberService memberService;
	
	@Inject
	private CommitmentOperations commitmentsOperations;
	
	@Inject
	private DbCommitment commitment;
	
    /**
     * Default constructor. 
     */
    public CommitmentServiceImpl() {}

    /**
     * Persist commitment object
     */
	@Override
	public void saveCommitment(DbCommitment commitment) {
	}

	/**
	 * Persist commitment. If Commit points are empty, Exceptions is thrown.
	 */
	// TODO refactor: saveCom.. to persistCom..
	@Override
	public void saveCommitment(Long memberId, String committedPoints, String sprintId) {

		try{
			if(!committedPoints.isEmpty()){
			commitment.setSprint(sprintService.findSprintById(sprintId))
					  .setCommittedPoints(Integer.parseInt(committedPoints))
					  .setMember(memberService.getMemberById(memberId));
			
			commitmentsOperations.saveCommitment(commitment);
			}else{
				throw new EmptyPointsException(memberId);
			}
		
		}catch(EmptyPointsException e){
			e.printError();
		}
	}

	/**
	 * List all commitments from DB
	 */
	@Override
	public List<DbCommitment> listAll() {
		return commitmentsOperations.getAll();
	}

}
