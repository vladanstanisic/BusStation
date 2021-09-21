package zavrsni.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import zavrsni.model.Line;
import zavrsni.web.dto.LineDTO;

@Component
public class LineToLineDto implements Converter<Line, LineDTO>{

	@Autowired
	private CompanyToCompanyDto toCompanyDto;

	@Override
	public LineDTO convert(Line source) {
		LineDTO lineDTO = new LineDTO();
		
		lineDTO.setId(source.getId());
		lineDTO.setAvailableSeats(source.getAvailableSeats());
		lineDTO.setPrice(source.getPrice());
		lineDTO.setDestination(source.getDestination());
		lineDTO.setScheduled(source.getScheduled());
		lineDTO.setCompanyDTO(toCompanyDto.convert(source.getCompany()));
		
		return lineDTO;
	}
	
	public List<LineDTO> convert(List<Line> lines) {
		List<LineDTO> linesDTO = new ArrayList<>();
		
		for (Line line: lines) {
			linesDTO.add(convert(line));
		}
		
		return linesDTO;
	}
}
