package com.reborn.web.controller.animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.reborn.web.entity.animal.Animal;
import com.reborn.web.entity.animal.AnimalAPIResponseData;
import com.reborn.web.entity.animal.AnimalKind;
import com.reborn.web.entity.animal.AnimalUpKind;
import com.reborn.web.service.animal.AnimalKindService;
import com.reborn.web.service.animal.AnimalService;

/* api를 읽어와서 유기동물 목록을 전시 */
@Controller
@RequestMapping("/animal/")
public class AnimalController {
	
	@Autowired
	AnimalService animalService;

	@Autowired
	AnimalKindService kindService;

	@Value("${animal.kindApiUrl}")
	private String kindUrl;
	
	@Value("${animal.apiKey}")
	private String serviceKey;
	
	
	@RequestMapping("list")
	public String list(
			@RequestParam(name="p", defaultValue="1") 	 int page,
			@RequestParam(name="upkind", required=false) String upkind,		//축종 코드
			@RequestParam(name="kind", required=false) 	 String kind,		//품종 코드
			@RequestParam(name="bgnde", required=false)	 Date startDate, 	//유기 시작 날짜
			@RequestParam(name="endde", required=false)	 Date endDate, 		//유기 종료 날짜
			@RequestParam(name="neuter", required=false) String neuter
			, Model model) {
		
		int size = 10;		
		List<Animal> list = animalService.getList(page, size, upkind, kind, startDate, endDate, neuter); 
		
		int count =	animalService.getCount();
		
		int pageCount = (int)Math.ceil(count / (float)size);
		model.addAttribute("pageCount", pageCount);
		model.addAttribute("list", list);
			
		return "home.animal.list";
	}
	
	@RequestMapping("{desertionNo}")
	public String detail(@PathVariable(name="desertionNo") long no, Model model) {
		
		System.out.println("desertionNo : "+no);
		
		Animal a = animalService.get(no);
		
		model.addAttribute("animal", a);		
		
		return "home.animal.detail";
	}
	
}
