package com.netty.fuse.route;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spring.Main;
import org.springframework.stereotype.Component;

import com.netty.fuse.util.PojoJson;

@Component

public class ServerRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		from("netty:tcp://localhost:7000?textline=true&sync=true&requestTimeout=10000&allowDefaultCodec=false&encoder=#stringEncoder&decoder=#stringDecoder")
		//from("timer:1")		
		.bean("parsingIso")
				.setHeader(Exchange.HTTP_METHOD, constant("POST"))
				.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
				.setBody(bean("parsingIso"))

//				.setBody(bean("jsonOut"))
//				.marshal().json(JsonLibrary.Gson, PojoJson.class)
				
				.to("http4://localhost:8080/employee")
				.unmarshal().json(JsonLibrary.Gson, PojoJson.class)
				.log("Response (${body})")
				
				.log("Response ID : (${body.getEmpId})")
				.log("Response Name : (${body.getName})")
				
				.bean("jsonOut", "setName(${body.getName})")
				.bean("jsonOut", "setEmpId(${body.getEmpId})")
				.bean("generateIso","generate(${body.getEmpId},${body.getName},${body.getDesignation},${body.getSalary})");
			;
		

	}
}