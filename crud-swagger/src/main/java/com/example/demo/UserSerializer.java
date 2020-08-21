package com.example.demo;

import com.example.demo.Entity.User;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class UserSerializer extends StdSerializer<User> {
    private static final long serialVersionUID = 1L;
    public  UserSerializer(){
        this(null);
    }
    protected UserSerializer(Class<User> t) {
        super(t);
    }

    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        serializerProvider.defaultSerializeField("id", user.getId(), jsonGenerator);
        serializerProvider.defaultSerializeField("firstName", user.getFirstName(), jsonGenerator);
        serializerProvider.defaultSerializeField("lastName", user.getLastName(), jsonGenerator);
        serializerProvider.defaultSerializeField("age", user.getAge(), jsonGenerator);
        serializerProvider.defaultSerializeField("email", user.getEmail(), jsonGenerator);
jsonGenerator.writeEndObject();
    }
}
