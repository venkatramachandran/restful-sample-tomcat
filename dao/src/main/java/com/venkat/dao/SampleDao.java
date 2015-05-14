package com.venkat.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.inject.Named;

import org.jvnet.hk2.annotations.Service;
import org.jvnet.hk2.annotations.Contract;

import com.venkat.entities.Sample;

@Contract
@Service
public class SampleDao {

	EntityManagerFactory emFactory= Persistence.createEntityManagerFactory("Sample");
	EntityManager enManager= emFactory.createEntityManager();

	public List<Sample> getAllSamples()
	{
		TypedQuery<Sample> query = enManager.createNamedQuery("Sample.findAll", Sample.class);
		List<Sample> list = query.getResultList();
		try {
			enManager.close();
			emFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Sample getSample(int sampleId)
	{
		TypedQuery<Sample> query=enManager.createNamedQuery("Sample.find", Sample.class);
		query.setParameter("id", sampleId);
		Sample sample = query.getSingleResult();
		try {
			enManager.close();
			emFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sample;

	}


	public boolean addSample(Sample sample)
	{
		boolean retVal = true;
		enManager.getTransaction().begin();
		enManager.persist(sample);
		enManager.getTransaction().commit();
		try {
			enManager.close();
			emFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
			retVal = false;
		}
		return retVal;
	}


	public Sample updateSample(Sample sample)
	{
		enManager.getTransaction().begin();
		enManager.merge(sample);
		enManager.getTransaction().commit();

		try {
			enManager.close();
			emFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sample;
	}


	public boolean deleteSample(int sampleId)
	{
		boolean retVal = true;
		enManager.getTransaction( ).begin( );
		Sample sample=enManager.find(Sample.class, sampleId);
		enManager.remove(sample);
		enManager.getTransaction( ).commit( );
		try {
			enManager.close();
			emFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
			retVal = false;
		}
		return retVal;
	}
}
