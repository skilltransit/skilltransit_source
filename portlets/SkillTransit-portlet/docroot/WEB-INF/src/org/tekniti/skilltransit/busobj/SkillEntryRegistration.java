package org.tekniti.skilltransit.busobj;

import java.io.Serializable;

public class SkillEntryRegistration implements Serializable {
	private static final long serialVersionUID = 2263661243678623672L;

	SkillEntry skillEntry;
	
	

	public SkillEntry getSkillEntry() {
		return skillEntry;
	}



	public void setSkillEntry(SkillEntry skillEntry) {
		this.skillEntry = skillEntry;
	}



	public String toString() {
		StringBuffer sb = new StringBuffer(); 
		sb.append("SkillEntry: " + skillEntry);
		return sb.toString();
	}
}