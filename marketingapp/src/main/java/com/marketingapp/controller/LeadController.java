package com.marketingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.LeadDto;
import com.marketingapp.entities.Lead;
import com.marketingapp.services.LeadService;

@Controller
public class LeadController {
	
	
	@Autowired
	private LeadService leadService;

	@RequestMapping("/viewCreateLead")
	public String viewCreateLeadForm() {
		return "create_registration";
	}
	
	
//	@RequestMapping("/saveLead")
//	public String saveOneLead(Lead lead) {
//		leadService.saveLead(lead);
//		return "create_registration";
//	}
	
	
//	//I will read the data from a different way into the console
//	@RequestMapping("/saveLead")
//	public String saveOneLead(@RequestParam ("firstName") String firstName,@RequestParam ("lastName") String lastName,@RequestParam ("email") String email,@RequestParam ("mobile") long mobile) {
//		System.out.println(firstName);
//		System.out.println(lastName);
//		System.out.println(email);
//		System.out.println(mobile);
//		return "create_registration";
//	}
	
//	    //I will save the data from a different way into the DB.
//		@RequestMapping("/saveLead")
//		public String saveOneLead(@RequestParam ("firstName") String firstName,@RequestParam ("lastName") String lastName,@RequestParam ("email") String email,@RequestParam ("mobile") long mobile) {
//			Lead lead=new Lead();
//			lead.setFirstName(firstName);
//			lead.setLastName(lastName);
//			lead.setEmail(email);
//			lead.setMobile(mobile);
//			leadService.saveLead(lead);
//			return "create_registration";
//		}
		
//	//I will read the form data a different way into the (dto).
//	@RequestMapping(value = "/saveLead", method = RequestMethod.POST)
//	
//	public String saveOneLead(@ModelAttribute("m") Lead lead, ModelMap model) {
//		leadService.saveLead(lead);
//		model.addAttribute("msg", "record is saved");
//		return "create_registration";
//	}
	
	
	//I will read the form data a different way into the (dto).
		@RequestMapping(value = "/saveLead", method = RequestMethod.POST)
		
		public String saveOneLead(LeadDto leadDto, ModelMap model) {
			Lead lead=new Lead();
			lead.setFirstName(leadDto.getFirstName());
			lead.setLastName(leadDto.getLastName());
			lead.setEmail(leadDto.getEmail());
			lead.setMobile(leadDto.getMobile());
			
			leadService.saveLead(lead);
			
			model.addAttribute("msg", "record is saved");
			return "create_registration";
		}
		
	
		
}
