package com.qima.task.excptions;

import java.util.Date;

import lombok.Data;

@Data

public class GlobalRestHndeller {
private  String messag;
private Date d=new Date();
public GlobalRestHndeller(String messag) {
	
	this.messag = messag;
}

}
