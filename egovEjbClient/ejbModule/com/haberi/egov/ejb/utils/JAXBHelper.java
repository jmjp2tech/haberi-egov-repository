package com.haberi.egov.ejb.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.haberi.egov.ejb.entities.dto.NotesDTO;

public class JAXBHelper {
	private static JAXBHelper instance;
	
	private JAXBHelper(){
		
	}
	
	public static JAXBHelper getInstance(){
		if(instance == null){
			instance = new JAXBHelper(); 
		}
		return instance; 
	}
	
	public  NotesDTO toNotesDTO( String xmlString){
		NotesDTO notesDTO = null ;
		Unmarshaller notesDTOUnmarshaller= getUnmarshaller(NotesDTO.class);
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xmlString.getBytes()); 
		if(notesDTOUnmarshaller != null){
			try {
				notesDTO = (NotesDTO) notesDTOUnmarshaller.unmarshal(byteArrayInputStream);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return notesDTO; 
	}
	
	public  String toXMLString(NotesDTO notesDTO){
		Marshaller notesDTOMarshaller= getMarshaller(NotesDTO.class);
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
		
		if(notesDTOMarshaller != null){
			try {
				notesDTOMarshaller.marshal(notesDTO,byteArrayOutputStream);
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return byteArrayOutputStream.toString(); 
	}

	private <T> Unmarshaller getUnmarshaller(Class<T> clazz) {
		Unmarshaller jaxbUnmarshaller = null ; 
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jaxbUnmarshaller;
	}
	
	private <T> Marshaller getMarshaller(Class<T> clazz) {
		Marshaller jaxbMarshaller = null ; 
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
			jaxbMarshaller = jaxbContext.createMarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jaxbMarshaller;
	}

}
