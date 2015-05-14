package com.venkat.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.container.ContainerRequestContext;

import javax.inject.Inject;
import javax.inject.Named;

import org.jvnet.hk2.annotations.Service;

import com.venkat.dao.SampleDao;
import com.venkat.entities.Sample;

@Path("/samples")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SampleApi {

	@Inject private SampleDao sampleDao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sample> getAllSamples(@Context ContainerRequestContext crc)
	{
		String sampleValue = (String) crc.getProperty("sampleKey");
		System.out.println("Sample:"+sampleValue);
		return sampleDao.getAllSamples();
	}

	@Path("/{sampleId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Sample getSample(@PathParam("sampleId") int sampleId)
	{
		return sampleDao.getSample(sampleId);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSample(Sample sample)
	{
		boolean retVal = sampleDao.addSample(sample);
		if (retVal) {
			return Response.status(201).build();
		}
		else {
			return Response.status(400).build();
		}
	}

	@Path("/{sampleId}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Sample updateSample(Sample sample)
	{
		return sampleDao.updateSample(sample);
	}

	@Path("/{sampleId}")
	@DELETE
	public Response deleteSample(@PathParam("sampleId") int sampleId)
	{
		boolean retVal = sampleDao.deleteSample(sampleId);
		if (retVal) {
			return Response.status(202).build();
		}
		else {
			return Response.status(400).build();
		}
	}
}

