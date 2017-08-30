package cn.author.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 8712457809613928724L;

	private Integer id;

    private String name;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}