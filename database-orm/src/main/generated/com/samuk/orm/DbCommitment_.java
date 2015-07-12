package com.samuk.orm;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-09T11:28:03.641+0300")
@StaticMetamodel(DbCommitment.class)
public class DbCommitment_ {
	public static volatile SingularAttribute<DbCommitment, Long> id;
	public static volatile SingularAttribute<DbCommitment, Integer> committedPoints;
	public static volatile SingularAttribute<DbCommitment, DbTeamMember> member;
	public static volatile SingularAttribute<DbCommitment, DbSprint> sprint;
}
