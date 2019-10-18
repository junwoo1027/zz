package com.company.me;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.domain.SampleVo;
import com.company.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@GetMapping(value = "/getText")
	public List<SampleVo> getText() {
		return IntStream.range(1, 10).mapToObj( i -> new SampleVo(i, i + "First", i + "Last")).collect(Collectors.toList());
	}
	
	@GetMapping(value = "/getMap")
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("First", new SampleVo(111,"키키","오오"));
		
		return map;
	}
	
	@GetMapping(value="check", params = {"height", "weight" })
	public ResponseEntity<SampleVo> check(Double height, Double weight){
		
		SampleVo sample = new SampleVo(0, "" + height, "" + weight);
		
		ResponseEntity<SampleVo> result = null;
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(sample);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(sample);
		}
		
		return result;
	}
	
	@GetMapping(value="/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") Integer pid) {
		return new String[] {"category: " + cat, "productid: " + pid };
	}
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		return ticket;
	}
}
