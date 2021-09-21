package zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zavrsni.model.User;
import zavrsni.web.dto.UserDTO;

@Component
public class UserListToUserDtoList implements Converter<List<User>, List<UserDTO>>{

	@Autowired
	private UserToUserDto toDto;
	
	@Override
	public List<UserDTO> convert(List<User> source) {
		List<UserDTO> target = new ArrayList<>();
		
		for(User u : source) {
			UserDTO dto = toDto.convert(u);
			target.add(dto);
		}
		
		return target;
	}
}
