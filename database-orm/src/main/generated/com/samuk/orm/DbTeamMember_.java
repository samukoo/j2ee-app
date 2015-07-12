package com.samuk.orm;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-08T20:43:20.098+0300")
@StaticMetamodel(DbTeamMember.class)
public class DbTeamMember_ {
	public static volatile SingularAttribute<DbTeamMember, Long> id;
	public static volatile SingularAttribute<DbTeamMember, String> name;
	public static volatile SingularAttribute<DbTeamMember, DbRole> role;
	public static volatile SingularAttribute<DbTeamMember, DbTeam> team;
}
