package com.jtd.util;

import java.nio.charset.Charset;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

public class KeyRedisSerializer implements RedisSerializer<Object>{
	
	private final Charset charset;

	public KeyRedisSerializer() {
		this(Charset.forName("UTF8"));
	}

	public KeyRedisSerializer(Charset charset) {
		Assert.notNull(charset);
		this.charset = charset;
	}

	@Override
	public byte[] serialize(Object object) throws SerializationException {
		String string = object == null ? null : object.toString();
		return (string == null ? null : string.getBytes(charset));
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		return (bytes == null ? null : new String(bytes, charset));
	}

}
