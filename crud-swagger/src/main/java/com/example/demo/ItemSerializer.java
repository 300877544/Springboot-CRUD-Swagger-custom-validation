package com.example.demo;

import com.example.demo.Entity.Item;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ItemSerializer extends StdSerializer<Item> {
   public ItemSerializer(){this(null);}
    protected ItemSerializer(Class<Item> t) {
        super(t);
    }

    @Override
    public void serialize(Item item, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException , JsonProcessingException {
    jsonGenerator.writeStartObject();
    jsonGenerator.writeNumberField("id", item.id);
    jsonGenerator.writeStringField("itemName", item.itemName);
    jsonGenerator.writeNumberField("owner", item.owner.getId());
    jsonGenerator.writeEndObject();
   }
}
