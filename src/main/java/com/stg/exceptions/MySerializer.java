package com.stg.exceptions;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.stg.entity.Cart;

public class MySerializer extends StdSerializer<Cart> {
	
	public MySerializer() {
		this(null);
	}

	protected MySerializer(Class<Cart> t) {
		super(t);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serialize(Cart value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
