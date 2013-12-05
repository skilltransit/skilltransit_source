package org.tekniti.skilltransit.validator;

import java.util.Properties;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.tekniti.skilltransit.busobj.SkillEntry;
import org.tekniti.skilltransit.util.ValidationPropertiesUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class SkillEntryValidator implements Validator {
	private static Log _log = LogFactoryUtil.getLog(SkillEntryValidator.class);
	ValidationPropertiesUtil propUtil=new ValidationPropertiesUtil();
	Properties loaderProps=propUtil.loadProps();
	
	public boolean supports(Class clazz){
		return SkillEntry.class.isAssignableFrom(clazz);
	}
	public void validate(Object formobject, Errors errors){	
		SkillEntry skillEntry = (SkillEntry)formobject;
		//Some validations here
		/*if (StringUtils.isBlank(userProfileForm.getScreenName())){
			errors.rejectValue(USERPROFILE_USER_ID,DEFAULT_MESSAGE, loaderProps.getProperty("userProfileForm.userId.required"));
		}*/
	}
}
