package com.samuk.orm;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-07-08T20:54:19.243+0300")
@StaticMetamodel(DbSprint.class)
public class DbSprint_ {
	public static volatile SingularAttribute<DbSprint, Long> id;
	public static volatile SingularAttribute<DbSprint, Integer> week;
	public static volatile SingularAttribute<DbSprint, Date> date;
	public static volatile SingularAttribute<DbSprint, DbTeam> team;
	public static volatile SingularAttribute<DbSprint, String> description;
}
