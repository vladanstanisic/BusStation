package zavrsni.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zavrsni.model.User;
import zavrsni.web.dto.UserDTO;

@Component
public class UserToUserDto implements Converter<User, UserDTO>{
	
	@Override
	public UserDTO convert(User source) {
		UserDTO target = new UserDTO();
		
		target.setId(source.getId());
		target.setUsername(source.getUsername());
		
		return target;
	}

}
