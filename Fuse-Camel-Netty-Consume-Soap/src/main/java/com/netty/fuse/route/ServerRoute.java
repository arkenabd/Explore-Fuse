package com.netty.fuse.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.Main;
import org.springframework.stereotype.Component;

@Component

public class ServerRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("netty:tcp://localhost:7000?textline=true&sync=true&requestTimeout=10000&allowDefaultCodec=false&encoder=#stringEncoder&decoder=#stringDecoder")
				.to("bean:echoService");

	}
}