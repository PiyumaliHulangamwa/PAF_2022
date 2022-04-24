package com.piyumali.demorest;


import java.util.HashMap;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/power") 
public class controller {
	
	private  model billmodel;
	private service billservice = new service();
	
	
	
	
	@GET
	@Path("/getAllbills")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllbills() {
		return billservice.getAllbills();
	}
	
	
	
	@GET
	@Path("/getpowerbyuserID/{poweruserIDId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPowerById(@PathParam("poweruserIDId") Integer poweruserIDId) {
		return billservice.getPowerById(poweruserIDId);
	}
	
	
	
	@PUT
	@Path("/update/{poweruserIDId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBill(HashMap<String, ?> powerData, @PathParam("poweruserIDId") Integer poweruserIDId) {
		String name = (String) powerData.get("name");
		String district = (String) powerData.get("district");
		String units = (String) powerData.get("units");
		billmodel = new model(name, district, units);
		billmodel.setId(poweruserIDId);
		return billservice.updatebillModel(billmodel);
	}
	
	
	
	@DELETE
	@Path("/deletebyuserID/{poweruserIDId}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteById(@PathParam("poweruserIDId") Integer poweruserIDId) {
		return billservice.deletePower(poweruserIDId);
	}
	

	
	
}

