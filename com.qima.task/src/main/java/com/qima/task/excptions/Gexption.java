package com.qima.task.excptions;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qima.task.exeptions.servicelayer.ProductNotFound;
import com.qima.task.exeptions.servicelayer.Quntityex;
import com.qima.task.exeptions.servicelayer.ReFundExc;

@RestController
@RestControllerAdvice
public class Gexption{
@ExceptionHandler(ConstraintViolationException.class)
public ResponseEntity<GlobalRestHndeller>emptyfield(){
	GlobalRestHndeller emptyConstrainmessge=new GlobalRestHndeller("please fill all data");
	return new ResponseEntity<GlobalRestHndeller>(emptyConstrainmessge,HttpStatus.BAD_REQUEST);
}
// it works with every not found record
@ExceptionHandler(ProductNotFound.class)
public ResponseEntity<GlobalRestHndeller>cannotfind(){
	GlobalRestHndeller emptyConstrainmessge=new GlobalRestHndeller("this id not existed");
	return new ResponseEntity<GlobalRestHndeller>(emptyConstrainmessge,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(Quntityex.class)
public ResponseEntity<GlobalRestHndeller>lessthenZerp (){
	GlobalRestHndeller emptyConstrainmessge=new GlobalRestHndeller("please fill the numric number with count>0");
	return new ResponseEntity<GlobalRestHndeller>(emptyConstrainmessge,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(ReFundExc.class)
public ResponseEntity<GlobalRestHndeller>refundex (){
	GlobalRestHndeller emptyConstrainmessge=new GlobalRestHndeller("can not delete order before refun all products");
	return new ResponseEntity<GlobalRestHndeller>(emptyConstrainmessge,HttpStatus.BAD_REQUEST);
}
}
