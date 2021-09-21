package zavrsni.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zavrsni.model.User;
import zavrsni.service.UserService;
import zavrsni.web.dto.UserDTO;

@Component
public class UserDtoToUser implements Converter<UserDTO, User>{
	
	@Autowired
	private UserService userService;
	
	@Override
	public User convert(UserDTO source) {
		User target = null;
		if(source.getId() != null) {
			target = userService.one(source.getId()).get();
		}
		
		if(target == null) { 
			target = new User();
		}
				
		target.setUsername(source.getUsername());
		
		return target;
	}

}
