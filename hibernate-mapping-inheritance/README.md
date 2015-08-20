# hibernate-showcase

A Simple Project For Using hibernate mapping inheritance

- Sample for Tables per Concrete Classes
	+ Create amount of tables corresponding to concrete classes
	+ @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
	+ Do not support IDENTITY generator strategy (not use: AUTO & IDENTITY)
	+ Drawbacks:
		* Polymorphic associations
		* Polymorphic queries
	+ Package: 
		* com.dee.hibernate.mapping.tblperconccreteclass
		
- Sample for Tables per hierarchy 
	+ Create just only ONE table
	+ @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
	+ Extra column of Discriminator to distinguish instances
	+ High performance to present polymorphic & non-polymorphic queries (no need to JOIN tables)
	+ Drawbacks:
		* Loss NOT NULL constraint of properties in subclasses
	+ Package:
		* com.dee.hibernate.mapping.tblperhierarchy
	  
- Sampel of tables per subclass
	+ Tables contain only properties that are non-inherited
	+ @Inheritance(strategy = InheritanceType.JOINED)
	+ Relational Model is completely normalized
	+ Drawbacks:
		* Low performance to make query (need to join tables)
	Package:
		* com.dee.hibernate.mapping.tablepersubclass
	
