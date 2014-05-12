package com.haberi.egov.ejb.entities.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="notes")
public class NotesDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7097468640117901140L;
	private List<NoteDTO> notes ;

	
	/**
	 * @return the notes
	 */
	@XmlElement(name="note")
	public List<NoteDTO> getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(List<NoteDTO> notes) {
		this.notes = notes;
	} 
	
	

}
