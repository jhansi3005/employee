package com.example.demo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/employeedata")
public class emploeecontroller {
@Autowired
employeeservice s;
@RequestMapping("/insertdata")
public Map<String,String> insertdata(@RequestBody employeedata e)
{
	HashMap<String,String> result=new HashMap<>();
	if(s.insertEmployee(e)>=1)
	{
		result.put("s","success");
	}
	else
	{
		result.put("f", "fail");
	}
	return result;
}
@GetMapping("/select")
public List<Map<String,Object>> selected(employeedata e)
{
	return s.select(e);
}
@PostMapping("/updateemp/{name}/{age}")
public Map<String,String> updated(@RequestBody employeedata e)
{
	HashMap<String,String> h=new HashMap<>();
	int i=s.update(e);
	if(i>=1)
	{
		h.put("s","successfully updated");
	}
	else
	{
		h.put("f", "updation failed");
	}
return 	h;
}



}
