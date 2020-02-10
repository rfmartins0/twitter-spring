package br.com.project.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TweetDto {


    private String text;
 

	private int hour;

    private Date created_at;



    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public int getHour() {
 		return hour;
 	}

 	public void setHour(int hour) {
 		this.hour = hour;
 	}
}
