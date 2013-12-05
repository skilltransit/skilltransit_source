create table skill_category (
	id LONG not null primary key,
	name VARCHAR(75) null
);

create table skill_subcategory (
	id LONG not null primary key,
	name VARCHAR(75) null
);

create table user_details (
	user_id LONG not null primary key,
	hourly_rate VARCHAR(75) null,
	zipCode VARCHAR(75) null,
	category VARCHAR(75) null,
	client VARCHAR(75) null,
	commute VARCHAR(75) null,
	skill VARCHAR(75) null,
	state_ VARCHAR(75) null
);

create table user_skills (
	id LONG not null primary key,
	name VARCHAR(75) null,
	user_id LONG
);